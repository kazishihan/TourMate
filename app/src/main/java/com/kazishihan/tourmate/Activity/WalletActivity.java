package com.kazishihan.tourmate.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.kazishihan.tourmate.R;

public class WalletActivity extends AppCompatActivity {
    public String eventId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wallet);

        eventId = getIntent().getStringExtra("current_event");


    }
}
