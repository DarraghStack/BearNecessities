package com.example.BearNecessities4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity2 extends AppCompatActivity {

    private EditText email;
    private EditText password;
    private Button login;

    private FirebaseAuth auth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login2);

        email = findViewById(R.id.email);
        password = findViewById(R.id.password);
        login = findViewById(R.id.login);

                auth = FirebaseAuth.getInstance();

        login.setOnClickListener(v -> {
            String txt_email = email.getText().toString();
            String txt_password = password.getText().toString();
            loginUser(txt_email, txt_password);
            finish();
        });
    }

    private void loginUser(String txt_email, String txt_password) {  ////Check here...Not sure why it is txt_email and not just email
        auth.signInWithEmailAndPassword(txt_email, txt_password).addOnSuccessListener(authResult -> {
            Toast.makeText(LoginActivity2.this, "Login Successful", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(LoginActivity2.this,MainActivity.class));
            finish();
        });                      ////Check here...Not sure why it is txt_email and not just email
    }
}