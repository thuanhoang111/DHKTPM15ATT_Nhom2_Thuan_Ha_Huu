package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Login extends AppCompatActivity {
    EditText txtEmail, txtPassword;
    Button btnLogin;
    FirebaseAuth firebaseAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        firebaseAuth = FirebaseAuth.getInstance();
        txtEmail= findViewById(R.id.txt_Email);
        txtPassword = findViewById(R.id.txt_Password);
        btnLogin = findViewById(R.id.btnLogin);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String emai = txtEmail.getText().toString().trim();
                String password = txtPassword.getText().toString().trim();
                if(TextUtils.isEmpty(emai) || TextUtils.isEmpty(password)){
                    Toast.makeText(Login.this, "Vui lòng điền đầy đủ thông tin để được đăng nhập", Toast.LENGTH_SHORT).show();
                    return;
                }
                firebaseAuth.signInWithEmailAndPassword(emai,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            Toast.makeText(Login.this, "Successed", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(Login.this, MainActivity2.class));
                        }
                        else{
                            Toast.makeText(Login.this, "Sai Email hoặc Password", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });
    }
}
