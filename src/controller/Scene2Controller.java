package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Scene2Controller {

    public void nextScene(ActionEvent event) throws IOException
    {
        Parent scene3 = FXMLLoader.load(getClass().getResource("../view/scene3.fxml"));
        Scene diffScene = new Scene(scene3);

        //This line gets the Stage information
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

        window.setScene(diffScene);
    }

    public void backScene(ActionEvent event) throws IOException
    {
        Parent scene1 = FXMLLoader.load(getClass().getResource("../view/scene1.fxml"));
        Scene selectCharaScene = new Scene(scene1);

        //This line gets the Stage information
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

        window.setScene(selectCharaScene);
    }
}
