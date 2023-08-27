package com.alura.hotelalura.controllers;

import com.alura.hotelalura.dao.GuestsDao;
import com.alura.hotelalura.dao.RegisterDao;
import com.alura.hotelalura.dao.LoginDao;
import com.alura.hotelalura.factory.ConnectionFactory;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.LocalDate;

public class ConnectController {


    public boolean loginAuthentication(String user, String password){
        // Se conecta a la db, busca el usuario ingresado y compara las contraseñas
        LoginDao login = new LoginDao(new ConnectionFactory().getConnection());

        return login.loginAutenthicationDAO(user,password);
    };

    public void updateReg(String checkIN,String checkOut,String amount, String payment){
        RegisterDao reg = new RegisterDao(new ConnectionFactory().getConnection());
        reg.updateReg(checkIN,checkOut,amount,payment);

    }

    public String getId() {
        RegisterDao reg = new RegisterDao(new  ConnectionFactory().getConnection());
        return reg.getId();
    }

    public void cancel() {
        RegisterDao reg = new RegisterDao(new ConnectionFactory().getConnection());
        reg.clearReg();


    }

    public void save(String fName, String lName, String birthDay, String nationality, String phoneNumber, String idReg) {
        GuestsDao guests = new GuestsDao(new ConnectionFactory().getConnection());
        guests.updateGuests(fName,lName,birthDay,nationality,phoneNumber,idReg);
    }
}
