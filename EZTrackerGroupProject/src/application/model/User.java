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
	
	public User(String userName, String name, String age, String gender, String weight, String height, String goalWeight) {
		super();
		this.userName = userName;
		this.name = name;
		this.age = Integer.parseInt(age);
		this.gender = gender;
		this.weight = Integer.parseInt(weight);
		this.height = Integer.parseInt(height);
		this.goalWeight = Integer.parseInt(goalWeight);
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	}
	
	

