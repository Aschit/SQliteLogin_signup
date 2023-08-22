package com.example.loginsignupwithsqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class signup extends AppCompatActivity {
    EditText editfname;
    EditText editemail;
    EditText editpassword;
    EditText editcpassword;

    TextView txtlogin;
    Button btnsignup;
    DatabaseHelper databaseHelper;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        init();
        databaseHelper = new DatabaseHelper(this);
        btnsignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String fullname=editfname.getText().toString().trim();
                String email=editemail.getText().toString().trim();
                String password= editpassword.getText().toString().trim();
                String cpassword= editcpassword.getText().toString().trim();
                boolean a= databaseHelper.insertUsers(email,password);
                if (a){
                    Toast.makeText(signup.this, "Data Successfully Inserted", Toast.LENGTH_SHORT).show();
                    Intent intent= new Intent(signup.this,login.class);
                    startActivity(intent);




                }


            }
        });

        txtlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent loginintent= new Intent(signup.this,login.class);
                startActivity(loginintent);


            }
        });



    }

    public void  init(){
        editfname= findViewById(R.id.editfname);
        editemail= findViewById(R.id.editemail);
        editpassword= findViewById(R.id.editpassword);
        editcpassword= findViewById(R.id.editCpassword);
        txtlogin= findViewById(R.id.loginText);
        btnsignup= findViewById(R.id.btnsignup);



    }
}