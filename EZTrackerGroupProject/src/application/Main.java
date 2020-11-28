package application;
	
import java.io.IOException;

import application.model.UserData;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.fxml.FXMLLoader;


/**
 * Begins program.
 * 
 * @author yit031
 * @version 1.0
 * @since 2020-11-27
 */
public class Main extends Application 
{
	/* (non-Javadoc)
	 * @see javafx.application.Application#start(javafx.stage.Stage)
	 */
	@Override
	public void start(Stage primaryStage) 
	{
		try {
			AnchorPane root = (AnchorPane)FXMLLoader.load(getClass().getResource("view/LogIn.fxml"));
			Scene scene = new Scene(root,305,245);
			scene.getStylesheets().add(getClass().getResource("view/application.css").toExternalForm());
			primaryStage.setTitle("EZ Tracker");
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		} 
	}
	
	/** 
	 * Starts program and launches first view.
	 * 
	 * @param args
	 * @throws ClassNotFoundException
	 * @throws IOException
	 */
	public static void main(String[] args) throws ClassNotFoundException, IOException
	{
		//UserData data = new UserData();
		//data.printExisting();
		launch(args);

	}
}
 