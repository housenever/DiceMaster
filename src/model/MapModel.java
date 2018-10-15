package model;

import java.util.ArrayList;

import javafx.scene.Node;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;

public class MapModel{

    int position_x = 100;
    int position_y = 100;
	// store each unit on the map to list
//	private ArrayList<MapUnitModel> mapUnitList = new ArrayList<MapUnitModel>();
	private MapUnitModel[][] mapUnitList = new MapUnitModel[position_x][position_y];
	// a grid pane to generate and draw the map
	private GridPane mapPane = new GridPane();

	// constructor 
	public MapModel(int mapSize) {
		creatMazeMap(mapSize);

	}
	
	public GridPane getMapPane() {
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
				if (r > 75)
					randomWall = true;
			
				// create a map for maze with random wall
				MapUnitModel aUnit = new MapUnitModel(randomWall, false);
				mapPane.add(aUnit, i, j);
				aUnit.setXY(i, j);
				mapUnitList[i][j] = aUnit;
				
				// put hero in the maze
				if(i == 0 && j == 0) {
					aUnit.setText("@");
				}
				
			}
	}

	public MapUnitModel getUnitList(int x, int y){
	    return mapUnitList[x][y];
    }

}
