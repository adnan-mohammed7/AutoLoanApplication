package application.controllers;

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
    void login(ActionEvent event) {
    	Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("ADNAN");
        alert.setHeaderText(null);
        alert.setContentText("BRO CODE");
        alert.showAndWait();
    }

    @FXML
    void showPassword(ActionEvent event) {
    	if(showCheckbox.isSelected()) {
    		// Show the password in the visible text field
            visiblePasswordField.setText(passwordField.getText());
            visiblePasswordField.setVisible(true);
            passwordField.setVisible(false);
    	}else {
    		// Switch back to the password field
            passwordField.setText(visiblePasswordField.getText());
            passwordField.setVisible(true);
            visiblePasswordField.setVisible(false);
    	}
    }

}
