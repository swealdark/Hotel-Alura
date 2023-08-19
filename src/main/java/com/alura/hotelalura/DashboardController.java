package com.alura.hotelalura;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

import java.time.LocalDate;
import java.util.Date;

public class DashboardController {
    @FXML
    public Button nextReg,next,previous;

    @FXML
    public DatePicker dateExit,dateEntry;
    @FXML
    public Label free,ocupied,maintenance,amount;
    @FXML
    public ImageView image,image2;
    @FXML
    public ComboBox paymentMethod;
    @FXML
    public void initialize(){
        // In the future optimize this code
        dateExit.setDayCellFactory(picker -> new DateCell(){
            public void updateItem(LocalDate date, boolean empty){
                super.updateItem(date,empty);
                LocalDate today = LocalDate.now();
                setDisable(empty || date.compareTo(today) < 0);
            }
        });
        dateEntry.setDayCellFactory(picker -> new DateCell(){
            public void updateItem(LocalDate date, boolean empty){
                super.updateItem(date,empty);
                LocalDate today = LocalDate.now();
                setDisable(empty || date.compareTo(today) < 0);
            }
        });

        paymentMethod.getItems().addAll("Cash","Paypal","Credit Card");


    }



}
