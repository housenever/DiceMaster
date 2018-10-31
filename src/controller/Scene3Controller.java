package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Slider;
import javafx.stage.Stage;
import model.Context;
import model.MapModel;

import java.io.IOException;

public class Scene3Controller {

    @FXML
    private Slider slider;


    public void nextScene(ActionEvent event) throws IOException
    {
    	Context.getInstance().getMapModel().setDifficulty((int)slider.getValue());
    	
    	Parent scene3 = FXMLLoader.load(getClass().getResource("../view/gameScene.fxml"));
        Scene gameScene = new Scene(scene3);

        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(gameScene);

    }

    public void backScene(ActionEvent event) throws IOException
    {
        Parent scene1 = FXMLLoader.load(getClass().getResource("../view/scene2.fxml"));
        Scene selectCharaScene = new Scene(scene1);

        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

        window.setScene(selectCharaScene);
    }
}
