/**
 * @author Iga Pawlak
 * The jCalculator project created for the PROZ subject.
 * @version 1.0
 * @since 2018-10-20
 */
module jCalculator {
	
	requires transitive javafx.controls ; 
	requires transitive javafx.graphics ; 
	requires javafx.base ;
	requires javafx.fxml ;
	requires jdk.jshell; 
	
	exports jCalculator.view ; 
	exports jCalculator.controller;
	
	opens jCalculator.controller to javafx.fxml ; 
	
}