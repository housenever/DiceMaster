package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import model.Context;
import model.DiceModel;
import model.HeroModel;
import model.HeroPinocchio;
import model.HeroValkyrie;
import model.HeroZombie;
import model.MapModel;
import view.DirectionInputBox;


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

    private Pane map = new Pane();
    private MapModel mapModel;
	private HeroModel hero;


    @FXML
    public void rollDice(ActionEvent event) throws InterruptedException {
    
        DiceModel diceModel = new DiceModel();
        int currentNumber = diceModel.rollDice();
        diceResult.setText(String.valueOf(currentNumber));
        DirectionInputBox modalbox = new DirectionInputBox();
        modalbox.display(mapModel, currentNumber,hero);
//        hero.move(mapModel,currentNumber);
        direction.setText(hero.detectDirection(mapModel));


        
    }

    @FXML
    public void exitGame(ActionEvent event) throws IOException
    {
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.close();
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
    	switch (Scene1Controller.flag) {
		case 0:
			hero = new HeroPinocchio();
			break;
		case 1:
			hero = new HeroValkyrie();
			break;
		case 2:
			hero = new HeroZombie();
			break;

		default:hero = new HeroValkyrie();
			break;
		}
    	userName.setText(hero.getHeroName());
    	mapModel = Context.getInstance().getMapModel();
        map = mapModel.getMapPane();
        mazeMap.getChildren().addAll(map,hero);
    }
}


