package application.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import application.model.User;
import application.model.UserData;
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

public class WeekySummaryController
{
	@FXML
	private AnchorPane mainPane;
	private AnchorPane InvPane;

	@FXML
	private Label text;
	@FXML
	private Label currentUser;

	@FXML
	public void toUserScene(ActionEvent event) throws IOException //goes to main user page
, ClassNotFoundException
	{
		FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/UserPage.fxml"));
		Parent userScene = loader.load();
		UserController controller = loader.getController();
		controller.loadStats(LogInController.username);
		Scene scene = new Scene(userScene);// pane you are GOING TO show
		scene.getStylesheets().add(getClass().getResource("../view/application.css").toExternalForm());
		Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();// pane you are ON
		window.setScene(scene);
		window.show();

	}
	public void loadStats(String username) throws ClassNotFoundException, IOException{
		UserData data = new UserData();
		User user = new User();
		user = data.getUser(username);;
		currentUser.setText(user.getUserName());
	}
}
