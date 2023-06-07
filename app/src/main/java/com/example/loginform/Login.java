package com.example.loginform;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.loginform.dao.Database;
import com.example.loginform.drawer.DrawerActivity;

public class Login extends AppCompatActivity {


    EditText edUserName;
    EditText edPassword;
    Button btn;
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        edUserName = findViewById(R.id.editTextLoginUserName);
        edPassword = findViewById(R.id.editTextLoginPassword);
        btn = findViewById(R.id.buttonLogin);
        tv = findViewById(R.id.textViewSignup);

        Database db = new Database(getApplicationContext(), "androidProject", null, 1);

        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Login.this, SignUpActivity.class);
                startActivity(intent);
//                Toast.makeText(getApplicationContext(),"Wrong Password and UserName..", Toast.LENGTH_SHORT).show();
            }
        });



        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String userName = edUserName.getText().toString();
                String password = edPassword.getText().toString();

//                Toast.makeText(
//                        getApplicationContext(), "User Name" + userName + "Password" + password,
//                        Toast.LENGTH_SHORT
//                ).show();

//                if(userName.length() == 0 || password.length() == 0) {
//                    Toast.makeText(getApplicationContext(),"Please Fill All Data Field.", Toast.LENGTH_SHORT).show();
//
//                } else {
//
//                    if (db.login(userName,password) == 1) {
//                        Toast.makeText(getApplicationContext(), "Login Successfully", Toast.LENGTH_SHORT).show();
//
//                        SharedPreferences preferences = getSharedPreferences("Share_Pref", Context.MODE_PRIVATE);
//                        SharedPreferences.Editor editor = preferences.edit();
//                        editor.putString("username", userName);
//                        editor.commit();
//                        editor.apply();
//                        startActivity(new Intent(Login.this, Home2.class));
//                    } else {
//                        Toast.makeText(getApplicationContext(), "Wrong User Name or Password are Inserted", Toast.LENGTH_SHORT).show();
//                    }
//                }

                startActivity(new Intent(Login.this, Home2.class));

            }
        });
    }
}