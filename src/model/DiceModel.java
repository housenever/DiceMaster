package model;

public class DiceModel {

	private int diceNumber;

	public int getDiceNumber() {
		return diceNumber;
	}

	public void setDiceNumber(int diceNumber) {
		this.diceNumber = diceNumber;
	}
	
	public int rollDice() {
		double d = Math.random();
		int r = (int) ((d * 10) % 6 + 1);
		diceNumber = r;
		setDiceNumber(diceNumber);
		return diceNumber;
	}

}
