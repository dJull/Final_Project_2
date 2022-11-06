package com.joel.finalproject2_master;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.FirebaseFirestore;

public class MainActivity extends AppCompatActivity {
    private FirebaseUser firebaseUser;
    private FirebaseFirestore db = FirebaseFirestore.getInstance();
    private CardView staffAdd,stockAdd;
    private Button btnLogout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        staffAdd=findViewById(R.id.addStaff);
        stockAdd=findViewById(R.id.addStock);
        btnLogout=findViewById(R.id.logoutBtn);
        firebaseUser= FirebaseAuth.getInstance().getCurrentUser();

        btnLogout.setOnClickListener(v->{
            FirebaseAuth.getInstance().signOut();
            startActivity(new Intent(getApplicationContext(),LoginAdminActivity.class));
            finish();
        });
        staffAdd.setOnClickListener(v->{
            startActivity(new Intent(getApplicationContext(),RegisterStaffActivity.class));
        });
        stockAdd.setOnClickListener(v->{
            startActivity(new Intent(getApplicationContext(),DataStockActivity.class));
        });
    }
}