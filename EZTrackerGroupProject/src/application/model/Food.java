package application.model;

import java.io.Serializable;

public class Food implements Serializable{

	private static final long serialVersionUID = 1L;
	private String name;
	private int calories;
	private int carbs;
	private int fat;
	private int protein;
	
	public Food(String name, int calories, int carbs, int fat, int protein) {
		super();
		this.name = name;
		this.calories = calories;
		this.carbs = carbs;
		this.fat = fat;
		this.protein = protein;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getCalories() {
		return calories;
	}
	public void setCalories(int calories) {
		this.calories = calories;
	}
	public int getCarbs() {
		return carbs;
	}
	public void setCarbs(int carbs) {
		this.carbs = carbs;
	}
	public int getFat() {
		return fat;
	}
	public void setFat(int fat) {
		this.fat = fat;
	}
	public int getProtein() {
		return protein;
	}
	public void setProtein(int protein) {
		this.protein = protein;
	}
}
