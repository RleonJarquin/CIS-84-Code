/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.util.Scanner;
import javax.swing.JFrame;

/**
 *
 * @author Ruben Leon
 */
public class FinalProject {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
            
        /*
            Objectives in Stages,
        1)	The program shall be able to allow the user to perform the following options:
            a.	Reserve a seat for an attendee
            b.	Update status of a seat reservation
            c.	Show attendance report
        2)	When reserving a seat for an attendee, the program shall obtain the name of the attendee and price paid for the event. The program then asks for the seat location for the attendee and reserves it for that person
            a.	Seat locations are identified by number ranging from 101 to 199
            b.	The program shall not allow reservations for multiple attendees to the same seat location
        3)	When updating the status of a seat reservation, the program shall obtain the seat location to update from the user and then allow the status to change to either be Reserved, Seated, or Available
        4)	For the attendance report, the program shall show the following information:

            a.	Show seat locations that are Reserved, Seated, or Available and show the total count of seats that in each of these statuses (i.e. show many seats are Reserved, Seated, and Available)
            b.	If a seat is either Reserved or Seated, the report should also show all the information about the attendee for that seat
            c.	At the end of the report, show a total of seat prices paid for all attendees 

        5)	Add other reporting options to the attendant report. Ideas include:
            a.	Show all attendants in order of highest price paid to lowest
            b.	Show all attendants by name in alphabetical order
            c.	Show a comparison of prices paid for seats the are Seated versus Reserved

        6)	User friendliness – the features and output should be clean and easy to use


        Technical Requirements:
            Your program must have a graphical user interface with text fields, buttons, etc.



            */
        
        
        seatReservation event1 = new seatReservation();
        event1.setDefault();
        //Part 1 Code No userInterface.
        
        finalProjectTextFrame center = new finalProjectTextFrame();
        center.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        center.pack();
        center.setSize(3000,1000);
        center.setLocation(0,0);
        center.setVisible(true);  
        center.setResizable(true);
        
        
        

        
        
        
        //Variables 


    }

}
