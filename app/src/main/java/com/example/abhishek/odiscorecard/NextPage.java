package com.example.abhishek.odiscorecard;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class NextPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_next_page);
        Intent i = getIntent();
        String teama = i.getStringExtra("teama");
        String teamb = i.getStringExtra("teamb");
        String overs = i.getStringExtra("overs");
        String wkts = i.getStringExtra("wkts");
    }
}
