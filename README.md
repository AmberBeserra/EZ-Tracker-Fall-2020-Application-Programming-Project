# ApplicationProgramming

# EZTracker

## Introduction

This app helps the user to keep track of what they are eating and how it affects their diet over time. It also helps ensure the user that they are getting the recommended servings of their daily nutrients.

## Code Samples


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

This code snippet creates an object user which is then used to store all the user's information. Included in this class is a number of setters and getters for each part of User.

public ArrayList<User> loadExistingUsers() throws IOException, ClassNotFoundException{

		ArrayList<User> users =  new ArrayList<User>();
		try {
			File userList = new File("userList.ser");
			userList.createNewFile();
			BufferedReader br;
			br = new BufferedReader(new FileReader("userList.ser"));
			if (br.readLine() == null) {
				br.close();
				return users;
			}
            FileInputStream fis = new FileInputStream("userList.ser");
            ObjectInputStream ois = new ObjectInputStream(fis);
            users = (ArrayList<User>) ois.readObject();
            ois.close();
            fis.close();
			br.close();
			return users;
		} catch (IOException e) {
			e.printStackTrace();
			throw e;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			throw e;
}

This code snippet loads all existing data from userList.ser into the ArrayList userList allowing the data to be accessible. Using fileInputStream we can read from a .ser file which will allow for constant updates to be saved and accessed.

public void updateUsers(ArrayList<User> users) throws IOException{

        FileOutputStream fos= new FileOutputStream("userList.ser");
        ObjectOutputStream oos= new ObjectOutputStream(fos);
        oos.writeObject(users);
        oos.close();
        fos.close();
}

This code snippet takes all the data that was inputted into the list of users and written to a .ser file which is used to store data from objects.

public class Food {

	private String name;
	private int calories;
	private int carbs;
	private int fat;
	private int protein;

This code snippet shows the Food class which stores the calories, carbs, fats, and proteins gathered from the user's entry. Each Food item is then stored into an arrayList called meal shown below.

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

This code snippet shows the Meal class which stores each food entry from the user at a specific time. It stores the calorie, protein, fats, and carb data from the Food object.
