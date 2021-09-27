module com.example.fxjava {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.bootstrapfx.core;
    requires javafx.graphics;

    opens com.example.fxjava to javafx.fxml;
    exports com.example.fxjava;
}