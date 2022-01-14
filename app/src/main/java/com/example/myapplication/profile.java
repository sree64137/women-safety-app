package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;

public class profile extends AppCompatActivity {
    TextView uname,umail,unumber;
    FirebaseAuth fauth;
    FirebaseFirestore fstore;
    String userid;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        uname=findViewById(R.id.user_name);
        umail=findViewById(R.id.user_email);
        unumber=findViewById(R.id.user_number);
        fauth=FirebaseAuth.getInstance();
        fstore=FirebaseFirestore.getInstance();
        userid=fauth.getCurrentUser().getUid();
        DocumentReference documentReference=fstore.collection("users").document(userid);
        documentReference.addSnapshotListener(this, new EventListener<DocumentSnapshot>() {
            @Override
            public void onEvent(@Nullable @org.jetbrains.annotations.Nullable DocumentSnapshot value, @Nullable @org.jetbrains.annotations.Nullable FirebaseFirestoreException error) {

                uname.setText(value.getString("fname"));
                umail.setText(value.getString("em"));
                unumber.setText(value.getString("pno"));
            }
        });


    }

    public void back_prof(View view) {
        startActivity(new Intent(getApplicationContext(),MainActivity.class));
        finish();
    }
}