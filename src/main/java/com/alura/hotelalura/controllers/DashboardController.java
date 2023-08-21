package com.alura.hotelalura.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

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
    private boolean validation = false;
    private double amountValue;
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

    public void evalDate(){
        if((dateExit.getValue() != null) && (dateEntry.getValue() != null)) {
            LocalDate dateStart = dateEntry.getValue();
            LocalDate dateFinish = dateExit.getValue();
            System.out.println(dateExit.getClass());
            System.out.println(dateEntry.getClass());
            long differenceDays = ChronoUnit.DAYS.between(dateStart,dateFinish);
            System.out.println("Gaaaaaaaaaaaaa" + differenceDays);
            evalMount(differenceDays);
        }
    }

    private void evalMount(long differenceDays) {
        if (differenceDays > 0){
            amountValue = differenceDays*100;
            amount.setText("Mount:$"+(amountValue));
        }else if(differenceDays == 0){
            amountValue = 100;
            amount.setText("Mount:$"+(amountValue));
        }else{
            amount.setText("Invalid Date");
        }
    }
    @FXML
    private void clickEventHandler(){
        if((amount.getText() != "Invalid Date") && (paymentMethod.getValue() != null) &&
                (dateEntry.getValue() != null) && (dateExit.getValue() != null)){
            ConnectController controller = new ConnectController();
            controller.updateReg(dateEntry.getValue().toString(),
                    dateExit.getValue().toString(), Double.toString(amountValue),(String) paymentMethod.getSelectionModel().getSelectedItem());
            updateRegDisplay();
        }

    }
    private void updateRegDisplay(){
        
    }
}
