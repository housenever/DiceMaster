package model;

import javafx.scene.control.Label;
import javafx.scene.image.ImageView;

public class AbilityModel {
	private ImageView drag;
	private ImageView drop;
	private int HPproperty;
	private int MPproperty;
	public AbilityModel(ImageView drag, ImageView drop, Label ability, int HPproperty,int MPproperty ) {
		super();
		this.drag = drag;
		this.drop = drop;
		this.HPproperty = HPproperty;
		this.MPproperty = MPproperty;
		this.ability = ability;
	}
	private Label ability;
	public ImageView getDrag() {
		return drag;
	}
	public void setDrag(ImageView drag) {
		this.drag = drag;
	}
	public ImageView getDrop() {
		return drop;
	}
	public void setDrop(ImageView drop) {
		this.drop = drop;
	}
	public Label getAbility() {
		return ability;
	}
	public void setAbility(Label ability) {
		this.ability = ability;
	}
	public int getHPproperty() {
		return HPproperty;
	}
	public void setHPproperty(int hPproperty) {
		HPproperty = hPproperty;
	}
	public int getMPproperty() {
		return MPproperty;
	}
	public void setMPproperty(int mPproperty) {
		MPproperty = mPproperty;
	}
 
	
	

}
