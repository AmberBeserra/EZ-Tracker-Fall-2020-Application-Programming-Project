package application.controller;

import java.io.IOException;

import application.model.User;
import application.model.UserData;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
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
public class UserController
{
	//Pages
	@FXML
	private AnchorPane loginScene;
	@FXML
	private AnchorPane monthlySummaryScene;
	@FXML
	private AnchorPane foodScene;
	@FXML
	private AnchorPane UpdateUser;
	//User information(Labels)
	@FXML
	private Label userlabel;
	@FXML
	private Label currentWeight;
	@FXML
	private Label goalWeight;
	@FXML
	private Label currentUser;
	@FXML
	private Label userHeight;
	@FXML
	private Label goalweightlabel;
	@FXML
	private Label totalCalories;
	@FXML
	private Label usedCalories;
	@FXML
	private Label leftCalories;
	@FXML
	private Label userweightlabel;
	//User information(Pie chart)
	@FXML
	private PieChart dailyView;
	//Buttons
	@FXML
	private Button home;
	@FXML
	private Button toSummary;
	@FXML
	private Button update;

	/**
	 * Takes user to monthly summary page.
	 * 
	 * @param event Monthly summary button clicked
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */
	@FXML
	private void toMonthlySummary(ActionEvent event) throws IOException, ClassNotFoundException 
	{
		monthlySummaryScene= FXMLLoader.load(getClass().getResource("../view/Monthly.fxml"));// pane you are GOING TO
		Scene scene = new Scene(monthlySummaryScene);// pane you are GOING TO show
		scene.getStylesheets().add(getClass().getResource("../view/application.css").toExternalForm());
		Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();// pane you are ON
		window.setScene(scene);
		window.show();   
	}
	/**
	 * Takes user to login page.
	 * 
	 * @param event Monthly logout button clicked
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */
	@FXML
	private void toLoginScene(ActionEvent event) throws IOException 
	{
		LogInController.username = null;
		loginScene = FXMLLoader.load(getClass().getResource("../view/LogIn.fxml"));// pane you are GOING TO
		Scene scene = new Scene(loginScene);// pane you are GOING TO show
		scene.getStylesheets().add(getClass().getResource("../view/application.css").toExternalForm());
		Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();// pane you are ON
		window.setScene(scene);
		window.show();
	}
	/**
	 * Takes user to new food scene.
	 * 
	 * @param event Enter new food button clicked
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */
	@FXML
	private void toFoodScene(ActionEvent event) throws IOException, ClassNotFoundException 
	{
		foodScene= FXMLLoader.load(getClass().getResource("../view/NewFood.fxml"));// pane you are GOING TO
		Scene scene = new Scene(foodScene);// pane you are GOING TO show
		scene.getStylesheets().add(getClass().getResource("../view/application.css").toExternalForm());
		Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();// pane you are ON
		window.setScene(scene);
		window.show();   
	}
	/**
	 * Takes user to update user page.
	 * 
	 * @param event Update user button clicked
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */
	@FXML
	private void toUpdateUser(ActionEvent event) throws ClassNotFoundException, IOException 
	{ 
		UpdateUser= FXMLLoader.load(getClass().getResource("../view/UpdateUser.fxml"));// pane you are GOING TO
		Scene scene = new Scene(UpdateUser);// pane you are GOING TO show
		scene.getStylesheets().add(getClass().getResource("../view/application.css").toExternalForm());
		Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();// pane you are ON
		window.setScene(scene);
		window.show();   
	}
	/**
	 * Loads user data into view.
	 * 
	 */
	@FXML
	private void initialize() throws ClassNotFoundException, IOException{
		UserData data = new UserData();
		User user = new User();
		user = data.getUser(LogInController.username);
		ObservableList<PieChart.Data> pieChartData = FXCollections.observableArrayList(
				new PieChart.Data("Carbs", (data.totalCarbs(data.todaysMeals(user))*4)),
				new PieChart.Data("Protein", (data.totalProtein(data.todaysMeals(user))*4)),
				new PieChart.Data("Fat", (data.totalFat(data.todaysMeals(user))*9)));

		userlabel.setText(user.getName());
		currentUser.setText(user.getUserName());
		currentWeight.setText(Integer.toString(user.getWeight())+"lbs");
		goalWeight.setText(Integer.toString(user.getGoalWeight())+"lbs");
		userHeight.setText(Integer.toString(user.getHeight())+"in");
		totalCalories.setText(Integer.toString(user.getCalorieGoal()));
		usedCalories.setText(Integer.toString(data.todaysCalories(data.todaysMeals(user))));
		leftCalories.setText(Integer.toString(user.getCalorieGoal()-data.todaysCalories(data.todaysMeals(user))));
		dailyView.setData(pieChartData);
		dailyView.setTitle("Daily Summary");
	}
}
