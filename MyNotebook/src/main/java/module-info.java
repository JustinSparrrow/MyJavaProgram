module org.example.mynotebook {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires net.synedra.validatorfx;

    opens org.example.mynotebook to javafx.fxml;
    exports org.example.mynotebook;
}