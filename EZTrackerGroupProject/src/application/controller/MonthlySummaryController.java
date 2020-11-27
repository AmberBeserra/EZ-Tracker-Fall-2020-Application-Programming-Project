package application.controller;

import java.io.IOException;


import application.model.User;
import application.model.UserData;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * @author yit031
 * @version .9
 * @since 2020-11-25
 *
 */
public class MonthlySummaryController
{
	//Monthly average labels
	@FXML
	private Label avgCarbs; 
	@FXML
	private Label avgFat;
	@FXML
	private Label avgCal;
	@FXML
	private Label avgProtien;
	//Pages
	@FXML
	private AnchorPane userScene;
	//Label
	@FXML
	private Label currentUser;
	//PieChart
	@FXML
	private PieChart monthlyView;

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
		ObservableList<PieChart.Data> pieChartData = FXCollections.observableArrayList(
				new PieChart.Data("Carbs", (data.totalCarbs(data.monthlyMeals(user))*4)),
				new PieChart.Data("Protein", (data.totalProtein(data.monthlyMeals(user))*4)),
				new PieChart.Data("Fat", (data.totalFat(data.monthlyMeals(user))*9)));
		
		currentUser.setText(user.getUserName());
		monthlyView.setData(pieChartData);
		monthlyView.setTitle("Monthly Summary");
	}		
}
