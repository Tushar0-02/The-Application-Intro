package com.example.introo;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.ListView;

import androidx.activity.ComponentActivity;
import androidx.activity.EdgeToEdge;

import java.util.ArrayList;

public class msg_main extends ComponentActivity {

    @SuppressLint("MissingInflatedId")
    protected void onCreate(Bundle savedInstanceState) {
        EdgeToEdge.enable(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dm_design);

        // Create an ArrayList of Dessert objects
        ArrayList<msg> desserts = new ArrayList<>();

        desserts.add(new msg("Tushar", 0, R.drawable.batman));
        desserts.add(new msg("Rutuja", 0, R.drawable.mj));
        desserts.add(new msg("Neha", 0, R.drawable.ironman));
        desserts.add(new msg("Saharsh", 0, R.drawable.scarlett));

        // Create an {@link DessertAdapter}, whose data source is a list of
        // {@link Dessert}s. The adapter knows how to create list item views for each item
        // in the list.
        msgAdapter flavorAdapter = new msgAdapter(this, desserts);

        // Get a reference to the ListView, and attach the adapter to the listView.
        ListView listView;
        listView = findViewById(R.id.list_msg);
        listView.setAdapter(flavorAdapter);
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {
        super.onPointerCaptureChanged(hasCapture);
    }
}