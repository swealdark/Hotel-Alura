package com.alura.hotelalura.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RegisterDao {
    final private Connection conn;
    public RegisterDao(Connection conn){
        this.conn = conn;
    }

    public void updateReg(String checkIN,String checkOut,String amount,String payment){
        try(conn) {
            PreparedStatement statement = conn.prepareStatement("INSERT INTO REGISTER(CHECKIN,CHECKOUT,MOUNT,PAYMENTMETHOD) VALUES(?,?,?,?)");

            statement.setString(1,checkIN);
            statement.setString(2,checkOut);
            statement.setString(3,amount);
            statement.setString(4,payment);
            statement.execute();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
