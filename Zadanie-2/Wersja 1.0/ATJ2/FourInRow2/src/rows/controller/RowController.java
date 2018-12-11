package rows.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent ; 
import javafx.event.ActionEvent;
import javafx.scene.control.TextField;
import java.util.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle ;
import javafx.scene.shape.CubicCurveTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.collections.*;
import javafx.scene.Node;
import javafx.animation.Animation ;
import javafx.animation.Timeline ; 
import javafx.animation.PathTransition ; 
import javafx.util.Duration ;
import rows.model.RowModel ; 
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javax.jms.JMSConsumer ;

import com.sun.messaging.jms.JMSException;

import rows.messages.*;


public class RowController {


	    @FXML private GridPane grid;
	    @FXML private Circle circle01;
	    @FXML private Circle circle11;
	    @FXML private Circle circle02;
	    @FXML private Circle circle12;
	    @FXML private Circle circle21;

	    @FXML
	    private Circle circle22;

	    @FXML
	    private Circle circle03;

	    @FXML
	    private Circle circle13;

	    @FXML
	    private Circle circle23;

	    @FXML
	    private Circle circle04;

	    @FXML
	    private Circle circle14;

	    @FXML
	    private Circle circle24;

	    @FXML
	    private Circle circle05;

	    @FXML
	    private Circle circle15;

	    @FXML
	    private Circle circle25;

	    @FXML
	    private Circle circle06;

	    @FXML
	    private Circle circle16;

	    @FXML
	    private Circle circle26;

	    @FXML
	    private Circle circle31;

	    @FXML
	    private Circle circle41;

	    @FXML
	    private Circle circle51;

	    @FXML
	    private Circle circle61;

	    @FXML
	    private Circle circle32;

	    @FXML
	    private Circle circle42;

	    @FXML
	    private Circle circle52;

	    @FXML
	    private Circle circle62;

	    @FXML
	    private Circle circle33;

	    @FXML
	    private Circle circle43;

	    @FXML
	    private Circle circle53;

	    @FXML
	    private Circle circle63;

	    @FXML
	    private Circle circle34;

	    @FXML
	    private Circle circle44;

	    @FXML
	    private Circle circle54;

	    @FXML
	    private Circle circle64;

	    @FXML
	    private Circle circle35;

	    @FXML
	    private Circle circle45;

	    @FXML
	    private Circle circle55;

	    @FXML
	    private Circle circle65;

	    @FXML
	    private Circle circle36;

	    @FXML
	    private Circle circle46;

	    @FXML
	    private Circle circle56;

	    @FXML
	    private Circle circle66;

	    @FXML
	    private Circle choiceCircle0;

	    @FXML
	    private Circle choiceCircle1;

	    @FXML
	    private Circle choiceCircle2;

	    @FXML
	    private Circle choiceCircle3;

	    @FXML
	    private Circle choiceCircle4;

	    @FXML
	    private Circle choiceCircle5;

	    @FXML
	    private Circle choiceCircle6;

	    List<Circle> choiceCircles = new ArrayList<>() ;
	    int [] takenSpaces = {0,0,0,0,0,0,0} ;  
	   
	     public void choiceClick(MouseEvent event) {
	    	 Producer sender  = null ; 
	    	 try {
		    		Producer producer = new Producer("8009","ATJQueue")  ;
		    		sender = producer ; 
		    		
		    	}
		    	catch (javax.jms.JMSException e) {
		    		e.printStackTrace();
		    	}
	    	 finally {
    		try {
    			fillSpace(event, sender) ; 
    		}
    		catch (Exception e)
    		{
    			System.out.println("Na-ah") ; 
    			return ; 
    		} 

	    	 }
    	}

	     public void fillSpace(MouseEvent event, Producer sender) throws Exception
	     {
	    	 Circle [] spaces = {circle01,circle02,circle03,circle04,circle05,circle06,
  	    		circle11,circle12,circle13,circle14,circle15,circle16,
  	    		circle21, circle22, circle23, circle24, circle25, circle26, 
  	    		circle31 , circle32, circle33, circle34, circle35, circle36, 
  	    		circle41, circle42, circle43, circle44, circle45, circle46, 
  	    		circle51, circle52, circle53, circle54, circle55, circle56, 
  	    		circle61, circle62, circle63, circle64, circle65, circle66} ; 
	    	
	    	 double x = event.getSceneX() ;
	    	 int column = RowModel.findColumn(x) ; 
	    	 int row = RowModel.findRow(column, takenSpaces[column]) ; 
	    	 spaces[6*column + row - 1].setFill(Color.BLUEVIOLET);
	    	 takenSpaces[column]++ ; 
	    	 if (sender != null) {
	    	 sender.sendQueueMessage(Integer.toString(column) + Integer.toString(row));
	    	 opponentMove(sender,spaces) ;
	    	 
	    	 }

	     }
	     public void opponentMove(Producer producer, Circle [] spaces)
	     {
	    	 String message  = null ; 
	    	 Consumer receiver = null ; 
	    	 try {
	    		 Consumer consumer = new Consumer ("8009", "ATJQueue") ; 
	    		 receiver = consumer ; 
	    		 receiver.setMessageListener(new AsynchConsumer());
	    		 message = receiver.receiveQueueMessage() ;
	    	 }  catch (javax.jms.JMSException e) {
				
				e.printStackTrace();
			}
	    	if (message != null) {
	    		int column = Integer.decode(message.substring(0, 0)) ; 
	    		int row = Integer.decode(Character.toString(message.charAt(1))) ; 
	    		spaces[6*column + row - 1].setFill(Color.LIME);
		    	takenSpaces[column]++ ; 
	    	}
	     }
	     
}