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
        FXMLLoader loader = new FXMLLoader(getClass().getResource("game.fxml"));
        Parent root = loader.load();
        Board game = new Board();
        MainController mainController = loader.getController();
        setBoard(game, mainController);
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
        
        launch(args);
    }
    public void setBoard(Board game, MainController mainController){
        for(int i=0;i<game.getSize();i++){
            for(int j=0;j<game.getSize();j++){
                if(game.getBoard()[i][j].getValue()==0){
                    mainController.getLabels().get(i).get(j).setText(" ");
                }
                else mainController.getLabels().get(i).get(j).setText(game.getBoard()[i][j].getValue()+"");
            }
        }
    }
}
