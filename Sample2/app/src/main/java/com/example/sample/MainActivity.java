package com.example.sample;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.RelativeLayout;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

    TextInputEditText TextInputEditText_Password, TextInputEditText_UsernameOrEmail;
    RelativeLayout RelativeLayout_Facebook, RelativeLayout_Google, RelativeLayout_ForgotPassword, RelativeLayout_Login;

    String email_verified       =   "123@gmail.com";
    String password_verifed     =   "1234";
    String input_email    = "";
    String input_password = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextInputEditText_Password = findViewById(R.id.TextInputEditText_Password);
        TextInputEditText_UsernameOrEmail = findViewById(R.id.TextInputEditText_UsernameOrEmail);
        RelativeLayout_Facebook = findViewById(R.id.RelativeLayout_Facebook);
        RelativeLayout_Google = findViewById(R.id.RelativeLayout_Google);
        RelativeLayout_ForgotPassword = findViewById(R.id.RelativeLayout_ForgotPassword);
        RelativeLayout_Login = findViewById(R.id.RelativeLayout_Login);


        RelativeLayout_Login.setClickable(false);
        TextInputEditText_UsernameOrEmail.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(s!=null){
                    input_email=s.toString();
                    RelativeLayout_Login.setClickable(validation());
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        TextInputEditText_Password.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(s!=null){
                    input_password=s.toString();
                    RelativeLayout_Login.setClickable(validation());
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        RelativeLayout_Facebook.setClickable(true);
        RelativeLayout_Google.setClickable(true);
        RelativeLayout_ForgotPassword.setClickable(true);

        RelativeLayout_Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email    =   TextInputEditText_UsernameOrEmail.getText().toString();
                String password =   TextInputEditText_Password.getText().toString();

                Intent intent = new Intent(MainActivity.this,TestActivity.class);
                intent.putExtra("email",email);
                intent.putExtra("password",password);
                startActivity(intent);
            }
        });
    }
    public boolean validation(){
        return input_email.equals(email_verified)&&input_password.equals(password_verifed);
    }
}
