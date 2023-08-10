package com.alura.hotelalura;

import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.sql.SQLException;

public class Controller {
    @FXML private TextField username;
    @FXML private PasswordField password;
    @FXML Hyperlink forgotpsw;
    @FXML Hyperlink signup;
    @FXML Button login;
    @FXML
    protected void onloginClick() throws SQLException {

        String userNameJoin = username.getText();
        String passwordJoin = password.getText();
        ConnectController connectController = new ConnectController();

        if(connectController.loginAuthentication(userNameJoin,passwordJoin)){
            System.out.println("Nyaaaaaaaaaaaa");
        }else{
            System.out.println("Fuera ctmr");
        }
    }

}