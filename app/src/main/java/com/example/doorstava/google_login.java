package com.example.doorstava;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;

public class google_login extends AppCompatActivity {
    GoogleSignInOptions gso;
    GoogleSignInClient gsc;
    TextView name,mail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_google_login);

        name=findViewById(R.id.name);
        mail=findViewById(R.id.mail);

        gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN).requestEmail().build();
        gsc= GoogleSignIn.getClient(this,gso);

        GoogleSignInAccount acct=GoogleSignIn.getLastSignedInAccount(this);
        if(acct!=null){
            String personName=acct.getDisplayName();
            String personEmail=acct.getEmail();
            name.setText(personName);
            mail.setText(personEmail); finish(); startActivity(new Intent(google_login.this,MainActivity.class));

        }
    }
}






