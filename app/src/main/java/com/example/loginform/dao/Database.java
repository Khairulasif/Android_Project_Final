package com.example.loginform.dao;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.loginform.entity.LeaveEntity;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

public class  Database extends SQLiteOpenHelper {


    public Database(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {


        String query = "CREATE TABLE USER_TEST (id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "NAME TEXT, " +

                "EMAIL TEXT, " +
                "PASSWORD TEXT,"+
                "GENDER TEXT," +
                "COURSE TEXT)" ;


        db.execSQL(query);

        String leaveApplicationSave = "CREATE TABLE LEAVE_APPLICATION (ID INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "EMP_ID INTEGER, " +
                "EMP_NAME TEXT, " +

                "EMP_EMAIL TEXT, " +
                "EMP_DEPARTMENT TEXT,"+
                "APPLY_DATE TEXT," +
                "LEAVE_FROM TEXT, " +
                "LEAVE_TO TEXT, " +
                "LEAVE_DESCRIPTION TEXT )";


        db.execSQL(leaveApplicationSave);

    }


    public void addLeaveApplication(Integer emp_id, String emp_name, String emp_email, String emp_department, String apply_date, String leave_from, String leave_to, String description) {

        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put("EMP_ID", emp_id);
        values.put("EMP_NAME", emp_name);
        values.put("EMP_EMAIL", emp_email);
        values.put("EMP_DEPARTMENT", emp_department);
        values.put("APPLY_DATE", apply_date);
        values.put("LEAVE_FROM", leave_from);
        values.put("LEAVE_TO", leave_to);
        values.put("LEAVE_DESCRIPTION", description);


        db.insert("LEAVE_APPLICATION", null, values);

        db.close();

    }




    public void addNewUser(String name, String email, String password, String gender, String course) {

        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put("Name", name);
        values.put("EMAIL", email);
        values.put("PASSWORD", password);
        values.put("GENDER", gender);
        values.put("COURSE", course);
//        values.put("PHP", php);
//        values.put("CSHERP", csherp);

        db.insert("USER", null, values);

        db.close();

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public int login(String user, String password) {

        int result = 0;
        String[] arr = new String[2];
        arr[0] = user;
        arr[1] = password;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor c = db.rawQuery("select * from USER where NAME=? and PASSWORD=?", arr);

        if (c.moveToFirst()) {
            return 1;
        }
        return 0;
    }

    public ArrayList<HashMap<String, String>> getLeaveList() {

        SQLiteDatabase db = this.getWritableDatabase();
        @SuppressLint("Recycle") Cursor c = db.rawQuery("select * from  LEAVE_APPLICATION", null);

        ArrayList<HashMap<String, String>> leaveList = new ArrayList<>(c.getCount());
        HashMap<String, String> list;
        if (c.moveToFirst()) {

            do {
                list = new HashMap<>();
                list.put("ID", c.getString(0));
                list.put("EMP_ID", c.getString(1));
                list.put("EMP_NAME", c.getString(2));
                list.put("EMP_EMAIL", c.getString(3));
                list.put("EMP_DEPARTMENT", c.getString(4));
                list.put("APPLY_DATE", c.getString(5));
                list.put("LEAVE_FROM", c.getString(6));
                list.put("LEAVE_TO", c.getString(7));
                list.put("LEAVE_DESCRIPTION", c.getString(8));

                leaveList.add(list);

            } while (c.moveToNext());

        }
        db.close();
        return leaveList;
    }

    public boolean updateEmployee(LeaveEntity leaveEntity) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();


        values.put("ID", leaveEntity.getLeave_id());
        values.put("EMP_ID", leaveEntity.getEmp_id());
        values.put("EMP_NAME", leaveEntity.getEmp_name());
        values.put("EMP_EMAIL", leaveEntity.getEmp_email());
        values.put("EMP_DEPARTMENT", leaveEntity.getEmp_department());
        values.put("APPLY_DATE", leaveEntity.getApply_date());
        values.put("LEAVE_FROM", leaveEntity.getLeave_from());
        values.put("LEAVE_TO", leaveEntity.getLeave_to());
        values.put("LEAVE_DESCRIPTION", leaveEntity.getDescription());
        int result = db.update("LEAVE_APPLICATION", values, "id = ?", new String[]{leaveEntity.getLeave_id() + ""});
        db.close();

        return result > 0;
    };

    public boolean deleteEmployee(int id) {
        SQLiteDatabase db = this.getWritableDatabase();
        int rowCount = db.delete("LEAVE_APPLICATION", "id = ?", new String[]{id + ""});
        db.close();
        return rowCount > 0;
    }



}
