package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.TextView;

public class Informationpage extends AppCompatActivity {
    TextView minf;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_informationpage);
         minf = findViewById(R.id.info);
         minf.setText(Html.fromHtml("<p><h3>HELP LINE NUMBERS</h3></p> " +
                "<p>police :: 100</p><p>Hospital :: 108</p><p><i><center>BE BRAVE BE SAFE</center></i></p>"));
    }

    public void back_info(View view) {
        startActivity(new Intent(getApplicationContext(),MainActivity.class));
        finish();

    }
}