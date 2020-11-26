package application.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;

public class Meal implements Serializable {
	private static final long serialVersionUID = 1L;
	LocalDate day;
	ArrayList<Food> foodItems = new ArrayList<Food>();
	
	public Meal(LocalDate day, ArrayList<Food> meal) {
		super();
		this.day = day;
		this.foodItems = meal;
	}
	public LocalDate getDay() {
		return day;
	}
	public void setDay(LocalDate day) {
		this.day = day;
	}
	public ArrayList<Food> getFoodItems() {
		return foodItems;
	}
}
