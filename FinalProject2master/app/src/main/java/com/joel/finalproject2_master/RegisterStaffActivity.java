package com.joel.finalproject2_master;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.UserProfileChangeRequest;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.sql.DatabaseMetaData;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Set;

public class RegisterStaffActivity extends AppCompatActivity {
    private EditText editName,editEmail,editPassword,editPassConf, editNumber;
    private Button registerStaffBtn;
    private FirebaseFirestore db = FirebaseFirestore.getInstance();
    private ProgressDialog progressDialog;
    private DatabaseReference databaseReference= FirebaseDatabase.getInstance().getReferenceFromUrl("https://final-project2-55ca4-default-rtdb.asia-southeast1.firebasedatabase.app/");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_staff);
        editName = findViewById(R.id.nameStaff);
        editEmail = findViewById(R.id.email);
        editPassword = findViewById(R.id.password);
        editNumber=findViewById(R.id.phoneNum);
        editPassConf=findViewById(R.id.passwordConf);
        registerStaffBtn=findViewById(R.id.btnRegisterStaff);
        progressDialog=new ProgressDialog(RegisterStaffActivity.this);
        progressDialog.setTitle("Loading");
        progressDialog.setMessage("Silahkan tunggu");
        progressDialog.setCancelable(false);

        registerStaffBtn.setOnClickListener(v->{
            if(editName.getText().length()>0 && editEmail.getText().length()>0&&editPassword.getText().length()>0&&editPassConf.getText().length()>0){
                if (editPassword.getText().toString().equals(editPassConf.getText().toString())){
                    registerStaff(editName.getText().toString(), editEmail.getText().toString(), editPassword.getText().toString());
                }else {
                    Toast.makeText(getApplicationContext(),"Pastikan kembali password anda terlebih dahulu", Toast.LENGTH_SHORT).show();
                }
            }else{
                Toast.makeText(getApplicationContext(),"Silahkan isi semua data terlebih dahulu", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void registerStaff(String name, String email, String password){
        Random rand=new Random();
        int uniqueKey= rand.nextInt(6);
        final String key = editNumber.getText().toString();

        databaseReference.child("staff").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                databaseReference.child("staff").child(key).child("name").setValue(name);
                databaseReference.child("staff").child(key).child("email").setValue(email);
                databaseReference.child("staff").child(key).child("password").setValue(password);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });


        Map<String, Object> staff = new HashMap<>();
        staff.put("fullName", name);
        staff.put("email",email);
        staff.put("password",password);

            db.collection("staff")
                .add(staff)
                .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                    @Override
                    public void onSuccess(DocumentReference documentReference) {
                        Toast.makeText(getApplicationContext(),"Berhasil menyimpan data", Toast.LENGTH_SHORT).show();
                        progressDialog.dismiss();
                        finish();
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(getApplicationContext(), e.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
                        progressDialog.dismiss();
                    }
                });
    }
}