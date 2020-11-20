package application.controller;
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
	private AnchorPane summary;
	private AnchorPane mainPane;
    @FXML
    void handle2Screen(ActionEvent event) throws IOException 
    {
    	  mainPane2 = FXMLLoader.load(getClass().getResource("../view/LogIn.fxml"));// pane you are GOING TO
          Scene scene = new Scene(mainPane2);// pane you are GOING TO show
          scene.getStylesheets().add(getClass().getResource("../view/application.css").toExternalForm());
          Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();// pane you are ON
          window.setScene(scene);
          window.show();
    }

    @FXML
    void foodHandle(ActionEvent event) throws IOException 
    {
    	  userFood = FXMLLoader.load(getClass().getResource("../view/newFood.fxml"));// pane you are GOING TO
          Scene scene = new Scene(userFood);// pane you are GOING TO show
          scene.getStylesheets().add(getClass().getResource("../view/application.css").toExternalForm());
          Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();// pane you are ON
          window.setScene(scene);
          window.show();
    }
    
    @FXML
    void weekSummary(ActionEvent event) throws IOException 
    {
    	  summary = FXMLLoader.load(getClass().getResource("../view/Weekly.fxml"));// pane you are GOING TO
          Scene scene = new Scene(summary);// pane you are GOING TO show
          scene.getStylesheets().add(getClass().getResource("../view/application.css").toExternalForm());
          Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();// pane you are ON
          window.setScene(scene);
          window.show();
    }
 
    @FXML
    public void handle1(ActionEvent event) throws IOException //goes to main user page
    {
        mainPane = FXMLLoader.load(getClass().getResource("../view/UserPage.fxml"));// pane you are GOING TO
        Scene scene = new Scene(mainPane);// pane you are GOING TO show
        scene.getStylesheets().add(getClass().getResource("../view/application.css").toExternalForm());
        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();// pane you are ON
        window.setScene(scene);
        window.show();

    }
}
    
    
 


