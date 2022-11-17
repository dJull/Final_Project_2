package com.example.finalproject2customer;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.text.method.PasswordTransformationMethod;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.button.MaterialButton;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity {

    EditText email;
    EditText password;
    CheckBox checkbox;
    MaterialButton loginbtn;
    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //
        email = findViewById(R.id.email);
        password = findViewById(R.id.password);
        checkbox = findViewById(R.id.checkbox);
        loginbtn = findViewById(R.id.loginbtn);
        mAuth = FirebaseAuth.getInstance();

        //
        loginbtn.setOnClickListener(view -> {
            loginuser();
        });

        //
        checkbox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if(isChecked){
                    password.setTransformationMethod(null);
                }else{
                    password.setTransformationMethod(new PasswordTransformationMethod());
                }
            }
        });

    }

    //
    private void loginuser(){
        String emailstr = email.getText().toString();
        String passwordstr = password.getText().toString();

        if (TextUtils.isEmpty(emailstr)) {
            email.setError("Email cannot be empty");
            email.requestFocus();
        } else if (TextUtils.isEmpty(passwordstr)) {
            password.setError("Email cannot be empty");
            password.requestFocus();
        }else {
            mAuth.signInWithEmailAndPassword(emailstr,passwordstr).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful()){
                        Toast.makeText(LoginActivity.this, "User Logged In Succesfully", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(LoginActivity.this, HomeActivity.class));
                    }else {
                        Toast.makeText(LoginActivity.this, "Log In Error: " + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }
}