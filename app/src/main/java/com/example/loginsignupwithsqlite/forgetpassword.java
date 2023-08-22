package com.example.loginsignupwithsqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.loginsignupwithsqlite.databinding.ActivityForgetpasswordBinding;

public class forgetpassword extends AppCompatActivity {

    ActivityForgetpasswordBinding binding;
    DatabaseHelper databaseHelper;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgetpassword);
        binding=ActivityForgetpasswordBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

       databaseHelper= new DatabaseHelper(this);

       binding.btncode.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               String email= binding.forgetemail.getText().toString().trim();
               if (email.isEmpty()){
                   Toast.makeText(forgetpassword.this, "Please Enter the Email", Toast.LENGTH_SHORT).show();
                   Intent intent1= new Intent(getApplicationContext(),login.class);
                   startActivity(intent1);

               }
                boolean check= databaseHelper.checkEmail(email);
               if (check==true){
                   Toast.makeText(forgetpassword.this, "Check Email", Toast.LENGTH_SHORT).show();
                   Intent loginintent = new Intent(getApplicationContext(), login.class);
                   startActivity(loginintent);
               }

               }





       });




        }


    }
