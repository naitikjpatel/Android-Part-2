package com.example.androidrevisiontwo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SharePreferanceLogin extends AppCompatActivity {

    EditText uname,upass;
    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_share_preferance_login);
        uname=findViewById(R.id.uname);
        upass=findViewById(R.id.upass);

        btn=findViewById(R.id.login);

//        This logic For the If user already Login
        SharedPreferences preferences=getSharedPreferences("myfile", Context.MODE_PRIVATE);
        boolean isLogin=preferences.getBoolean("IsLogin",false);
        if(isLogin){
            Intent intent=new Intent(SharePreferanceLogin.this,SharePreferanceHomePage.class);
            startActivity(intent);
        finish();
        }

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username=uname.getText().toString();
                String password=upass.getText().toString();
                SharedPreferences.Editor ed=preferences.edit();

                ed.putBoolean("IsLogin",true);
                ed.apply();
                String name=preferences.getString("name",null);
                String pass=preferences.getString("pass",null);

                if (name.equals(username) && pass.equals(password)){
//                    Intent
                    Toast.makeText(SharePreferanceLogin.this, "Login Success", Toast.LENGTH_SHORT).show();
                    Intent intent=new Intent(SharePreferanceLogin.this,SharePreferanceHomePage.class);
                    startActivity(intent);
                }
                else{
//                    Intent On the Same activity
                    Toast.makeText(SharePreferanceLogin.this, "Login Fail", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}