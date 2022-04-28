package com.example.myapplication;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Register extends AppCompatActivity {

    private EditText txtEmail;
    private EditText txtName;
    private EditText txtPhone;
    private EditText txtPassword;
    private EditText txtConfirmPassword;
    private Button btnRegister;

    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        mAuth = FirebaseAuth.getInstance();


        txtEmail = findViewById(R.id.editTextEmail);
        txtPassword = findViewById(R.id.editTextPassword);
        txtConfirmPassword = findViewById(R.id.editTextPassword2);
        btnRegister = findViewById(R.id.cirLoginButton);

        btnRegister.setOnClickListener(
                (view) -> {
                    if (!txtPassword.getText().toString().isEmpty() || !txtConfirmPassword.getText().toString().isEmpty()) {
                        Toast.makeText(this, "Password or Confirm password is required", Toast.LENGTH_LONG).show();
                    }
                    if (!txtPassword.getText().toString().equals(txtConfirmPassword.getText().toString())) {
                        Toast.makeText(this, "Password and Confirm password is not matched", Toast.LENGTH_LONG).show();
                    }

                    mAuth.createUserWithEmailAndPassword(txtEmail.getText().toString(), txtPassword.getText().toString()).addOnCompleteListener(
                            this, task -> {
                                if (task.isSuccessful()) {

                                    FirebaseUser currentUser = mAuth.getCurrentUser();
//                                    assert currentUser != null;
                                    Toast.makeText(this, "Login as " + currentUser.getEmail(), Toast.LENGTH_LONG).show();
                                } else {
                                    Toast.makeText(this, "Fail", Toast.LENGTH_LONG).show();
                                }
                            }
                    );

                }
        );

    }

    @Override
    protected void onStart() {
        super.onStart();
        FirebaseUser currentUser = mAuth.getCurrentUser();
        if (currentUser != null) {
            currentUser.reload();
        }
    }


}