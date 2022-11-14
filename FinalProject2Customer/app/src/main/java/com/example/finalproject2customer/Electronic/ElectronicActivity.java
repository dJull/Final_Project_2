package com.example.finalproject2customer.Electronic;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.finalproject2customer.HomeActivity;
import com.example.finalproject2customer.R;

public class ElectronicActivity extends AppCompatActivity {

    ImageView logout;
    ImageView menimage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_electronic);

        //
        logout = findViewById(R.id.logout);
        menimage = findViewById(R.id.menimage);

        //
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ElectronicActivity.this, HomeActivity.class);
                startActivity(intent);
            }
        });

        //
        menimage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ElectronicActivity.this, ComputerActivity.class);
                startActivity(intent);
            }
        });

    }
}