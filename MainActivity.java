package com.example.hivegamestate;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //initialize HiveGameState
        HiveGameState hiveGameState = new HiveGameState();

        //initialize the the Run Test button
        View runTestButton = findViewById(R.id.runTestButton);

    }
}
