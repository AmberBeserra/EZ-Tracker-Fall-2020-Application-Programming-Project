package application;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Properties;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class NewUser
{
	@FXML
	private AnchorPane mainPane2;
	private AnchorPane userFood;
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
    void foodHandle(ActionEvent event) throws IOException 
    {
    	  userFood = FXMLLoader.load(getClass().getResource("newFood.fxml"));// pane you are GOING TO
          Scene scene = new Scene(userFood);// pane you are GOING TO show
          scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
          Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();// pane you are ON
          window.setScene(scene);
          window.show();
    }
    	
 }


	
    
    
 


