package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

public class MainActivity2 extends AppCompatActivity {
    private final String COLLECTION_KEY = "customer";
    private ListView lsCustomer;
    private ArrayList<Customer> customerArrayList;
    private CustomerAdapter customerAdapter;
    private FirebaseFirestore db;
    private Button btnAdd;
    TextView txtLopHP;
    TextView txtName;
    TextView txtEmail;
    //    ImageView imgPicture;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        lsCustomer = findViewById(R.id.list_view);
    customerArrayList = new ArrayList<>();
        customerArrayList.add( new Customer("NguyenHoanHuu1","DHKTPM15BTT1","huu@gmail.com1",R.drawable.sieu_nhan_gao));
        customerArrayList.add( new Customer("NguyenHoanHuu2","DHKTPM15BTT2","huu@gmail.com2",R.drawable.sieu_nhan_gao));
        customerArrayList.add( new Customer("NguyenHoanHuu3","DHKTPM15BTT3","huu@gmail.com3",R.drawable.sieu_nhan_gao));
        lsCustomer.setAdapter(new CustomerAdapter(MainActivity2.this,R.layout.customer_item,customerArrayList));

//        db.collection(COLLECTION_KEY).get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
//            @Override
//            public void onComplete(@NonNull Task<QuerySnapshot> task) {
//                List<Customer> listCustomer = new ArrayList<>();
//                if(task.isSuccessful()){
//                    for(QueryDocumentSnapshot document : task.getResult()) {
//                        Customer customer = document.toObject(Customer.class);
//                        listCustomer.add(customer);
//                    }
//                    lsCustomer.setAdapter(new CustomerAdapter(MainActivity2.this,R.layout.customer_item, (ArrayList<Customer>) listCustomer));
//                } else {
//                    Log.d("CustomerActivity", "Error getting documents: ", task.getException());
//                }
//            }
//        });


        btnAdd= findViewById(R.id.btnAdd);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity2.this, AddCustomer.class));
            }
        });
    }

}