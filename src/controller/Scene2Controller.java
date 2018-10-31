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
import javafx.scene.control.Label;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.TransferMode;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import model.AbilityModel;

public class Scene2Controller implements Initializable  {
	
    @FXML
    private ImageView charaPic;

    @FXML
    private Text charaName;
    
    @FXML
    private ImageView  drag1;

    @FXML
    private ImageView  drag2;

    @FXML
    private ImageView  drag3;

    @FXML
    private ImageView  drag4;
    
    @FXML
    private ImageView  drop1;

    @FXML
    private ImageView  drop2;

    @FXML
    private ImageView  drop3;

    @FXML
    private ImageView  drop4;
    
    @FXML
    private Label ability1;
    
    @FXML
    private Label ability2;
    
    @FXML
    private Label ability3;
    
    @FXML
    private Label ability4;

     

    public void nextScene(ActionEvent event) throws IOException
    {
        Parent scene3 = FXMLLoader.load(getClass().getResource("../view/scene3.fxml"));
        Scene diffScene = new Scene(scene3);

        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(diffScene);
    }

    public void backScene(ActionEvent event) throws IOException
    {
        Parent scene1 = FXMLLoader.load(getClass().getResource("../view/scene1.fxml"));
        Scene selectCharaScene = new Scene(scene1);

        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(selectCharaScene);
    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		//the hero that you choose
		int flag = Scene1Controller.flag;
		
		String[] roleName = {"Pinocchio","Valkyrie","Zombie"};
		
		charaName.setText(roleName[flag]);
		
		charaPic.setImage(new Image("source/"+roleName[flag].toLowerCase()+".png"));

		Tooltip tooltip1 = new Tooltip();
		tooltip1.setText("HP+40");
		ability1.setTooltip(tooltip1);
		
		Tooltip tooltip2 = new Tooltip();
		tooltip2.setText("MP+40");
		ability2.setTooltip(tooltip1);
		
		Tooltip tooltip3 = new Tooltip();
		tooltip3.setText("HP+50");
		ability3.setTooltip(tooltip1);
		
		Tooltip tooltip4 = new Tooltip();
		tooltip4.setText("MP+50");
		ability4.setTooltip(tooltip1);
	 

		List<AbilityModel > abilityList = new ArrayList<>();
		abilityList.add(new AbilityModel(drag1, drop1, ability1,"HP+40"));
		abilityList.add(new AbilityModel(drag2, drop2, ability2,"MP+40"));
		abilityList.add(new AbilityModel(drag3, drop3, ability3,"HP+50"));
		abilityList.add(new AbilityModel(drag4, drop4, ability4,"MP+50"));
		
		for(AbilityModel abilityModel:abilityList) {
			
			abilityModel.getDrag().setOnDragDetected(e->{
				
				Dragboard dragboard = abilityModel.getDrag().startDragAndDrop(TransferMode.ANY);
				ClipboardContent content = new ClipboardContent();
				content.putImage(abilityModel.getDrag().getImage());
				dragboard.setContent(content);
			});
			
			abilityModel.getDrop().setOnDragDetected(e->{
				Dragboard dragboard = abilityModel.getDrop().startDragAndDrop(TransferMode.ANY);
				ClipboardContent content = new ClipboardContent();
				content.putImage(abilityModel.getDrop().getImage());
				Image myimg = abilityModel.getDrop().getImage();
				System.out.println(abilityModel.getDrop().getImage());
				dragboard.setContent(content);
			});
			
			abilityModel.getDrop().setOnDragDone(e->{
				abilityModel.getDrop().setImage(new Image("source/circle.png"));
				abilityModel.getAbility().setText("Ability");
			});
			
			
			abilityModel.getDrop().setOnDragEntered(e->{
				Dragboard dragboard = e.getDragboard();
				abilityModel.getDrop().setImage(dragboard.getImage());
				abilityModel.getAbility().setText(abilityModel.getProperty());
			});
			
			abilityModel.getDrop().setOnDragExited(e->{
			});
			
			abilityModel.getDrop().setOnDragOver(e->{
				if (e.getGestureSource() != abilityModel.getDrop() && e.getDragboard().hasString()) {
					e.acceptTransferModes(TransferMode.COPY_OR_MOVE);
				}
			});
		}
	}
}
