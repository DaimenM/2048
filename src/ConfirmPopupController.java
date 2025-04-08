import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class ConfirmPopupController {
    private Stage stage;

    @FXML
    private Button cancelButton = new Button();

    @FXML
    private Button confirmButton = new Button();

    @FXML
    private Label content = new Label();

    @FXML
    private Label title = new Label();

    public void setTitle(String title) {
        this.title.setText(title);
        this.title.setAlignment(javafx.geometry.Pos.CENTER);
    }
    public void setContent(String content) {
        this.content.setText(content);
        this.content.setAlignment(javafx.geometry.Pos.CENTER);
    }
    public Button getCancelButton() {
        return cancelButton;
    }
    public Button getConfirmButton() {
        return confirmButton;
    }
    public Label getContent() {
        return content;
    }
    public Label getTitle() {
        return title;
    }
    public void setStage(Stage stage) {
        this.stage = stage;
    }
    public Stage getStage() {
        return stage;
    }

    @FXML
    public void initialize() {
        cancelButton.setOnMouseClicked(event -> {
            this.stage.close();
        });
    }

}
