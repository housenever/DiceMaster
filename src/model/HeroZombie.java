package model;

import javafx.scene.image.Image;

public class HeroZombie extends HeroModel{
	
	public HeroZombie() {
		super("Zombie", 200, 0,new Image(HeroModel.class.getResourceAsStream("../source/Zombie.png")));
		// TODO Auto-generated constructor stub
		System.out.println("Hero Zombie has heen created!");
	}

}
