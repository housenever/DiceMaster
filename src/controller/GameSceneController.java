package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import model.MapModel;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


public class GameSceneController implements Initializable {

    @FXML
    private Pane mazeMap;

    public void exitGame(ActionEvent event) throws IOException
    {
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.close();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Pane map = new Pane();
        MapModel Map = new MapModel(20);
        map = Map.getMapPane();
        mazeMap.getChildren().add(map);
    }
}


