package io.git.captureboard;

import java.lang.System.Logger;

import javafx.beans.property.ReadOnlyObjectProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Bounds;
import javafx.geometry.Point2D;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.robot.Robot;
import javafx.scene.shape.Rectangle;
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
        Robot robot = new Robot();

//        make WritableImage from BufferedImage
        WritableImage writable = SwingFXUtils.toFXImage(robot.getScreenCapture(null, null), null);
        WritableImage writable =

        SwingFXUtils.toFXImage(robot.getScreenCapture(null, null), null);
        robot.getScreenCapture()
    }
    static void snapshot(javafx.scene.Node node) {

        Point2D point2D = node.localToScreen(0d, 0d);
        ReadOnlyObjectProperty<Bounds> boundsReadOnlyObjectProperty = node.boundsInParentProperty();
        boundsReadOnlyObjectProperty.addListener((observable, oldValue, newValue) -> {
            System.out.println("oldValue = " + oldValue);
            System.out.println("newValue = " + newValue);
        });
        def bi = robot.getScreenCapture(new Rectangle(point2D.getX(), point2D.getY(), node.getWidth(), node.getHeight()
        def writableImage = SwingFXUtils.toFXImage(bi, null)
        new Stage().with {
            title = 'snapshot'
            scene = new Scene(new Pane(new ImageView(writableImage)))
            show()
        }
    }

    @FXML
    private void startAction(ActionEvent event) {
        // Your event handling code here
    }
}