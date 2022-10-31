package com.example.myapp;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.example.myapp.profile;
import androidx.appcompat.app.AppCompatActivity;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;

public class login extends AppCompatActivity {

    Button loginButton;
    Button registerButton;
    EditText idText;
    EditText passWordText;
    Button lookAroundButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        registerButton = (Button) findViewById(R.id.login_register);
        loginButton = (Button) findViewById(R.id.login);
        idText = (EditText) findViewById(R.id.id);
        passWordText = (EditText) findViewById(R.id.password);
        lookAroundButton = (Button) findViewById(R.id.lookAroundButton);
        lookAroundButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                profile.id = "";
                profile.password = "";
                Intent mainActivity = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(mainActivity);
            }
        });

        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent register = new Intent(getApplicationContext(), register.class);
                startActivity(register);
            }
        });
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String id = idText.getText().toString();
                String passWord = passWordText.getText().toString();
                try {
                    File file = new File("/data/user/0/com.example.myapp/files/data.txt");
                    String s;
                    BufferedReader r = new BufferedReader(new FileReader("/data/user/0/com.example.myapp/files/data.txt"));
                    while((s = r.readLine()) != null){
                        profile.map.put(s.split(" ")[0], s.split(" ")[1]);
                    }
                    r.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                if (!profile.map.containsKey(id)){
                    Toast toast = Toast.makeText(getApplicationContext(), "없는 아이디입니다.", Toast.LENGTH_SHORT);
                    toast.show();
                }
                else{
                    if(profile.map.get(id).equals(passWord)){
                        profile.id = id;
                        profile.password = passWord;
                        Toast toast = Toast.makeText(getApplicationContext(), "로그인 성공.", Toast.LENGTH_SHORT);
                        toast.show();
                        Intent main = new Intent(getApplicationContext(), MainActivity.class);
                        startActivity(main);
                    }
                    else{
                        Toast toast = Toast.makeText(getApplicationContext(), "로그인 실패.", Toast.LENGTH_SHORT);
                        toast.show();
                    }
                }
            }
        });
    }
}
