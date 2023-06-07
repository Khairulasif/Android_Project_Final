package com.example.loginform;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.loginform.api_get.ApiGetWay;
import com.example.loginform.entity.Emp;

import java.util.List;

public class ApiActivity extends AppCompatActivity {

    Button btn1;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_api);

        btn1 = findViewById(R.id.buttonTest);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ApiGetWay apiGet = new ApiGetWay();

//                try {
//                    List<Emp>  emp = apiGet.getList(getApplicationContext());
//                    Toast.makeText(getApplicationContext(),"Employee : " + emp.size(), Toast.LENGTH_SHORT).show();
//                } catch (Exception e) {
//
//                }


                Emp emp  = new Emp();
//                emp.setName("Nafin Shona");
//                emp.setUsername("nafiunShona");
//                emp.setPassword("3432j4hjk5h34j5k");
//
//                apiGet.addStudent(getApplicationContext(),emp);


                emp.setId(45644);
//                apiGet.updateStudent(getApplicationContext(),emp);
//
//
//
                apiGet.deleteStudent(getApplicationContext(),45644);





            }
        });





    }
}