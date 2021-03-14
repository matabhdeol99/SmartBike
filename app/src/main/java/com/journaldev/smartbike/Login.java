package com.journaldev.smartbike;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.text.Html;
import android.text.Spanned;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

public class Login extends AppCompatActivity implements View.OnClickListener {


    Button btLogin;
    EditText etUsername,etPassword;
    TextView tvRegisterLink;

    private DBManager dbManager;

    private SimpleCursorAdapter adapter;

    DatabaseHelper databaseHelper;

    final String[] from = new String[] { DatabaseHelper._ID,
            DatabaseHelper.USERNAME, DatabaseHelper.PASSWORD };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        dbManager = new DBManager(this);
        dbManager.open();

        Cursor cursor = dbManager.fetch();

        etUsername = (EditText)findViewById(R.id.etPhoneS);
        etPassword = (EditText)findViewById(R.id.etPhoneP);
        btLogin = (Button)findViewById(R.id.btLogin);
        tvRegisterLink = (TextView)findViewById(R.id.tvRegisterLink);

        tvRegisterLink.setOnClickListener(this);

    }
    //This method is for handling fromHtml method deprecation

    public static Spanned fromHtml(String html) {
        Spanned result;
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N) {
            result = Html.fromHtml(html, Html.FROM_HTML_MODE_LEGACY);
        } else {
            result = Html.fromHtml(html);
        }
        return result;
    }

    //This method is used to validate input given by user
    public boolean validate() {
        boolean valid;

        //Get values from EditText fields
        String Username = etUsername.getText().toString();
        String Password = etPassword.getText().toString();


        //Handling validation for Password field
        if (Password.isEmpty()) {
            valid = false;
            Toast toast = Toast.makeText(getApplicationContext(),"Please enter a password!", Toast.LENGTH_LONG);
            toast.show();
            } else {
            if (Password.length() > 5) {
                valid = true;

            } else {
                valid = false;
                Toast toast = Toast.makeText(getApplicationContext(),"Password is too short!", Toast.LENGTH_LONG);
                toast.show();
                }
        }

        return valid;
    }
    @Override
    public void onClick(View v) {

        switch(v.getId()){

            case R.id.tvRegisterLink:

                startActivity(new Intent(this,Register.class));

                break;

        }
    }

    public void sendMessage(View view) {


        final DatabaseHelper databaseHelper;



        databaseHelper = new DatabaseHelper(this);


        String Username = etUsername.getText().toString();
        String Password = etPassword.getText().toString();
        if (Password.isEmpty() || Username.isEmpty() ){
            Toast toast = Toast.makeText(getApplicationContext(),"Username AND Password required!", Toast.LENGTH_LONG);
            toast.show();
        }

        else{

            btLogin.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (validate()) {

                        String UserName1 = etUsername.getText().toString();

                        String Password = etPassword.getText().toString();

                        //Authenticate user
                        User currentUser = databaseHelper.Authenticate(new User(null, UserName1, null,null, Password));

                        //Check Authentication is successful or not
                        if (currentUser != null) {
                            Snackbar.make(btLogin, "Successfully Logged in!", Snackbar.LENGTH_LONG).show();

                            //User Logged in Successfully Launch You home screen activity
                            Intent intent1 = new Intent(Login.this, HomePage.class);

                            startActivity(intent1);
                            finish();
                        } else {

                            //User Logged in Failed
                            Snackbar.make(btLogin, "Failed to log in , please try again", Snackbar.LENGTH_LONG).show();

                        }
                    }
                }
            });

        }

    }

}

