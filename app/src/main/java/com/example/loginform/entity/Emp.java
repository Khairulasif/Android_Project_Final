package com.example.loginform.entity;

public class Emp {


    private Integer id;
    private String name;
    private String username;
    private String password;


    public Emp( String name, String username, String password) {

        this.name = name;
        this.username = username;
        this.password = password;
    }

    public Emp(Integer id, String name, String username, String password) {

        this.id = id;
        this.name = name;
        this.username = username;
        this.password = password;
    }

    public Emp() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
