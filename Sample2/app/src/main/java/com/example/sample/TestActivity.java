package com.example.sample;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;

public class TestActivity extends AppCompatActivity {

    TextView TextView_test;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_test);
            TextView_test = findViewById(R.id.TextView_test);
            Intent intent = getIntent();

            Bundle bundle   = intent.getExtras();
            String email    = bundle.getString("email");
            String password = bundle.getString("password");

            TextView_test.setText(email+"/"+password);

    }
}
