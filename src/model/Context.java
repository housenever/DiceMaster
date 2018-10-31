package model;

public class Context {
	private final static Context instance = new Context();

	public static Context getInstance() {
		return instance;
	}

	private MapModel mapModel = new MapModel(20);

	public MapModel getMapModel() {
		return mapModel;
	}
}