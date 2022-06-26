package com.example.tugaspert2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {

    Button register, toLogin;
    EditText registerUsername, registerEmail, registerPassword;
    SharedPreferences sharedPref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        register = findViewById(R.id.btn_register);
        toLogin = findViewById(R.id.btn_toLogin);
        registerUsername = findViewById(R.id.et_registerUsername);
        registerEmail = findViewById(R.id.et_registerEmail);
        registerPassword = findViewById(R.id.et_registerPassword);
        sharedPref = getSharedPreferences("account", MODE_PRIVATE);

        register.setOnClickListener(v -> {
            SharedPreferences.Editor editor = sharedPref.edit();
            editor.putString("account_username", registerUsername.toString());
            editor.putString("account_email", registerEmail.toString());
            editor.putString("account_password", registerPassword.toString());
            editor.apply();

            Toast.makeText(RegisterActivity.this, "Register Successful!", Toast.LENGTH_SHORT).show();

//            Intent registerIntent = new Intent(RegisterActivity.this, MainActivity.class);
//            startActivity(registerIntent);
        });

        toLogin.setOnClickListener(v-> {
            Intent toLoginIntent = new Intent (RegisterActivity.this, MainActivity.class);
            startActivity(toLoginIntent);
        });
    }
}