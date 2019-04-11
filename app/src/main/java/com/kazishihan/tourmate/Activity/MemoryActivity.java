package com.kazishihan.tourmate.Activity;

import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.kazishihan.tourmate.BottomSheet.BottomSheet_AddMemory;
import com.kazishihan.tourmate.R;

public class MemoryActivity extends AppCompatActivity {

    public String eventId;
   // private EventIdClass eventIdClass;


    private BottomSheet_AddMemory bottomSheet_addMemory;
    private FloatingActionButton floatingActionButtonMemory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_memory);
        eventId = getIntent().getStringExtra("curre");

        floatingActionButtonMemory = findViewById(R.id.fabMemory);



        Toast.makeText(this, ""+eventId, Toast.LENGTH_SHORT).show();


        floatingActionButtonMemory.setOnClickListener(new View.OnClickListener() {



            @Override
            public void onClick(View v) {
//                  EventIdClass eventIdClass = new EventIdClass();
//                  eventIdClass.setEventId(eventId);

                  bottomSheet_addMemory = new BottomSheet_AddMemory();
                  bottomSheet_addMemory.setcID(eventId);
                  bottomSheet_addMemory.show(getSupportFragmentManager(), "bottomSheetImageDialog");
            }
        });
    }
}
