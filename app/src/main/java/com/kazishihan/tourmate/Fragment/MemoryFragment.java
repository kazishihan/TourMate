package com.kazishihan.tourmate.Fragment;


import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.kazishihan.tourmate.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class MemoryFragment extends Fragment {

    private FloatingActionButton floatingActionButtonMemory;
   // private BottomSheet_AddMemory bottomSheet_addMemory;


    public MemoryFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
         View view=inflater.inflate(R.layout.fragment_memory, container, false);

         floatingActionButtonMemory = view.findViewById(R.id.fabMemory);


        floatingActionButtonMemory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //  bottomSheet_addMemory = new BottomSheet_AddMemory();
                //  bottomSheet_addMemory.show(getFragmentManager(),"BottomSheet_addmemory");
                // .show(getFragmentManager(), "BootmSheet_addtrip");
            }
        });


         return view;
    }

}
