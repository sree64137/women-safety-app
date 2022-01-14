package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.TextView;

public class developedby extends AppCompatActivity {
    TextView mdev;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_developedby);
        mdev=findViewById(R.id.developers);
        mdev.setText(Html.fromHtml("<p>O.Srinath Reddy</p> " +
                "<p>Y.Naveen Reddy</p><p>B.Koishil</<p><p><i><center>If any queries please mail to <q>sreenathreddy6526@gmail.com</q></center></i></p>"));
    }

    public void back_dev(View view) {
        startActivity(new Intent(getApplicationContext(),MainActivity.class));
        finish();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}