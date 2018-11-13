package model;

import java.util.ArrayList;

import javafx.scene.Node;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;

public class MapModel {

	private int position_x = 100;
	private int position_y = 100;
	private int mazeSize;
	private int difficulty;
	
	public int getDifficulty() {
		return difficulty;
	}

	public void setDifficulty(int difficulty) {
		this.difficulty = difficulty;
	}


	// store each unit on the map to list
	private MapUnitModel[][] mapUnitList = new MapUnitModel[position_x][position_y];
	
	// a grid pane to generate and draw the map
	private GridPane mapPane = new GridPane();

	// constructor
	public MapModel(int mapSize) {
		mazeSize = mapSize;
	}

	public GridPane getMapPane() {
		creatMazeMap(mazeSize);
		return mapPane;
	}

	// method to create map
	private void creatMazeMap(int mapSize) {

		for (int i = mapSize; i >= 0; i--)
			for (int j = mapSize; j >= 0; j--) {

				// get random number to creating random walls
				Boolean randomWall = false;
				double d = Math.random();
				int r = (int) (d * 100);
				if (r > 100-difficulty*2.5)
					randomWall = true;


				// create a map for maze with random wall
				MapUnitModel aUnit = new MapUnitModel(randomWall, false);
				mapPane.add(aUnit, i, j);
				aUnit.setXY(i, j);
				mapUnitList[i][j] = aUnit;

				// put hero in the maze
				if (i == 0 && j == 0) {
//					aUnit.setText("@");
//					aUnit.setStyle("-fx-background-color: #fff;");
				}

			}
	}

	public MapUnitModel getUnitList(int x, int y) {
		return mapUnitList[x][y];
	}
	
	public int getSize() {
		return mazeSize;
	}
	
}
