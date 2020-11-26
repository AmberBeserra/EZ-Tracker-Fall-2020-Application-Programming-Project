package application.model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.util.ArrayList;

public class UserData
{
	public boolean userExists(String username) throws ClassNotFoundException, IOException{
		ArrayList<User> userList =  loadExistingUsers();
		for(int i = 0; i < userList.size(); i++){
			if(userList.get(i).getUserName().equals(username)) 
				return true;
		}
		return false;
	}
	public void printExisting() throws ClassNotFoundException, IOException{
		ArrayList<User> userList =  loadExistingUsers();
		for(int i = 0; i < userList.size(); i++) {
			System.out.println(userList.get(i).getUserName());
			System.out.println(userList.get(i).getName());
			System.out.println(userList.get(i).getAge());
			System.out.println(userList.get(i).getGender());
			System.out.println(userList.get(i).getWeight());
			System.out.println(userList.get(i).getHeight());
			
		}
	}
	 public boolean addUser(User newUser) throws ClassNotFoundException, IOException{
		ArrayList<User> userList =  loadExistingUsers();
		
		if(userList.isEmpty()){
			userList.add(newUser);
			updateUsers(userList);
			return true;
		}
		else {
			for(int i = 0; i < userList.size(); i++){
				if(userList.get(i).getUserName().equals(newUser.getUserName())) 
					return false;	
			}
			userList.add(newUser);
			updateUsers(userList);
			return true;
		}
	}
	public void updateUsers(ArrayList<User> users) throws IOException{
       FileOutputStream fos= new FileOutputStream("userList.ser");
       ObjectOutputStream oos= new ObjectOutputStream(fos);
       oos.writeObject(users);
       oos.close();
       fos.close();
	}
	 public void updateUser(User user) throws ClassNotFoundException, IOException{
		ArrayList<User> userList =  loadExistingUsers();
		

			for(int i = 0; i < userList.size(); i++){
				if(userList.get(i).getUserName().equals(user.getUserName()))
				{
					userList.set(i, user);
				}
				
			}
			updateUsers(userList);
	}
	@SuppressWarnings("unchecked")
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
           users = (ArrayList<User>)ois.readObject();
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
	}
	public User getUser(String username) throws ClassNotFoundException, IOException{
		ArrayList<User> userList =  loadExistingUsers();
		User user = new User();
		for(int i = 0; i < userList.size(); i++){
			if(userList.get(i).getUserName().equals(username)) 
				return userList.get(i);	
		} 
		return user;
	}
	public ArrayList<Meal> monthlyMeals(User user){
		ArrayList <Meal> monthly = new ArrayList<Meal>();
		for(int i = 0; i < user.getMealHistory().size(); i++) {
			if (user.getMealHistory().get(i).getDay().getMonth().equals(LocalDate.now().getMonth())){
				monthly.add(user.getMealHistory().get(i));
			}
		}
		return monthly;
	}
	public ArrayList<Meal> todaysMeals(User user){
		ArrayList <Meal> today = new ArrayList<Meal>();
		for(int i = 0; i < user.getMealHistory().size(); i++) {
			if (user.getMealHistory().get(i).getDay().equals(LocalDate.now())){
				today.add(user.getMealHistory().get(i));
			}
		}
		return today;
	}
	public int todaysCalories(ArrayList<Meal> meals){
		int totalCalories = 0;
		for(int i = 0; i < meals.size(); i++) {
			for(int j = 0; j <meals.get(i).getFoodItems().size(); j++){
				totalCalories += meals.get(i).getFoodItems().get(j).getCalories();
			}
		}
		return totalCalories;
	}
	public int totalCarbs(ArrayList<Meal> meals){
		int totalCarbs = 0;
		for(int i = 0; i < meals.size(); i++) {
			for(int j = 0; j <meals.get(i).getFoodItems().size(); j++){
				totalCarbs += meals.get(i).getFoodItems().get(i).getCarbs();
			}
		}
		return totalCarbs;
	}
	public int totalFat(ArrayList<Meal> meals){
		int totalFat = 0;
		for(int i = 0; i < meals.size(); i++) {
			for(int j = 0; j <meals.get(i).getFoodItems().size(); j++){
				totalFat += meals.get(i).getFoodItems().get(i).getFat();
			}
		}
		return totalFat;
	}
	public int totalProtein(ArrayList<Meal> meals){
		int totalProtein = 0;
		for(int i = 0; i < meals.size(); i++) {
			for(int j = 0; j <meals.get(i).getFoodItems().size(); j++){
				totalProtein += meals.get(i).getFoodItems().get(i).getProtein();
			}
		}
		return totalProtein;
	}
}
