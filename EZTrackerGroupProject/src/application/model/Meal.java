package application.model;

import java.time.LocalDate;
import java.util.ArrayList;

public class Meal {
	LocalDate day;
	ArrayList<Food> meal = new ArrayList<Food>();
	
	public Meal(LocalDate day, ArrayList<Food> meal) {
		super();
		this.day = day;
		this.meal = meal;
	}
	public LocalDate getDay() {
		return day;
	}
	public void setDay(LocalDate day) {
		this.day = day;
	}
	public ArrayList<Food> getMeal() {
		return meal;
	}
	public void setMeal(ArrayList<Food> meal) {
		this.meal = meal;
	}
}
