package com.kazishihan.tourmate.Adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.kazishihan.tourmate.Activity.MemoryActivity;
import com.kazishihan.tourmate.Activity.WalletActivity;
import com.kazishihan.tourmate.Classes.IndividualTrip;
import com.kazishihan.tourmate.Fragment.MemoryFragment;
import com.kazishihan.tourmate.Fragment.WalletFragment;
import com.kazishihan.tourmate.R;

import java.util.List;

public class TripAdapter extends RecyclerView.Adapter<TripAdapter.ViewHolder> {
    private List<IndividualTrip> individualTrips;
    Context context;

    public TripAdapter(List<IndividualTrip> individualTrips, Context context) {
        this.individualTrips = individualTrips;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.all_trip_sample_layout, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder viewHolder, int position) {
        final IndividualTrip mylist = individualTrips.get(position);
        viewHolder.trip_title.setText("" + mylist.getTrip_Name());
        viewHolder.trip_description.setText("" + mylist.getTrip_Description());
        viewHolder.fromdate.setText("" + mylist.getTrip_fromDate());
        viewHolder.todate.setText("" + mylist.getTrip_toDate());


//        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                final AlertDialog.Builder builder = new AlertDialog.Builder(context);
//                LayoutInflater layoutInflater = LayoutInflater.from(context);
//                View view = layoutInflater.inflate(R.layout.dialog_for_memory_wallet, null);
//
//                builder.setView(view);
//                final Dialog dialog = builder.create();
//                dialog.show();
//
//
//                TextView wallet = view.findViewById(R.id.walletDialogId);
//                TextView memory = view.findViewById(R.id.addMemoryDialogId);
//
//                wallet.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//
//                    }
//                });
//
//                memory.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                        String current_event = mylist.getTrip_id();
//                        Intent intent = new Intent(context, AddMemory.class);
//                        intent.putExtra("curre",current_event);
//                        context.startActivity(intent);
//
//                    }
//                });
//
        viewHolder.memoryEvent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MemoryFragment memoryFragment = new MemoryFragment();

                Bundle bundle = new Bundle();
                bundle.putString("message", mylist.getTrip_id());
                memoryFragment.setArguments(bundle);
                FragmentManager fragmentManager2 = ((AppCompatActivity) context).getSupportFragmentManager();
                FragmentTransaction fragmentTransaction2 = fragmentManager2.beginTransaction();
                fragmentTransaction2.replace(R.id.frame_layout_id, memoryFragment);
                fragmentTransaction2.addToBackStack("dashboard");
                fragmentTransaction2.commit();


            }
        });

        viewHolder.walletEvent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                WalletFragment walletFragment = new WalletFragment();
                //String myMessage = "Stackoverflow is cool!";
                Bundle bundle = new Bundle();
                bundle.putString("message", mylist.getTrip_id());
                //FragmentClass fragInfo = new FragmentClass();
                // fragInfo.setArguments(bundle);
                walletFragment.setArguments(bundle);
                FragmentManager fragmentManager3 = ((AppCompatActivity) context).getSupportFragmentManager();
                FragmentTransaction fragmentTransaction3 = fragmentManager3.beginTransaction();
                fragmentTransaction3.replace(R.id.frame_layout_id, walletFragment);
                fragmentTransaction3.addToBackStack("dashboard");
                fragmentTransaction3.commit();

            }
        });
//
//
//            }
//        });
    }


    @Override
    public int getItemCount() {

        return individualTrips.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView trip_title, trip_description, fromdate, todate, memoryEvent, walletEvent, deleteEvent;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            trip_title = itemView.findViewById(R.id.trip_name_id);
            trip_description = itemView.findViewById(R.id.trip_description_id);
            fromdate = itemView.findViewById(R.id.trip_From_date);
            todate = itemView.findViewById(R.id.trip_TO_Date);
            memoryEvent = itemView.findViewById(R.id.memoriesTvClickId);
            walletEvent = itemView.findViewById(R.id.walletTvClickId);
            deleteEvent = itemView.findViewById(R.id.deleteEventTvClickId);
        }
    }
}
