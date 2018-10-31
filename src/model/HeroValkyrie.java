package model;

import javafx.scene.image.Image;

public class HeroValkyrie extends HeroModel {

	public HeroValkyrie() {
		super("valkyrie", 100, 50,new Image(HeroModel.class.getResourceAsStream("../source/valkyrie.png")));
		// TODO Auto-generated constructor stub
		System.out.println("Hero Valkyrie has heen created!");
	}

	

}
