package com.example.loginform;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.loginform.dao.Database;

import java.util.Calendar;

public class LeaveForm extends AppCompatActivity {




    private EditText empID;
    private EditText empName;
    private EditText empEmail;
    private Spinner empDepartment;
    private EditText leaveApplyDate;
    private EditText leaveDescription;

    Button btnSubmit;

//    private TextView textViewSelectDateFrom;
    private EditText editTextDateFrom;

//    private TextView textViewSelectDateTo;
    private EditText editTextDateTo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leave_form);



        empID = findViewById(R.id.editTextempId);
        empName = findViewById(R.id.editTextempName);
        empEmail = findViewById(R.id.editTextempEmail);
        empDepartment = findViewById(R.id.spinnerDepartment);
        leaveApplyDate = findViewById(R.id.editTextApplyDate);

//        textViewSelectDateFrom = findViewById(R.id.textViewSelectDateFrom);
        editTextDateFrom = findViewById(R.id.editTextDateFrom);
//        textViewSelectDateTo = findViewById(R.id.textViewSelectDateTo);
        editTextDateTo = findViewById(R.id.editTextDateTo);
        leaveDescription = findViewById(R.id.editTextDescription);

        btnSubmit = findViewById(R.id.buttonSubmit);

        final Calendar calendar = Calendar.getInstance();
        final int year = calendar.get(Calendar.YEAR);
        final int month = calendar.get(Calendar.MONTH);
        final int day = calendar.get(Calendar.DAY_OF_MONTH);




        leaveApplyDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatePickerDialog dialog = new DatePickerDialog(LeaveForm.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {

                        month = month+1;
                        String date = dayOfMonth +"/" + month + "/" + year;
                        leaveApplyDate.setText(date);
                    }
                },year, month, day);
                dialog.show();
            }
        });

//        textViewSelectDateFrom.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                DatePickerDialog dialog = new DatePickerDialog(LeaveForm.this, new DatePickerDialog.OnDateSetListener() {
//                    @Override
//                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
//
//                        month = month + 1;
//                        String date = dayOfMonth +"/" + month + "/" + year;
//                        editTextDateFrom.setText(date);
//                    }
//                },year, month, day);
//                dialog.show();
//            }
//        });
//
        editTextDateFrom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatePickerDialog dialog = new DatePickerDialog(LeaveForm.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {

                        month = month+1;
                        String date = dayOfMonth +"/" + month + "/" + year;
                        editTextDateFrom.setText(date);
                    }
                },year, month, day);
                dialog.show();
            }
        });
//
//        textViewSelectDateFrom.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                DatePickerDialog dialog = new DatePickerDialog(LeaveForm.this, new DatePickerDialog.OnDateSetListener() {
//                    @Override
//                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
//
//                        month = month+1;
//                        String date = dayOfMonth +"/" + month + "/" + year;
//                        editTextDateFrom.setText(date);
//                    }
//                },year, month, day);
//                dialog.show();
//            }
//        });
//
        editTextDateTo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatePickerDialog dialog = new DatePickerDialog(LeaveForm.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {

                        month = month+1;
                        String date = dayOfMonth +"/" + month + "/" + year;
                        editTextDateTo.setText(date);
                    }
                },year, month, day);
                dialog.show();
            }
        });

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String empIdGetS = empID.getText().toString();
                int empIdGet = Integer.parseInt(empIdGetS);
                String empNameGet = empName.getText().toString();
                String empEmailGet = empEmail.getText().toString();
                String empDepartGet = empDepartment.getSelectedItem().toString();
                String empApplyDateGet = leaveApplyDate.getText().toString();
                String fromDateGet = editTextDateFrom.getText().toString();
                String toDateGet = editTextDateTo.getText().toString();
                String leaveDescrip = leaveDescription.getText().toString();

                Database db = new Database(getApplicationContext(), "androidProject", null, 1);

                if ( empNameGet.length() == 0 || empEmailGet.length() == 0 || empDepartGet.length() == 0 || empApplyDateGet.length() == 0 || fromDateGet.length() == 0 || toDateGet.length() == 0 || leaveDescrip.length() == 0) {

                    Toast.makeText(getApplicationContext(), "Please fill the all data field", Toast.LENGTH_SHORT).show();
                }else {
                    if (true) {
                        db.addLeaveApplication(empIdGet, empNameGet, empEmailGet, empDepartGet, empApplyDateGet, fromDateGet, toDateGet, leaveDescrip);
                        Toast.makeText(getApplicationContext(), "Record Inserted", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(LeaveForm.this, LeaveList.class));
                    } else {
//                        Toast.makeText(getApplicationContext(), "", Toast.LENGTH_SHORT).show();
                    }
                }



//                Toast.makeText(getApplicationContext(),"ID" + empIdGet +
//                        "Name" + empNameGet +
//                        "Email" + empEmailGet +
//                        "Department" + empDepartGet +
//                        "Apply" + empApplyDateGet +
//                        "From" + fromDateGet +
//                        "To" + toDateGet +
//                        "Description" + leaveDescrip, Toast.LENGTH_SHORT).show();
            }
        });


    }
}