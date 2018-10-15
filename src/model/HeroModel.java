package model;

public class HeroModel {

	private String heroName;
	private int HP;
	private int MP;
	private int xAxis = 0, yAxis = 0;

	public HeroModel(String heroName, int HP, int MP) {
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

	public int getHeroPositionX() {
		return xAxis;
	}

	public int getHeroPositionY() {
		return yAxis;
	}

	public void updateNewHeroPosition(int x, int y) {

		xAxis = x;
		yAxis = y;
		
		System.out.println("HeroPositionXY set to ("+ xAxis + "," + yAxis + ")");
	}

}
