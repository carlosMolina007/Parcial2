module com.example.parcial2inmuebles {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.parcial2inmuebles to javafx.fxml;
    exports com.example.parcial2inmuebles;
}