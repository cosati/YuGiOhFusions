package com.alexandrecosati.YuGiOhFusions.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MySQLConnection {

    private static final Logger logger = Logger.getLogger(MySQLConnection.class.getName());
    private static final String DRIVER_CLASS = "com.mysql.cj.jdbc.Driver";
    private static final String USER = "root";
    private static final String PASSWORD = "";
    private static final String DB_HOST = "localhost";
    private static final String PORT = "3306";
    private static final String DB_NAME = "yugi_db";

    public static Connection getConnectionToDatabase() {
        Connection connection = null;
        try {
            Class.forName(DRIVER_CLASS);
            connection = DriverManager
                    .getConnection(getConnectionString());
        } catch (ClassNotFoundException|SQLException exception) {
            logger.log(Level.SEVERE, "Could not set up connection", exception);
        }
        return connection;
    }

    private static String getConnectionString() {
        String connectionString = new StringBuilder("jdbc:mysql://")
                .append(DB_HOST)
                .append(":")
                .append(PORT)
                .append("/")
                .append(DB_NAME)
                .append("?")
                .append("user=").append(USER)
                .append("&password=").append(PASSWORD)
                .toString();
        return connectionString;
    }
}
