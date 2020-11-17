/**
 * 
 */
package application.model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

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

	public boolean addUser(User newUser) throws ClassNotFoundException, IOException{
		ArrayList<User> userList =  loadExistingUsers();
		
		if(userList.isEmpty()){
			userList.add(newUser);
	         FileOutputStream fos= new FileOutputStream("myfile");
	         ObjectOutputStream oos= new ObjectOutputStream(fos);
	         oos.writeObject(userList);
	         oos.close();
	         fos.close();
			return true;
		}
		else {
			for(int i = 0; i < userList.size(); i++){
				if(userList.get(i).getUserName().equals(newUser.getUserName())) 
					return false;
				
			}
			userList.add(newUser);
	        FileOutputStream fos= new FileOutputStream("myfile");
	        ObjectOutputStream oos= new ObjectOutputStream(fos);
	        oos.writeObject(userList);
	        oos.close();
	        fos.close();
			return true;
		}
	}
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


 
	}

	}
	
	

