package com.portal.model;

public class Job {
    public enum Status { PENDING, APPROVED, REJECTED }

    private int id;
    private int employerId;
    private String title;
    private String description;
    private String requirements;
    private double salary;
    private Status status = Status.PENDING;

    public Job(int id, int employerId, String title, String description, String requirements, double salary) {
        this.id = id;
        this.employerId = employerId;
        this.title = title;
        this.description = description;
        this.requirements = requirements;
        this.salary = salary;
    }

    public int getId() { return id; }
    public int getEmployerId() { return employerId; }
    public String getTitle() { return title; }
    public String getDescription() { return description; }
    public String getRequirements() { return requirements; }
    public double getSalary() { return salary; }
    public Status getStatus() { return status; }
    public void setStatus(Status status) { this.status = status; }

    @Override
    public String toString() {
        return "Job{" + id + ", " + title + ", status=" + status + "}";
    }
}