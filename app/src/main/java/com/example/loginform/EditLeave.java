package com.example.loginform;

import static com.example.loginform.R.id.editLeaveId;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.loginform.dao.Database;
import com.example.loginform.entity.LeaveEntity;

import java.util.Calendar;

public class EditLeave extends AppCompatActivity {


    private EditText leaveId;
    private EditText empID;
    private EditText empName;
    private EditText empEmail;
    private Spinner empDepartment;
    private EditText leaveApplyDate;
    private EditText leaveDescription;

    Button btnSubmit;


    private TextView editTextDateFrom;


    private TextView editTextDateTo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_leave);


        leaveId = findViewById(R.id.editLeaveId);
        empID = findViewById(R.id.editEmpId);
        empName = findViewById(R.id.editEmpName);
        empEmail = findViewById(R.id.editEmpEmail);
        empDepartment = findViewById(R.id.editSpinnerDepartment);
        leaveApplyDate = findViewById(R.id.editApplyDate);


        editTextDateFrom = findViewById(R.id.editDateFrom);

        editTextDateTo = findViewById(R.id.editDateTo);
        leaveDescription = findViewById(R.id.editDescription);

        btnSubmit = findViewById(R.id.buttonEdit);

        final Calendar calendar = Calendar.getInstance();
        final int year = calendar.get(Calendar.YEAR);
        final int month = calendar.get(Calendar.MONTH);
        final int day = calendar.get(Calendar.DAY_OF_MONTH);


        leaveApplyDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatePickerDialog dialog = new DatePickerDialog(EditLeave.this, new DatePickerDialog.OnDateSetListener() {
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

        editTextDateFrom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatePickerDialog dialog = new DatePickerDialog(EditLeave.this, new DatePickerDialog.OnDateSetListener() {
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

        editTextDateTo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatePickerDialog dialog = new DatePickerDialog(EditLeave.this, new DatePickerDialog.OnDateSetListener() {
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




        leaveId.setKeyListener(null);


        Intent intent = getIntent();

        String leave_id = intent.getStringExtra("ID");
        String emp_id = intent.getStringExtra("EMP_ID");
        String emp_name = intent.getStringExtra("EMP_NAME");
        String emp_email = intent.getStringExtra("EMP_EMAIL");
        String emp_department = intent.getStringExtra("EMP_DEPARTMENT");
        String apply_date = intent.getStringExtra("APPLY_DATE");
        String leave_from = intent.getStringExtra("LEAVE_FROM");
        String leave_to = intent.getStringExtra("LEAVE_TO");
        String leave_description = intent.getStringExtra("LEAVE_DESCRIPTION");




        leaveId.setText(leave_id);
        empID.setText(emp_id);

        empName.setText(emp_name);
        empEmail.setText(emp_email);
//        empDepartment.setAdapter();
        leaveApplyDate.setText(apply_date);


        editTextDateFrom.setText(leave_from);

        editTextDateTo.setText(leave_to);
        leaveDescription.setText(leave_description);


        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.departments, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);


        empDepartment.setAdapter(adapter);

        Integer pos;
        if(emp_department.contains("Technical")) {
            pos = adapter.getPosition("Technical");
            empDepartment.setSelection(pos);
        } else if (emp_department.contains("Support")) {
            pos = adapter.getPosition("Support");
            empDepartment.setSelection(pos);
        } else if (emp_department.contains("Research and Development")) {
            pos = adapter.getPosition("Research and Development");
            empDepartment.setSelection(pos);
        } else if (emp_department.contains("Marketing")) {
            pos = adapter.getPosition("Marketing");
            empDepartment.setSelection(pos);
        } else if (emp_department.contains("Support")) {
            pos = adapter.getPosition("Support");
            empDepartment.setSelection(pos);
        }else{
            empDepartment.setSelection(0);
        }

        Database db = new Database(getApplicationContext(), "androidProject", null,1);


        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Navigation.findNavController(view).navigate(R.id.nav_gallery);

                LeaveEntity leave = new LeaveEntity();
                Integer lid = Integer.parseInt(leaveId.getText().toString());
                Integer id = Integer.parseInt(empID.getText().toString());
                String name = empName.getText().toString();
                String email = empEmail.getText().toString();
                String department = (String) empDepartment.getSelectedItem();
                String applyDate = leaveApplyDate.getText().toString();
                String from = editTextDateFrom.getText().toString();
                String to = editTextDateTo.getText().toString();
                String description = leaveDescription.getText().toString();


                leave.setLeave_id(lid);
                leave.setEmp_id(id);
                leave.setEmp_name(name);
                leave.setEmp_email(email);
                leave.setEmp_department(department);
                leave.setApply_date(applyDate);
                leave.setLeave_from(from);
                leave.setLeave_to(to);
                leave.setDescription(description);


                Boolean result = db.updateEmployee(leave);
                String message = result ? "Successfully Updated!" : "Failed to Update.";
                Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();//
                Intent intent = new Intent(getApplicationContext(), LeaveList.class);
                startActivity(intent);
            }
        });
    }
}