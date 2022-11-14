package com.example.finalproject2customer.Clothing;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.finalproject2customer.R;

public class ClothingActivity2 extends AppCompatActivity {

    ImageView logout;
    ImageView tshirtimage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clothing2);

        //
        logout = findViewById(R.id.logout);
        tshirtimage = findViewById(R.id.tshirtimage);

        //
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ClothingActivity2.this, ClothingActivity.class);
                startActivity(intent);
            }
        });

        //
        tshirtimage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ClothingActivity2.this, com.example.finalproject2customer.Clothing.TshirtActivity.class);
                startActivity(intent);
            }
        });

    }
}