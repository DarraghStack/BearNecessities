package com.example.bearnecetties4;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    private Button logout = findViewById(R.id.logout);
    private ListView listView = findViewById(R.id.listView);
    private Button add = findViewById(R.id.add);
    private EditText edit = findViewById(R.id.edit);
    private TextView label =findViewById(R.id.label);




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth.getInstance().signOut();
                Toast.makeText(MainActivity.this, "logged Out", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(new Intent(MainActivity.this, StartActivity.class)));
            }
        });

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String txt_name = edit.getText().toString();
                if (txt_name.isEmpty())
                    Toast.makeText(MainActivity.this,"Logged Out",Toast.LENGTH_SHORT).show();
                else    {
                    FirebaseDatabase.getInstance().getReference().child("Test").push().child("Name").setValue(txt_name);
                }
            }
        });
        final ArrayList<String> list= new ArrayList<>();
        final  ArrayAdapter adapter = new ArrayAdapter<String>(this,R.layout.list_item,list);
                listView.setAdapter(adapter);

      DatabaseReference reference = FirebaseDatabase.getInstance().getReference();
      reference.addValueEventListener(new ValueEventListener() {
          @Override
          public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
              list.clear();
              for (DataSnapshot snapshot : dataSnapshot.getChildren()){
                  list.add(snapshot.getValue().toString());
              }
              adapter.notifyDataSetChanged();
          }

          @Override
          public void onCancelled(@NonNull DatabaseError error) {

          }
      });
    }
}