package model;

import java.util.ArrayList;

import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class MapUnitModel extends Label{



	private Boolean isWall = false;
	private Boolean hasHero = false;     //This is for further use
	private int xAxis, yAxis;

	public Boolean getWall() {
		return isWall;
	}
	
	public MapUnitModel(Boolean isWall, Boolean hasHero) {
		// TODO Auto-generated constructor stub
		this.isWall = isWall;
		this.hasHero = hasHero;
		
		// default (not wall)
		this.setText("   ");
		this.setPrefSize(25,25);

		if(this.isWall == true) {
			this.setStyle("-fx-background-color: #844414;");
		}
		else{
			this.setStyle("-fx-border-color: #EEE8E5; -fx-border-width:0.6px;");
		}
	}
	
	public void setXY(int x, int y) {
		this.xAxis = x;
		this.yAxis = y;
	}
	
}
