package com.portal.model;

public class JobSeeker extends User {
    private String resume;
    public JobSeeker(int id, String name, String email, String resume) {
        super(id, name, email, Role.JOB_SEEKER);
        this.resume = resume;
    }
    public String getResume() { return resume; }
    public void setResume(String resume) { this.resume = resume; }
    @Override
    public String dashboardTitle() { return "Job Seeker Dashboard"; }
}