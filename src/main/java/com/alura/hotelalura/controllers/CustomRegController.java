package com.alura.hotelalura.controllers;

import com.alura.hotelalura.dao.RegisterDao;
import com.alura.hotelalura.factory.ConnectionFactory;
import com.alura.hotelalura.model.Register;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;

import java.util.List;

public class CustomRegController {
    @FXML
    public TableView<Register> regTable;
    @FXML
    public TableColumn<Register,String> checkin,checkout,paymentMethod;
    @FXML
    public TableColumn<Register,String> id;
    @FXML
    public TableColumn<Register,Double> mount;
    @FXML
    public void initialize(){
        RegisterDao registerDao = new RegisterDao(new ConnectionFactory().getConnection());
        ObservableList<Register> data = FXCollections.observableArrayList(registerDao.getReg());
        id.setCellValueFactory(new PropertyValueFactory<Register,String>("id"));
        checkin.setCellValueFactory(new PropertyValueFactory<Register,String>("checkin"));
        checkout.setCellValueFactory(new PropertyValueFactory<Register,String>("checkout"));
        paymentMethod.setCellValueFactory(new PropertyValueFactory<Register,String>("paymentMethod"));
        mount.setCellValueFactory(new PropertyValueFactory<Register,Double>("mount"));
        regTable.setItems(data);
        checkin.setCellFactory(TextFieldTableCell.forTableColumn());
        checkout.setCellFactory(TextFieldTableCell.forTableColumn());
        paymentMethod.setCellFactory(TextFieldTableCell.forTableColumn());
        
    }
    @FXML
    public void editable(){


    }
    @FXML
    public void cancelEditable(){
        initialize();
    }
    @FXML
    public void delReg(){
        System.out.println("Ga");
    }
}
