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
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.fxml.FXMLLoader;

public class LogInController
{	@FXML
	private AnchorPane mainPane;
	@FXML
	private AnchorPane newuser;
	@FXML
	private TextField userName;
	
	static String username;
	
    @FXML
    public void handle1(ActionEvent event) throws IOException //goes to main user page(we need to put in method later for login check)
, ClassNotFoundException
    {
    	UserData data = new UserData();
    	username = userName.getText();
    	
    	if(data.userExists(username)){
            mainPane = FXMLLoader.load(getClass().getResource("../view/UserPage.fxml"));// pane you are GOING TO
            Scene scene = new Scene(mainPane);// pane you are GOING TO show
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
    
    @FXML
    public void newUser(ActionEvent event) throws IOException 
    {
        newuser= FXMLLoader.load(getClass().getResource("../view/NewUser.fxml"));// pane you are GOING TO
        Scene scene = new Scene(newuser);// pane you are GOING TO show
        scene.getStylesheets().add(getClass().getResource("../view/application.css").toExternalForm());
        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();// pane you are ON
        window.setScene(scene);
        window.show();

    }
      
        	   
  }
     
    

