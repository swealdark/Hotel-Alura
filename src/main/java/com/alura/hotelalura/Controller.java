package com.alura.hotelalura;

import  javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
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
    private Scene mainScene;
    public void setMainScene(Scene scene){
        this.mainScene = scene;
    }
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
                e.printStackTrace();
                throw new RuntimeException(e);
            }
            System.out.println("Nyaaaaaaaaaaaa");
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