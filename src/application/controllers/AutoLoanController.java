package application.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;

public class AutoLoanController {

    @FXML
    private ChoiceBox<String> ageField;

    @FXML
    private Button calculateBtn;

    @FXML
    private TextField cityField;

    @FXML
    private Button clearBtn;

    @FXML
    private TextField downPayField;

    @FXML
    private RadioButton fourInterest;

    @FXML
    private ChoiceBox<String> frequencyField;

    @FXML
    private Slider monthsField;

    @FXML
    private TextField nameField;

    @FXML
    private RadioButton oneInterest;

    @FXML
    private TextField otherInterestField;

    @FXML
    private TextField phoneField;

    @FXML
    private TextField priceField;

    @FXML
    private ChoiceBox<String> provinceField;

    @FXML
    private Button saveBtn;

    @FXML
    private Button showSavedBtn;

    @FXML
    private RadioButton threeInterest;

    @FXML
    private RadioButton twoInterest;

    @FXML
    private ChoiceBox<String> typeField;
    
    @FXML
    void initialize() {
    	
    }

    @FXML
    void calculate(ActionEvent event) {

    }

    @FXML
    void clear(ActionEvent event) {

    }

    @FXML
    void save(ActionEvent event) {

    }

    @FXML
    void showSaved(ActionEvent event) {

    }

}
