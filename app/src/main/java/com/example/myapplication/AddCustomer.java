package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class AddCustomer extends AppCompatActivity {
    EditText txt_get_Name;
    EditText txt_get_LopHP;
    EditText txt_get_Email;
    ProgressDialog dialog;
    FirebaseFirestore db ;
    Button btnThemCustomer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_customer);
        txt_get_Name = findViewById(R.id.txt_get_Name);
        txt_get_LopHP = findViewById(R.id.txt_get_LHP);
        txt_get_Email = findViewById(R.id.txt_get_Email);
        btnThemCustomer= findViewById(R.id.btnThemCustomer);
        dialog = new ProgressDialog(this);
        db = FirebaseFirestore.getInstance();

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("add Data");




        btnThemCustomer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String lophp = txt_get_LopHP.getText().toString().trim();
                String name = txt_get_Name.getText().toString().trim();
                String email = txt_get_Email.getText().toString().trim();
                uploadData(lophp,name,email);
            }
        });
    }

    private void uploadData(String lophp, String name, String email) {
        dialog.setTitle("adding data to firebase");
        dialog.show();
        String id = UUID.randomUUID().toString();
        Map<String,Object> doc = new HashMap<>();
        doc.put("id",id);
        doc.put("lopHP",lophp);
        doc.put("name",name);
        doc.put("email",email);
        db.collection("customer").document(id).set(doc).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                dialog.dismiss();
                Toast.makeText(AddCustomer.this,"Uploaded...",Toast.LENGTH_SHORT).show();
                startActivity(new Intent(AddCustomer.this, MainActivity2.class));
            }
        })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        dialog.dismiss();
                        Toast.makeText(AddCustomer.this,e.getMessage(),Toast.LENGTH_SHORT).show();
                    }
                });
    }
}