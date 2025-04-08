import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.scene.control.Label;

public class EndGameController {
    private Stage stage;

    @FXML
    private Button close;

    @FXML
    private Label score = new Label();

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
            new App().start(stage);
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
    public void setStage(Stage stage) {
        this.stage = stage;
    }
    public Stage getStage() {
        return stage;

}
public void setScore(int score) {
    this.score.setText("Score: " + score);
    this.score.setAlignment(javafx.geometry.Pos.CENTER);
}
}
