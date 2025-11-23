package com.portal.model;

public abstract class User {
    protected int id;
    protected String name;
    protected String email;

    public enum Role { ADMIN, EMPLOYER, JOB_SEEKER }

    protected Role role;

    protected User(int id, String name, String email, Role role) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.role = role;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public String getEmail() { return email; }
    public Role getRole() { return role; }

    public abstract String dashboardTitle();

    @Override
    public String toString() {
        return role + "{" + id + ", " + name + ", " + email + "}";
    }
}