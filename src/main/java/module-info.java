module com.alura.hotelalura {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.alura.hotelalura to javafx.fxml;
    exports com.alura.hotelalura;
}