package com.example.alc4android_challenge1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /** Called when the user taps the 'ABOUT ALC' button */
    public void openAboutActivity(View view) {
        // Do something in response to button
        Intent intent = new Intent(this, ActivityB.class);
        startActivity(intent);
    }

    /** Called when the user taps the 'MY PROFILE' button */
    public void openProfileActivity(View view) {
        // Do something in response to button
        Intent intent = new Intent(this, ActivityC.class);
        startActivity(intent);
    }
}
