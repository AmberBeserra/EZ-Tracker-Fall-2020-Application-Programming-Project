package application.controller;
import java.io.IOException;
import application.model.UserData;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.fxml.FXMLLoader;

/**
 * This class controls the login view. Validates input before passing to model classes.
 * 
 * @author yit031
 * @version 1.0
 * @since 2020-11-27
 *
 */
public class LogInController
{
	//Pages	
	@FXML
	private AnchorPane userScene;
	@FXML
	private AnchorPane newUserScene;
	//TextFields
	@FXML
	private TextField userName;
	//User name put into TextField
	static String username;

	/**
	 * Takes user to user page providing a correct login is put in.
	 * 
	 * @param event Login button is clicked.
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */
	@FXML
	public void toUserScene(ActionEvent event) throws IOException , ClassNotFoundException
	{
		UserData data = new UserData();
		//Checks if user name TextField is empty
		if(userName.getText().isEmpty()||userName.getText()== null){
			Alert userNotFound = new Alert(AlertType.NONE);
			userNotFound.setAlertType(AlertType.ERROR);
			userNotFound.setTitle("ERROR");
			userNotFound.setHeaderText("No text detected!");
			userNotFound.setContentText("Please enter a username into text field.");
			userNotFound.show();    		
		}
		else{
			username = userName.getText();		//Sets user name to TextField for package

			//Checks if user exists
			if(data.userExists(username)){
				userScene= FXMLLoader.load(getClass().getResource("../view/UserPage.fxml"));// pane you are GOING TO
				Scene scene = new Scene(userScene);// pane you are GOING TO show
				scene.getStylesheets().add(getClass().getResource("../view/application.css").toExternalForm());
				Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();// pane you are ON
				window.setScene(scene);
				window.show();
			}
			else {
				Alert userNotFound = new Alert(AlertType.NONE);
				userNotFound.setAlertType(AlertType.ERROR);
				userNotFound.setTitle("ERROR");
				userNotFound.setHeaderText("User not found!");
				userNotFound.setContentText("User " + username + " does not exist! Try again or create new user.");
				userNotFound.show();
			}
		}
	}

	/**
	 * Takes user to create new user page.
	 * 
	 * @param event New user button is clicked.
	 * @throws IOException
	 */
	@FXML
	public void toNewUserScene(ActionEvent event) throws IOException 
	{
		newUserScene= FXMLLoader.load(getClass().getResource("../view/NewUser.fxml"));// pane you are GOING TO
		Scene scene = new Scene(newUserScene);// pane you are GOING TO show
		scene.getStylesheets().add(getClass().getResource("../view/application.css").toExternalForm());
		Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();// pane you are ON
		window.setScene(scene);
		window.show();

	}
}



