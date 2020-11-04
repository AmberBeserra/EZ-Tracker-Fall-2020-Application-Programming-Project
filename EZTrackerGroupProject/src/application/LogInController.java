package application;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.fxml.FXMLLoader;

public class LogInController
{	
	private AnchorPane mainPane2;
	private AnchorPane mainPane;
	private AnchorPane mainPane3;
	private AnchorPane newuser;
    @FXML
    public void newUser(ActionEvent event) throws IOException 
    {
        newuser= FXMLLoader.load(getClass().getResource("NewUser.fxml"));// pane you are GOING TO
        Scene scene = new Scene(newuser);// pane you are GOING TO show
        scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();// pane you are ON
        window.setScene(scene);
        window.show();

    }
    @FXML
    void handle2Screen(ActionEvent event) throws IOException  
    {
    	mainPane2 = FXMLLoader.load(getClass().getResource("LogIn.fxml"));// pane you are GOING TO
        Scene scene = new Scene(mainPane2);// pane you are GOING TO show
        scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();// pane you are ON
        window.setScene(scene);
        window.show();
    }
    
    @FXML
    public void handle1(ActionEvent event) throws IOException //goes to main user page(we need to put in method later for login check)
    {
        mainPane = FXMLLoader.load(getClass().getResource("UserPage.fxml"));// pane you are GOING TO
        Scene scene = new Scene(mainPane);// pane you are GOING TO show
        scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();// pane you are ON
        window.setScene(scene);
        window.show();

    }
      
        	   
  }
     
    

