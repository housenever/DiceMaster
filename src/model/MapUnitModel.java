package model;

import javafx.scene.control.Label;

public class MapUnitModel extends Label{



	private Boolean isWall = false;
	private Boolean hasHero = false;     //This is for further use
	private int xAxis, yAxis;

	public Boolean getWall() {
		return isWall;
	}
	
	public MapUnitModel(Boolean _isWall, Boolean _hasHero) {
		// TODO Auto-generated constructor stub
		isWall = _isWall;
		hasHero = _hasHero;
		
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
		xAxis = x;
		yAxis = y;
	}
	
}
