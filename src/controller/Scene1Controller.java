package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

public class Scene1Controller {

    public void nextScene(ActionEvent event) throws IOException
    {
        Parent scene2 = FXMLLoader.load(getClass().getResource("../view/scene2.fxml"));
        Scene editCharaScene = new Scene(scene2);

        //This line gets the Stage information
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        System.out.println("Stage loaded.");

        window.setScene(editCharaScene);
    }
}
