package com.portal.model;

public class Message {
    private int id;
    private int senderId;
    private int receiverId;
    private Integer jobId;
    private String content;

    public Message(int id, int senderId, int receiverId, Integer jobId, String content) {
        this.id = id;
        this.senderId = senderId;
        this.receiverId = receiverId;
        this.jobId = jobId;
        this.content = content;
    }

    public int getId() { return id; }
    public int getSenderId() { return senderId; }
    public int getReceiverId() { return receiverId; }
    public Integer getJobId() { return jobId; }
    public String getContent() { return content; }

    @Override
    public String toString() {
        return "Message{" + id + ", to=" + receiverId + ", '" + content + "'}";
    }
}