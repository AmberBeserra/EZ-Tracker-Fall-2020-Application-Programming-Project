/**
 * 
 */
package application.model;


import java.io.Serializable;


/**
 * @author yit031
 *
 */
public class User implements Serializable{
	/**
	 * 
	 */
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
	private Boolean isEmpty;
	
	public User(){
		super();
		this.isEmpty = true;
	}
	public User(String userName, String name, String age, String gender, String weight, String height, String goalWeight) {
		super();
		this.userName = userName;
		this.name = name;
		this.age = Integer.parseInt(age);
		this.gender = gender;
		this.weight = Integer.parseInt(weight);
		this.height = Integer.parseInt(height);
		this.goalWeight = Integer.parseInt(goalWeight);
		this.isEmpty = false;
		this.calorieGoal = calcCalories(gender,Integer.parseInt(age),Integer.parseInt(weight),Integer.parseInt(height));
	}

	public String getUserName() {
		return userName;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getGoalWeight() {
		return goalWeight;
	}

	public void setGoalWeight(int goalWeight) {
		this.goalWeight = goalWeight;
	}

	public int getCalorieGoal() {
		return calorieGoal;
	}

	public void setCalorieGoal(int calorieGoal) {
		this.calorieGoal = calorieGoal;
	}

	public int getCaloriesUsed() {
		return caloriesUsed;
	}

	public void setCaloriesUsed(int caloriesUsed) {
		this.caloriesUsed = caloriesUsed;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
	public Boolean getIsEmpty() {
		return isEmpty;
	}
	public int calcCalories(String gender,int age, int weight, int height){
		int h = (int) (height*2.54);
		int w = (int) (weight*.453592);
		int BMR;
		int TDEE;
		int totalCalories;
		
		if(gender.equalsIgnoreCase("M")){
			BMR =(int) (66+(13.7*w)+(5*h)-(6.8*age));
		}
		else {
			BMR =(int) (655+(9.6*w)+(1.8*h)-(4.7*age));
		}
		TDEE=(int) (BMR*1.2);
		
		return TDEE;
		
	}
	}
	
	

