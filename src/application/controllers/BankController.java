package application.controllers;

import application.models.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class BankController {

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
    
    @FXML
    public void initialize() {
    	User userOne = new User("Adnan", "12345");
    	User userTwo = new User("Saad", "YorkRegion");
    	
    	visiblePasswordField.textProperty().bind(passwordField.textProperty());
    }

    @FXML
    void login(ActionEvent event) {
    	
    }

    @FXML
    void showPassword(ActionEvent event) {
    	if(showCheckbox.isSelected()) {
            visiblePasswordField.setVisible(true);
            passwordField.setVisible(false);
    	}else {
            passwordField.setVisible(true);
            visiblePasswordField.setVisible(false);
    	}
    }
    
    void checkUserCredentials(String username, String password) {
    	
    }
    
    void showAlert() {
    	Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("ADNAN");
        alert.setHeaderText(null);
        alert.setContentText("BRO CODE");
        alert.showAndWait();
    }

}
