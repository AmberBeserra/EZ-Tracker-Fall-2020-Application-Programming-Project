package application.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import application.model.Meal;
import application.model.Food;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
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
	private TextField foodName;
	@FXML
	private TextField calories;
	@FXML
	private TextField carbs;
	@FXML
	private TextField fat;
	@FXML
	private TextField protein;
	@FXML
	private TextArea output;

	static ArrayList<Food> meal = new ArrayList<Food>();


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
	void completeMeal(ActionEvent event) throws IOException  //returns to main user page
	{

	}

	@FXML
	void addToMeal(ActionEvent event) throws IOException  //returns to main user page
	{
		String name = foodName.getText();
		String cal = calories.getText();
		String car = carbs.getText();
		String f = fat.getText();
		String pro = protein.getText();
		String out = "";
		
		if(validateInput(name,cal,car,f,pro)){
			Food currentItem = new Food(name,Integer.parseInt(cal),Integer.parseInt(car),Integer.parseInt(f),Integer.parseInt(pro));
			meal.add(currentItem);
			out = ("Name: " + name +"\n");
			out = ("Carbs: " + cal +"\n");
			output.setText(out);
		}
	}

	Boolean validateInput(String name, String calories,String carbs, String fat, String protein){
		int issueCode = 0;
		if(name.isEmpty()||calories.isEmpty()||carbs.isEmpty()||fat.isEmpty()||protein.isEmpty()){
			issueCode = 1;
		}
		else {
			if(isInt(calories)&&isInt(carbs)&&isInt(fat)&&isInt(protein)){
				if(Integer.parseInt(calories) < 0){
					issueCode = 2;
				}
				if(Integer.parseInt(carbs) < 0){
					issueCode = 2;
				}
				if(Integer.parseInt(fat) < 0){
					issueCode = 2;
				}
				if(Integer.parseInt(protein) < 0){
					issueCode = 2;
				}
			}
				else {
					issueCode = 3;
				}
			}
			switch(issueCode) {
			case 1:
				Alert emptyField = new Alert(AlertType.NONE);
				emptyField.setAlertType(AlertType.ERROR);
				emptyField.setTitle("ERROR");
				emptyField.setHeaderText("Unable to add food!");
				emptyField.setContentText("Please make sure every field has a value to add food");
				emptyField.show();
				return false;
			case 2:
				Alert valueError = new Alert(AlertType.NONE);
				valueError.setAlertType(AlertType.ERROR);
				valueError.setTitle("ERROR");
				valueError.setHeaderText("Unable to add food!");
				valueError.setContentText("Please make sure every field with a number has a value above zero!");
				valueError.show();
				return false;
			case 3:
				Alert notInt = new Alert(AlertType.NONE);
				notInt.setAlertType(AlertType.ERROR);
				notInt.setTitle("ERROR");
				notInt.setHeaderText("Unable to add food");
				notInt.setContentText("Please make sure every field requiring an integer(Calories,Carbs,Fat,Protein) has one!");
				notInt.show();
				return false;
			default:
				return true;
			}
		}
	Boolean isInt(String str){
		try 
		{ 
			// checking valid integer using parseInt() method 
			Integer.parseInt(str);
			return true;
		}  
		catch (NumberFormatException e)  
		{ 
			return false;
		} 
	}
}
