package application.controller;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;

import application.model.Meal;
import application.model.User;
import application.model.UserData;
import application.model.Food;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * @author yit031
 * @version .9
 * @since 2020-11-25
 *
 */
public class NewFoodController
{
	//Pages
	@FXML
	private AnchorPane userScene;
	//User input(TextField)
	@FXML
	private TextField foodName;
	@FXML
	private TextField calories;
	@FXML
	private TextField carbs;
	@FXML
	private TextField fat;
	@FXML
	private TextField protein;
	//Output
	@FXML
	private TextArea output;
	//User data(label
	@FXML
	private Label currentUser;

	static ArrayList<Food> meal = new ArrayList<Food>(); //ArrayList passed between methods	

	/**
	 * Takes user to user page.
	 * 
	 * @param event Back button clicked
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */
	@FXML
	private void toUserScene(ActionEvent event) throws IOException, ClassNotFoundException
	{
		userScene= FXMLLoader.load(getClass().getResource("../view/UserPage.fxml"));// pane you are GOING TO
		Scene scene = new Scene(userScene);// pane you are GOING TO show
		scene.getStylesheets().add(getClass().getResource("../view/application.css").toExternalForm());
		Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();// pane you are ON
		window.setScene(scene);
		window.show();
	}
	/**
	 * Completes meal and adds it to user history after all food items have been added.
	 * 
	 * @param event Done with Meal button clicked
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */
	@FXML
	private void completeMeal(ActionEvent event) throws IOException, ClassNotFoundException
	{
		UserData data = new UserData();
		User currentUser = data.getUser(LogInController.username);		//Sets currentUser to whichever user logged in

		//Checks if meal is empty, if empty prints out error
		if(meal.isEmpty()){
			Alert mealsEmpty = new Alert(AlertType.NONE);
			mealsEmpty.setAlertType(AlertType.ERROR);
			mealsEmpty.setTitle("ERROR");
			mealsEmpty.setHeaderText("Unable to add meal!");
			mealsEmpty.setContentText("Please make sure to add at least one food item!");
			mealsEmpty.show();
		}
		else {
			Meal completeMeal = new Meal(LocalDate.now(), meal);		//Adds all food items and includes date they were added
			currentUser.addMeal(completeMeal);		//Adds meal to user
			data.updateUser(currentUser);			//Updates stored user information

			//Confirms foods was added succesfuly
			Alert mealAdded = new Alert(AlertType.NONE);
			mealAdded.setAlertType(AlertType.CONFIRMATION);
			mealAdded.setTitle("Success");
			mealAdded.setHeaderText("Meal added!");
			mealAdded.setContentText("Meal added to history for " + currentUser.getUserName() + "!");
			mealAdded.show();

			//Takes user back to user page
			userScene= FXMLLoader.load(getClass().getResource("../view/UserPage.fxml"));// pane you are GOING TO
			Scene scene = new Scene(userScene);// pane you are GOING TO show
			scene.getStylesheets().add(getClass().getResource("../view/application.css").toExternalForm());
			Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();// pane you are ON
			window.setScene(scene);
			window.show();
		}

	}

	/**
	 * Takes user input and adds it into a food object.
	 * 
	 * @param event Add To Meal button clicked
	 * @throws IOException
	 */
	@FXML
	private void addToMeal(ActionEvent event) throws IOException  //returns to main user page
	{
		String name = foodName.getText();
		String cal = calories.getText();
		String car = carbs.getText();
		String f = fat.getText();
		String pro = protein.getText();
		String out = "";

		if(validateInput(name,cal,car,f,pro)){
			Food currentItem = new Food(name,Integer.parseInt(cal),Integer.parseInt(car),Integer.parseInt(f),Integer.parseInt(pro));
			meal.add(currentItem);
			out = ("Name: " + name +"\n");
			out += ("Carbs: " + cal +" ");
			out += ("Fat: " + f + " ");
			out += ("Protein: " + pro + "\n");
			output.appendText(out);
		}
	}

	/**
	 * Checks if all values inputed by user are valid
	 * 
	 * @param name Name of foods
	 * @param calories Amount of calories(kCal)
	 * @param carbs Amount of carbs(g)
	 * @param fat Amount of fat(g)
	 * @param protein Amount of protein(g)
	 * @return True if input is valid or false if not valid
	 */
	private Boolean validateInput(String name, String calories,String carbs, String fat, String protein){
		int issueCode = 0;
		if(name.isEmpty()||calories.isEmpty()||carbs.isEmpty()||fat.isEmpty()||protein.isEmpty()){
			issueCode = 1;
		}
		else {
			if(isInt(calories)&&isInt(carbs)&&isInt(fat)&&isInt(protein)){
				if(Integer.parseInt(calories) < 0){
					issueCode = 2;
				}
				if(Integer.parseInt(carbs) < 0){
					issueCode = 2;
				}
				if(Integer.parseInt(fat) < 0){
					issueCode = 2;
				}
				if(Integer.parseInt(protein) < 0){
					issueCode = 2;
				}
			}
			else {
				issueCode = 3;
			}
		}
		switch(issueCode) {
		case 1:
			Alert emptyField = new Alert(AlertType.NONE);
			emptyField.setAlertType(AlertType.ERROR);
			emptyField.setTitle("ERROR");
			emptyField.setHeaderText("Unable to add food!");
			emptyField.setContentText("Please make sure every field has a value to add food");
			emptyField.show();
			return false;
		case 2:
			Alert valueError = new Alert(AlertType.NONE);
			valueError.setAlertType(AlertType.ERROR);
			valueError.setTitle("ERROR");
			valueError.setHeaderText("Unable to add food!");
			valueError.setContentText("Please make sure every field with a number has a value above zero!");
			valueError.show();
			return false;
		case 3:
			Alert notInt = new Alert(AlertType.NONE);
			notInt.setAlertType(AlertType.ERROR);
			notInt.setTitle("ERROR");
			notInt.setHeaderText("Unable to add food");
			notInt.setContentText("Please make sure every field requiring an integer(Calories,Carbs,Fat,Protein) has one!");
			notInt.show();
			return false;
		default:
			return true;
		}
	}
	/**
	 * Checks if string contains an int
	 * @param str String to check for int
	 * @return Tru if value is int false if not
	 */
	private Boolean isInt(String str){
		try 
		{ 
			// checking valid integer using parseInt() method 
			Integer.parseInt(str);
			return true;
		}  
		catch (NumberFormatException e)  
		{ 
			return false;
		}
	}
	/**
	 * Loads user data into view.
	 * @throws ClassNotFoundException
	 * @throws IOException
	 */
	@FXML
	private void initialize() throws ClassNotFoundException, IOException{
		UserData data = new UserData();
		User user = new User();
		user = data.getUser(LogInController.username);;
		currentUser.setText(user.getUserName());    
	}
}
