package com.example.loginform.entity;

public class LeaveEntity {


    private Integer leave_id;
    private Integer emp_id;
    private String emp_name;
    private String emp_email;
    private String emp_department;
    private String apply_date;
    private String leave_from;

    public Integer getLeave_id() {
        return leave_id;
    }

    public void setLeave_id(Integer leave_id) {
        this.leave_id = leave_id;
    }

    private String leave_to;
    private String description;


    public Integer getEmp_id() {
        return emp_id;
    }

    public void setEmp_id(Integer emp_id) {
        this.emp_id = emp_id;
    }

    public String getEmp_name() {
        return emp_name;
    }

    public void setEmp_name(String emp_name) {
        this.emp_name = emp_name;
    }

    public String getEmp_email() {
        return emp_email;
    }

    public void setEmp_email(String emp_email) {
        this.emp_email = emp_email;
    }

    public String getEmp_department() {
        return emp_department;
    }

    public void setEmp_department(String emp_department) {
        this.emp_department = emp_department;
    }

    public String getApply_date() {
        return apply_date;
    }

    public void setApply_date(String apply_date) {
        this.apply_date = apply_date;
    }

    public String getLeave_from() {
        return leave_from;
    }

    public void setLeave_from(String leave_from) {
        this.leave_from = leave_from;
    }

    public String getLeave_to() {
        return leave_to;
    }

    public void setLeave_to(String leave_to) {
        this.leave_to = leave_to;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
