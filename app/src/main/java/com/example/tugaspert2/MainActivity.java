package com.example.tugaspert2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

    SharedPreferences sharedPref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button login = findViewById(R.id.btn_login);
        Button toRegister = findViewById(R.id.btn_toRegister);
        EditText loginUsername, loginPassword;

        loginUsername = findViewById(R.id.et_loginUsername);
        loginPassword = findViewById(R.id.et_loginPassword);
        sharedPref = getSharedPreferences("account", MODE_PRIVATE);

        login.setOnClickListener(view -> {
            if (!loginUsername.getText().toString().equals(sharedPref.getString("account_username", ""))) {
                Toast.makeText(MainActivity.this, "Username Invalid!", Toast.LENGTH_SHORT).show();
            } else if (!loginPassword.getText().toString().equals(sharedPref.getString("account_password", ""))){
                Toast.makeText(MainActivity.this, "Password Invalid!", Toast.LENGTH_SHORT).show();
            } else if (loginUsername.getText().toString().equals(sharedPref.getString("account_username", "")) &&
                    loginPassword.getText().toString().equals(sharedPref.getString("account_password", ""))){
                Intent loginIntent = new Intent(MainActivity.this, HomeActivity.class);
                loginIntent.putExtra("account_username", sharedPref.getString("account_username", ""));
                loginIntent.putExtra("account_email", sharedPref.getString("account_email", ""));
                startActivity(loginIntent);
            }
        });

        toRegister.setOnClickListener(v -> {
            Intent toRegisterIntent = new Intent(MainActivity.this, RegisterActivity.class);
            startActivity(toRegisterIntent);
        });
    }

}