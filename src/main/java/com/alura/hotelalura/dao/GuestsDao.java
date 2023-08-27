package com.alura.hotelalura.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;

public class GuestsDao {
    final private Connection conn;

    public GuestsDao(Connection conn){this.conn = conn;}

    public void updateGuests(String fName, String lName, String birthDay,String nationality,String phoneNumber, String idReg){
        try(conn) {
            PreparedStatement statement = conn.prepareStatement("INSERT INTO GUESTS(" +
                    "FIRSTNAME,LASTNAME,DATEOFBIRTH,NATIONALITY,PHONE,IDREGISTER) VALUES (?,?,?,?,?,?)");
            statement.setString(1,fName);
            statement.setString(2,lName);
            statement.setString(3,birthDay);
            statement.setString(4,nationality);
            statement.setString(5,phoneNumber);
            statement.setString(6,idReg);
            statement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
