/**
 * The jController class is the link between the model and the view.
 * It controls the buttons, labels etc 
 */

package jCalculator.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.event.ActionEvent;
import javafx.scene.control.TextField;
import java.util.*;
import jCalculator.model.jModel ; 
import jCalculator.view.JAlerts ; 



public class jController {


    @FXML
    private Button buttonSubmit;

    @FXML
    private Button buttonMultiply;

    @FXML
    private Button buttonDivide;

    @FXML
    private Button buttonSqrt;
    
    @FXML
    private Button buttonSinus;
    
    @FXML
    private Button buttonCancel;

    @FXML
    private Button buttonPower;

    @FXML
    private Button buttonAdd;

    @FXML
    private Button buttonDistract;
    
    @FXML
    private TextField textField;
   
    private List<Button> actionButtons = new ArrayList<>() ; 
    private String input = new String() ; 
    private String tempInput = new String() ; 
    private String result ; 
    
    
    /**
     * The function listInit adds the buttons that are not numbers
     * to the list actionButtons
     */
    void listInit()
    {
    	actionButtons.add(buttonAdd) ; 
    	actionButtons.add(buttonCancel) ; 
    	actionButtons.add(buttonDistract) ; 
    	actionButtons.add(buttonDivide) ; 
    	actionButtons.add(buttonMultiply) ; 
    	actionButtons.add(buttonPower) ; 
    	actionButtons.add(buttonSqrt) ; 
    	actionButtons.add(buttonSubmit) ; 
    	actionButtons.add(buttonSinus) ; 
    }
    
    /**
     * This method adds appropriate characters to the input, 
     * which indicates what is there to calculate. It also determines 
     * whether the user is starting a new action or changed their mind
     * about the action for the calculator to perform. It displays 
     * the current input on the text field. 
     * @param event 
     */
    @FXML
    void buttonClicked(ActionEvent event) {
    	listInit() ; 
    	Button click  = (Button) event.getSource() ; 
    	if (input == result && !actionButtons.contains(click))
    	{
    		input = "" ; 
    	}
    	if ( input.isEmpty() && (actionButtons.contains(click) && click.getText() == ".") ) return ; 
    	if (input.length() > 1  ) 
    		{
    		tempInput = input.substring(0, input.length()-1) ; 
    		if (Character.isDigit(input.charAt(input.length() - 1)) == false && 
    				actionButtons.contains(click)) input = tempInput ;  
    		}
    	
    	input = input + click.getText() ; 
    	textField.setText(input);

    }

    /**
     * This method is run by the cancel button, clears the input, result
     * and the text field. 
     * @param event
     */
    @FXML
    void cancelClicked(ActionEvent event) {
    	textField.clear();
    	result = "" ; 
    	input = "" ; 
    }

    /**
     * This method is activated by the sinus button
     * @param event
     */
    @FXML
    void sinusClicked(ActionEvent event) {
    	input = "sin(" + input +")" ; 
    	textField.setText(input) ;
    }
    
    /**
     * This method is activated by the power button
     * @param event
     */
    @FXML
    void powerClicked(ActionEvent event) {
    	input = "power(" + input +")" ; 
    	textField.setText(input) ; 
    }

    /**
     * This method is activated by the sqrt button
     * @param event
     */
    @FXML
    void sqrtClicked(ActionEvent event) {
    	input = "sqrt(" + input + ")" ; 
    	textField.setText(input);
    }
    
    /**
     * This method is activated by the submitButton.
     * It converts all integer numbers to double, and makes the Model
     * calculate. If the result is invalid it causes the display of 
     * an alert window and clears the input, result and the text field.
     * Otherwise it displays the result. 
     * @param event
     */
    @FXML
    void submitClicked(ActionEvent event)  {
    	funnyConversion() ; 
    	try {
    	result = jModel.calculate(input) ; 
    	}
    	catch (Exception e ) {
    		JAlerts alert = new JAlerts() ; 
    		alert.showAlert(e.getMessage());
    		textField.clear();
        	result = "" ; 
        	input = "" ; 
        	return ; 
    	}
    	textField.setText(result);
    	input = result ; 

    }
    /**
     * This method converts all the integer numbers to double, by 
     * adding ".0" to the input in the right places. 
     */
    void funnyConversion(){
    	boolean foundDot  = false ; 
    	for (int i = 1 ; i < input.length() - 1 ; i++) 
    	{
    		if (input.charAt(i) == '.') 
    		{
    			foundDot = true ; 
    			continue ; 
    		}
    		if ( Character.isDigit(input.charAt(i-1)) && !Character.isDigit(input.charAt(i)))
    		{
    			if ( foundDot == true) 
    			{
    				foundDot = false ; 
    				continue ; 
    			} 
    			input = input.substring(0, i) + ".0" + input.substring(i) ; 
    			i = i+2 ; 
    		}
    	}	
    }

}


