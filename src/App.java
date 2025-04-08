import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.Modality;

public class App extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("game.fxml"));
        Parent root = loader.load();
        MainController mainController = loader.getController();
        mainController.setStage(primaryStage);
        setBoard(mainController.getBoard(), mainController);
        primaryStage.setTitle("2048");
        Scene scene = new Scene(root, 750, 600);
        primaryStage.setScene(scene);
        scene.setOnKeyPressed(event -> mainController.handleKeyPress(event));
        primaryStage.show();
    }
    public static void endGame(Stage endStage,MainController mainController) throws Exception{
        FXMLLoader loader = new FXMLLoader(App.class.getResource("endGame.fxml"));
        Parent root = loader.load();
        endStage.setTitle("Game Over");
        EndGameController endGameController = loader.getController();
        endGameController.setStage(endStage);
        Scene scene = new Scene(root);
        endStage.setScene(scene);
        endGameController.setScore(mainController.getBoard().getScore());
        endGameController.getClose().setOnMouseClicked(event -> endGameController.close(event));
        endGameController.getReplay().setOnMouseClicked(event -> endGameController.replay(event));
        endStage.show();
    }

    public static ConfirmPopupController loadConfirm(){
        try{
        Stage popup = new Stage();
        popup.initModality(Modality.APPLICATION_MODAL);
        FXMLLoader loader = new FXMLLoader(App.class.getResource("confirmPopup.fxml"));
        Parent root = loader.load();
        ConfirmPopupController confirm = loader.getController();
        confirm.setStage(popup);
        popup.setScene(new Scene(root, 581, 273));
        popup.show();
        return confirm;
    } catch(Exception e){
        e.printStackTrace();
    }
        return null;
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
                mainController.getSquares().get(i).get(j).setFill(game.getBoard()[i][j].getColor(game.getBoard()[i][j].getValue()));

            }
        }
        mainController.getScore().setText("Score: "+game.getScore());
        if(game.isGameOver()){
            try {
                endGame(mainController.getStage(),mainController);
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }
}