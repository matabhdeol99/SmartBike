package com.journaldev.smartbike;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.material.snackbar.Snackbar;

import android.widget.Toast;


public class Register extends AppCompatActivity  implements View.OnClickListener{

    Button btRegister;
    EditText etName, etPhone, etEmail, etUsername, etPassword;
    TextView tvLoginLink;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        etName = (EditText)findViewById(R.id.etName);
        etEmail = (EditText)findViewById(R.id.etEmail);
        etPhone = (EditText)findViewById(R.id.etPhone);
        etUsername = (EditText)findViewById(R.id.etUsername);
        etPassword = (EditText)findViewById(R.id.etPassword);
        btRegister = (Button)findViewById(R.id.btSaveContact);

        final DatabaseHelper databaseHelper;


        tvLoginLink = (TextView)findViewById(R.id.tvLoginLink);
        tvLoginLink.setOnClickListener(this);
        databaseHelper = new DatabaseHelper(this);



        btRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (validate()) {
                    String UserName = etUsername.getText().toString();
                    String Phone = etPhone.getText().toString();
                    String Email = etEmail.getText().toString();
                    String Password = etPassword.getText().toString();


                    //Check in the database is there any user associated with  this email
                    if (!databaseHelper.isEmailExists(Email)) {

                        //Email does not exist now add new user to database
                        databaseHelper.addUser(new User(null, UserName, Phone, Email, Password));
                        Snackbar.make(btRegister, "User created successfully! Please Login ", Snackbar.LENGTH_LONG).show();


                    }else {

                        //Email exists with email input provided so show error user already exist
                        Snackbar.make(btRegister, "User already exists with same email ", Snackbar.LENGTH_LONG).show();
                    }


                }
            }
        });
    }

    public boolean validate() {
        boolean valid = false;

        //Get values from EditText fields
        String UserName = etUsername.getText().toString();
        String Phone = etPhone.getText().toString();
        String Email = etEmail.getText().toString();
        String Password = etPassword.getText().toString();

        //Handling validation for UserName field
        if (UserName.isEmpty()) {
            valid = false;
            Toast toast = Toast.makeText(getApplicationContext(),"Please enter valid username!", Toast.LENGTH_LONG);
            toast.show();

        }

        //Handling validation for Email field
        if (!android.util.Patterns.EMAIL_ADDRESS.matcher(Email).matches()) {
            valid = false;
            Toast toast = Toast.makeText(getApplicationContext(),"Please enter valid email!", Toast.LENGTH_LONG);
            toast.show();

        } else {
            valid = true;

        }

        //Handling validation for Password field
        if (Password.isEmpty()) {
            valid = false;
            Toast toast = Toast.makeText(getApplicationContext(),"Please enter valid password!", Toast.LENGTH_LONG);
            toast.show();
        } else {
            if (Password.length() > 5) {
                valid = true;

            } else {
                valid = false;
                Toast toast = Toast.makeText(getApplicationContext(),"Please is too short!", Toast.LENGTH_LONG);
                toast.show();

            }
        }


        return valid;
    }

    @Override
    public void onClick(View v) {

        switch(v.getId()){
            case R.id.btSaveContact:

                startActivity(new Intent(this,Login.class));
                break;

            case R.id.tvLoginLink:

                startActivity(new Intent(this,Login.class));
                break;

        }
    }


}
