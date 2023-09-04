package com.alura.hotelalura.dao;



import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.alura.hotelalura.model.Register;

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
    public List<Register> getReg(){
        List<Register> register = new ArrayList<>();
        try(conn){
            PreparedStatement statement = conn.prepareStatement("SELECT ID,CHECKIN,CHECKOUT,MOUNT,PAYMENTMETHOD FROM REGISTER");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                String idReg = resultSet.getString("ID");
                String checkin = resultSet.getString("CHECKIN");
                String checkout = resultSet.getString("CHECKOUT");
                double mount = resultSet.getDouble("MOUNT");
                String paymentMethod = resultSet.getString("PAYMENTMETHOD");
                Register registerf = new Register(idReg,checkin,checkout,mount,paymentMethod);
                register.add(registerf);
            }
            statement.execute();


        }catch (SQLException e){
            throw new RuntimeException(e);
        }
        return register;
        
    }
}
