package com.example.finalproject2customer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.finalproject2customer.Book.BookActivity;
import com.example.finalproject2customer.Clothing.ClothingActivity;
import com.example.finalproject2customer.Electronic.ElectronicActivity;
import com.example.finalproject2customer.Other.OtherActivity;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class HomeActivity extends AppCompatActivity {

    ImageView logout;
    ImageView bajuimage;
    ImageView electronicimage;
    ImageView bukuimage;
    ImageView otherimage;
    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        //
        logout = findViewById(R.id.logout);
        bajuimage = findViewById(R.id.bajuimage);
        electronicimage = findViewById(R.id.elektronikimage);
        bukuimage = findViewById(R.id.bukuimage);
        otherimage = findViewById(R.id.otherimage);
        mAuth = FirebaseAuth.getInstance();

        //
        logout.setOnClickListener(view -> {
            mAuth.signOut();
            startActivity(new Intent(HomeActivity.this, AnimActivity.class));
        });

        //
        bajuimage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeActivity.this, ClothingActivity.class);
                startActivity(intent);
            }
        });

        //
        electronicimage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeActivity.this, ElectronicActivity.class);
                startActivity(intent);
            }
        });

        //
        bukuimage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeActivity.this, BookActivity.class);
                startActivity(intent);
            }
        });

        //
        otherimage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeActivity.this, OtherActivity.class);
                startActivity(intent);
            }
        });

    }

    //
    @Override
    protected void onStart() {
        super.onStart();
        FirebaseUser user = mAuth.getCurrentUser();
        if (user == null){
            startActivity(new Intent(HomeActivity.this, AnimActivity.class));
        }
    }

}