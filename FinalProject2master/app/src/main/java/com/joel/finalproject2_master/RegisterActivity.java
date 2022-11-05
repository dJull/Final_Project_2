package com.joel.finalproject2_master;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.UserProfileChangeRequest;

public class RegisterActivity extends AppCompatActivity {
    private EditText editName,editEmail,editPassword,editPasswordConfirmation;
    private Button btnRegister,btnLogin;
    private ProgressDialog progressDialog;
    private FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        editName=findViewById(R.id.name);
        editEmail=findViewById(R.id.email);
        editPassword=findViewById(R.id.password);
        editPasswordConfirmation=findViewById(R.id.passwordConf);
        btnRegister=findViewById(R.id.registerBtn);
        btnLogin=findViewById(R.id.goLogin);
        // Initialize Firebase Auth
        mAuth = FirebaseAuth.getInstance();
        progressDialog=new ProgressDialog(RegisterActivity.this);
        progressDialog.setTitle("Loading");
        progressDialog.setMessage("Silahkan tunggu");
        progressDialog.setCancelable(false);

        btnRegister.setOnClickListener(v->{
            if(editName.getText().length()>0&&editEmail.getText().length()>0&&editPassword.getText().length()>0&&editPasswordConfirmation.getText().length()>0){
                if(editPassword.getText().toString().equals(editPasswordConfirmation.getText().toString())){
                    register(editName.getText().toString(), editEmail.getText().toString(), editPassword.getText().toString());
                }else{
                    Toast.makeText(getApplicationContext(),"Pastikan kembali password anda sama",Toast.LENGTH_SHORT).show();
                }
            }else{
                Toast.makeText(getApplicationContext(),"Silahkan isi data anda terlebih dahulu",Toast.LENGTH_SHORT).show();
            }
        });

        btnLogin.setOnClickListener(v->{
            finish();
        });
    }

    private void register(String name, String email, String password){
        progressDialog.show();
        mAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful() && task.getResult()!=null) {
                    FirebaseUser user = task.getResult().getUser();
                    if (user != null) {
                        UserProfileChangeRequest request = new UserProfileChangeRequest.Builder()
                                .setDisplayName(name)
                                .build();
                        user.updateProfile(request).addOnCompleteListener(new OnCompleteListener<Void>() {
                            @Override
                            public void onComplete(@NonNull Task<Void> task) {
                                reload();
                            }
                        });
                    } else {
                        Toast.makeText(getApplicationContext(),"Register Gagal", Toast.LENGTH_SHORT).show();
                    }
                }else{
                    Toast.makeText(getApplicationContext(), task.getException().getLocalizedMessage(), Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();
        if(currentUser != null){
            reload();
        }
    }

    private void reload() {
        startActivity(new Intent(getApplicationContext(), MainActivity.class));
    }
}