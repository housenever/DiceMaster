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
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.*;
import javafx.scene.layout.Background;
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
    @FXML
    private ImageView dicePic;
    @FXML
    private ImageView numberResult;

    private Pane map = new Pane();
    private MapModel mapModel;
	private HeroModel hero;


    @FXML
    public void dragDetected(MouseEvent event){
        Dragboard db = dicePic.startDragAndDrop(TransferMode.ANY);
        ClipboardContent cb = new ClipboardContent();
        DiceModel diceModel = new DiceModel();
        int currentNumber = diceModel.rollDice();
        cb.putString(String.valueOf(currentNumber));
        db.setContent(cb);
        event.consume();
    }

    public void setOnDragOver(DragEvent event){
        numberResult.setImage(new Image("source/n0_hover.png"));
        event.consume();
    }

    public void setOnDragExited(DragEvent event){
        numberResult.setImage(new Image("source/n0.png"));

        //以下两行代码应该放到setOnDragDropped去，但目前setOnDragDropped不管用啊
        String str = event.getDragboard().getString();//获得dice数值
        numberResult.setImage(new Image("source/n"+str+".png")); //展示结果图片

        event.consume();
    }

    //TODO 目前DragDropped不管用啊，好奇怪
    public void setOnDragDropped(DragEvent event){
        String str = event.getDragboard().getString();//获得dice数值
        numberResult.setImage(new Image("source/n"+str+".png")); //展示结果图片
        DirectionInputBox modalbox = new DirectionInputBox(); //实例化一个新的方向提示框
        modalbox.display(mapModel, Integer.valueOf(str),hero); //展示方向提示框

        //TODO 下面这个方向提示得写到ModalBox里去
        direction.setText(hero.detectDirection(mapModel));
        event.consume();
    }


    @FXML
    public void exitGame(ActionEvent event) throws IOException
    {
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.close();
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {

        int flag = Scene1Controller.flag;
        String[] roleName = {"Pinocchio","Valkyrie","Zombie"};
        charaPic.setImage(new Image("source/"+roleName[flag].toLowerCase()+".png"));

    	hero = Scene1Controller.hero;
    	System.out.println(hero.getHP()+"--"+hero.getMP());
    	userName.setText(hero.getHeroName());
    	mapModel = Context.getInstance().getMapModel();
        map = mapModel.getMapPane();
        mazeMap.getChildren().addAll(map,hero);
    }
}


