package com.alura.hotelalura;

import com.alura.hotelalura.controllers.ConnectController;
import  javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.sql.SQLException;

public class Controller {
    @FXML private TextField username;
    @FXML private PasswordField password;
    @FXML Hyperlink forgotpsw;
    @FXML Hyperlink signup;
    @FXML Button login;

    @FXML
    protected void onloginClick(MouseEvent event) throws SQLException {

        String userNameJoin = username.getText();
        String passwordJoin = password.getText();
        ConnectController connectController = new ConnectController();

        if(connectController.loginAuthentication(userNameJoin,passwordJoin)){
            try {
                Parent dashboard = FXMLLoader.load(getClass().getResource("dashboard.fxml"));
                Stage scenne =(Stage) ((Node) event.getSource()).getScene().getWindow();
                scenne.setScene(new Scene(dashboard));
                scenne.show();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }else{
            Alert loginError = new Alert(Alert.AlertType.INFORMATION);
            loginError.setTitle("Login Error");
            loginError.setHeaderText(null);
            loginError.setContentText("Check that the password or user name is valid.");
            loginError.initStyle(StageStyle.UTILITY);
            loginError.showAndWait();

        }
    }

}