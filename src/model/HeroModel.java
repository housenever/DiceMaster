package model;

public class HeroModel {

	private String heroName;
	private int HP;
	private int MP;
	
	public HeroModel(String heroName, int HP, int MP){
		this.heroName = heroName;
		this.HP = HP;
		this.MP = MP;
	}
	
	public String getHeroName() {
		return heroName;
	}

	public int getHP() {
		return HP;
	}

	public int getMP() {
		return MP;
	}



	
}
