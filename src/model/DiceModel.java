package model;

public class DiceModel {
	
	private int diceNumber;
	
	public int rollDice() {
		double d = Math.random();
		int r = (int) ((d * 10) % 6 + 1);
		diceNumber = r;
		return diceNumber;
	}

}
