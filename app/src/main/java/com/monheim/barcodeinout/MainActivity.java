package com.monheim.barcodeinout;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import MssqlCon.SqlCon;
import MssqlCon.Login;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        try {
            this.getSupportActionBar().hide();
        } catch (NullPointerException e) {
        }
        setContentView(R.layout.activity_main);

        Button btn = (Button) findViewById(R.id.btnLogin);
        EditText etUser = (EditText) findViewById(R.id.edtUserName);
        EditText etPass = (EditText) findViewById(R.id.edtPassword);

        Login login = new Login();

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
                NetworkInfo ni = cm.getActiveNetworkInfo();

                if (ni != null && ni.getType() == ConnectivityManager.TYPE_WIFI)
                {
                    String userName = etUser.getText().toString();
                    String pass = etPass.getText().toString();

                    if (login.CheckUser(userName, pass)) {
                        startActivity(new Intent(MainActivity.this, HomeActivity.class));
                    } else {
                        Toast.makeText(MainActivity.this, "Invalid Username or Password.", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(MainActivity.this, "Please check if you are connected to wifi.", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}