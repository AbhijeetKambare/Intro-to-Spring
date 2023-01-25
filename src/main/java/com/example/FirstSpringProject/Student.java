package com.example.FirstSpringProject;

public class Student {
    private int admin_id;
    private String name;
    private String state;
    private int roll_no;

    public Student(int admin_id, String name, String state, int roll_no) {
        this.admin_id = admin_id;
        this.name = name;
        this.state = state;
        this.roll_no = roll_no;
    }

    public int getAdmin_id() {
        return admin_id;
    }

    public void setAdmin_id(int admin_id) {
        this.admin_id = admin_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public int getRoll_no() {
        return roll_no;
    }

    public void setRoll_no(int roll_no) {
        this.roll_no = roll_no;
    }
}
