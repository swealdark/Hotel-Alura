module com.alura.hotelalura {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires c3p0;
    requires java.naming;
    opens com.alura.hotelalura.model;
    opens com.alura.hotelalura to javafx.fxml;
    exports com.alura.hotelalura;
    exports com.alura.hotelalura.controllers;
    opens com.alura.hotelalura.controllers to javafx.fxml;
}