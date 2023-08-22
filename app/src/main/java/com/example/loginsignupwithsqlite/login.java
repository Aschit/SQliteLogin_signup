package com.example.loginsignupwithsqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class login extends AppCompatActivity {
    Button btnlogin;
    EditText editemail;
    EditText editpassword;
    TextView txthome;

    TextView txtforget;

    DatabaseHelper databaseHelper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        init();
        databaseHelper = new DatabaseHelper(this);
        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = editemail.getText().toString().trim();
                String password = editpassword.getText().toString().trim();

                if (email.equals("") || password.equals("")) {
                    Toast.makeText(login.this, "All the Fields are Mandatory", Toast.LENGTH_SHORT).show();

                } else {
                    Boolean check = databaseHelper.checkEmailPassword(email, password);
                    if (check == true) {
                        Intent intent = new Intent(getApplicationContext(), Home.class);
                        startActivity(intent);
                        Toast.makeText(login.this, "Login Successful", Toast.LENGTH_SHORT).show();

                    }
                }


            }
        });


        txtforget.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent passwordintent = new Intent(getApplicationContext(), forgetpassword.class);
                startActivity(passwordintent);
            }
        });

    }


        public void init () {
            btnlogin = findViewById(R.id.btnlogin);
            editemail = findViewById(R.id.editname);
            editpassword = findViewById(R.id.editpassword);
            txtforget = findViewById(R.id.forget);
            txthome = findViewById(R.id.Home);
        }
    }












