package com.example.introo001;

import android.os.Bundle;
import android.content.Intent;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class toCheckValidOTP extends AppCompatActivity {

    private boolean fromEmail;
    private boolean fromPhone;
    private boolean otpResponse;

    private Button forBackToEditEmail;
    private Button forContinueToGetUserPhoneNumber;
    private Button forBackToEditPhone;
    private Button ForContinueToGetUserPassword;

    private EditText Ed1, Ed2, Ed3, Ed4, Ed5, Ed6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_to_check_valid_otp);

        Ed1 = findViewById(R.id.otp_digit_1);
        Ed2 = findViewById(R.id.otp_digit_2);
        Ed3 = findViewById(R.id.otp_digit_3);
        Ed4 = findViewById(R.id.otp_digit_4);
        Ed5 = findViewById(R.id.otp_digit_5);
        Ed6 = findViewById(R.id.otp_digit_6);

        forBackToEditEmail = findViewById(R.id.btnBackToEditEmailorPhone);
        forBackToEditPhone = findViewById(R.id.btnBackToEditEmailorPhone);
        forContinueToGetUserPhoneNumber = findViewById(R.id.btnContinueToCreatePassword);
        ForContinueToGetUserPassword = findViewById(R.id.btnContinueToCreatePassword);

        Intent intent = getIntent();
        fromEmail = intent.getBooleanExtra("EmailResponse", false);
        String targetedEmail = intent.getStringExtra("User-Email");
        int forCheckOtpForEmail = intent.getIntExtra("Generated-Otp-Email", 0);

        fromPhone = intent.getBooleanExtra("PhoneResponse", false);
        String targetedPhone = intent.getStringExtra("User-Phone");
        int forCheckOtpForPhone = intent.getIntExtra("Generated-Otp-Phone", 0);

        if (fromEmail) {
            forBackToEditEmail.setOnClickListener(v -> {
                Intent BackToEmailIntent = new Intent(toCheckValidOTP.this, toGetUserEmail.class);
                startActivity(BackToEmailIntent);
            });

            forContinueToGetUserPhoneNumber.setOnClickListener(v -> {
                if (!areOtpFieldsFilled()) {
                    Toast.makeText(toCheckValidOTP.this, "All fields are required", Toast.LENGTH_SHORT).show();
                } else {
                    String otp = getOtpFromFields();
                    try {
                        int otpNumber = Integer.parseInt(otp);
                        otpResponse = otpVerification.checkOTP(forCheckOtpForEmail, otpNumber);
                        if (otpResponse) {
                            Toast.makeText(toCheckValidOTP.this, "Successful, Next!", Toast.LENGTH_SHORT).show();
                            Intent NextToPhoneNumberIntent = new Intent(toCheckValidOTP.this, toGetUserPhoneNumber.class);
                            startActivity(NextToPhoneNumberIntent);
                        } else {
                            Toast.makeText(toCheckValidOTP.this, "OTP is incorrect", Toast.LENGTH_SHORT).show();
                        }
                    } catch (NumberFormatException e) {
                        Toast.makeText(toCheckValidOTP.this, "Invalid OTP format", Toast.LENGTH_SHORT).show();
                    }
                }
            });

        } else if (fromPhone) {
            forBackToEditPhone.setOnClickListener(v -> {
                Intent BackTOPhoneIntent = new Intent(toCheckValidOTP.this, toGetUserPhoneNumber.class);
                startActivity(BackTOPhoneIntent);
            });

            ForContinueToGetUserPassword.setOnClickListener(v -> {
                if (!areOtpFieldsFilled()) {
                    Toast.makeText(toCheckValidOTP.this, "All fields are required", Toast.LENGTH_SHORT).show();
                } else {
                    String otp = getOtpFromFields();
                    try {
                        int otpNumber = Integer.parseInt(otp);
                        otpResponse = otpVerification.checkOTP(forCheckOtpForPhone, otpNumber);
                        if (otpResponse) {
                            Toast.makeText(toCheckValidOTP.this, "Successful, Next!", Toast.LENGTH_SHORT).show();
                            Intent NextToPasswordIntent = new Intent(toCheckValidOTP.this, toGetPassword.class);
                            startActivity(NextToPasswordIntent);
                        } else {
                            Toast.makeText(toCheckValidOTP.this, "OTP is incorrect", Toast.LENGTH_SHORT).show();
                        }
                    } catch (NumberFormatException e) {
                        Toast.makeText(toCheckValidOTP.this, "Invalid OTP format", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        } else {
            Toast.makeText(toCheckValidOTP.this, "Unexpected Error!", Toast.LENGTH_SHORT).show();
        }
    }

    private boolean areOtpFieldsFilled() {
        return !Ed1.getText().toString().isEmpty() &&
                !Ed2.getText().toString().isEmpty() &&
                !Ed3.getText().toString().isEmpty() &&
                !Ed4.getText().toString().isEmpty() &&
                !Ed5.getText().toString().isEmpty() &&
                !Ed6.getText().toString().isEmpty();
    }

    private String getOtpFromFields() {
        return Ed1.getText().toString() +
                Ed2.getText().toString() +
                Ed3.getText().toString() +
                Ed4.getText().toString() +
                Ed5.getText().toString() +
                Ed6.getText().toString();
    }
}
