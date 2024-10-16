package com.test.dm;

import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Create an ArrayList of Dessert objects
        ArrayList<Dessert> desserts = new ArrayList<>();

        desserts.add(new Dessert("Tushar", 0, R.drawable.batman));
        desserts.add(new Dessert("Rutuja", 0, R.drawable.mj));
        desserts.add(new Dessert("Neha", 0, R.drawable.ironman));
        desserts.add(new Dessert("Saharsh", 0, R.drawable.scarlett));

        // Create an {@link DessertAdapter}, whose data source is a list of
        // {@link Dessert}s. The adapter knows how to create list item views for each item
        // in the list.
        DesertAdapter flavorAdapter = new DesertAdapter(this, desserts);

        // Get a reference to the ListView, and attach the adapter to the listView.
        ListView listView = findViewById(R.id.list_msg);
        listView.setAdapter(flavorAdapter);
    }
}
