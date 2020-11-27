package application.model;

import java.io.Serializable;

/**
 * This class represents a food items nutritional value including total calories and macronutrients.
 * 
 * @author yit032
 * @version 1.0
 * @since 2020-11-27
 *
 */
public class Food implements Serializable{

	private static final long serialVersionUID = 1L;
	private String name;	//name of food item
	private int calories;	//amount of calories(kCal)
	private int carbs;		// amount of of carbs(g)
	private int fat;		//amount of fat(g)
	private int protein;	//amount of protein(g)
	
	/**
	 * Constructor for food class, any food item created must have all these fields.
	 * 
	 * @param name Name of food items
	 * @param calories Total amount of calories(kCal)
	 * @param carbs Total amount of carbohydrates(g)
	 * @param fat Total amount of fat(g)
	 * @param protein Total amount of protein(g)
	 */
	public Food(String name, int calories, int carbs, int fat, int protein) {
		super();
		this.name = name;
		this.calories = calories;
		this.carbs = carbs;
		this.fat = fat;
		this.protein = protein;
	}
	/**
	 * Gets name of food item.
	 * 
	 * @return name of food item
	 */
	public String getName() {
		return name;
	}
	/**
	 * Gets amount of calories food item contains.
	 * 
	 * @return amount of calories
	 */
	public int getCalories() {
		return calories;
	}
	/**
	 * Gets amount of carbs a food item contains.
	 * @return amount of carbs
	 */
	public int getCarbs() {
		return carbs;
	}
	/**
	 * Gets amount of fat a food item contains.
	 * @return amount of fat
	 */
	public int getFat() {
		return fat;
	}
	/**
	 * Gets amount of protein a food item contains.
	 * @return amount of protein
	 */
	public int getProtein() {
		return protein;
	}

}
