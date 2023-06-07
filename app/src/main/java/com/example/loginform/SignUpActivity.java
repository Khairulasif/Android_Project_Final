package com.example.loginform;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.loginform.dao.Database;

public class SignUpActivity extends AppCompatActivity {


    RadioGroup radioGroup;


    CheckBox java, php, c;

    Button submit, clear;
    EditText regName;
    EditText regEmail;
    EditText regPassword;
    Button btn;

    TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        regName = findViewById(R.id.editTextRegisName);
        regEmail = findViewById(R.id.editTextRegisEmail);
        regPassword = findViewById(R.id.editTextRegisPassword);
        btn = findViewById(R.id.buttonSignUp);

        radioGroup=(RadioGroup)findViewById(R.id.radioGroup);
        radioGroup.clearCheck();

        java = findViewById(R.id.checkBoxJava);
        php = findViewById(R.id.checkBoxPHP);
        c = findViewById(R.id.checkBoxCsherp);


        tv = findViewById(R.id.textViewLogin);


        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SignUpActivity.this, Login.class);
                startActivity(intent);
//                Toast.makeText(getApplicationContext(),"Wrong Password and UserName..", Toast.LENGTH_SHORT).show();
            }
        });



        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String name = regName.getText().toString();
                String email = regEmail.getText().toString();
                String password = regPassword.getText().toString();


                String gender = "";
                String course = "";





                int selectedId = radioGroup.getCheckedRadioButtonId();
                if (selectedId == -1) {
                    Toast.makeText(SignUpActivity.this,
                                    "No answer has been selected-(" + selectedId,
                                    Toast.LENGTH_SHORT)
                            .show();
                }
                else {

                    RadioButton radioButton = radioGroup.findViewById(selectedId);

                    // Now display the value of selected item
                    // by the Toast message
                    gender = radioButton.getText().toString();
                }


                if(java.isChecked()){
                    course +=" " + "Java";
                }
                if(php.isChecked()){
                    course +=" " + "PHP";
                }
                if(c.isChecked()){
                    course +=" " + "C++";
                }
//                Toast.makeText(SignUpActivity.this,radioText+ "--" +CheckBoxText, Toast.LENGTH_SHORT).show();


                Database db = new Database(getApplicationContext(), "androidProject", null, 1);



                if (name.length() == 0 || email.length() == 0 || password.length() == 0 || gender.length() == 0 || course.length() == 0) {

                    Toast.makeText(getApplicationContext(), "Please fill the all data field", Toast.LENGTH_SHORT).show();
                }else {
                    if (true) {
                        db.addNewUser(name, email, password, gender, course);
                        Toast.makeText(getApplicationContext(), "Record Inserted", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(SignUpActivity.this, Login.class));
                    } else {
//                        Toast.makeText(getApplicationContext(), "", Toast.LENGTH_SHORT).show();
                    }
                }
                Toast.makeText(getApplicationContext(), "Name :" + name +  "Email :" +email+  "Password :" + password +  "Gender :" + gender +  "Interested :" + course , Toast.LENGTH_SHORT).show();

//                Toast.makeText(
//                        getApplicationContext(), "Name" + name + "Email" + email + "Password" + password,
//                        Toast.LENGTH_SHORT
//                ).show();


            }
        });
    }
}