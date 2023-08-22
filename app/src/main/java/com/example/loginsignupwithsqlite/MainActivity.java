package com.example.loginsignupwithsqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button btnlogin;
    Button btnsignup;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnlogin= findViewById(R.id.btnlogin);
        btnsignup= findViewById(R.id.btnsignup);
    }

    public  void  login(View view){
        Intent loginintent= new Intent(getApplicationContext(),login.class);
        startActivity(loginintent);
    }

    public void signup(View view){
        Intent signupintent= new Intent(getApplicationContext(),signup.class);
        startActivity(signupintent);

    }













}