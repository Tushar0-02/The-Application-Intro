package com.example.introo001;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class toGetPassword extends AppCompatActivity {

    private Button forContinueToHome;

    private EditText forGetUserPassword;
    private EditText forGetUserReEnteredPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_to_get_password);

        forContinueToHome = findViewById(R.id.btnRegisterTheUser);
        forGetUserPassword = findViewById(R.id.getUserCreatedPassword);
        forGetUserReEnteredPassword = findViewById(R.id.getUserReEnteredPassword);

        forContinueToHome.setOnClickListener(v -> {
            String UserPassword = forGetUserPassword.getText().toString().trim();
            String UserReEnteredPassword = forGetUserReEnteredPassword.getText().toString().trim();

            if (UserPassword.isEmpty() && UserReEnteredPassword.isEmpty()) {
                Toast.makeText(toGetPassword.this, "All fields are required", Toast.LENGTH_SHORT).show();
            } else {
                if (UserPassword.equals(UserReEnteredPassword)) {
                    Toast.makeText(toGetPassword.this, "Successfull, Next!", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(toGetPassword.this, Home.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(toGetPassword.this, "Password Dose not match!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}