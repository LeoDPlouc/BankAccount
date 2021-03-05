package com.dp.bankaccount;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Base64;
import android.widget.Button;
import android.widget.TextView;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class LoginActivity extends AppCompatActivity {

    TextView username;
    TextView password;
    Button loginBtn;

    @Override
    protected void onStart() {
        super.onStart();

        username = (TextView)findViewById(R.id.login_username_edit);
        password = (TextView)findViewById(R.id.login_password_edit);
        loginBtn = (Button)findViewById(R.id.login_button);

        loginBtn.setOnClickListener(view -> login());
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    protected void login() {
        String pw = password.getText().toString();
        String un = username.getText().toString();

        System.out.println(Base64.encodeToString("https://60102f166c21e10017050128.mockapi.io/labbbank/accounts".getBytes(), 0));

        if(Encrypted.verifyCredential(un, pw)) {
            System.out.println("OKILOUL");
            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
            startActivity(intent);
        }
    }
}