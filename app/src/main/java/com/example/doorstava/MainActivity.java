package com.example.doorstava;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.Task;

public class MainActivity extends AppCompatActivity {
    GoogleSignInOptions gso;
    GoogleSignInClient gsc;
    ImageView google_button;

    @Override
    protected void onCreate(Bundle savedInstanceStates) {
        super.onCreate(savedInstanceStates);
        setContentView(R.layout.activity_main);

        google_button=findViewById(R.id.google_button);
        gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN).requestEmail().build();
        gsc=GoogleSignIn.getClient(this,gso);

        google_button.setOnClickListener(view -> signIn());
    }
     void signIn(){
         Intent signInIntent = gsc.getSignInIntent();
         startActivityForResult(signInIntent,1000);
     }

    @Override
    protected void onActivityResult(int requestCode, int resultCode,Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==1000){
            Task<GoogleSignInAccount>task=GoogleSignIn.getSignedInAccountFromIntent(data);

            try {
                task.getResult(ApiException.class);
                navigateToSecondActivity();
            } catch (ApiException e) {
                Toast.makeText(this, "Something Went Wrong", Toast.LENGTH_SHORT).show();
            }

        }
    }
    void navigateToSecondActivity(){
        finish();
        Intent intent= new Intent(MainActivity.this,google_login.class);
        startActivity(intent);
    }
}
