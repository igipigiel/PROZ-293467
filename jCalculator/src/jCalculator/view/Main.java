/**
 * Class Main contains the main method and overrides the start method from
 * the class Application. It creates the window for the calculator 
 * application, sets the title and the appearance set with Scene builder.
 */
package jCalculator.view;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class Main extends Application{
	
	/**
	 * The start method opens the window, sets its title and appearance. 
	 * @param primaryStage the stage to open the window
	 * @exception e 
	 */
	@Override
		public void start(Stage primaryStage) {
			try {
				Parent root = FXMLLoader.load(getClass().getResource("/jCalculator/view/Calc.fxml"));
				Scene scene = new Scene(root);
				primaryStage.setScene(scene);
				primaryStage.setTitle("Calculator");
				primaryStage.show();

			} catch (Exception e) {
				e.printStackTrace();
			}
	}
/**
 * The main method is the first one run in the application
 * @param args standard arguments 
 */
public static void main(String[] args) {
		
		launch(args);
		
	}
}
