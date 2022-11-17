package com.joel.finalproject2_master;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;
import com.joel.finalproject2_master.model.Stocks;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LoginStaffActivity extends AppCompatActivity {

    EditText phoneStaff, passwordStaff;
    Button btnLoginStaff;
    DatabaseReference databaseReference= FirebaseDatabase.getInstance().getReferenceFromUrl("https://final-project2-55ca4-default-rtdb.asia-southeast1.firebasedatabase.app/");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_staff);
        phoneStaff = findViewById(R.id.phoneNumber);
        passwordStaff = findViewById(R.id.passwordStaff);
        btnLoginStaff = findViewById(R.id.btnloginstaff);
        btnLoginStaff.setOnClickListener(v -> {
            final String txtPhone = phoneStaff.getText().toString();
            final String txtPass = passwordStaff.getText().toString();
            if(phoneStaff.getText().toString().length()==0 && passwordStaff.getText().toString().length()==0){
                Toast.makeText(LoginStaffActivity.this, "Please fill email and password", Toast.LENGTH_SHORT).show();
            }else{
                databaseReference.child("staff").addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        if (snapshot.hasChild(txtPhone)) {
                            final String getPassword = snapshot.child(txtPhone).child("password").getValue(String.class);
                            if (getPassword.equals(txtPass)) {
                                startActivity(new Intent(getApplicationContext(), StaffMenuActivity.class));
                                Toast.makeText(LoginStaffActivity.this, "Login Successfully", Toast.LENGTH_SHORT).show();
                            } else {
                                Toast.makeText(LoginStaffActivity.this, "Wrong password", Toast.LENGTH_SHORT).show();
                            }
                        } else {
                            Toast.makeText(LoginStaffActivity.this, "Wrong Phone Number", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });
            }
        });
    }
}