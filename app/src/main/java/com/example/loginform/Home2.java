package com.example.loginform;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Home2 extends AppCompatActivity {



    CardView cardV;
    CardView cardVTest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home2);

        cardV = findViewById(R.id.leaveCard);
        cardVTest = findViewById(R.id.settingCard);


        cardV.setOnClickListener(new View.OnClickListener() {



            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Home2.this, LeaveForm.class);
                startActivity(intent);
//                Toast.makeText(getApplicationContext(),"Wrong Password and UserName..", Toast.LENGTH_SHORT).show();
            }
        });

        cardVTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Home2.this, ApiActivity.class);
                startActivity(intent);
            }

        });
        }




}