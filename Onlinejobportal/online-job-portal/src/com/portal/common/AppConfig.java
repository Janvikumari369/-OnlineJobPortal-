package com.portal.common;

public final class AppConfig {
    public static final String DB_URL = "jdbc:mysql://localhost:3306/job_portal";
    public static final String DB_USER = "root";
    public static final String DB_PASS = "password";
    public static final int NOTIFY_WORKER_INTERVAL_MS = 1500;
    private AppConfig() {}
}