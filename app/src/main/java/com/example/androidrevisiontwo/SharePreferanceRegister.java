package com.example.androidrevisiontwo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class SharePreferanceRegister extends AppCompatActivity {

    EditText name,password;
    TextView tv;
    Button btn,displaybtn,login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_share_preferance_register);
        name=findViewById(R.id.name);
        password=findViewById(R.id.password);
        tv=findViewById(R.id.show);
        btn=findViewById(R.id.button);
        displaybtn=findViewById(R.id.displaybtn);
        login=findViewById(R.id.login);

        SharedPreferences sharedPreferences = getSharedPreferences("myfile",Context.MODE_PRIVATE);
        boolean ans=sharedPreferences.getBoolean("IsRegistered",false);
        if(ans){
            Intent intent=new Intent(SharePreferanceRegister.this,SharePreferanceLogin.class);
            startActivity(intent);
            finish();
        }

        //this is for the save
        //        This is for the save the data in the sharepreferances
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String uname=name.getText().toString();
                String upass=password.getText().toString();
                SharedPreferences preferences=getSharedPreferences("myfile", Context.MODE_PRIVATE);
                SharedPreferences.Editor ed=preferences.edit();
                ed.putString("uname",uname);
                ed.putString("upass",upass);
                ed.putBoolean("IsRegistered",true);
                ed.apply();
                Toast.makeText(SharePreferanceRegister.this, "Data is Saved", Toast.LENGTH_SHORT).show();

//                Intent intent=new Intent(SharePreferanceRegister.this,SharePreferanceLogin.class);
//                startActivity(intent);
            }
        });


        //This code for the show the data on the screen
        displaybtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences sp=getSharedPreferences("myfile",Context.MODE_PRIVATE);
                //when we want the data from the preferance then we not need to make the Editor class
                String name=sp.getString("uname","");
                String pass=sp.getString("upass","");
                Toast.makeText(SharePreferanceRegister.this, "Name :"+name+"\nPass :"+pass, Toast.LENGTH_SHORT).show();

            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(SharePreferanceRegister.this,SharePreferanceLogin.class);
                startActivity(intent);
            }
        });

    }
}