package com.alura.hotelalura.controllers;

import javafx.beans.Observable;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;

import java.io.IOException;
import java.text.BreakIterator;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class DashboardController {
    @FXML
    public Button nextReg,next,previous,customReg;
    @FXML
    public DatePicker dateExit,dateEntry,dateBirth;
    @FXML
    public TextField firstName,lastName,phone;
    @FXML
    public Label free,ocupied,maintenance,amount,resLabel;
    @FXML
    public ImageView image,image2;
    @FXML
    public ComboBox paymentMethod;
    @FXML
    public Pane regPhase2;
    @FXML
    public BorderPane displayContent;
    @FXML
    public StackPane regStack;
    @FXML
    public ComboBox nationality;
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
        try {
            ObservableList<Node> children = regStack.getChildren();
            Node nodoB = children.get(1);
            nodoB.toBack();
            nationality.getItems().addAll("Afgano","Argentino","Peruano");
            ConnectController controller = new ConnectController();
            String a = controller.getId();
            resLabel.setText("Reservation ID: "+a);


        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }

    }
    @FXML
    private void save(){
        String fName = firstName.getText();
        String lName = lastName.getText();
        String birthDay = dateBirth.getValue().toString();
        String nationalitySlct = (String) nationality.getValue();
        String phoneSv = phone.getText();

        ConnectController controller = new ConnectController();
        String idReg = controller.getId();
        controller.save(fName,lName,birthDay,nationalitySlct,phoneSv,idReg);
        ObservableList<Node> children = regStack.getChildren();
        Node nodoB = children.get(1);
        nodoB.toBack();


    }
    @FXML
    private void cancel(){
        ConnectController controller = new ConnectController();
        controller.cancel();
        ObservableList<Node> children = regStack.getChildren();
        Node nodoB = children.get(1);
        nodoB.toBack();

    }
    @FXML
    private void customRegHandleClick(){
        customReg.setStyle("-fx-text-fill: #157BFE");
        displayContent.setCenter(null);
        displayContent.setRight(null);

        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("customerRegistration.fxml"));
            Node newContent = fxmlLoader.load();
            displayContent.setCenter(newContent);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
