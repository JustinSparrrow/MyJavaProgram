module org.example.lab10_2 {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;

    opens org.example.lab10_2 to javafx.fxml;
    exports org.example.lab10_2;
}