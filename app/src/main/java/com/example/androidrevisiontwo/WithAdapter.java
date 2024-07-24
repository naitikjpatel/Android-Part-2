package com.example.androidrevisiontwo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.Spinner;

import java.util.ArrayList;

public class WithAdapter extends AppCompatActivity {

    EditText ename;
    Button button;
    Spinner spinner;
    ListView listView;

    GridView gridView;
    ArrayList<String> arrayList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_with_adapter);

        ename=findViewById(R.id.ename);
        button=findViewById(R.id.button);
        spinner=findViewById(R.id.spinner);
        listView=findViewById(R.id.listview);
        gridView=findViewById(R.id.gridview);
        arrayList=new ArrayList<>();

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name=ename.getText().toString();
                arrayList.add(name);

                ArrayAdapter<String> arrayAdapter=new ArrayAdapter(WithAdapter.this, android.R.layout.simple_list_item_1,arrayList);

                spinner.setAdapter(arrayAdapter);
                listView.setAdapter(arrayAdapter);
                gridView.setAdapter(arrayAdapter);
            }
        });


    }
}