package application.controller;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.RadioButton;
import java.io.IOException;
import application.model.UserData;
import application.model.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * Controller for NewUser view, allows user to create new user. Validates input before passing to model classes.
 * 
 * @author yit031
 * @version 1.0
 * @since 2020-11-27
 */
public class NewUserController
{
	//Pages
	@FXML
	private AnchorPane mainPane2;
	//TextFields
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
	//ToggleGroup
	@FXML
	private ToggleGroup loseGain;
	//Radio Button
	@FXML
	private RadioButton loseWeight;
	@FXML
	private RadioButton gainWeight;

	/**
	 * Creates User with given value and stores in file.
	 * 
	 * @param event Create User button clicked
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */
	@FXML
	private void createUser(ActionEvent event) throws IOException //goes to main user page
	, ClassNotFoundException
	{
		String userN, name, age, gender, weight, height, gWeight;
		int lOrG;

		//Set all User values to user input
		userN = newUserName.getText();
		name = newName.getText();
		age = newAge.getText();
		gender = newGender.getText();
		weight = newWeight.getText();
		height = newHeight.getText();
		gWeight = goalWeight.getText();
		lOrG = Integer.parseInt(loseGain.getSelectedToggle().getUserData().toString());

		//Make sure user input is valid
		if(validateInput(userN, name, age, gender, weight, height, gWeight)){
			UserData data= new UserData();
			User user = new User(userN, name, age, gender, weight, height, gWeight, lOrG);

			//Adds previous values to user Storage
			if(data.addUser(user)){
				//Confirmation that user was created
				Alert userCreated = new Alert(AlertType.NONE);
				userCreated.setAlertType(AlertType.CONFIRMATION);
				userCreated.setTitle("User Added");
				userCreated.setHeaderText("User added successfully!");
				userCreated.setContentText("You can now login and start tracking!");
				userCreated.show();
				//Goes back to login page
				mainPane2 = FXMLLoader.load(getClass().getResource("../view/LogIn.fxml"));// pane you are GOING TO
				Scene scene = new Scene(mainPane2);// pane you are GOING TO show
				scene.getStylesheets().add(getClass().getResource("../view/application.css").toExternalForm());
				Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();// pane you are ON
				window.setScene(scene);
				window.show();
			}
			else {
				//Error that user already exists
				Alert creationFailed = new Alert(AlertType.NONE);
				creationFailed.setAlertType(AlertType.ERROR);
				creationFailed.setTitle("ERROR");
				creationFailed.setHeaderText("Unable to create user!");
				creationFailed.setContentText("User already exists, choose a different username!");
				creationFailed.show();
			}
		}

	}

	/**
	 * Take user back to Login page.
	 * 
	 * @param event I have a profile button clicked
	 * @throws IOException
	 */
	@FXML
	private void toLoginScene(ActionEvent event) throws IOException 
	{
		mainPane2 = FXMLLoader.load(getClass().getResource("../view/LogIn.fxml"));// pane you are GOING TO
		Scene scene = new Scene(mainPane2);// pane you are GOING TO show
		scene.getStylesheets().add(getClass().getResource("../view/application.css").toExternalForm());
		Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();// pane you are ON
		window.setScene(scene);
		window.show();
	}

	/**
	 * Checks to see if values are valid.
	 * 
	 * @param user The username for new user.
	 * @param name The Full name of user.
	 * @param age The age of user.
	 * @param gen The gender of user.
	 * @param weight The weight of user.
	 * @param height The height of user.
	 * @param gWeight
	 * @return Returns true if valid false if not.
	 */
	private boolean validateInput(String user, String name, String age, String gen, String weight, String height, String gWeight){
		int issueCode = 0;		//Reason input is not valid
		//Check if empty input
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
			if(!gen.equalsIgnoreCase("M")&&!gen.equalsIgnoreCase("F")){
				issueCode = 4;
			}
		}
		switch(issueCode) {
		case 1:		//Empty field
			Alert emptyField = new Alert(AlertType.NONE);
			emptyField.setAlertType(AlertType.ERROR);
			emptyField.setTitle("ERROR");
			emptyField.setHeaderText("Unable to create user!");
			emptyField.setContentText("Please make sure every field has a value to create a new user");
			emptyField.show();
			return false;
		case 2:		//Value below zero
			Alert valueError = new Alert(AlertType.NONE);
			valueError.setAlertType(AlertType.ERROR);
			valueError.setTitle("ERROR");
			valueError.setHeaderText("Unable to create user!");
			valueError.setContentText("Please make sure every field with a number has a value above zero!");
			valueError.show();
			return false;
		case 3:		//Missing int
			Alert notInt = new Alert(AlertType.NONE);
			notInt.setAlertType(AlertType.ERROR);
			notInt.setTitle("ERROR");
			notInt.setHeaderText("Unable to create user!");
			notInt.setContentText("Please make sure every field requiring an integer has one!");
			notInt.show();
			return false;
		case 4:		//Wrong gender
			Alert genderMF = new Alert(AlertType.NONE);
			genderMF.setAlertType(AlertType.ERROR);
			genderMF.setTitle("ERROR");
			genderMF.setHeaderText("Unable to create user!");
			genderMF.setContentText("Please make sure to select M or F for gender for BMR/TDEE calculations!");
			genderMF.show();
			return false;
		default:
			return true;
		}
	}

	/**
	 * Loads scene with data.
	 * 
	 */
	@FXML
	private void initialize(){
		gainWeight.setToggleGroup(loseGain);
		loseWeight.setToggleGroup(loseGain);
		gainWeight.setUserData("2");
		loseWeight.setUserData("1");
		loseWeight.setSelected(true);

	}
}





