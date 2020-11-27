package application.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;

/**
 * This class represents a meal containing multiple food items and a date.
 * 
 * @author yit031
 * @version 1.0
 * @since 2020-11-27
 */
public class Meal implements Serializable {
	private static final long serialVersionUID = 1L;
	LocalDate day;											//date food was added
	ArrayList<Food> foodItems = new ArrayList<Food>();		//food contained in meal
	
	/**
	 * Constructor for a meal, requires these an array of food and date added.
	 * 
	 * @param day date meal was added
	 * @param meal array of food items in meal
	 */
	public Meal(LocalDate day, ArrayList<Food> meal) {
		super();
		this.day = day;
		this.foodItems = meal;
	}
	/**
	 * Gets date meal was added.
	 * 
	 * @return date in year-month-day format
	 */
	public LocalDate getDay() {
		return day;
	}
	/**
	 * Gets ArrayList of individual food items which make a meal.
	 * 
	 * @return individual food items in an ArrayList
	 */
	public ArrayList<Food> getFoodItems() {
		return foodItems;
	}
}
