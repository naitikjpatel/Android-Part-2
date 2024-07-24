package com.example.androidrevisiontwo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.Toast;

public class Advance_Control extends AppCompatActivity {

    Button cmenu,pmenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_advance_control);

        cmenu=findViewById(R.id.cmenu);
        pmenu=findViewById(R.id.pmenu);
        //we need to register the context button on press
        registerForContextMenu(cmenu);
        pmenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopupMenu popupMenu=new PopupMenu(Advance_Control.this,pmenu);
                popupMenu.getMenuInflater().inflate(R.menu.main,popupMenu.getMenu());
                Toast.makeText(Advance_Control.this, "Clicked on popupMenu", Toast.LENGTH_SHORT).show();
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        if (item.getItemId()==R.id.i1){
                            Toast.makeText(Advance_Control.this, "Selected :"+item.getTitle(), Toast.LENGTH_SHORT).show();
                        } else if (item.getItemId()==R.id.i2) {
                            Toast.makeText(Advance_Control.this, "Selected :"+item.getTitle(), Toast.LENGTH_SHORT).show();
                        } else if (item.getItemId()==R.id.i3) {
                            Toast.makeText(Advance_Control.this, "Selected :"+item.getTitle(), Toast.LENGTH_SHORT).show();
                        }
                        return false;
                    }
                });
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId()==R.id.i1){
            Toast.makeText(Advance_Control.this, "Selected :"+item.getTitle(), Toast.LENGTH_SHORT).show();
        } else if (item.getItemId()==R.id.i2) {
            Toast.makeText(Advance_Control.this, "Selected :"+item.getTitle(), Toast.LENGTH_SHORT).show();
        } else if (item.getItemId()==R.id.i3) {
            Toast.makeText(Advance_Control.this, "Selected :"+item.getTitle(), Toast.LENGTH_SHORT).show();
        }

        return super.onOptionsItemSelected(item);
    }


    //this code for the context menu

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        getMenuInflater().inflate(R.menu.main,menu);
        super.onCreateContextMenu(menu, v, menuInfo);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        if (item.getItemId()==R.id.i1){
            Toast.makeText(Advance_Control.this, "Selected :"+item.getTitle(), Toast.LENGTH_SHORT).show();
        } else if (item.getItemId()==R.id.i2) {
            Toast.makeText(Advance_Control.this, "Selected :"+item.getTitle(), Toast.LENGTH_SHORT).show();
        } else if (item.getItemId()==R.id.i3) {
            Toast.makeText(Advance_Control.this, "Selected :"+item.getTitle(), Toast.LENGTH_SHORT).show();
        }
        return super.onContextItemSelected(item);
    }
}