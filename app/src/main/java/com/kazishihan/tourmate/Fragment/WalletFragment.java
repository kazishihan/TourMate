package com.kazishihan.tourmate.Fragment;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.kazishihan.tourmate.Adapter.ExpenseAdapter;
import com.kazishihan.tourmate.Adapter.TripAdapter;
import com.kazishihan.tourmate.BottomSheet.BottomSheet_AddExpense;
import com.kazishihan.tourmate.BottomSheet.BottomSheet_AddMemory;
import com.kazishihan.tourmate.BottomSheet_AddTrip;
import com.kazishihan.tourmate.Classes.Expense;
import com.kazishihan.tourmate.Classes.IndividualTrip;
import com.kazishihan.tourmate.R;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class WalletFragment extends Fragment {

    private FloatingActionButton floatingActionButton;
    private BottomSheet_AddExpense bottomSheet_addExpense;
    public String eventId;


    private BottomSheet_AddTrip bottomSheet_addTrip;
    private FloatingActionButton fab;
    private RecyclerView recyclerView;
    DatabaseReference database;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference myRef;
    private List<Expense> expenseList;
   private ExpenseAdapter expenseAdapter;
    //private Context context;
    private FirebaseAuth firebaseAuth;
    private String currentuser;

    public WalletFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_wallet, container, false);



        firebaseDatabase = FirebaseDatabase.getInstance();
        firebaseAuth = FirebaseAuth.getInstance();
        currentuser = firebaseAuth.getCurrentUser().getUid();
        expenseList = new ArrayList<>();


        recyclerView = view.findViewById(R.id.recyclerviewExpenseId);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));


        eventId = getArguments().getString("message");
        Toast.makeText(getContext(), "get"+eventId, Toast.LENGTH_SHORT).show();

        floatingActionButton = view.findViewById(R.id.floatingbtnId)  ;

        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                bottomSheet_addExpense = new BottomSheet_AddExpense();
                bottomSheet_addExpense.setEventId(eventId);
                bottomSheet_addExpense.show(getFragmentManager(), "bottomSheetImageDialog");
            }
        });




        database = FirebaseDatabase.getInstance().getReference().child("UserList").child(currentuser).child("Events").child(eventId);
        database.child("Wallet").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()){
                    expenseList.clear();
                    for (DataSnapshot data: dataSnapshot.getChildren()) {
                        Expense expense= data.getValue(Expense.class);
                        expenseList.add(expense);

                    }
                    expenseAdapter = new ExpenseAdapter(expenseList,getContext());
                    recyclerView.setAdapter(expenseAdapter);
                    expenseAdapter.notifyDataSetChanged();
                }else {
                    Toast.makeText(getActivity(), "Empty database", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(getContext(), ""+databaseError.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

        return view;
    }

}
