package com.example.myapp;

import android.os.Bundle;
import android.widget.TextView;
import com.example.myapp.profile;

import androidx.appcompat.app.AppCompatActivity;

public class profile_screen extends AppCompatActivity {

    TextView profile_profile;
    TextView profile_id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile);
        profile_profile = (TextView) findViewById(R.id.profile);
        profile_id = (TextView) findViewById(R.id.profile_id);
        profile_id.setText("id : " + profile.id);
    }
}
