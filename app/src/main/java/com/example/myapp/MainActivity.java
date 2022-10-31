package com.example.myapp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.myapp.profile;

public class MainActivity extends AppCompatActivity {

    Button informationButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        informationButton = (Button) findViewById(R.id.information);
        informationButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(profile.id == ""){

                    AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this)
                            .setTitle("회원가입")
                            .setMessage("회원가입 창으로 이동할까요?")
                            .setPositiveButton("yes", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    Toast toast = Toast.makeText(getApplicationContext(), "회원가입 창으로 이동합니다.", Toast.LENGTH_SHORT);
                                    toast.show();
                                    Intent register = new Intent(getApplicationContext(), register.class);
                                    startActivity(register);
                                    finish();

                                }
                            })
                            .setNegativeButton("no", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {

                                }
                            });
                    AlertDialog msgDig = builder.create();
                    msgDig.show();
                }
                else{
                    Intent main = new Intent(getApplicationContext(), profile_screen.class);
                    startActivity(main);
                }
            }
        });
    }
}