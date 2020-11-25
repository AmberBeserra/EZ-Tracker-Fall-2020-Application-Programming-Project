
package application.model;


import java.io.Serializable;
import java.util.ArrayList;


/**
 * @author yit031
 * @version .9
 * @since 2020-11-25
 */
public class User implements Serializable{
	private static final long serialVersionUID = 1L;
	private String userName;
	private String name;
	private int age;
	private String gender;
	private int weight;
	private int height;
	private int goalWeight;
	private int calorieGoal;
	private int caloriesUsed;
	private int loseOrGain;
	private Boolean isEmpty;
	private ArrayList<Meal> mealHistory;

	public User(){
		super();
		this.isEmpty = true;
	}
	public User(String userName, String name, String age, String gender, String weight, String height, String goalWeight, int lOrG) {
		super();
		this.userName = userName;
		this.name = name;
		this.age = Integer.parseInt(age);
		this.gender = gender;
		this.weight = Integer.parseInt(weight);
		this.height = Integer.parseInt(height);
		this.goalWeight = Integer.parseInt(goalWeight);
		this.calorieGoal = calcCalories(gender,Integer.parseInt(age),Integer.parseInt(weight),Integer.parseInt(height),lOrG);
		this.loseOrGain = lOrG;
		this.isEmpty = false;
		this.mealHistory = new ArrayList<Meal>();


	}
	/**
	 * Gets User's username.
	 * 
	 * @return username
	 */
	public String getUserName() {
		return userName;
	}
	/**
	 * Sets User's username. NOTE: Should not be used without checking if user exists.
	 * 
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}
	/**
	 * Gets User's full name.
	 * 
	 * @return Returns full name
	 */
	public String getName() {
		return name;
	}
	/**
	 * Sets User's full name.
	 * 
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * Gets User's age.
	 * 
	 * @return Returns User's age
	 */
	public int getAge() {
		return age;
	}
	/**
	 * Sets User's age.
	 * 
	 */
	public void setAge(int age) {
		this.age = age;
	}
	/**
	 * Gets User's gender(M or F).
	 * 
	 * @return Returns User's gender
	 */
	public String getGender() {
		return gender;
	}
	/**
	 * Sets User's gender.
	 * 
	 */
	public void setGender(String gender) {
		this.gender = gender;
	}
	/**
	 * Gets User's weight(lbs).
	 * 
	 * @return Returns User's weight
	 */
	public int getWeight() {
		return weight;
	}
	/**
	 * Sets User's weight(lbs).
	 * 
	 */
	public void setWeight(int weight) {
		this.weight = weight;
	}
	/**
	 * Gets User's height(in).
	 * 
	 * @return Returns User's height
	 */
	public int getHeight() {
		return height;
	}
	/**
	 * Sets User's weight(in).
	 * 
	 */
	public void setHeight(int height) {
		this.height = height;
	}
	/**
	 * Gets User's goal weight(lbs).
	 * 
	 * @return Returns User's goal weight(lbs)
	 */
	public int getGoalWeight() {
		return goalWeight;
	}
	/**
	 * Sets User's goal weight(lbs).
	 * 
	 */
	public void setGoalWeight(int goalWeight) {
		this.goalWeight = goalWeight;
	}
	/**
	 * Gets User's calorie goal(kCal).
	 * 
	 * @return Returns User's  calorie goal(kCal)
	 */
	public int getCalorieGoal() {
		return calorieGoal;
	}
	/**
	 * Sets User's calorie goal(kCal).
	 * 
	 */
	public void setCalorieGoal(int calorieGoal) {
		this.calorieGoal = calorieGoal;
	}
	/**
	 * Gets User's amount of calories used(kCal).
	 * 
	 * @return Returns User's amount of used calorieskCal)
	 */
	public int getCaloriesUsed() {
		return caloriesUsed;
	}
	/**
	 * Sets User's amount of used calories(kCal).
	 * 
	 */
	public void setCaloriesUsed(int caloriesUsed) {
		this.caloriesUsed = caloriesUsed;
	}
	/**
	 * Gets whether user wants to lose, maintain, or gain weight.
	 * 
	 * @return Returns lose,gain, or maintain
	 */
	public int getLoseOrGain() {
		return loseOrGain;
	}
	/**
	 * Sets whether user wants to lose, maintain, or gain weight.
	 * 
	 */
	public void setLoseOrGain(int loseOrGain) {
		this.loseOrGain = loseOrGain;
	}
	/**
	 * Checks whether user is populated with values or empty.
	 * 
	 * @return Returns False if user is populated or true if empty
	 */
	public Boolean getIsEmpty() {
		return isEmpty;
	}
	/**
	 * Sets whether user is populated with values or empty.
	 * 
	 */
	public void setIsEmpty(Boolean isEmpty) {
		this.isEmpty = isEmpty;
	}
	/**
	 * Gets users meal history.
	 * 
	 * @return Returns ArrayList or all meals added
	 */
	public ArrayList<Meal> getMealHistory() {
		return mealHistory;
	}
	/**
	 * Sets users meal history.
	 * 
	 */
	public void setMealHistory(ArrayList<Meal> mealHistory) {
		this.mealHistory = mealHistory;
	}
	/**
	 * Adds meal to current mealhistory.
	 * 
	 */
	public void addMeal(Meal meal) {
		this.mealHistory.add(meal);
	}
	/**
	 * Calculates total calories available base on values selected from parameter.
	 * 
	 * @param gender Gender of user(M or F)
	 * @param age Age of user
	 * @param weight Weight of user (lbs)
	 * @param height Heigh of user (in)
	 * @param lOrG Whether use wants to lose,gain, or maintain weight
	 * @return Total calories available for provided values.
	 */
	public int calcCalories(String gender,int age, int weight, int height, int lOrG){
		int h = (int) (height*2.54);
		int w = (int) (weight*.453592);
		int BMR;
		int TDEE;
		int totalCalories;
		int loseGain = lOrG;		//lose=1 gain=2, defaults to maintain
		@SuppressWarnings("unused")	//to be implemented later
		int activityLevel = 0;	// how active user is, defaults to sedentary


		//Caclulates BMR depending on whether M or F
		if(gender.equalsIgnoreCase("M")){
			BMR =(int) (66+(13.7*w)+(5*h)-(6.8*age));
		}
		else {
			BMR =(int) (655+(9.6*w)+(1.8*h)-(4.7*age));
		}
		//Calculate TDEE
		TDEE=(int) (BMR*1.2);

		//Update total calories based on whether user wants to lose gain or maintain
		switch(loseGain){
		case 1:		//User wants to lose weight
			totalCalories = (int) (TDEE *.8);
			break;
		case 2:		//User wants to gain weight
			totalCalories = TDEE + 250;
			break;
		default:	//User wants to maintain weight.
			totalCalories =TDEE;
			break;

		}
		return totalCalories;

	}
}



