import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class EndGameController {

    @FXML
    private Button close;

    @FXML
    private Button replay;

    @FXML
    public void initialize() {
        // Initialize any required components
    }

    @FXML
    void close(MouseEvent event) {
        System.exit(0);
    }

    @FXML
    void replay(MouseEvent event) {
        try {
        Stage stage = (Stage) ((Button) event.getSource()).getScene().getWindow();
        stage.close();
        Stage primaryStage = new Stage();
            new App().start(primaryStage);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public Button getClose() {
        return close;
    }
    public Button getReplay() {
        return replay;
    }

}
