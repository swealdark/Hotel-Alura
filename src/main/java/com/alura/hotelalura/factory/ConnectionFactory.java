package com.alura.hotelalura.factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
    public Connection getConnection(){
        try {
            return DriverManager.getConnection("jdbc:mysql://localhost:3306/hotelalura?useTimeZone=true&serverTimeZone=UTC",
                    "root","NENgoflow777");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
