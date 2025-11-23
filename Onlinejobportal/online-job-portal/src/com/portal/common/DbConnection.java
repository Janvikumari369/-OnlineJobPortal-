package com.portal.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public final class DbConnection {
    private DbConnection() {}
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(AppConfig.DB_URL, AppConfig.DB_USER, AppConfig.DB_PASS);
    }
}