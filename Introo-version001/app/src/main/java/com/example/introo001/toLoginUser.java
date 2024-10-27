package com.example.introo001;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class toLoginUser extends AppCompatActivity {

    private EditText getUserEmailOrPhone;
    private EditText getUserPassword;
    private CheckBox btnToggleShowPassword;
    private Button btnLogin;
    private Button btnGoogleLogin;
    private TextView btnSignUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_to_login_user);

        getUserEmailOrPhone = findViewById(R.id.getUserEmailOrPhone);
        getUserPassword = findViewById(R.id.getUserPassword);
        btnToggleShowPassword = findViewById(R.id.btnToggleShowPassword);
        btnLogin = findViewById(R.id.btnLogin);
        btnGoogleLogin = findViewById(R.id.btnGoogleLogin);
        btnSignUp = findViewById(R.id.btnSignUp);

        btnToggleShowPassword.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) {
                getUserPassword.setInputType(android.text.InputType.TYPE_CLASS_TEXT);
            } else {
                getUserPassword.setInputType(android.text.InputType.TYPE_CLASS_TEXT | android.text.InputType.TYPE_TEXT_VARIATION_PASSWORD);
            }
            getUserPassword.setSelection(getUserPassword.getText().length());
        });

        btnLogin.setOnClickListener(v -> {
            String emailOrPhone = getUserEmailOrPhone.getText().toString().trim();
            String password = getUserPassword.getText().toString().trim();

            if (emailOrPhone.isEmpty() || password.isEmpty()) {
                Toast.makeText(toLoginUser.this, "All fields are required", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(toLoginUser.this, "Login successful", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(toLoginUser.this, Home.class);
                startActivity(intent);
            }
        });

        btnGoogleLogin.setOnClickListener(v -> {
            Toast.makeText(toLoginUser.this, "Coming soon", Toast.LENGTH_SHORT).show();
        });

        btnSignUp.setOnClickListener(v -> {
            Intent intent = new Intent(toLoginUser.this, toGetUserFullName.class);
            startActivity(intent);
        });
    }
}