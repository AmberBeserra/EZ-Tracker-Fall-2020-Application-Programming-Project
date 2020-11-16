package application.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

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

public class WeekySummaryController
{
	@FXML
    private AnchorPane mainPane;
	private AnchorPane InvPane;
	
	@FXML
    private Label text;
	
    @FXML
    public void handle1(ActionEvent event) throws IOException //goes to main user page
    {
        mainPane = FXMLLoader.load(getClass().getResource("../view/UserPage.fxml"));// pane you are GOING TO
        Scene scene = new Scene(mainPane);// pane you are GOING TO show
        scene.getStylesheets().add(getClass().getResource("../view/application.css").toExternalForm());
        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();// pane you are ON
        window.setScene(scene);
        window.show();

    }
    


}
