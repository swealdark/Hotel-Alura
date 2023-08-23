package com.alura.hotelalura.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class RegController {
    @FXML
    private Label resLabel;



    public void initialize() {
        ConnectController controller = new ConnectController();
        String a = controller.getId();
        resLabel.setText("Numero de Reserva: "+a);
    }
}
