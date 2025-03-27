import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
public class App extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("game.fxml"));
        primaryStage.setTitle("2048");
        primaryStage.setScene(new Scene(root, 600, 600));
        primaryStage.show();
    }

    public static void main(String[] args) throws Exception {
       /* Board board = new Board();
        for(int i=0;i<board.getSize();i++){
            for(int j=0;j<board.getSize();j++){
                Label label = new Label(board.getBoard()[i][j].getValue()+"");
            }
        }
            */
        
        MainController mainController = new MainController();
        mainController.val00.setText("2");
        launch(args);
    }
}
