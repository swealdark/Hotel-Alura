package com.alura.hotelalura.controllers;

import com.alura.hotelalura.dao.RegisterDao;
import com.alura.hotelalura.factory.ConnectionFactory;
import com.alura.hotelalura.model.Register;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.List;

public class CustomRegController {
    @FXML
    public TableView<Register> regTable;
    @FXML
    public TableColumn<Register,String> checkin;
    @FXML
    public void initialize(){
        RegisterDao registerDao = new RegisterDao(new ConnectionFactory().getConnection());
        ObservableList<Register> data = FXCollections.observableArrayList(
                new Register("1","15/12/20","16/12/20",150,"Paypal"),
                new Register("3","15/11/20","16/11/20",150,"Paypal"));
        checkin.setCellValueFactory(new PropertyValueFactory<Register,String>("checkin"));
        regTable.setItems(data);

        
    }
}
