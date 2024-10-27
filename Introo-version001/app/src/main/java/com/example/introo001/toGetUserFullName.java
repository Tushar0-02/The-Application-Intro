package com.example.introo001;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class toGetUserFullName extends AppCompatActivity {

    private TextView btnForLogin;
    private Button btnForGoogleRegister;
    private Button btnForToGetDOB;
    private EditText forToGetUserFirstName;
    private EditText forToGetUserLastName;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_to_get_user_full_name);

        forToGetUserFirstName = findViewById(R.id.getUserFirstName);
        forToGetUserLastName = findViewById(R.id.getUserLastName);
        btnForToGetDOB = findViewById(R.id.btnContinueToDateOfBirth);
        btnForGoogleRegister = findViewById(R.id.btnGoogleRegister);
        btnForLogin = findViewById(R.id.btnSignIn);

        btnForToGetDOB.setOnClickListener(v -> {
            String FirstName = forToGetUserFirstName.getText().toString().trim();
            String LastName = forToGetUserLastName.getText().toString().trim();

            if (FirstName.isEmpty() || LastName.isEmpty()) {
                Toast.makeText(toGetUserFullName.this, "All fields are required", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(toGetUserFullName.this, "Successfull, Next!", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(toGetUserFullName.this, toGetUserDateOfBirth.class);
                startActivity(intent);
            }
        });

        btnForGoogleRegister.setOnClickListener(v -> {
            Toast.makeText(toGetUserFullName.this, "Coming soon", Toast.LENGTH_SHORT).show();
        });

        btnForLogin.setOnClickListener(v -> {
            Intent intent = new Intent(toGetUserFullName.this, toLoginUser.class);
            startActivity(intent);
        });
    }
}