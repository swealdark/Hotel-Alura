package com.alura.hotelalura.dao;


import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
    public String getId(){
        try(conn){
            PreparedStatement statement = conn.prepareStatement("SELECT ID FROM REGISTER ORDER BY ID DESC LIMIT 1");
            ResultSet resultSet = statement.executeQuery();
            if(resultSet.next()){
                String numberReservation = resultSet.getString("ID");
                return numberReservation;
            }else{
                throw new SQLException();
            }

        }catch (SQLException e){
            throw new RuntimeException();
        }
    }

    public void clearReg() {
        try(conn) {
            PreparedStatement statement = conn.prepareStatement("DELETE FROM REGISTER ORDER BY ID DESC LIMIT 1");
            statement.execute();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
