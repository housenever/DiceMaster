package model;

import java.util.ArrayList;

import javafx.scene.layout.GridPane;

public class MapModel {

	// store each unit on the map to list
	private ArrayList<MapUnitModel> mapUnitList = new ArrayList<MapUnitModel>();
	// a grid pane to generate and draw the map
	private GridPane mapPane = new GridPane();

	// constructor 
	public MapModel(int mapSize) {
		// TODO Auto-generated constructor stub
		creatMazeMap(mapSize);
	}
	
	public GridPane getMapPane() {
		return mapPane;
	}

	// method to create map
	private void creatMazeMap(int mapSize) {

		for (int i = mapSize; i > 0; i--)
			for (int j = mapSize; j > 0; j--) {

				// get random number to creating random walls
				Boolean randomWall = false;
				double d = Math.random();
				int r = (int) (d * 100);
				if (r > 50)
					randomWall = true;

				// create a map for maze with random wall
				MapUnitModel aUnit = new MapUnitModel(randomWall, false);
				mapPane.add(aUnit, i, j);
				mapUnitList.add(aUnit);
			}
	}
}
