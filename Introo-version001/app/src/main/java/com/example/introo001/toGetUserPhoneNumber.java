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

public class toGetUserPhoneNumber extends AppCompatActivity {

    private Button forBackToEditEmail;
    private Button forContinueToGetPassword;
    private EditText forGetUserPhone;

    private boolean fromPhone = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_to_get_user_phone_number);

        forBackToEditEmail = findViewById(R.id.btnBackToEditEmail);
        forContinueToGetPassword = findViewById(R.id.btnContinueToPhoneVerificationViaOtp);
        forGetUserPhone = findViewById(R.id.getUserEmail);

        forBackToEditEmail.setOnClickListener(v -> {
            Intent intent = new Intent(toGetUserPhoneNumber.this, toGetUserEmail.class);
            startActivity(intent);
        });

        forContinueToGetPassword.setOnClickListener(v -> {
            String UserPhone = forGetUserPhone.getText().toString().trim();

            if (UserPhone.isEmpty()) {
                Toast.makeText(toGetUserPhoneNumber.this, "All fields are required", Toast.LENGTH_SHORT).show();
            } else {
                String targetedPhone = forGetUserPhone.getText().toString().trim();
                int forCheckOtp = otpGenerator.numericOTP(6);

                Toast.makeText(toGetUserPhoneNumber.this, "Successfull, Next!", Toast.LENGTH_SHORT).show();
                Toast.makeText(toGetUserPhoneNumber.this, String.valueOf(forCheckOtp), Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(toGetUserPhoneNumber.this, toCheckValidOTP.class);
                intent.putExtra("PhoneResponse", fromPhone);
                intent.putExtra("User-Phone", targetedPhone);
                intent.putExtra("Generated-Otp-Phone", forCheckOtp);
                startActivity(intent);
            }
        });
    }
}