package model;

import javafx.scene.image.Image;

public class HeroPinocchio extends HeroModel {
	
	public HeroPinocchio() {
		super("pinocchio", 50, 100,new Image(HeroModel.class.getResourceAsStream("../source/pinocchio.png")));
		// TODO Auto-generated constructor stub
		System.out.println("Hero Pinocchio has heen created!");
	}

}
