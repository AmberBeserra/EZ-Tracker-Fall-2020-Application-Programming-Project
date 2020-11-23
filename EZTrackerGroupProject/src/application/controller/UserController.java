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
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class UserController
{
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
    private Button toFood;

    @FXML
    private Label userHeight;

    @FXML
    private AnchorPane mainPane2;

    @FXML
    private Label goalweightlabel;
	
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
    
    @FXML
    public void newUser(ActionEvent event) throws IOException 
    {
    	newuserscene = FXMLLoader.load(getClass().getResource("../view/NewUser.fxml"));// pane you are GOING TO
        Scene scene = new Scene(newuserscene);// pane you are GOING TO show
        scene.getStylesheets().add(getClass().getResource("../view/application.css").toExternalForm());
        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();// pane you are ON
        window.setScene(scene);
        window.show();

    }

    @FXML
    public void weekSummary(ActionEvent event) throws IOException 
    {
    	weekscene = FXMLLoader.load(getClass().getResource("../view/Weekly.fxml"));// pane you are GOING TO
        Scene scene = new Scene(weekscene);// pane you are GOING TO show
        scene.getStylesheets().add(getClass().getResource("../view/application.css").toExternalForm());
        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();// pane you are ON
        window.setScene(scene);
        window.show();   
    }
    
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
    void updateWeight(ActionEvent event) throws IOException 
    {
    	//change the current weight and update the current weight displayed on click
    	
    }
    
}
