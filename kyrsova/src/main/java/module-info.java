module com.example.kyrsova {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires java.sql;

    opens com.example.kyrsova to javafx.fxml;
    exports com.example.kyrsova;
    opens com.example.kyrsova.Controler to javafx.fxml;
    exports com.example.kyrsova.Controler;
}