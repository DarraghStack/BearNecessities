package com.example.BearNecessities4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class AddEditOne extends AppCompatActivity {

    Button btn_OK, btn_cancel;


    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_add_edit_one);

        btn_OK= findViewById (R.id.btn_OK);
        btn_cancel= findViewById (R.id.btn_cancel);


        btn_OK.setOnClickListener (new View.OnClickListener () {
    @Override
    public void onClick (View v) {
        Intent intent = new Intent (AddEditOne.this,MainActivity.class);
        startActivity (intent);
    }
});
      btn_cancel.setOnClickListener (new View.OnClickListener () {
          @Override
          public void onClick (View v) {
              Intent intent = new Intent (AddEditOne.this,MainActivity.class);
              startActivity (intent);
          }
      });

    }
}
