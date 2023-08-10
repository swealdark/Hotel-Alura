module com.alura.hotelalura {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.alura.hotelalura to javafx.fxml;
    exports com.alura.hotelalura;
}