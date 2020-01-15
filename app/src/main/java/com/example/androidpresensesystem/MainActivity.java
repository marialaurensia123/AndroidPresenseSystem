package com.example.androidpresensesystem;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.firebase.ui.auth.AuthUI;

public class MainActivity extends AppCompatActivity {

    Button btnLogin;
    private final static int LOGIN_PERMISSION=1000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnLogin = (Button)findViewById(R.id.btnSignIn);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivityForResult(
                        AuthUI.getInstance().createSignInIntentBuilder()
                        .setAllowNewEmailAccounts(true).build(),LOGIN_PERMISSION
                );
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if(requestCode==LOGIN_PERMISSION){
            startActivity(resultCode,data);
        }
    }

    private void startActivity(int resultCode, Intent data) {
        if(resultCode == RESULT_OK){
            Intent intent = new Intent(MainActivity.this,ListOnline.class);
            startActivity(intent);
            finish();
        }else{
            Toast.makeText(this, "Login Failed!!", Toast.LENGTH_SHORT).show();
        }
    }
}
