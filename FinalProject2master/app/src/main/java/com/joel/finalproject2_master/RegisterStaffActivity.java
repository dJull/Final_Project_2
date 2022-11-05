package com.joel.finalproject2_master;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class RegisterStaffActivity extends AppCompatActivity {

    private Button backBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_staff);
        backBtn=findViewById(R.id.btnBack);

        backBtn.setOnClickListener(v->{
            startActivity(new Intent(getApplicationContext(),MainActivity.class));
        });
    }
}