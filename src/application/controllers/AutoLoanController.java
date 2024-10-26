package application.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;

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
    private TextField display;
    
    ToggleGroup interestGroup;
    
    @FXML
    void initialize() {
    	ageField.getItems().addAll("New", "Old");
    	ageField.setValue("Select Vehicle Age");
    	
    	frequencyField.getItems().addAll("Weekly", "Bi-Weekly", "Monthly");
    	frequencyField.setValue("Select Payment Frequency");
    	
        provinceField.getItems().addAll("Ontario", "Quebec", "Alberta",
        		"British Columbia", "Manitoba", "Saskatchewan", "Nova Scotia",
        		"New Brunswick", "Prince Edward Island", "Newfoundland and Labrador"
        );
        provinceField.setValue("Select Province");
        
        typeField.getItems().addAll("Car", "Truck", "Family Van");
        typeField.setValue("Select Vehicle Type");
        
        otherInterestField.setVisible(false);
        
        interestGroup = new ToggleGroup();
        
        oneInterest.setToggleGroup(interestGroup);
        twoInterest.setToggleGroup(interestGroup);
        threeInterest.setToggleGroup(interestGroup);
        fourInterest.setToggleGroup(interestGroup);
        
        interestGroup.selectedToggleProperty().addListener((obs, oldToggle, newToggle) -> {
            if (newToggle != null) {
                RadioButton selectedRadioButton = (RadioButton) interestGroup.getSelectedToggle();
                if(selectedRadioButton.getText().equals("Others")){
                	otherInterestField.setVisible(true);
                }else {
                	otherInterestField.setVisible(false);
                }
            }
        });
        
        display.setEditable(false);
    }

    @FXML
    void calculate(ActionEvent event) {
    }

    @FXML
    void clear(ActionEvent event) {
    	nameField.setText("");
    	phoneField.setText("");
    	cityField.setText("");
    	provinceField.setValue("Select Province");
    	typeField.setValue("Select Vehicle Type");
    	ageField.setValue("Select Vehicle Age");
    	priceField.setText("");
    	downPayField.setText("");
    	otherInterestField.setText("");
    	interestGroup.selectToggle(null);
    	monthsField.setValue(12);
    	frequencyField.setValue("Select Payment Frequency");
    	display.setText("");
    }

    @FXML
    void save(ActionEvent event) {

    }

    @FXML
    void showSaved(ActionEvent event) {

    }

}
