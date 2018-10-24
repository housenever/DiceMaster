package model;

import java.util.concurrent.TimeUnit;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class HeroModel extends ImageView {

	private String heroName;
	private int HP;
	private int MP;
	private int xAxis = 0, yAxis = 0;
	private int pix_mazeSize_20 = 25; // unavoidable magic number :(
	Image heroImage = new Image(HeroModel.class.getResourceAsStream("../source/valkyrie.png"));

	public String detectDirection(MapModel map) {
		boolean upHasWall = true;
		boolean downHasWall = true;
		boolean leftHasWall = true;
		boolean rightHasWall = true;
		String s = "";

		try {
			upHasWall = map.getUnitList(xAxis, yAxis - 1).getWall();
			if (!upHasWall) {
				s = s + "up,";
			}
		} catch (Exception e) {
		}

		try {
			downHasWall = map.getUnitList(xAxis, yAxis + 1).getWall();
			if (!downHasWall) {
				s = s + "down,";
			}
		} catch (Exception e) {

		}

		try {
			leftHasWall = map.getUnitList(xAxis - 1, yAxis).getWall();
			if (!leftHasWall) {
				s = s + "left,";
			}
		} catch (Exception e) {

		}

		try {
			rightHasWall = map.getUnitList(xAxis + 1, yAxis).getWall();
			if (!rightHasWall) {
				s = s + "right,";
			}
		} catch (Exception e) {

		}

		return s;

	}

	public void move(MapModel map, int diceNumber, int dx, int dy) {

//			System.out.println("Start Moving");
			for (int i = 0; i < diceNumber; i++) {
				if (!map.getUnitList(xAxis + dx, yAxis + dy).getWall()) {
					updateNewHeroPosition(xAxis + dx, yAxis +dy);

					if (dy == 0){
						this.setTranslateX(dx * xAxis * pix_mazeSize_20);
					}
					else{
						this.setTranslateY(dy * yAxis * pix_mazeSize_20);
					}

					// TimeUnit.SECONDS.sleep(3);
				} else {
					System.out.println("You hit a wall!");
				}
			}



	}

	public HeroModel(String heroName, int HP, int MP) {
		this.heroName = heroName;
		this.HP = HP;
		this.MP = MP;

		this.setImage(heroImage);
		// TODO: 2018/10/17 调整hero尺寸
		this.setFitHeight(30);
		this.setFitWidth(20);

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

		System.out.println("HeroPositionXY set to (" + xAxis + "," + yAxis + ")");
	}

}
