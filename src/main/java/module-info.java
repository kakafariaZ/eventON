module com.example.eventon {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.google.gson;
    opens com.example.eventon to javafx.fxml;
    exports com.example.eventon;
}
