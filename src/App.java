import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("game.fxml"));
        Parent root = loader.load();
        MainController mainController = loader.getController();
        setBoard(mainController.getBoard(), mainController);
        primaryStage.setTitle("2048");
        Scene scene = new Scene(root, 600, 600);
        primaryStage.setScene(scene);
        scene.setOnKeyPressed(event -> mainController.handleKeyPress(event));
        primaryStage.show();
    }
    public static void endGame(Stage endStage,MainController mainController) throws Exception{
        FXMLLoader loader = new FXMLLoader(App.class.getResource("endGame.fxml"));
        Parent root = loader.load();
        endStage.setTitle("Game Over");
        EndGameController endGameController = loader.getController();
        Scene scene = new Scene(root, 600, 400);
        endStage.setScene(scene);
        endGameController.getClose().setOnMouseClicked(event -> endGameController.close(event));
        endGameController.getReplay().setOnMouseClicked(event -> endGameController.replay(event));
        Stage currentStage = (Stage) mainController.getLabels().get(0).get(0).getScene().getWindow();
        currentStage.close();
        endStage.show();
    }

    public static void main(String[] args) throws Exception {
        launch(args);
    }
    public static void setBoard(Board game, MainController mainController){
        for(int i=0;i<game.getSize();i++){
            for(int j=0;j<game.getSize();j++){
                if(game.getBoard()[i][j].getValue()==0){
                    mainController.getLabels().get(i).get(j).setText(" ");
                }
                else mainController.getLabels().get(i).get(j).setText(game.getBoard()[i][j].getValue()+"");
            }
        }
        if(game.isGameOver()){
            try {
                endGame(new Stage(),mainController);
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }
}
