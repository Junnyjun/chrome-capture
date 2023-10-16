package io.git.captureboard;

import java.lang.System.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MainController {
    private Logger log = System.getLogger("MAIN");

    @FXML
    private VBox vBox;

    @FXML
    private Pane pane;

    @FXML
    private Label titleLabel;

    @FXML
    private Label fileNameLabel;

    @FXML
    private TextField fileNameTextField;

    @FXML
    private Label commandLabel;

    @FXML
    private TextField commandTextField;

    @FXML
    private Label pageSizeLabel;

    @FXML
    private TextField pageSizeTextField;

    @FXML
    private Button captureSizeButton;

    @FXML
    private Button actionButton;

    @FXML
    private TextField captureSizeTextField;

    @FXML
    private ImageView imageView;

    private double xa;
    private double xb;
    private double ya;
    private double yb;
    private boolean selecting = false;

    BorderPane borderPane = new BorderPane();
    Canvas canvas = new Canvas();
    GraphicsContext gc = canvas.getGraphicsContext2D();
    Stage stage;

    @FXML
    private void captureAction(ActionEvent event) {
        log.log(System.Logger.Level.INFO, "captureAction");
        canvas.setWidth(100);
        canvas.setHeight(100);

        canvas.setOnMousePressed(m -> {
            xa = (int) m.getScreenX();
            ya = (int) m.getScreenY();
        });
        canvas.setOnMouseDragged(m -> {
            xb = (int) m.getScreenX();
            yb = (int) m.getScreenY();
            gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
            gc.strokeRect(xa, ya, xb - xa, yb - ya);
        });
    }

    @FXML
    private void startAction(ActionEvent event) {
        // Your event handling code here
    }
}