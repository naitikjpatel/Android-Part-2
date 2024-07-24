package com.example.androidrevisiontwo;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.MultiAutoCompleteTextView;

public class MainActivity extends AppCompatActivity {

    AutoCompleteTextView actv;
    MultiAutoCompleteTextView mactv;
    String languages[]={"c","cpp","java","python","adv java","adv python","c#"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        actv=findViewById(R.id.actv);
        mactv=findViewById(R.id.mactv);

//        make the adapter
        ArrayAdapter<String> arrayAdapter=new ArrayAdapter(MainActivity.this, android.R.layout.select_dialog_item,languages);

        actv.setAdapter(arrayAdapter);
        actv.setThreshold(1);
        actv.setTextColor(Color.MAGENTA);

        mactv.setAdapter(arrayAdapter);
        mactv.setThreshold(1);
        mactv.setTokenizer(new MultiAutoCompleteTextView.CommaTokenizer());
        mactv.setTextColor(Color.RED);

    }
}