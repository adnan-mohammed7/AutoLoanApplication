/**********************************************
Workshop #3
Course:APD 545 - Semester 5
Last Name: Mohammed
First Name: Adnan
ID: 174731216
Section: ZAA
This assignment represents my own work in accordance with Seneca Academic Policy.
Signature
Date: 28th October 2024
**********************************************/

package application;
	
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.fxml.FXMLLoader;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			BorderPane root = (BorderPane)FXMLLoader.load(getClass().getResource("views/login.fxml"));
			Scene scene = new Scene(root,600,600);
			primaryStage.setTitle("Login");
			primaryStage.setScene(scene);
			primaryStage.setResizable(false);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
