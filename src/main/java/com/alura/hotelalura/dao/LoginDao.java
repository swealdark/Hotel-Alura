package com.alura.hotelalura.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class LoginDao {
    final private Connection conn;
    public LoginDao(Connection conn){
        this.conn = conn;
    }
    public boolean loginAutenthicationDAO(String user,String password){
        try(conn) {
            PreparedStatement statement = conn.prepareStatement("SELECT * FROM usuarios WHERE username = ?");
            statement.setString(1,user);
            statement.execute();
            ResultSet result = statement.getResultSet();
            System.out.println(result);
            Map<String,String> usersAutorizados = new HashMap<>();
            if(result.next()){

                boolean resp = password.equals(result.getString("password"));
                return resp;

            }else{
                return false;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
