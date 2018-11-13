package view;

import static javafx.scene.input.KeyCode.DOWN;
import static javafx.scene.input.KeyCode.LEFT;
import static javafx.scene.input.KeyCode.RIGHT;
import static javafx.scene.input.KeyCode.UP;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import model.HeroModel;
import model.MapModel;

public class DirectionInputBox {

	public void display(MapModel mapModel, int number, HeroModel hero, String direction) {
		Stage window = new Stage();

		// Block events to other windows
		window.initModality(Modality.APPLICATION_MODAL);
		window.setTitle("Wait For your keyboard");
		window.setMinWidth(250);

		Label text1 = new Label();
		Label text2 = new Label();
		text1.setText("You can select these direction to go (Keyboard) ");
		text1.setAlignment(Pos.CENTER);
		text2.setText(direction);
		text1.setAlignment(Pos.CENTER);
		text2.setStyle("-fx-font-size: 36px;");

		HBox buttonArea = new HBox();
		Button btn = new Button("Give up step");
		// btn.setVisible(false);
		btn.setOnAction(e -> {
			// window.close();
		});
		buttonArea.setAlignment(Pos.CENTER);
		buttonArea.setSpacing(20);
		buttonArea.getChildren().add(btn);

		VBox layout = new VBox(10);
		layout.setPadding(new Insets(20, 20, 20, 20));
		layout.getChildren().addAll(text1, text2, buttonArea);
		layout.setAlignment(Pos.CENTER);

		btn.setOnKeyPressed(event -> {
			if (event.getCode() == UP) {
				System.out.println("Input UP");
				hero.move(mapModel, number, 0, -1);
				if(hero.checkWin() == true) {
					text1.setText("Conguatulations!");
					text2.setText("You Win!!!!!");
					btn.setText("Exit Game!");
					btn.setOnMouseClicked(e ->{
						System.exit(0);
					});
				}else
					window.close();
			}
			if (event.getCode() == DOWN) {
				System.out.println("Input Down");
				hero.move(mapModel, number, 0, 1);
				if(hero.checkWin() == true) {
					text1.setText("Conguatulations!");
					text2.setText("You Win!!!!!");
					btn.setText("Exit Game!");
					btn.setOnMouseClicked(e ->{
						System.exit(0);
					});
				}else
					window.close();
			}
			if (event.getCode() == LEFT) {
				System.out.println("Input Left");
				hero.move(mapModel, number, -1, 0);
				if(hero.checkWin() == true) {
					text1.setText("Conguatulations!");
					text2.setText("You Win!!!!!");
					btn.setText("Exit Game!");
					btn.setOnMouseClicked(e ->{
						System.exit(0);
					});
				}else
					window.close();
			}
			if (event.getCode() == RIGHT) {
				System.out.println("Input Right");
				hero.move(mapModel, number, 1, 0);
				if(hero.checkWin() == true) {
					text1.setText("Conguatulations!");
					text2.setText("You Win!!!!!");
					btn.setText("Exit Game!");
					btn.setOnMouseClicked(e ->{
						System.exit(0);
					});
				}else
					window.close();
			}
		});

		// Display window and wait for it to be closed before returning
		Scene scene = new Scene(layout);
		window.setScene(scene);
		window.show();
	}

}
