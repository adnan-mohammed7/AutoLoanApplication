package application.controllers;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

import application.models.LoanApplication;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Dialog;
import javafx.scene.control.DialogPane;
import javafx.scene.control.Labeled;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Slider;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.control.Label;

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
    
    @FXML
    private Label paymentDisplay;
    
    ToggleGroup interestGroup;
    
    List<TextField> customerFields;
    List<TextField> vehicleFields;
    List<String> emptyFields;
    List<ChoiceBox<String>> choices;
    List<LoanApplication> storedList;
    LoanApplication tempApplication;
    ListView<LoanApplication> loanListView;
    
    String mName, mCity, mProvince, mType, mAge, mFrequency; 
    int mMonths;
    long mPhone;
    double mPrice, mDown, mInterest;
    
    @FXML
    void initialize() {
    	customerFields = Arrays.asList(nameField, phoneField, cityField);
    	vehicleFields = Arrays.asList(priceField, downPayField);
    	choices = Arrays.asList(provinceField, typeField, ageField);
    	emptyFields = new ArrayList<String>();
    	storedList = new ArrayList<LoanApplication>();
    	
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
                	otherInterestField.setText("");
                }
            }
        });
        
        monthsField.valueProperty().addListener((obs, oldValue, newValue) -> {
            int months = newValue.intValue();
            paymentDisplay.setText("" + months);
            mMonths = months;
        });
        
        display.setEditable(false);
    }

    @FXML
    double calculate(ActionEvent event) {
    	double result = 0;
    	validateCustomerTextFields();
    	validateChoiceBoxes();
    	validateVehicleTextFields();
    	validateRadioButtonAndChoiceBox();
    	if(emptyFields.size() > 0) {
    		createAlert();
        	clearEmptyList();
    	}else {
    		if(validateCredentials()){
    			double price = Double.parseDouble(priceField.getText());
    	    	double downPayment = Double.parseDouble(downPayField.getText());
    	    	double loanPrice = price - downPayment;
    	    	double interest = 0;
    	    	int months = (int) monthsField.getValue();
    	    	String frequency = frequencyField.getValue();
    	    	
    	    	String selectedRadioButton = ((RadioButton) interestGroup.getSelectedToggle()).getText();
    	    	
    	    	if (selectedRadioButton.equals("Others")) {
    	    		interest = Double.parseDouble(otherInterestField.getText());
    	    	}else if (selectedRadioButton.equals("0.99%")){
    	    		interest = 0.99;
    	    	}else if (selectedRadioButton.equals("1.99%")){
    	    		interest = 1.99;
    	    	}else if (selectedRadioButton.equals("2.99%")){
    	    		interest = 2.99;
    	    	}
    	    	
    	    	double compoundInterest = (interest / 100) / 12;
    	    	double monthlyPay = (loanPrice * ((compoundInterest * Math.pow(1 + compoundInterest, months)) / 
    	                (Math.pow(1 + compoundInterest, months) - 1)));
    	    	DecimalFormat df = new DecimalFormat("#.00");
    	    	
    	    	if(frequency.equals("Weekly")) {
    	    		result = monthlyPay / 4;
    	    		display.setText("$" + df.format(result) + " Per Week");
    	    	}else if(frequency.equals("Bi-Weekly")) {
    	    		result = (monthlyPay * 12) / 26;
    	    		display.setText("$" + df.format(result) + " Per Bi-Week");
    	    	}else if(frequency.equals("Monthly")) {
    	    		result = monthlyPay;
    	    		display.setText("$" + df.format(result) + " Per Month");
    	    	}
    		}
    	}
    	return result;
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
    	paymentDisplay.setText("Payment Period");
    	display.setText("");
    	tempApplication = null;
    }

    @FXML
    void save(ActionEvent event) {
    	validateCustomerTextFields();
    	validateChoiceBoxes();
    	validateVehicleTextFields();
    	validateRadioButtonAndChoiceBox();
    	if(emptyFields.size() > 0) {
    		createAlert();
        	clearEmptyList();
    	}else {
    		if(validateCredentials()) {
    			if(tempApplication == null) {
    				setValues();
        			double calculatedPay = calculate(event);
        			storedList.add(new LoanApplication(mType, mAge, mPrice, mDown, mInterest, mMonths, mFrequency, calculatedPay, mName, mPhone, mCity, mProvince));
    			}else {
    				LoanApplication selected = loanListView.getSelectionModel().getSelectedItem();
    				loadSelectedApplication(selected, tempApplication);
    			}
    			clear(event);
    		}
    	}   	
    }

    @FXML
    void showSaved(ActionEvent event) {
    	loanListView = new ListView<>();
    	loanListView.setItems(FXCollections.observableArrayList(storedList));
    	
    	Dialog<Void> dialog = new Dialog<Void>();
    	dialog.setTitle("Select Loan Application");
    	
    	DialogPane dialogPane= dialog.getDialogPane(); 
    	dialogPane.setPrefSize(700, 700);
    	
    	VBox box = new VBox(loanListView);
    	box.setStyle("-fx-font-size: 45");
    	dialogPane.setContent(box);
    	dialogPane.getButtonTypes().addAll(ButtonType.OK);
    	Node bt = dialogPane.lookupButton(ButtonType.OK);
    	bt.setStyle("-fx-font-size: 45");
    	
    	loanListView.setOnMouseClicked(e -> {
    	    if (e.getButton() == MouseButton.PRIMARY && e.getClickCount() == 2 && loanListView.getSelectionModel().getSelectedItem() != null) {
    	    	loadSelectionDialogBox(loanListView.getSelectionModel().getSelectedItem(), dialog);
    	    }
    	});
    	dialog.show();
    }
    
    void loadSelectedApplication(LoanApplication selected, LoanApplication temp) {
    	//Binded
    	selected.setName(temp.getName());
    	selected.setCity(temp.getCity());
    	selected.setProvince(temp.getProvince());
    	selected.setType(temp.getType());
    	selected.setAge(temp.getAge());
    	selected.setFrequency(temp.getFrequency());
    	
    	//Non-Binded
    	setValues();
    	selected.setPhone(mPhone);
    	selected.setPrice(mPrice);
    	selected.setDownPay(mDown);
    	selected.setInterest(mInterest);
    	selected.setNumOfMonths(mMonths);
    	selected.setPay(calculate(null));
    }
    
    void loadSelectionDialogBox(LoanApplication loan, Dialog<Void> dialog) {
    	tempApplication = new LoanApplication(loan.getType(), loan.getAge(), loan.getPrice(),
    			loan.getDownPay(), loan.getInterest(), loan.getNumOfMonths(), loan.getFrequency(),
    			loan.getPay(), loan.getName(), loan.getPhone(), loan.getCity(), loan.getProvince());
    	    	
    	provinceField.setValue(tempApplication.getProvince());
    	typeField.setValue(tempApplication.getType());
    	ageField.setValue(tempApplication.getAge());
    	frequencyField.setValue(tempApplication.getFrequency());
    	
    	//Binded
    	nameField.textProperty().bindBidirectional((tempApplication.nameProperty()));
    	cityField.textProperty().bindBidirectional(tempApplication.cityProperty());
    	tempApplication.provinceProperty().bindBidirectional(provinceField.valueProperty());
    	tempApplication.typeProperty().bindBidirectional(typeField.valueProperty());
    	tempApplication.ageProperty().bindBidirectional(ageField.valueProperty());
    	tempApplication.frequencyProperty().bindBidirectional(frequencyField.valueProperty());
    	
    	
    	//Non-Binded
    	phoneField.setText(Long.toString(tempApplication.getPhone()));
    	priceField.setText(Double.toString(tempApplication.getPrice()));
    	downPayField.setText(Double.toString(tempApplication.getDownPay()));
    	if(tempApplication.getInterest() == 0.99) {
    		oneInterest.setSelected(true);
    	}else if(tempApplication.getInterest() == 1.99) {
    		twoInterest.setSelected(true);
    	}else if(tempApplication.getInterest() == 2.99) {
    		threeInterest.setSelected(true);
    	}else{
    		fourInterest.setSelected(true);
    		otherInterestField.setText(Double.toString(tempApplication.getInterest()));
    	}
    	monthsField.setValue(tempApplication.getNumOfMonths());
    	paymentDisplay.setText("" + tempApplication.getNumOfMonths());
    }
    
    private void validateCustomerTextFields() {
        for(TextField text : customerFields) {
        	if(text.getText().isEmpty()) {
        		emptyFields.add(text.getId());
        	}
        }
    }
    
    private void validateChoiceBoxes() {
        for(ChoiceBox<String> choice : choices) {
        	if(choice.getValue().equals("Select Province")) {
        		emptyFields.add(choice.getId());
        	}else if(choice.getValue().equals("Select Vehicle Type")) {
        		emptyFields.add(choice.getId());
        	}else if(choice.getValue().equals("Select Vehicle Age")) {
        		emptyFields.add(choice.getId());
        	}
        }
    }
    
    private void validateVehicleTextFields() {
        for(TextField text : vehicleFields) {
        	if(text.getText().isEmpty()) {
        		emptyFields.add(text.getId());
        	}
        }
    }
    
    private void validateRadioButtonAndChoiceBox() {
        if (interestGroup.getSelectedToggle() == null) {
            emptyFields.add("Interest Rate");
        }else if (((RadioButton)interestGroup.getSelectedToggle()).getText().equals("Others")) {
        	if(otherInterestField.getText().isEmpty()) {
        		emptyFields.add("Other Interest Rate");
        	}
        }
        
        if (frequencyField.getValue().equals("Select Payment Frequency"))
        	emptyFields.add("Payment Frequency");
    }
    
    void createAlert() {
    	String msg = "Please Enter the Following:";
    	
    	for(int i=0; i<emptyFields.size(); i++) {
    		msg += emptyFields.get(i);
    		if(i != emptyFields.size()-1) {
        		msg += ", ";
    		}
    	}
    	showAlert(msg);
    	createFocus();
    }
    
    void showAlert(String message) {
    	Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Information");
        alert.setHeaderText(null);

        TextArea textArea = new TextArea(message);
        textArea.setWrapText(true);
        textArea.setEditable(false);
        textArea.setPrefSize(400, 200);
        textArea.setMaxWidth(400);
        textArea.setMaxHeight(200);
        
        Pane pane = new Pane(textArea);
        pane.setPrefSize(400, 300);
        pane.setMaxWidth(400);
        
        
        DialogPane dialogPane = alert.getDialogPane();
        dialogPane.setStyle("-fx-font-size: 25px; -fx-padding: 20px;");
        dialogPane.setContent(pane);
        dialogPane.setPrefSize(500, 350);
        dialogPane.setMaxHeight(350);
        dialogPane.setMaxWidth(500);
        
        alert.show();
    }
    
    boolean createFocus() {
    	validateCustomerTextFields();
    	validateChoiceBoxes();
    	validateVehicleTextFields();
    	validateRadioButtonAndChoiceBox();
    	
    	String first = emptyFields.get(0);
    	
    	for(TextField each : customerFields) {
    		if(each.getId().equals(first)) {
    			each.requestFocus();
    			return true;
    		}
    			
    	}
    	for(ChoiceBox<String> each : choices) {
    		if(each.getId().equals(first)) {
    			each.requestFocus();
    			return true;
    		}
    			
    	}
    	for(TextField each : vehicleFields) {
    		if(each.getId().equals(first)) {
    			each.requestFocus();
    			return true;
    		}	
    	}
    	
    	if (first.equals("Interest Rate")) {
            oneInterest.requestFocus();
            return true;
        }else if (first.equals("Other Interest Rate")) {
        	otherInterestField.requestFocus();
        	return true;
        }else if (first.equals("Payment Frequency")) {
        	frequencyField.requestFocus();
        	return true;
        }
        	
    	
    	return false;
    }
    
    private boolean validateCredentials() {
        if (!validatePhoneNumber(phoneField.getText())) {
            showAlert("Invalid Phone Number, Phone number must be exactly 10 digits.");
            phoneField.requestFocus();
            return false;
        }

        if (!validateDouble(priceField.getText())) {
            showAlert("Invalid Price, Price must be a positive number.");
            priceField.requestFocus();
            return false;
        }

        if (!validateDouble(downPayField.getText())) {
            showAlert("Invalid Downpayment, Downpayment must be a positive number.");
            downPayField.requestFocus();
            return false;
        }

        if(((RadioButton)interestGroup.getSelectedToggle()).getText().equals("Others")) {
        	if (!validateDouble(otherInterestField.getText())) {
                showAlert("Invalid Interest Rate, Interest rate must be a positive number.");
                otherInterestField.requestFocus();
                return false;
            } else {
            	double rate = Double.parseDouble(otherInterestField.getText());
            	if (rate > 30.00) {
            		showAlert("Invalid Interest Rate, Interest rate must be less than or equal to 30.0");
                    otherInterestField.requestFocus();
                    return false;
            	}
            }
        }
        return true; 
    }
    
    private boolean validatePhoneNumber(String phone) {
    	try {
            long value = Long.parseLong(phone);
            return value > 1000000000 && value < 9999999999L;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private boolean validateDouble(String input) {
        try {
            double value = Double.parseDouble(input);
            return value > 0;
        } catch (NumberFormatException e) {
            return false;
        }
    }
    
    void setValues() {
    	mName = nameField.getText();
    	mPhone = Long.parseLong(phoneField.getText());
    	mCity = cityField.getText();
    	mProvince = provinceField.getValue();
    	mType = typeField.getValue();
    	mAge = ageField.getValue();
    	mPrice = Double.parseDouble(priceField.getText());
    	mDown = Double.parseDouble(downPayField.getText());
    	
    	String selectedRadioButton = ((RadioButton) interestGroup.getSelectedToggle()).getText();
    	
    	if (selectedRadioButton.equals("Others")) {
    		mInterest = Double.parseDouble(otherInterestField.getText());
    	}else if (selectedRadioButton.equals("0.99%")){
    		mInterest = 0.99;
    	}else if (selectedRadioButton.equals("1.99%")){
    		mInterest = 1.99;
    	}else if (selectedRadioButton.equals("2.99%")){
    		mInterest = 2.99;
    	}
    	
    	mFrequency = frequencyField.getValue();
}

    
    private void clearEmptyList() {
    	emptyFields.clear();
    }
}
