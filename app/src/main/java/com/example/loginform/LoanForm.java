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
import android.widget.Toast;

import com.example.loginform.dao.Database;

import java.util.Calendar;

public class LoanForm extends AppCompatActivity {



    private EditText empID;
    private EditText empName;

    private Spinner empDepartment;
    private EditText loanApplyDate;
    private EditText loanAmount;
    private EditText loanInstallment;
    private EditText loanDescription;
    Button btnSubmit;

    final Calendar calendar = Calendar.getInstance();
    final int year = calendar.get(Calendar.YEAR);
    final int month = calendar.get(Calendar.MONTH);
    final int day = calendar.get(Calendar.DAY_OF_MONTH);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loan_form);


        empID = findViewById(R.id.editTextLoanempId);
        empName = findViewById(R.id.editTextLoanempName);

        empDepartment = findViewById(R.id.spinnerDepartment);
        loanApplyDate = findViewById(R.id.editTextApplyDate);
        loanAmount = findViewById(R.id.editTextLoanAmount);
        loanInstallment = findViewById(R.id.editTextInstallmentAmount);


        loanDescription = findViewById(R.id.editTextLoanDescription);

        btnSubmit = findViewById(R.id.buttonLoanSubmit);


        loanApplyDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatePickerDialog dialog = new DatePickerDialog(LoanForm.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {

                        month = month+1;
                        String date = dayOfMonth +"/" + month + "/" + year;
                        loanApplyDate.setText(date);
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

                String empDepartGet = empDepartment.getSelectedItem().toString();
                String empApplyDateGet = loanApplyDate.getText().toString();
                String empLoanAmounts = loanAmount.getText().toString();
                int empLoanAmount = Integer.parseInt(empLoanAmounts);
                String empLoanInstallments = loanInstallment.getText().toString();
                int empLoanInstallment = Integer.parseInt(empLoanInstallments);
                String leaveDescrip = loanDescription.getText().toString();

                Database db = new Database(getApplicationContext(), "androidProject", null, 1);

                if ( empNameGet.length() == 0 || empDepartGet.length() == 0 || empApplyDateGet.length() == 0 || String.valueOf(empLoanAmount).length() == 0 || String.valueOf(empLoanInstallment).length() == 0 || leaveDescrip.length() == 0) {

                    Toast.makeText(getApplicationContext(), "Please fill the all data field", Toast.LENGTH_SHORT).show();
                }else {
                    if (true) {
                        db.addLoanApplication(empIdGet, empNameGet, empDepartGet, empApplyDateGet, empLoanAmount, empLoanInstallment, leaveDescrip);
                        Toast.makeText(getApplicationContext(), "Record Inserted", Toast.LENGTH_SHORT).show();
//                        startActivity(new Intent(LeaveForm.this, LeaveList.class));
                    } else {
                        Toast.makeText(getApplicationContext(), "Insert Failed", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}