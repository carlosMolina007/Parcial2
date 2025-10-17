module com.example.parcial2inmuebles {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;
    requires javafx.base;


    opens com.example.parcial2inmuebles to javafx.fxml;
    exports com.example.parcial2inmuebles;
    opens com.example.parcial2inmuebles.controller to javafx.fxml;
    opens com.example.parcial2inmuebles.model to javafx.fxml;
}