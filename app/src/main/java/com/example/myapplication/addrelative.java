package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class addrelative extends AppCompatActivity {
    EditText name,number;
    Button add,back;
    public static String numk;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addrelative);
        name=findViewById(R.id.relative_name);
        number=findViewById(R.id.relative_number);
        add=findViewById(R.id.add1);
        back=findViewById(R.id.relative_back2);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String rname=name.getText().toString();
                numk=number.getText().toString();
                Toast.makeText(getApplicationContext(),"the number is added succesfully" , Toast.LENGTH_SHORT).show();


                // Intent inte=new Intent(addrelative.this,MapsActivity.class);
                //inte.putExtra("keynumber",num);
                //startActivity(inte);
            }
        });
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),MainActivity.class));
                finish();
            }
        });

    }


}