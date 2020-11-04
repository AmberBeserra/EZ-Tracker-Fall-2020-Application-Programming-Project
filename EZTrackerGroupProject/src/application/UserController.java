package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import application.NewUser;
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
    private AnchorPane mainPane;
	private AnchorPane newuserscene;
	private AnchorPane weekscene;
	
	@FXML
    private Label text;
	
    @FXML
    public void handle1(ActionEvent event) throws IOException //goes to main user page
    {
        mainPane = FXMLLoader.load(getClass().getResource("UserPage.fxml"));// pane you are GOING TO
        Scene scene = new Scene(mainPane);// pane you are GOING TO show
        scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();// pane you are ON
        window.setScene(scene);
        window.show();

    }
    
    @FXML
    public void newUser(ActionEvent event) throws IOException 
    {
    	newuserscene = FXMLLoader.load(getClass().getResource("NewUser.fxml"));// pane you are GOING TO
        Scene scene = new Scene(newuserscene);// pane you are GOING TO show
        scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();// pane you are ON
        window.setScene(scene);
        window.show();

    }

    @FXML
    public void weekSummary(ActionEvent event) throws IOException 
    {
    	weekscene = FXMLLoader.load(getClass().getResource("Weekly.fxml"));// pane you are GOING TO
        Scene scene = new Scene(weekscene);// pane you are GOING TO show
        scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();// pane you are ON
        window.setScene(scene);
        window.show();

    }

}
