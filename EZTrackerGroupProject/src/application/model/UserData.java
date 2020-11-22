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

public class UserData
{
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
}
