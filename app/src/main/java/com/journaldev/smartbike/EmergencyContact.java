package com.journaldev.smartbike;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import com.google.firebase.auth.ActionCodeSettings;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.EmailAuthProvider;
import com.google.firebase.auth.FacebookAuthProvider;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthSettings;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.GithubAuthProvider;
import com.google.firebase.auth.GoogleAuthProvider;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthOptions;
import com.google.firebase.auth.PhoneAuthProvider;
import com.google.firebase.auth.PlayGamesAuthProvider;
import com.google.firebase.auth.SignInMethodQueryResult;
import com.google.firebase.auth.UserInfo;
import com.google.firebase.auth.UserProfileChangeRequest;


public class EmergencyContact extends AppCompatActivity {

    EditText etName, etPhoneP, etPhoneS, etEmail;
    Button btSaveContact;
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference reference;
    DocumentReference documentReference;
    FirebaseFirestore db = FirebaseFirestore.getInstance();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_emergencycontact);

        etName = findViewById(R.id.etName);
        etPhoneP = findViewById(R.id.etPhoneP);
        etPhoneS = findViewById(R.id.etPhoneS);
        etEmail = findViewById(R.id.etEmail);

        btSaveContact = findViewById(R.id.btSaveContact);

        btSaveContact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateProfile();
            }
        });

    }

    @Override
    protected void onStart(){
        super.onStart();
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        String currentuid = user.getUid();
    documentReference.collection("user").document(currentuid);

    documentReference.get()
            .addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
                @Override
                public void onComplete(@NonNull Task<DocumentSnapshot> task) {



                    String nameResult = task.getResult().getString("name");
                    String phonePResult = task.getResult().getString("name");
                    String phoneSResult = task.getResult().getString("name");
                    String emailResult = task.getResult().getString("name");


                    etName.setText(nameResult);
                    etPhoneP.setText(phonePResult);
                    etPhoneS.setText(phoneSResult);
                    etEmail.setText(emailResult);


                }
            });
    }
    private void updateProfile(){
        String name = etName.getText().toString();
        String phoneP = etPhoneP.getText().toString();
        String phoneS = etPhoneS.getText().toString();
        String email = etEmail.getText().toString();

        String currentuid;


    }


    public void sendHome(View view){
        Intent intent = new Intent(this, HomePage.class);
        startActivity(intent);
    }
    public void sendLogout(View view){
        Intent intent = new Intent(this, Login.class);
        startActivity(intent);
    }

}