package com.test.chat;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        ImageButton icon = findViewById(R.id.icon);
        ImageButton story;
        story = findViewById(R.id.story);

        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) ImageButton tushar= findViewById(R.id.tushar);

        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) ImageButton rutuja= findViewById(R.id.rutuja);

        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) ImageButton hayat= findViewById(R.id.hayat);

        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) ImageButton swaroop= findViewById(R.id.swaroop);

        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) ImageButton saharsh= findViewById(R.id.saharsh);

        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) ImageButton atharv= findViewById(R.id.atharv);

        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) ImageButton viraj= findViewById(R.id.viraj);

        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) ImageButton jay= findViewById(R.id.jay);

        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) ImageButton sita= findViewById(R.id.sita);

        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) ImageButton krishn= findViewById(R.id.krishn);


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}