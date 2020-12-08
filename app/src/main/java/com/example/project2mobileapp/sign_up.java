package com.example.project2mobileapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class sign_up extends AppCompatActivity {

    EditText mEmail,mPassword,mRepeatPassword;
    Button mRegisterBtn;
    TextView mLoginBtn;
    DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sign_up);

        db = new DatabaseHelper(this);

        mEmail = findViewById(R.id.Email);
        mPassword = findViewById(R.id.password);
        mRepeatPassword = findViewById(R.id.RepeatPassword);
        mRegisterBtn = findViewById(R.id.registerbtn);
        mLoginBtn = findViewById(R.id.createText);


        mRegisterBtn.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                String email = mEmail.getText().toString().trim();
                String password = mPassword.getText().toString().trim();
                String repeatpassword = mRepeatPassword.getText().toString().trim();
                if(email.equals("")||password.equals("")||repeatpassword.equals("")){
                    Toast.makeText(getApplicationContext(), "Fields are empty", Toast.LENGTH_SHORT).show();
                }
                else {
                    if(password.equals(repeatpassword)){
                        Boolean chkemail = db.chkemail(email);
                        if(chkemail==true){
                            Boolean insert = db.insert(email,password);
                            if(insert==true){
                                Toast.makeText(getApplicationContext(), "Registered Successfully", Toast.LENGTH_SHORT).show();
                            }
                        }
                        else{
                            Toast.makeText(getApplicationContext(), "Email Already exists", Toast.LENGTH_SHORT).show();
                        }
                    }

                }


            }
        });

        mLoginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),sign_in.class));
            }
        });

    }
}
