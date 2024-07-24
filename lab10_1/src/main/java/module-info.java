module org.example.lab10_1 {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;

    opens org.example.lab10_1 to javafx.fxml;
    exports org.example.lab10_1;
}