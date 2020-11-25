package application.controller;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

import application.model.UserData;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.fxml.FXMLLoader;

/**
 * @author yit031
 *
 */
public class LogInController
{	@FXML
	private AnchorPane userScene;
@FXML
private AnchorPane newUserScene;
@FXML
private TextField userName;

static String username;

/**
 * Takes user to user page providing a correct login is put in.
 * 
 * @param event Login button is clicked.
 * @throws IOException
 * @throws ClassNotFoundException
 */
@FXML
public void toUserScene(ActionEvent event) throws IOException //goes to main user page(we need to put in method later for login check)
, ClassNotFoundException
{
	UserData data = new UserData();
	//Checks if username TextField is empty
	if(userName.getText().isEmpty()||userName.getText()== null){
		Alert userNotFound = new Alert(AlertType.NONE);
		userNotFound.setAlertType(AlertType.ERROR);
		userNotFound.setTitle("ERROR");
		userNotFound.setHeaderText("No text detected!");
		userNotFound.setContentText("Please enter a username into text field.");
		userNotFound.show();    		
	}
	else{
		username = userName.getText();		//Sets username to TextField for package
		
		//Checks if user exists
		if(data.userExists(username)){
			FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/UserPage.fxml"));
			Parent userScene = loader.load();
			UserController controller = loader.getController();
			controller.loadStats(username);		//Populates information for next view										
			Scene scene = new Scene(userScene);		// pane you are GOING TO show
			scene.getStylesheets().add(getClass().getResource("../view/application.css").toExternalForm());
			Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();		// pane you are ON
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



