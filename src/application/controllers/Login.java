package application.controllers;

import application.models.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.DialogPane;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Login {

    @FXML
    private PasswordField passwordField;

    @FXML
    private CheckBox showCheckbox;

    @FXML
    private Button submitBtn;

    @FXML
    private TextField usernameField;

    @FXML
    private TextField visiblePasswordField;
    
    private User[] users;
    private User userTwo;
    
    @FXML
    public void initialize() {
    	users = new User[2];
    	users[0] = new User("Adnan", "Seneca");
    	users[1] = new User("Saad", "York");
    	
    	visiblePasswordField.textProperty().bind(passwordField.textProperty());
    }

    @FXML
    void login(ActionEvent event) {
    	if(checkUserCredentials(usernameField.getText(), passwordField.getText())) {
    		openAutoLoan();
    	}else {
    		usernameField.setText("");
    		passwordField.setText("");
    	}
    }

    @FXML
    void showPassword(ActionEvent event) {
    	if(showCheckbox.isSelected()) {
            visiblePasswordField.setVisible(true);
    	}else {
            visiblePasswordField.setVisible(false);
    	}
    }
    
    boolean checkUserCredentials(String username, String password) {
    	for(User a : users) {
    		if(a.getUserName().equals(username) && a.getPassword().equals(password)) {
    			return true;
    		}else if(a.getUserName().equals(username) && !(a.getPassword().equals(password))) {
    			showAlert("Invaid Password!");
    			return false;
    		}
    	}
    	showAlert("User does not exist!");
    	return false;
    }
    
    void showAlert(String message) {
    	Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Invalid User Credentials");
        alert.setHeaderText(null);
        alert.setContentText(message);
        
        DialogPane dialogPane = alert.getDialogPane();
        dialogPane.setStyle("-fx-font-size: 20px; -fx-padding: 20px;");
        
        alert.show();
    }
    
    void openAutoLoan() {
    	try { 
			BorderPane root = (BorderPane)FXMLLoader.load((getClass().getResource("/application/views/AutoLoan.fxml")));
			Scene scene = new Scene(root);
			Stage primaryStage = (Stage) submitBtn.getScene().getWindow();
			primaryStage.setScene(scene);
			primaryStage.setMaximized(true);
			primaryStage.setResizable(false);
			primaryStage.setTitle("Auto Loan App");
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
    }
}
