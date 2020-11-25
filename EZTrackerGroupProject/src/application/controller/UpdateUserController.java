package application.controller;

import java.io.IOException;
import application.model.User;
import application.model.UserData;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.fxml.FXMLLoader;

/**
 * @author yit031
 * @version .09
 * @since 2020-11-25
 *
 */
public class UpdateUserController
{	
	//Pages
	@FXML
	private AnchorPane userScene;
	@FXML
	private Label userweightlabel;
	//UserData(Label)
	@FXML
	private Label currentUser;
	//User input(TextField)
	@FXML
	private TextField newWeight;
	@FXML
	private TextField newAge;
	//ToggleGroup
	@FXML
	private ToggleGroup loseGain;
	//User input(RadioButton)
	@FXML
	private RadioButton loseWeight;
	@FXML
	private RadioButton gainWeight;
	//Button
	@FXML
	private Button update;

	/**
	 * Take user to user page.
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
	 * Updates user with given information.
	 * 
	 * @param event Update button clicked
	 * @throws IOException 
	 * @throws ClassNotFoundException 
	 */
	@FXML
	private void updateUser(ActionEvent event) throws ClassNotFoundException, IOException
	{
		//Shows whether something has been changed
		boolean wChanged = true;
		boolean aChanged = true;
		boolean gOrLChanged = true;
		
		String changeLog = "";		//Contains what has and hasn't been changed
		
		UserData data = new UserData();
		User user = new User();

		user = data.getUser(LogInController.username);;		//Sets user = to existing user information
		
		//Checks to see if nothing needs to be changed, adds to changeLog
		if(newWeight.getText().isEmpty()|| newWeight.getText()==""){
			changeLog += "Weight not changed! ";
			wChanged=false;
		}
		if(newAge.getText().isEmpty()|| newAge.getText()==""){
			changeLog += "Age not changed! ";
			aChanged=false;
		}
		if(!loseWeight.isSelected() && !gainWeight.isSelected()){
			changeLog += "Goal not changed! ";
			gOrLChanged = false;
		}
		
		//Makes sure if there are values that they are valid
		if(validateInput(newWeight.getText(),newAge.getText())){
			
			//If value is not blank updates it with user inputer, adds to changeLog
			if(wChanged){
				user.setWeight(Integer.parseInt(newWeight.getText()));
				changeLog += "Weight updated !";
			}
			if(aChanged) {
				user.setAge(Integer.parseInt(newAge.getText()));
				changeLog += "Age updated! ";
			}
			if(gOrLChanged){
				user.setLoseOrGain(Integer.parseInt(loseGain.getSelectedToggle().getUserData().toString()));
			}
			//Updates calories as weight/age/goal play into calculation of daily available calories then updates user
			user.calcCalories(user.getGender(),user.getAge(), user.getWeight(), user.getHeight(), user.getLoseOrGain());
			data.updateUser(user);

			//Alert that update was succesfull and what was updated and what wasn't
			Alert notInt = new Alert(AlertType.NONE);
			notInt.setAlertType(AlertType.CONFIRMATION);
			notInt.setTitle("User updated");
			notInt.setHeaderText("User updated succesfully!");
			notInt.setContentText(changeLog);
			notInt.show();

			//Changed back to user page
			userScene= FXMLLoader.load(getClass().getResource("../view/UserPage.fxml"));// pane you are GOING TO
			Scene scene = new Scene(userScene);// pane you are GOING TO show
			scene.getStylesheets().add(getClass().getResource("../view/application.css").toExternalForm());
			Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();// pane you are ON
			window.setScene(scene);
			window.show();
		}


	}
	/**
	 * Checks if user inputs are valid.
	 * 
	 * @param weight New weight put in by user
	 * @param age New age put int by user
	 * @return True if valid or false if not
	 */
	private boolean validateInput(String weight, String age){
		int issueCode = 0;		//Reason input is not valid
		boolean wChanged = true;
		boolean aChanged = true;
		if(weight.isEmpty()|| weight==""){
			wChanged=false;
		}
		if(age.isEmpty()|| age==""){
			aChanged=false;
		}
		//Check if above zero and int
		try{
			if(aChanged){
				if(Integer.parseInt(age) <= 0){
					issueCode = 2;
				}
			}
			if(wChanged){
				if(Integer.parseInt(weight) <= 0){
					issueCode = 2;
				}
			}
		} catch (NumberFormatException e){
			issueCode= 3;
		}

		switch(issueCode) {
		case 2:		//Value below zero
			Alert valueError = new Alert(AlertType.NONE);
			valueError.setAlertType(AlertType.ERROR);
			valueError.setTitle("ERROR");
			valueError.setHeaderText("Unable to update user!");
			valueError.setContentText("Please make sure every field with a number has a value above zero!");
			valueError.show();
			return false;
		case 3:		//Missing int
			Alert notInt = new Alert(AlertType.NONE);
			notInt.setAlertType(AlertType.ERROR);
			notInt.setTitle("ERROR");
			notInt.setHeaderText("Unable to update user!");
			notInt.setContentText("Please make sure every field requiring an integer has one!");
			notInt.show();
			return false;
		default:
			return true;
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
		gainWeight.setToggleGroup(loseGain);
		loseWeight.setToggleGroup(loseGain);
		gainWeight.setUserData("2");
		loseWeight.setUserData("1");

	}
}



