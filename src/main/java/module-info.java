module com.example.myjavafxapp {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.myjavafxapp to javafx.fxml;
    exports com.example.myjavafxapp;
}