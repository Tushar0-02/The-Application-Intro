package com.example.introo001;

import android.content.Intent;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class toGetUserDateOfBirth extends AppCompatActivity {

    private Spinner monthSpinner;
    private Button forBackToEditFullName;
    private Button forContinueToGetEmail;
    private EditText forBirthDate;
    private EditText forBirthYear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_to_get_user_date_of_birth);

        monthSpinner = findViewById(R.id.month_spinner);
        forBirthDate = findViewById(R.id.Birth_date);
        forBirthYear = findViewById(R.id.Birth_year);
        forContinueToGetEmail = findViewById(R.id.btnContinueToEmail);
        forBackToEditFullName = findViewById(R.id.btnBackToEditFullname);


        String[] months = {"January", "February", "March", "April", "May", "June",
                "July", "August", "September", "October", "November", "December"};

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_item, months);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        monthSpinner.setAdapter(adapter);

        forBackToEditFullName.setOnClickListener(v -> {
            Intent intent = new Intent(toGetUserDateOfBirth.this, toGetUserFullName.class);
            startActivity(intent);
        });

        forContinueToGetEmail.setOnClickListener(v -> {
            String BirthDate = forBirthDate.getText().toString().trim();
            String BirthYear = forBirthYear.getText().toString().trim();

            if (BirthDate.isEmpty() || BirthYear.isEmpty()) {
                Toast.makeText(toGetUserDateOfBirth.this, "All fields are required", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(toGetUserDateOfBirth.this, "Successfull, Next!", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(toGetUserDateOfBirth.this, toGetUserEmail.class);
                startActivity(intent);
            }
        });
    }
}
