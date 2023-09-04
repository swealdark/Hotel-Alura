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
    public TableView regTable;
    @FXML
    public TableColumn<Register,String> checkin;
    @FXML
    public void initialize(){
        RegisterDao registerDao = new RegisterDao(new ConnectionFactory().getConnection());
        List<Register> registers = registerDao.getReg();
//        checkin.setCellValueFactory(new PropertyValueFactory<>("checkin"));
//        System.out.println(registers.get(0).getCheckin());
//        ObservableList<Register> data = FXCollections.observableArrayList(registers);
//        regTable.setItems(data);
//        regTable.refresh();
        
    }
}
