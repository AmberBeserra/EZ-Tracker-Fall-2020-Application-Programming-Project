/**
 * 
 */
package application.model;

/**
 * @author yit031
 *
 */
public class User {
	private String userName;
	private String name;
	private int age;
	private String gender;
	private int weight;
	private int height;
	private int goalWeight;
	private int calorieGoal;
	private int caloriesUsed;
	
	public User(String userName, String name, int age, String gender, int weight, int height, int goalWeight) {
		super();
		this.userName = userName;
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.weight = weight;
		this.height = height;
		this.goalWeight = goalWeight;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
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
	
	
	

}
