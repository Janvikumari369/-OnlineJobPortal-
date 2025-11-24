package com.portal.model;

public class Application {
    public enum Status { APPLIED, REVIEWING, ACCEPTED, REJECTED }

    private int id;
    private int jobId;
    private int seekerId;
    private String coverLetter;
    private Status status = Status.APPLIED;

    public Application(int id, int jobId, int seekerId, String coverLetter) {
        this.id = id;
        this.jobId = jobId;
        this.seekerId = seekerId;
        this.coverLetter = coverLetter;
    }

    public int getId() { return id; }
    public int getJobId() { return jobId; }
    public int getSeekerId() { return seekerId; }
    public String getCoverLetter() { return coverLetter; }
    public Status getStatus() { return status; }
    public void setStatus(Status status) { this.status = status; }

    @Override
    public String toString() {
        return "Application{" + id + ", job=" + jobId + ", seeker=" + seekerId + ", status=" + status + "}";
    }
}