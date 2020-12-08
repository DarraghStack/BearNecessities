package com.example.BearNecessities4;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;


public class MainActivity extends AppCompatActivity {

    Button logout;
    Button btn_addOne;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        logout = findViewById(R.id.logout);
        btn_addOne = findViewById(R.id.btn_addOne);

        logout.setOnClickListener(v -> {
            FirebaseAuth.getInstance().signOut();
            Toast.makeText(MainActivity.this, "logged Out", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(new Intent(MainActivity.this, StartActivity.class)));
        })
        ;

        btn_addOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (MainActivity.this,AddEditOne.class);
                startActivity(intent);
            }
        });
    }
}

