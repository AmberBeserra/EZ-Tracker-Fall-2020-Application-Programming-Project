package application;
	
import java.io.IOException;

import application.model.UserData;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.fxml.FXMLLoader;


public class Main extends Application 
{
	@Override
	public void start(Stage primaryStage) 
	{
		try {
			AnchorPane root = (AnchorPane)FXMLLoader.load(getClass().getResource("view/LogIn.fxml"));
			Scene scene = new Scene(root,310,265);
			scene.getStylesheets().add(getClass().getResource("view/application.css").toExternalForm());
			primaryStage.setTitle("EZ Tracker");
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		} 
	}
	
	public static void main(String[] args) throws ClassNotFoundException, IOException
	{
		UserData data = new UserData();
		data.printExisting();
		launch(args);

	}
}
