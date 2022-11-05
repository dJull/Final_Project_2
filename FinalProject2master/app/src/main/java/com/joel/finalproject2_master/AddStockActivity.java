package com.joel.finalproject2_master;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;

public class AddStockActivity extends AppCompatActivity {

    private Button backBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_stock);
        backBtn=findViewById(R.id.btnBack);

        backBtn.setOnClickListener(v->{
            startActivity(new Intent(getApplicationContext(),MainActivity.class));
        });
    }
}