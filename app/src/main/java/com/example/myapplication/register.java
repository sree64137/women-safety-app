package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

import static android.content.ContentValues.TAG;

public class register extends AppCompatActivity {
    EditText mfullname,memail,mpassword,mphone;
    Button mregisterbtn;
    TextView mloginbtn;
    FirebaseAuth fauth;
    FirebaseFirestore fstore;
    String userId;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        mfullname=findViewById(R.id.full_name);
        memail=findViewById(R.id.email);
        mpassword=findViewById(R.id.password);
        mphone=findViewById(R.id.phone_number);
        mregisterbtn=findViewById(R.id.registerbtn);
        mloginbtn=findViewById(R.id.loginbtn);
        fauth=FirebaseAuth.getInstance();
        fstore=FirebaseFirestore.getInstance();
        if(fauth.getCurrentUser()!=null){
            startActivity(new Intent(getApplicationContext(),MainActivity.class));
            finish();

        }

        mregisterbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email=memail.getText().toString().trim();
                String password=mpassword.getText().toString().trim();
                String fullname=mfullname.getText().toString().trim();
                String phone=mphone.getText().toString().trim();

                if(TextUtils.isEmpty(email)){
                    memail.setError("email is required");
                    return;
                }
                if(TextUtils.isEmpty(password)){
                    mpassword.setError("email is required");
                    return;
                }
                if(password.length()<6){
                    mpassword.setError("password is not less than 6 characters");

                }
                fauth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()){
                            Toast.makeText(register.this, "user added", Toast.LENGTH_SHORT).show();
                            userId=fauth.getCurrentUser().getUid();
                            DocumentReference documentReference=fstore.collection("users").document(userId);
                            Map<String,Object> user=new HashMap<>();
                            user.put("fname",fullname);
                            user.put("em",email);
                            user.put("pno",phone);
                            documentReference.set(user).addOnSuccessListener(new OnSuccessListener<Void>() {
                                @Override
                                public void onSuccess(Void unused) {
                                    Log.d(TAG,"onSucess:user profile is created for "+userId);

                                }
                            });

                            startActivity(new Intent(getApplicationContext(),MainActivity.class));

                        }
                        else{
                            Toast.makeText(register.this, "error is happen"+task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                        }

                    }
                });


            }
        });
        mloginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),login.class));

            }
        });
    }
}