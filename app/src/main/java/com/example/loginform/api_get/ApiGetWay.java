package com.example.loginform.api_get;

import android.content.Context;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.loginform.entity.Emp;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ApiGetWay {

    public List<Emp> getList(Context con){

        List<Emp> employeeList = new ArrayList<>();


        RequestQueue queue = Volley.newRequestQueue(con);
        String url ="http://192.168.20.40:3000/users";

        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

//                        System.out.println("Response: --"+response);
//                                Toast.makeText(ApiMainActivity.this, "Massage: "+ response, Toast.LENGTH_LONG).show();

                        try {
                            JSONArray ja= new JSONArray(response);
                            System.out.println("Array Size:------"+ ja.length());
                            for (int i = 0; i < (ja.length()/3) ; i++) {

                                JSONObject jb = ja.getJSONObject(i);
                                String name = jb.getString("name");
                                String username = jb.getString("username");
                                String password = jb.getString("password");
                                Integer id = jb.getInt("id");
                                System.out.println("Data--"+name+"----------------------------------");
                                Emp emp =  new Emp(jb.getInt("id"), jb.getString("name"), jb.getString("username"), jb.getString("password"));

                                employeeList.add(emp);

                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }


                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                System.out.println("error--"+ error.getLocalizedMessage());
            }
        }){
            protected Map<String, String> getParams(){
                Map<String, String> paramV = new HashMap<>();

                return paramV;
            }
        };
        queue.add(stringRequest);


        return employeeList;
    }


    public void addStudent(Context con, Emp emp){

        List<Emp> empList = new ArrayList<>();


        RequestQueue queue = Volley.newRequestQueue(con);
        String url ="http://192.168.20.40:3000/users";

        StringRequest stringRequest = new StringRequest(Request.Method.POST, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        System.out.println("Response: --"+response);
                        Toast.makeText(con, "Massage: "+ response, Toast.LENGTH_LONG).show();

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                System.out.println("error--"+ error.getLocalizedMessage());
            }
        }){
            protected Map<String, String> getParams(){

                Map<String, String> paramV = new HashMap<>();
                paramV.put("username", emp.getUsername());
                paramV.put("name", emp.getName());
                paramV.put("password", emp.getPassword());
                return paramV;

            }
        };
        queue.add(stringRequest);


    }

    public void updateStudent(Context con, Emp emp){

        List<Emp> studentList = new ArrayList<>();


        RequestQueue queue = Volley.newRequestQueue(con);
        String url ="http://192.168.20.40:3000/users/"+ emp.getId();

        StringRequest stringRequest = new StringRequest(Request.Method.PUT, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        System.out.println("Response: --"+response);
                        Toast.makeText(con, "Massage: "+ response, Toast.LENGTH_LONG).show();

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                System.out.println("error--"+ error.getLocalizedMessage());
            }
        }){
            protected Map<String, String> getParams(){
                Map<String, String> paramV = new HashMap<>();
                paramV.put("id", emp.getId().toString());
                paramV.put("username", emp.getUsername());
                paramV.put("name", emp.getName());
                paramV.put("password", emp.getPassword());
                return paramV;
            }
        };
        queue.add(stringRequest);


    }

    public void deleteStudent(Context con, Integer id){

        List<Emp> studentList = new ArrayList<>();


        RequestQueue queue = Volley.newRequestQueue(con);
        String url ="http://192.168.20.40:3000/users/"+ id;

        StringRequest stringRequest = new StringRequest(Request.Method.DELETE, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        System.out.println("Response: --"+response);
                        Toast.makeText(con, "Massage: "+ response, Toast.LENGTH_LONG).show();

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                System.out.println("error--"+ error.getLocalizedMessage());
            }
        }){
            protected Map<String, String> getParams(){
                Map<String, String> paramV = new HashMap<>();
                return paramV;
            }
        };
        queue.add(stringRequest);


    }
    }



