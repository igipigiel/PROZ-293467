/**
 * The clas jModel is the one proceeding the calculations using JShell
 */
package jCalculator.model;

import jdk.jshell.JShell;
import jdk.jshell.SnippetEvent;
import java.util.*;
import java.lang.Exception ; 


public class jModel {
	
	static JShell jshell = JShell.create() ; 
	private static String result ; 
	
	/**
	 * This methods defines the additional operations, 
	 * other than the basic ones, such as adding. Then it calculates
	 * what is stated in the input and returns the result.
	 * @param input the String defining operations to calculate
	 * @return result result of the calculations
	 * @throws Exception when the input is wrong
	 */
	static public String calculate (String input) throws Exception 
	{
		jshell.eval("private double power(double x) {return Math.pow(x, 2.0) ; }") ;
		jshell.eval("private double sqrt(double x) {return Math.sqrt(x);}") ; 
		jshell.eval("private double sin(double x) {return Math.sin(x) ; }") ;
		
		List<SnippetEvent> events = jshell.eval(input) ; 
		for (SnippetEvent e : events)
		{
			
			result = e.value() ; 
		}	
		if (result == null ) throw new Exception("Wrong input.") ; 
		return result ; 
		
	}
}
