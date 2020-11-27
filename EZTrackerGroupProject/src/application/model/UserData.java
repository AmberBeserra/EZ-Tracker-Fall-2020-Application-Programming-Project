package application.model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/**
 * This class allows existing users stored in userList.ser to be loaded into program and manipulated.
 * 
 * @author yit032
 * @version 1.0
 * @since 2020-11-27
 */
public class UserData
{
	/**
	 * Checks if username passed already exists.
	 * 
	 * @param username username of user to be searched
	 * @return returns true if user exists and false if they do not
	 * 
	 * @throws ClassNotFoundException
	 * @throws IOException
	 */
	public boolean userExists(String username) throws ClassNotFoundException, IOException{
		ArrayList<User> userList =  loadExistingUsers();	//load existing users from userList.ser
		
		//iterates through all users
		for(int i = 0; i < userList.size(); i++){
			//checks if username is already stored and a user
			if(userList.get(i).getUserName().equals(username)) 
				return true;
		}
		return false;
	}
	/**
	 * Prints existing users for debugging purposes.
	 * 
	 * @throws ClassNotFoundException
	 * @throws IOException
	 */
	public void printExisting() throws ClassNotFoundException, IOException{
		ArrayList<User> userList =  loadExistingUsers();	//load existing users from userList.ser
		//iterates through all users, prints info
		for(int i = 0; i < userList.size(); i++) {
			System.out.println(userList.get(i).getUserName());
			System.out.println(userList.get(i).getName());
			System.out.println(userList.get(i).getAge());
			System.out.println(userList.get(i).getGender());
			System.out.println(userList.get(i).getWeight());
			System.out.println(userList.get(i).getHeight());
			
		}
	}
	
	 /**
	  * Adds new users to userList.ser as long as the username does not already exist.
	  * 
	 * @param newUser user object storing all user information
	 * @return returns true if user is created false if unable to create
	 * 
	 * @throws ClassNotFoundException
	 * @throws IOException
	 */
	public boolean addUser(User newUser) throws ClassNotFoundException, IOException{
		ArrayList<User> userList =  loadExistingUsers();	//load existing users from userList.ser
		
		//checks if userList is empty
		if(userList.isEmpty()){
			userList.add(newUser);	//adds user to userList array
			updateUsers(userList);	//adds userList to userList.ser
			return true;
		}
		else {
			//iterates through  userList
			for(int i = 0; i < userList.size(); i++){
				//checks if username is already stored and a user, if exists does not add
				if(userList.get(i).getUserName().equals(newUser.getUserName())) 
					return false;	
			}
			userList.add(newUser);	//adds user to userList array
			updateUsers(userList);	//adds userList to userList.ser
			return true;
		}
	}
	
	/**
	 * Updates userList.ser to contain most up to date list of users
	 * 
	 * @param users userlist to update userList.ser with
	 * 
	 * @throws IOException
	 */
	public void updateUsers(ArrayList<User> users) throws IOException{
       FileOutputStream fos= new FileOutputStream("userList.ser");
       ObjectOutputStream oos= new ObjectOutputStream(fos);
       oos.writeObject(users);
       oos.close();
       fos.close();
	}
	 /**
	  * Updates specific user information
	  * 
	 * @param user	user to be updated
	 * 
	 * @throws ClassNotFoundException
	 * @throws IOException
	 */
	public void updateUser(User user) throws ClassNotFoundException, IOException{
		ArrayList<User> userList =  loadExistingUsers();	//load existing users from userList.ser
		
			//iterates through arraylist
			for(int i = 0; i < userList.size(); i++){
				//checks if usernames match
				if(userList.get(i).getUserName().equals(user.getUserName()))
				{
					userList.set(i, user);	//updates userList with users new info
				}
				
			}
			updateUsers(userList);	//updates userList.ser with new list of users
	}
	/**
	 * Loads all existing users from userList.ser into an arraylist of users
	 * 
	 * @return	existing users
	 * 
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */
	@SuppressWarnings("unchecked")
	public ArrayList<User> loadExistingUsers() throws IOException, ClassNotFoundException{
		ArrayList<User> users =  new ArrayList<User>();
		
		//attemps to read from serialized file and store in arraylist of user
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
	/**
	 * Gets specific user from userList.ser.
	 * 
	 * @param username username of user
	 * @return returns user with information, or empty user if not found
	 * 
	 * @throws ClassNotFoundException
	 * @throws IOException
	 */
	public User getUser(String username) throws ClassNotFoundException, IOException{
		ArrayList<User> userList =  loadExistingUsers();	//load existing users from userList.ser
		User user = new User();
		//iterates through arraylist of users
		for(int i = 0; i < userList.size(); i++){
			//checks if usernames match
			if(userList.get(i).getUserName().equals(username)) 
				return userList.get(i);	
		} 
		return user;
	}
}
