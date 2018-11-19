/**
 * This class creates the alert window, sets its title and the 
 * message to the user 
 */
package jCalculator.view;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;


public class JAlerts {
	
	private Alert alert = new Alert (AlertType.ERROR) ; 
	
	/**
	 * Method sets the alert window's title and its context
	 * @param type determines what is displayed as the alert window's title
	 */
	public void showAlert(String type)
	{
		alert.setTitle("Error: " + type);
		alert.setContentText("There's something wrong with your"
				+ " input. Please correct.");
		alert.showAndWait() ; 
	}
}
