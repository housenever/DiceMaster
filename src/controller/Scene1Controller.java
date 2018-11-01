package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import model.HeroModel;
import model.HeroPinocchio;
import model.HeroValkyrie;
import model.HeroZombie;

public class Scene1Controller implements Initializable {
	@FXML
	private Button btn1;

	@FXML
	private Button btn2;

	@FXML
	private Button btn3;
	
	@FXML
	private Button nextBtn;

	public static int flag;
	
	public static HeroModel hero;
	
	

	public void nextScene(ActionEvent event) throws IOException {

		switch (flag) {
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

		Parent scene2 = FXMLLoader.load(getClass().getResource("../view/scene2.fxml"));
		Scene editCharaScene = new Scene(scene2);

		Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
		System.out.println("Stage loaded.");

		window.setScene(editCharaScene);
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		nextBtn.setDisable(true);
		
		List<Button> btnList = new ArrayList<>();
		btnList.add(btn1);
		btnList.add(btn2);
		btnList.add(btn3);
		
		btn1.setOnAction(e -> {
			flag=0;
			changeButton(flag, btnList);
		});
		
		btn2.setOnAction(e -> {
			flag=1;
			changeButton(flag, btnList);
		});
		
		btn3.setOnAction(e -> {
			flag=2;
			changeButton(flag, btnList);
		});
		
		

	}

	void changeButton(int flag, List<Button> btnList) {
		
		nextBtn.setDisable(false);
		
		for (int i = 0; i < btnList.size(); i++) {
			if (i == flag) {
				btnList.get(i).setDisable(true);
				btnList.get(i).setText("selected");
			} else {
				btnList.get(i).setDisable(false);
				btnList.get(i).setText("select");
			}

		}

	}
	
}
