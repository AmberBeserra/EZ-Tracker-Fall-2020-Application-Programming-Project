package application.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import application.model.User;
import application.model.UserData;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class UserController
{
    @FXML
    private AnchorPane loginScene;
    
    @FXML
    private AnchorPane monthlySummaryScene;
    
    @FXML
    private AnchorPane foodScene;
    
    @FXML
    private Label userlabel;

    @FXML
    private TextField newWeight;

    @FXML
    private Label currentWeight;

    @FXML
    private Button update;

    @FXML
    private Label goalWeight;

    @FXML
    private Button home;

    @FXML
    private Button toSummary;

    @FXML
    private Label userweightlabel;

    @FXML
    private Label currentUser;

    @FXML
    private Label userHeight;

    @FXML
    private Label goalweightlabel;
	
    @FXML
    private Label totalCalories;
   

    @FXML
    public void toMonthlySummary(ActionEvent event) throws IOException 
    {
    	monthlySummaryScene = FXMLLoader.load(getClass().getResource("../view/Monthly.fxml"));// pane you are GOING TO
        Scene scene = new Scene(monthlySummaryScene);// pane you are GOING TO show
        scene.getStylesheets().add(getClass().getResource("../view/application.css").toExternalForm());
        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();// pane you are ON
        window.setScene(scene);
        window.show();   
    }
    
    @FXML
    void toLoginScene(ActionEvent event) throws IOException 
    {
    	LogInController.username = null;
    	  loginScene = FXMLLoader.load(getClass().getResource("../view/LogIn.fxml"));// pane you are GOING TO
          Scene scene = new Scene(loginScene);// pane you are GOING TO show
          scene.getStylesheets().add(getClass().getResource("../view/application.css").toExternalForm());
          Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();// pane you are ON
          window.setScene(scene);
          window.show();
    }

    @FXML
    void toFoodScene(ActionEvent event) throws IOException 
    {
    	  foodScene = FXMLLoader.load(getClass().getResource("../view/newFood.fxml"));// pane you are GOING TO
          Scene scene = new Scene(foodScene);// pane you are GOING TO show
          scene.getStylesheets().add(getClass().getResource("../view/application.css").toExternalForm());
          Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();// pane you are ON
          window.setScene(scene);
          window.show();
    }
    @FXML
    public void loadStats(String username) throws ClassNotFoundException, IOException{
    	UserData data = new UserData();
    	User user = new User();
    	user = data.getUser(username);
    	userlabel.setText(user.getName());
    	currentUser.setText(user.getUserName());
    	currentWeight.setText(Integer.toString(user.getWeight())+"lbs");
    	goalWeight.setText(Integer.toString(user.getGoalWeight())+"lbs");
    	userHeight.setText(Integer.toString(user.getHeight())+"in");
    	totalCalories.setText(Integer.toString(user.getCalorieGoal()));

    }

    @FXML
    void updateWeight(ActionEvent event) throws IOException 
    {
    	//change the current weight and update the current weight displayed on click
    	
    }
    
}
