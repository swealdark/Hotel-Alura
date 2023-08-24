package com.alura.hotelalura.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;

public class RegController {
    @FXML
    private Label resLabel;
//    @FXML
//    public Pane regPhase2;

    @FXML
    public void initialize() {
        ConnectController controller = new ConnectController();
        String a = controller.getId();
        resLabel.setText("Numero de Reserva: "+a);
    }
    @FXML
    public void cancel(){
        ConnectController controller = new ConnectController();
        controller.cancel();

//        try {
//            regPhase2.getChildren().clear();
//            Parent view = FXMLLoader.load(getClass().getResource("regt1.fxml"));
//            regPhase2.getChildren().add(view);
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }

    }
}
