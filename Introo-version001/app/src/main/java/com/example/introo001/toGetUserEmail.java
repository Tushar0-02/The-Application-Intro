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

public class toGetUserEmail extends AppCompatActivity {

    private Button forBackToEditDOB;
    private Button forContinueToVerifyOtp;
    private EditText forGetUserEmail;

    private Boolean fromEmail = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_to_get_user_email);

        forBackToEditDOB = findViewById(R.id.btnBackToEditDateOfBirth);
        forContinueToVerifyOtp = findViewById(R.id.btnContinueToEmailVerificationViaOtp);
        forGetUserEmail = findViewById(R.id.getUserEmail);

        forBackToEditDOB.setOnClickListener(v -> {
            Intent intent = new Intent(toGetUserEmail.this, toGetUserDateOfBirth.class);
            startActivity(intent);
        });

        forContinueToVerifyOtp.setOnClickListener(v -> {
            String UserEmail = forGetUserEmail.getText().toString().trim();

            if (UserEmail.isEmpty()) {
                Toast.makeText(toGetUserEmail.this, "All fields are required", Toast.LENGTH_SHORT).show();
            } else {
                String targetedEmail = forGetUserEmail.getText().toString().trim();
                int forCheckOtp = otpGenerator.numericOTP(6);

                Toast.makeText(toGetUserEmail.this, "Successfull, Next!", Toast.LENGTH_SHORT).show();
                Toast.makeText(toGetUserEmail.this, String.valueOf(forCheckOtp), Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(toGetUserEmail.this, toCheckValidOTP.class);
                intent.putExtra("EmailResponse", fromEmail);
                intent.putExtra("User-Email", targetedEmail);
                intent.putExtra("Generated-Otp-Email", forCheckOtp);
                startActivity(intent);
            }
        });
    }
}