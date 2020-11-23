package application.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class newFood
{

	
	@FXML
	private AnchorPane userScene;
	
	
    @FXML
    void toUserScene(ActionEvent event) throws IOException  //returns to main user page
, ClassNotFoundException
    {
    	FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/UserPage.fxml"));
		Parent userScene = loader.load();
		UserController controller = loader.getController();
		controller.loadStats(LogInController.username);
		//userScene = FXMLLoader.load(getClass().getResource("../view/UserPage.fxml"));// pane you are GOING TO
		Scene scene = new Scene(userScene);// pane you are GOING TO show
		scene.getStylesheets().add(getClass().getResource("../view/application.css").toExternalForm());
		Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();// pane you are ON
		window.setScene(scene);
		window.show();

          
    }
    
    @FXML
    void completeMeal(ActionEvent event) throws IOException  //returns to main user page
    {
    	
    }
    
    @FXML
    void addToMeal(ActionEvent event) throws IOException  //returns to main user page
    {
    	
    }
}
