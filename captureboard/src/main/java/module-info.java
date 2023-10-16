module io.git.captureboard {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;

    opens io.git.captureboard to javafx.fxml;
    exports io.git.captureboard;
}