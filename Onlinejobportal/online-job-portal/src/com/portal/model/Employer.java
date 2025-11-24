package com.portal.model;

public class Employer extends User {
    public Employer(int id, String name, String email) {
        super(id, name, email, Role.EMPLOYER);
    }
    @Override
    public String dashboardTitle() { return "Employer Dashboard"; }
}