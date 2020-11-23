package application.controller;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Properties;

import application.model.UserData;
import application.model.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class NewUserController
{
	@FXML
	private AnchorPane mainPane2;

	@FXML
	private TextField newUserName;
	@FXML
	private TextField newName;
	@FXML
	private TextField newAge;
	@FXML
	private TextField newGender;
	@FXML
	private TextField newWeight;
	@FXML
	private TextField newHeight;
	@FXML
	private TextField goalWeight;


	@FXML
	public void createUser(ActionEvent event) throws IOException //goes to main user page
	, ClassNotFoundException
	{
		String userN, name, age, gender, weight, height, gWeight; 

		userN = newUserName.getText();
		name = newName.getText();
		age = newAge.getText();
		gender = newGender.getText();
		weight = newWeight.getText();
		height = newHeight.getText();
		gWeight = goalWeight.getText();

		if(validateInput(userN, name, age, gender, weight, height, gWeight)){
			UserData data= new UserData();
			User user = new User(userN, name, age, gender, weight, height, gWeight);
			if(data.addUser(user)){
				Alert userCreated = new Alert(AlertType.NONE);
				userCreated.setAlertType(AlertType.CONFIRMATION);
				userCreated.setTitle("User Added");
				userCreated.setHeaderText("User added successfully!");
				userCreated.setContentText("You can now login and start tracking!");
				userCreated.show();
				
				mainPane2 = FXMLLoader.load(getClass().getResource("../view/LogIn.fxml"));// pane you are GOING TO
				Scene scene = new Scene(mainPane2);// pane you are GOING TO show
				scene.getStylesheets().add(getClass().getResource("../view/application.css").toExternalForm());
				Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();// pane you are ON
				window.setScene(scene);
				window.show();
			}
			else {
				Alert creationFailed = new Alert(AlertType.NONE);
				creationFailed.setAlertType(AlertType.ERROR);
				creationFailed.setTitle("ERROR");
				creationFailed.setHeaderText("Unable to create user!");
				creationFailed.setContentText("User already exists, choose a different username!");
				creationFailed.show();
			}
		}

	}
	@FXML
	void toLoginScene(ActionEvent event) throws IOException 
	{
		mainPane2 = FXMLLoader.load(getClass().getResource("../view/LogIn.fxml"));// pane you are GOING TO
		Scene scene = new Scene(mainPane2);// pane you are GOING TO show
		scene.getStylesheets().add(getClass().getResource("../view/application.css").toExternalForm());
		Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();// pane you are ON
		window.setScene(scene);
		window.show();
	}

	boolean validateInput(String user, String name, String age, String gen, String weight, String height, String gWeight){
		int issueCode = 0;
		//check if empty input
		if(user.isEmpty()||name.isEmpty()||age.isEmpty()||gen.isEmpty()||weight.isEmpty()||height.isEmpty()||gWeight.isEmpty()){
			issueCode = 1;
		}
		else{
			try{
				if(Integer.parseInt(age) <= 0){
					issueCode = 2;
				}
				if(Integer.parseInt(weight) <= 0){
					issueCode = 2;
				}
				if(Integer.parseInt(height) <= 0){
					issueCode = 2;
				}
				if(Integer.parseInt(gWeight) <= 0){
					issueCode = 2;
				}
			} catch (NumberFormatException e){
				issueCode= 3;
			}
		}
		switch(issueCode) {
		case 1:
			Alert emptyField = new Alert(AlertType.NONE);
			emptyField.setAlertType(AlertType.ERROR);
			emptyField.setTitle("ERROR");
			emptyField.setHeaderText("Unable to create user!");
			emptyField.setContentText("Please make sure every field has a value to create a new user");
			emptyField.show();
			return false;
		case 2:
			Alert valueError = new Alert(AlertType.NONE);
			valueError.setAlertType(AlertType.ERROR);
			valueError.setTitle("ERROR");
			valueError.setHeaderText("Unable to create user!");
			valueError.setContentText("Please make sure every field with a number has a value above zero!");
			valueError.show();
			return false;
		case 3:
			Alert notInt = new Alert(AlertType.NONE);
			notInt.setAlertType(AlertType.ERROR);
			notInt.setTitle("ERROR");
			notInt.setHeaderText("Unable to create user!");
			notInt.setContentText("Please make sure every field requiring an integer has one!");
			notInt.show();
			return false;
		default:
			return true;

		}
	}
}





