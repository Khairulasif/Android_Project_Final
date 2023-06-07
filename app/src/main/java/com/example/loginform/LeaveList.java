package com.example.loginform;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import com.example.loginform.dao.Database;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

public class LeaveList extends AppCompatActivity {



    ArrayList leaveList;

    Button createBtn;

    SimpleAdapter sa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leave_list);

        Database db = new Database(getApplicationContext(), "androidProject", null, 1);
        leaveList = new ArrayList<>();
        leaveList = db.getLeaveList();

        System.out.println(leaveList);

        sa = new SimpleAdapter(this,
                leaveList,
                R.layout.leavelistview,
                new String[]{"EMP_ID", "EMP_NAME", "APPLY_DATE", "EMP_DEPARTMENT"},
                new int[]{R.id.line_id1, R.id.line_c1, R.id.line_d1, R.id.line_e1}
        ) {
            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                View v = super.getView(position, convertView, parent);

                ImageView editBtn = v.findViewById(R.id.emp_edit_btn1);
                ImageView delBtn = v.findViewById(R.id.emp_del_btn1);


                editBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        System.out.println(position);
                        HashMap<String, String> user = new HashMap<>();

                        try {
//                            System.out.println(v.findViewById(R.id.line_c).toString());

                            user = (HashMap<String, String>) leaveList.get(position);


                            System.out.println(leaveList.get(position));
                        } catch (Exception e) {
                            e.printStackTrace();
                        }

//                        Toast.makeText(EmpListActivity.this, "Edit button clicked!! + " + position + user, Toast.LENGTH_SHORT).show();
                        System.out.println("EDIT----");
                        Intent intent = new Intent(getApplicationContext(), EditLeave.class);
                        intent.putExtra("ID", user.get("ID"));
                        intent.putExtra("EMP_ID", user.get("EMP_ID"));
                        intent.putExtra("EMP_NAME", user.get("EMP_NAME"));
                        intent.putExtra("EMP_EMAIL", user.get("EMP_EMAIL"));
                        intent.putExtra("EMP_DEPARTMENT", user.get("EMP_DEPARTMENT"));
                        intent.putExtra("APPLY_DATE", user.get("APPLY_DATE"));

                        intent.putExtra("LEAVE_FROM", user.get("LEAVE_FROM"));
                        intent.putExtra("LEAVE_TO", user.get("LEAVE_TO"));
                        intent.putExtra("LEAVE_DESCRIPTION", user.get("LEAVE_DESCRIPTION"));


                        startActivity(intent);
                    }
                });

                delBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        HashMap<String, String> user = new HashMap<>();

                        user = (HashMap<String, String>) leaveList.get(position);

                        boolean deleted = db.deleteEmployee(Integer.parseInt(Objects.requireNonNull(user.get("ID"))));
                        if (deleted) {
                            leaveList.remove(position);
                            notifyDataSetChanged();
                        }
                        String message = deleted ? "Successfully deleted" : "Failed to delete";
                        Toast.makeText(LeaveList.this, message, Toast.LENGTH_SHORT).show();
                    }
                });


                return v;
            }


        };

        ListView lv = findViewById(R.id.listViewUD);
        lv.setAdapter(sa);

    }
}