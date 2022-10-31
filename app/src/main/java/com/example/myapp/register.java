package com.example.myapp;

import static java.lang.Character.isDigit;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


public class register extends AppCompatActivity {
    Button registerButton;
    EditText idText;
    EditText passWordText;
    CheckBox registerCheckBox;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);
        registerButton = (Button) findViewById(R.id.register_register);
        idText = (EditText) findViewById(R.id.register_id);
        passWordText = (EditText) findViewById(R.id.register_password);
        registerCheckBox = (CheckBox) findViewById(R.id.register_checkBox);
        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String id = idText.getText().toString();
                String passWord = passWordText.getText().toString();
                try {
                    File file = new File(getFilesDir(), "data.txt");
                    String s;
                    BufferedReader r = new BufferedReader(new FileReader(file));
                    while((s = r.readLine()) != null){
                        profile.map.put(s.split(" ")[0], s.split(" ")[1]);
                    }
                    r.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                boolean eng = false;
                boolean num = false;
                for (int i = 0; i<passWord.length(); i++){
                    if (isDigit(passWord.charAt(i))){
                        num = true;
                    }
                    else if((0x61 <= passWord.charAt(i) && passWord.charAt(i) <= 0x7A) || (0x41 <= passWord.charAt(i) && passWord.charAt(i) <= 0x5A)){
                        eng = true;
                    }
                    if (eng && num){
                        break;
                    }
                }
                if ( id.trim().getBytes().length <= 0 || passWord.trim().getBytes().length <= 0 ){
                    Toast toast = Toast.makeText(getApplicationContext(), "빈 칸 없이 채워주세요.", Toast.LENGTH_SHORT);
                    toast.show();
                }
                else if (profile.map.containsKey(id)) {
                    Toast toast = Toast.makeText(getApplicationContext(), "이미 존재하는 아이디입니다.", Toast.LENGTH_SHORT);
                    toast.show();
                }
                else if( passWord.trim().getBytes().length < 5){
                    Toast toast = Toast.makeText(getApplicationContext(), "비밀번호는 5자 이상 입력해주세요.", Toast.LENGTH_SHORT);
                    toast.show();
                }
                else if(!eng || !num){
                    Toast toast = Toast.makeText(getApplicationContext(), "비밀번호는 영문과 숫자의 조합으로 입력해주세요.", Toast.LENGTH_SHORT);
                    toast.show();
                }
                else{
                    if(registerCheckBox.isChecked()){
                        profile.map.put(id, passWord);
                        try {
                            String filename = "data.txt";
                            File file;
                            file = new File(getFilesDir(), filename);
                            if(!file.exists()){
                                file.createNewFile();
                            }
                            BufferedWriter w = new BufferedWriter(new FileWriter(file, true));
                            w.write(id + " ");
                            w.write(passWord + "\r\n");
                            w.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        Toast toast = Toast.makeText(getApplicationContext(), "회원 가입 되셨습니다.", Toast.LENGTH_SHORT);
                        toast.show();
                        finish();
                    }
                    else{
                        Toast toast = Toast.makeText(getApplicationContext(), "개인정보 이용 약관에 동의해주세요.", Toast.LENGTH_SHORT);
                        toast.show();
                    }
                }
            }
        });
    }
}
