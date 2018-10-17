package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import model.DiceModel;
import model.HeroModel;
import model.HeroValkyrie;
import model.MapModel;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


public class GameSceneController implements Initializable {

    @FXML
    private Pane mazeMap;
    @FXML
    private ProgressBar bloodBar;
    @FXML
    private VBox sideBar;
    @FXML
    private Button exitBtn;
    @FXML
    private ImageView charaPic;
    @FXML
    private HBox header;
    @FXML
    private ImageView logo;
    @FXML
    private Label diceResult;
    @FXML
    private Button diceBtn;
    @FXML
    private Label userName;
    @FXML
    private VBox operateArea;
    @FXML
    private VBox userProfile;
    @FXML
    private Label direction;

    Pane map = new Pane();
    MapModel mapModel = new MapModel(20);
    HeroValkyrie hero = new HeroValkyrie();



    @FXML
    public void rollDice(ActionEvent event) {
        DiceModel diceModel = new DiceModel();
        int currentNumber = diceModel.rollDice();
        diceResult.setText(String.valueOf(currentNumber));
        direction.setText(hero.detectDirection(mapModel));
        hero.move();
    }



    @FXML
    public void exitGame(ActionEvent event) throws IOException
    {
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.close();
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        map = mapModel.getMapPane();
        mazeMap.getChildren().addAll(map,hero);

    }
}


