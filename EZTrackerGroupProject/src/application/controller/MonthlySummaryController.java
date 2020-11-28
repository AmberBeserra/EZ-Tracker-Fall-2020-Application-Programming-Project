package application.controller;

import java.io.IOException;

import application.model.NutritionInfo;
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
 * This class controls Monthly view.
 * 
 * @author yit031
 * @version 1.0
 * @since 2020-11-27
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
	private Label avgProtein;
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
		
		//loads pie chart with data
		ObservableList<PieChart.Data> pieChartData = FXCollections.observableArrayList(
				new PieChart.Data("Carbs", (NutritionInfo.totalCarbs(NutritionInfo.monthlyMeals(user))*4)),
				new PieChart.Data("Protein", (NutritionInfo.totalProtein(NutritionInfo.monthlyMeals(user))*4)),
				new PieChart.Data("Fat", (NutritionInfo.totalFat(NutritionInfo.monthlyMeals(user))*9)));
		
		//Statement below can be used to debug daily meals
		NutritionInfo.printMeals(NutritionInfo.monthlyMeals(user));
		
		//sets labels to described information
		currentUser.setText(user.getUserName());
		monthlyView.setData(pieChartData);
		monthlyView.setTitle("Monthly Summary");
		//If no meals have been added catches / by zero exceptions and sets text to 0
		try{
		avgCal.setText(Integer.toString(NutritionInfo.totalCalories(NutritionInfo.monthlyMeals(user))/NutritionInfo.monthlyMeals(user).size()));
		avgCarbs.setText(Integer.toString(NutritionInfo.totalCarbs(NutritionInfo.monthlyMeals(user))/NutritionInfo.monthlyMeals(user).size()));
		avgFat.setText(Integer.toString(NutritionInfo.totalFat(NutritionInfo.monthlyMeals(user))/NutritionInfo.monthlyMeals(user).size()));
		avgProtein.setText(Integer.toString(NutritionInfo.totalProtein(NutritionInfo.monthlyMeals(user))/NutritionInfo.monthlyMeals(user).size()));
		}
		catch (ArithmeticException e) {
			avgCal.setText("0");
			avgCarbs.setText("0");
			avgFat.setText("0");
			avgProtein.setText("0");
     }
	}		
}
