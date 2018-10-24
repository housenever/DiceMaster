package view;

import javafx.scene.input.KeyCode;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.geometry.*;
import model.HeroValkyrie;
import model.MapModel;

import java.util.List;

import static javafx.scene.input.KeyCode.*;

public class DirectionInputBox {

    public static void display(MapModel mapModel, int number, HeroValkyrie hero) {
        Stage window = new Stage();

        //Block events to other windows
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("Wait For your keyboard");
        window.setMinWidth(250);

        Label label = new Label();
        label.setText("Please input the direction");

        HBox buttonArea = new HBox();
        Button btn = new Button("Give up step");
//        btn.setVisible(false);
        btn.setOnAction(e -> {
//            window.close();
        });
        buttonArea.setAlignment(Pos.CENTER);
        buttonArea.setSpacing(20);
        buttonArea.getChildren().add(btn);

        VBox layout = new VBox(10);
        layout.setPadding(new Insets(20, 20, 20, 20));
        layout.getChildren().addAll(label, buttonArea);
        layout.setAlignment(Pos.CENTER);

        btn.setOnKeyPressed(
                event -> {
                    if (event.getCode() == UP){
                        System.out.println("Input UP"); hero.move(mapModel, number, 0,-1); window.close();
                    }
                    if (event.getCode() == DOWN){
                        System.out.println("Input Down"); hero.move(mapModel, number, 0,1); window.close();
                    }
                    if (event.getCode() == LEFT){
                        System.out.println("Input Left"); hero.move(mapModel, number, -1,0); window.close();
                    }
                    if (event.getCode() == RIGHT){
                        System.out.println("Input Right"); hero.move(mapModel, number, 1,0); window.close();
                    }
                    System.out.println("once");
                }
        );

        //Display window and wait for it to be closed before returning
        Scene scene = new Scene(layout);
        window.setScene(scene);
        window.show();
    }

}
