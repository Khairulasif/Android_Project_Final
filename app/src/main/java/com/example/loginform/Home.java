package com.example.loginform;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Toast;

public class Home extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);




        SharedPreferences preferences = getSharedPreferences("Share_Pref", Context.MODE_PRIVATE);
        String username = preferences.getString("username", "");
        Toast.makeText(getApplicationContext(), "Welcome " +username+ "!", Toast.LENGTH_SHORT).show();



//        SharedPreferences.Editor editor = preferences.edit();
//        editor.putString("username", userName);
//        editor.commit();
    }
}