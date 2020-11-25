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

/**
 * @author yit031
 * @version .9
 * @since 2020-11-25
 *
 */
public class MonthlySummaryController
{
	//Pages
	@FXML
	private AnchorPane userScene;
	//Label
	@FXML
	private Label currentUser;

	/**
	 * Takes user to user page.
	 * 
	 * @param event Back button clicked
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */
	@FXML
	private void toUserScene(ActionEvent event) throws IOException, ClassNotFoundException
	{
		userScene= FXMLLoader.load(getClass().getResource("../view/UserPage.fxml"));// pane you are GOING TO
		Scene scene = new Scene(userScene);// pane you are GOING TO show
		scene.getStylesheets().add(getClass().getResource("../view/application.css").toExternalForm());
		Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();// pane you are ON
		window.setScene(scene);
		window.show();

	}
	/**
	 * Loads data for view.
	 * 
	 * @throws ClassNotFoundException
	 * @throws IOException
	 */
	@FXML
	private void initialize() throws ClassNotFoundException, IOException{
		UserData data = new UserData();
		User user = new User();
		user = data.getUser(LogInController.username);;
		currentUser.setText(user.getUserName());
	}
}
