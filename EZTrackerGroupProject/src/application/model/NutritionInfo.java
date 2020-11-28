package application.model;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 * This class calculates daily nutrition information.
 * 
 * @author yit031
 * @version 1.0
 * @since 2020-11-27
 */
public class NutritionInfo {
	/**
	 * Gets meals corresponding to todays date from meal history.
	 * 
	 * @param user user with meals
	 * @return	arraylist containing meals added today
	 */
	public static ArrayList<Meal> todaysMeals(User user){
		ArrayList <Meal> today = new ArrayList<Meal>();
		for(int i = 0; i < user.getMealHistory().size(); i++) {
			if (user.getMealHistory().get(i).getDay().equals(LocalDate.now())){
				today.add(user.getMealHistory().get(i));
			}
		}
		return today;
	}
	/**
	 * Gets users meals for a month.
	 * 
	 * @param user user to search for meals
	 * @return arraylist of all meals for a month
	 */
	public static ArrayList<Meal> monthlyMeals(User user){
		ArrayList <Meal> monthly = new ArrayList<Meal>();
		for(int i = 0; i < user.getMealHistory().size(); i++) {
			if (user.getMealHistory().get(i).getDay().getMonth().equals(LocalDate.now().getMonth())){
				monthly.add(user.getMealHistory().get(i));
			}
		}
		return monthly;
	}

	/**
	 * Gets total of todays calories from all meals.
	 * 
	 * @param meals todays meals
	 * @return total calories consumed today
	 */
	public static int totalCalories(ArrayList<Meal> meals){
		int totalCalories = 0;
		for(int i = 0; i < meals.size(); i++) {
			for(int j = 0; j <meals.get(i).getFoodItems().size(); j++){
				totalCalories += meals.get(i).getFoodItems().get(j).getCalories();
			}
		}
		return totalCalories;
	}
	/**
	 * Gets total of todays carbs from all meals.
	 * 
	 * @param meals todays meals
	 * @return total carbs consumed today
	 */
	public static int totalCarbs(ArrayList<Meal> meals){
		int totalCarbs = 0;
		for(int i = 0; i < meals.size(); i++) {
			for(int j = 0; j <meals.get(i).getFoodItems().size(); j++){
				totalCarbs += meals.get(i).getFoodItems().get(j).getCarbs();
			}
		}
		return totalCarbs;
	}
	/**
	 * Gets total of todays fat from all meals.
	 * 
	 * @param meals todays meals
	 * @return total fat consumed today
	 */
	public static int totalFat(ArrayList<Meal> meals){
		int totalFat = 0;
		for(int i = 0; i < meals.size(); i++) {
			for(int j = 0; j <meals.get(i).getFoodItems().size(); j++){
				totalFat += meals.get(i).getFoodItems().get(j).getFat();
			}
		}
		return totalFat;
	}
	/**
	 * Gets total of todays protein from all meals.
	 * 
	 * @param meals todays meals
	 * @return total protein consumed today
	 */
	public static int totalProtein(ArrayList<Meal> meals){
		int totalProtein = 0;
		for(int i = 0; i < meals.size(); i++) {
			for(int j = 0; j <meals.get(i).getFoodItems().size(); j++){
				totalProtein += meals.get(i).getFoodItems().get(j).getProtein();
			}
		}
		return totalProtein;
	}
	/**
	 * Prints all meals passed to it to console.
	 * 
	 * @param meals meals to be printed
	 */
	public static void printMeals(ArrayList<Meal> meals){
		for(int i = 0; i < meals.size(); i++) {
			System.out.println(meals.get(i).getDay());
			for(int j = 0; j <meals.get(i).getFoodItems().size(); j++){
				System.out.print(meals.get(i).getFoodItems().get(j).getName()+ ": ");
				System.out.print("carbs =");
				System.out.print(meals.get(i).getFoodItems().get(j).getCarbs()+ "; ");
				System.out.print("fat =");
				System.out.print(meals.get(i).getFoodItems().get(j).getFat()+ "; ");
				System.out.print("protein =");
				System.out.println(meals.get(i).getFoodItems().get(j).getProtein());
			}
		}
	}
}
