package com.example.BearNecessities4;

import android.content.Intent;
import android.nfc.Tag;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.auth.FirebaseAuth;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
        private RecyclerView.Adapter mAdapter;
        private RecyclerView.LayoutManager layoutManager;

    private static final String TAG = "Presidents App";
    Button btn_addOne;

    List<President> presidentList = new ArrayList<President> ();

    Button logout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        logout = findViewById(R.id.logout);

        btn_addOne = findViewById(R.id.btn_addOne);

        fillPresidentList ();
        Log.d(TAG,"onCreate:"+presidentList.toString ());
        Toast.makeText (this,"Test",Toast.LENGTH_SHORT).show();


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
recyclerView= findViewById (R.id.lv_presidentlist);
recyclerView.setHasFixedSize (true);

layoutManager = new LinearLayoutManager (this);
recyclerView.setLayoutManager (layoutManager);
mAdapter=new RecyclerViewAdapter (presidentList,this) {
};
        recyclerView.setAdapter (mAdapter);
    }

    private void fillPresidentList() {
        President p0 = new President (0,"Bramely Cooking Apple(Single)",0.55,"https://img.tesco.ie/Groceries/pi/000/0260500000000/IDShot_90x90.jpg");
        President p1 = new President (1,"Banana(Single)",0.22,"https://image.shutterstock.com/image-photo/single-banana-isolated-600w-575528569.jpg");
        President p2 = new President (2,"Apple(Multi)",2.99,"https://img.tesco.ie/Groceries/pi/604/0000010111604/IDShot_90x90.jpg");
        President p3 = new President (3,"Banana(Multi)",1.99,"https://img.tesco.ie/Groceries/pi/875/0000010001875/IDShot_90x90.jpg");
        President p4 = new President (4,"Pear(Single)",.50,"https://upload.wikimedia.org/wikipedia/commons/thumb/c/cf/Pears.jpg/330px-Pears.jpg");
        President p5 = new President (5,"Pear(Multi)",1.49,"https://img.tesco.ie/Groceries/pi/574/0000003249574/IDShot_90x90.jpg");
        President p6 = new President (6,"Sweet easy peeler",2.99,"https://img.tesco.ie/Groceries/pi/891/0000003263891/IDShot_90x90.jpg");
        President p7 = new President (7,"Orange(Multi)",3.99,"https://img.tesco.ie/Groceries/pi/324/5059316064324/IDShot_225x225.jpg");
        President p8 = new President (8,"Keelings Strawberry",2.99,"https://img.tesco.ie/Groceries/pi/110/0000053994110/IDShot_90x90.jpg");
        President p9 = new President (9,"Keelings Extra Sweet Batch Blueberries",1.99,"https://img.tesco.ie/Groceries/pi/041/5099400004041/IDShot_90x90.jpg");

        presidentList.addAll(Arrays.asList (new President []  {p0,p1,p2,p3,p4,p5,p6,p7,p8,p9}));
    }

}

