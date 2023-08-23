package com.alura.hotelalura.controllers;

import com.alura.hotelalura.dao.RegisterDao;
import com.alura.hotelalura.dao.LoginDao;
import com.alura.hotelalura.factory.ConnectionFactory;

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
}
