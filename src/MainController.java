import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.shape.Rectangle;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.SwipeEvent;
import java.util.ArrayList;
import java.util.Arrays;
import javafx.stage.Stage;
import javafx.scene.layout.GridPane;


public class MainController {
    private Stage stage;

     @FXML
    private GridPane gameGrid = new GridPane();

    @FXML
    private Label quit = new Label();

    @FXML
    private Label restart = new Label();

    @FXML
    private Label score = new Label();

    @FXML
    public Rectangle square00;

    @FXML
    private Rectangle square01;

    @FXML
    private Rectangle square02;

    @FXML
    private Rectangle square03;

    @FXML
    private Rectangle square10;

    @FXML
    private Rectangle square11;

    @FXML
    private Rectangle square12;

    @FXML
    private Rectangle square13;

    @FXML
    private Rectangle square20;

    @FXML
    private Rectangle square21;

    @FXML
    private Rectangle square22;

    @FXML
    private Rectangle square23;

    @FXML
    private Rectangle square30;

    @FXML
    private Rectangle square31;

    @FXML
    private Rectangle square32;

    @FXML
    private Rectangle square33;

    @FXML
    private Label val00 = new Label();

    @FXML
    private Label val01 = new Label();

    @FXML
    private Label val02 = new Label();

    @FXML
    private Label val03 = new Label();

    @FXML
    private Label val10 = new Label();

    @FXML
    private Label val11 = new Label();

    @FXML
    private Label val12 = new Label();

    @FXML
    private Label val13 = new Label();

    @FXML
    private Label val20 = new Label();

    @FXML
    private Label val21 = new Label();

    @FXML
    private Label val22 = new Label();

    @FXML
    private Label val23 = new Label();

    @FXML
    private Label val30 = new Label();

    @FXML
    private Label val31 = new Label();

    @FXML
    private Label val32 = new Label();

    @FXML
    private Label val33 = new Label();

    private ArrayList<ArrayList<Label>> labels = new ArrayList<>();

    private ArrayList<ArrayList<Rectangle>> squares = new ArrayList<>();

    private Board game;
    
    @FXML
    public void initialize() {
        // Move the labels initialization to the initialize method
        labels.add(new ArrayList<>(Arrays.asList(val00,val01,val02,val03)));
        labels.add(new ArrayList<>(Arrays.asList(val10,val11,val12,val13)));
        labels.add(new ArrayList<>(Arrays.asList(val20,val21,val22,val23)));
        labels.add(new ArrayList<>(Arrays.asList(val30,val31,val32,val33)));
        
        squares.add(new ArrayList<>(Arrays.asList(square00,square01,square02,square03)));
        squares.add(new ArrayList<>(Arrays.asList(square10,square11,square12,square13)));
        squares.add(new ArrayList<>(Arrays.asList(square20,square21,square22,square23)));
        squares.add(new ArrayList<>(Arrays.asList(square30,square31,square32,square33)));

        game = new Board();
        score.setText("Score: " + game.getScore());
        gameGrid.addEventHandler(SwipeEvent.SWIPE_UP,event -> moveUp(event));
        gameGrid.addEventHandler(SwipeEvent.SWIPE_DOWN,event -> moveDown(event));
        gameGrid.addEventHandler(SwipeEvent.SWIPE_LEFT,event -> moveLeft(event));
        gameGrid.addEventHandler(SwipeEvent.SWIPE_RIGHT,event -> moveRight(event));
        restart.setOnMouseClicked(event -> restart(event));
        quit.setOnMouseClicked(event -> quit(event));

    }
    public void setSwipeEvents(){
    for(int i=0;i<game.getSize();i++){
        for(int j=0;j<game.getSize();j++){
            squares.get(i).get(j).addEventHandler(SwipeEvent.SWIPE_UP,event -> moveUp(event));
            squares.get(i).get(j).addEventHandler(SwipeEvent.SWIPE_DOWN,event -> moveDown(event));
            squares.get(i).get(j).addEventHandler(SwipeEvent.SWIPE_LEFT,event -> moveLeft(event));
            squares.get(i).get(j).addEventHandler(SwipeEvent.SWIPE_RIGHT,event -> moveRight(event));
        }
        }
    }
    @FXML
    void moveDown(SwipeEvent event) {
        game.moveDown();
        App.setBoard(game, this);
    }

    @FXML
    void moveLeft(SwipeEvent event) {
        game.moveLeft();
        App.setBoard(game, this);
    }

    @FXML
    void moveRight(SwipeEvent event) {
        game.moveRight();
        App.setBoard(game, this);
    }

    @FXML
    void moveUp(SwipeEvent event) {
        game.moveUp();
        App.setBoard(game, this);
    }
    public void handleKeyPress(KeyEvent e){
        switch(e.getCode()){
            case UP:
                game.moveUp();
                App.setBoard(game, this);
                break;
            case DOWN:
                game.moveDown();
                App.setBoard(game, this);
                break;
            case LEFT:
                game.moveLeft();
                App.setBoard(game, this);
                break;
            case RIGHT:
                game.moveRight();
                App.setBoard(game, this);
                break;
            default:
                break;
        }
    }
    
    public ArrayList<ArrayList<Label>> getLabels() {
        return labels;
    }
    public ArrayList<ArrayList<Rectangle>> getSquares() {
        return squares;
    }
    public Board getBoard() {
        return game;
    }
    public void setStage(Stage stage) {
        this.stage = stage;
    }
    public Stage getStage() {
        return stage;
    }
    public Label getScore() {
        return score;
    }
    public void restart(MouseEvent event) {
        ConfirmPopupController confirm = App.loadConfirm();
        confirm.setTitle("Restart Game?");
        confirm.setContent("Are you sure you want to restart the game?");
        confirm.getConfirmButton().setOnMouseClicked(e -> {
        
        
            try{
            confirm.getStage().close();
            new App().start(stage);
        } catch(Exception err){
            err.printStackTrace();
        };
    });
    }
    public void quit(MouseEvent event) {
        ConfirmPopupController confirm = App.loadConfirm();
        confirm.setTitle("Quit Game?");
        confirm.setContent("Are you sure you want to quit the game?");
        confirm.getConfirmButton().setOnMouseClicked(e -> {
            System.exit(0);
        });
    }
}
