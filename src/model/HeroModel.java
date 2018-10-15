package model;

public class HeroModel {

	private String heroName;
	private int HP;
	private int MP;
	private int xAxis = 0, yAxis = 0;

	public String detectDirection(MapModel map){
		boolean upHasWall = true;
		boolean downHasWall = true;
		boolean leftHasWall = true;
		boolean rightHasWall = true;
		String s = "";



		try{
			upHasWall = map.getUnitList(xAxis, yAxis-1).getWall();
			if(!upHasWall){
				s = s+"up,";
			}
		}catch(Exception e){
		}

		try{
			downHasWall = map.getUnitList(xAxis, yAxis+1).getWall();
			if(!downHasWall){
				s = s+"down,";
			}
		}catch (Exception e) {

		}

		try{
			leftHasWall = map.getUnitList(xAxis-1, yAxis).getWall();
			if(!leftHasWall){
				s = s+"left,";
			}
		}catch (Exception e){

		}

		try{
			rightHasWall = map.getUnitList(xAxis+1, yAxis).getWall();
			if(!rightHasWall){
				s = s+"right,";
			}
		}catch (Exception e){

		}

		return s;

	}

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
