package model;

import javafx.scene.control.Label;

public class MapUnitModel extends Label{

	private Boolean isWall = false;
	private Boolean hasHero = false;     //This is for further use
	
	public MapUnitModel(Boolean isWall, Boolean hasHero) {
		// TODO Auto-generated constructor stub
		this.isWall = isWall;
		this.hasHero = hasHero;
		
		// default (not wall)
		this.setText("   ");
		
		// if true, display wall as "[ ]"
		if(this.isWall == true) {
			this.setText("[ ]");
		}
	}
	
}
