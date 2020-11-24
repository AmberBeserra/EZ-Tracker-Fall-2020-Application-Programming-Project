package application.controller;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

import application.model.User;
import application.model.UserData;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.fxml.FXMLLoader;

public class UpdateUserController
{	
	@FXML
    private Label userweightlabel;

    @FXML
    private Label currentUser;

    @FXML
    private TextField newWeight;

    @FXML
    private TextField newAge;

    @FXML
    private RadioButton loseWeight;

    @FXML
    private Button update;

    @FXML
    private AnchorPane userScene;

    @FXML
    private RadioButton gainWeight;

   

	@FXML
	void toUserScene(ActionEvent event) throws IOException, ClassNotFoundException
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
	void updateUser(ActionEvent event)
	{

	}
	
    @FXML
    public void loadStats(String username) throws ClassNotFoundException, IOException{
    	UserData data = new UserData();
    	User user = new User();
    	user = data.getUser(username);;
    	currentUser.setText(user.getUserName());    }
}



