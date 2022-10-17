/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



//Box Layout Imports
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;


import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//import javafx.scene.control.ScrollBar;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;


/**
 *
 * @author Ruben Leon
 */
public class finalProjectTextFrame extends JFrame implements ActionListener {
    
    //Attributes
    private JPanel westPanel,centerPanel,topPanel,southPanel,eastPanel ; //,eastTopPanel
    private BoxLayout buttonLayout;
    private JButton enterButton,removeButton,changeSeatButton,viewAllAvailableSeats,viewAllSeats,viewReservedSeats,viewSeatedSeats,viewReservedSeated;
    private BorderLayout layout;
    private JLabel titleBar,nameLabel,seatNumberLabel,priceLabel,removeLabel,changeSeatedL,reportLabel;
    private JTextField tfName,tfSeat,tfPrice,tfRemove,tfSeated;
    private JTextArea centerSeatText;
    
    //Menu
    private MenuBar mainMenu;
    private Menu options;
    private MenuItem home,report,edit;
    private JScrollPane centerTextScroll;
    
    
    private seatReservation event2;
    
    
    
    finalProjectTextFrame () {
        
        super ("Reservation Program");
        
        setResizable(false);
        //Defining the seatClass logic
        event2 = new seatReservation();
        event2.setDefault();
        
        //Defining the Layout of Main Frame
        layout = new BorderLayout();
        
        //Creating the components for sub Panels
        
        //WestPanel Components
            //titleBar = new JLabel("Reserve a seat");
        tfName = new JTextField(5);        
        nameLabel = new JLabel("Enter Name");
        tfSeat = new JTextField(5);
        seatNumberLabel = new JLabel("Enter seat Number");
        tfPrice = new JTextField(5);
        priceLabel = new JLabel("Enter a Payment");
        enterButton = new JButton("Enter");
        
        //CenterPanel Components
        centerSeatText = new JTextArea(50,100);
        centerTextScroll = new JScrollPane(centerSeatText,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        
        //SouthPanel Components
        removeButton = new JButton("Enter");
        changeSeatButton = new JButton("Enter");
        removeLabel = new JLabel("Remove Seat(Type valid seat #)");
        changeSeatedL = new JLabel("Change seat to Seated (Type valid seat#)");
        tfRemove = new JTextField(5);
        tfSeated = new JTextField(5);
        
        //EastPanel Components
        reportLabel = new JLabel ("Report Functions");
        viewAllAvailableSeats = new JButton("View all Available Seats");
        viewAllSeats = new JButton("View all Seats");
        viewReservedSeats = new JButton("View all Reserved Seats");
        viewSeatedSeats = new JButton("View all Seated seats");
        viewReservedSeated = new JButton("View Reserved and Seated Seats");
        
        
        
        
        // Create Menu for Main Frame
        /*
        home = new MenuItem("Home");
        report = new MenuItem("Report");
        edit = new MenuItem("Edit");
        
        mainMenu = new MenuBar();
        options = new Menu("Options");
        this.setMenuBar(mainMenu);
        options.add(home);
        options.add(report);
        options.add(edit);
        
        mainMenu.add(options);
        */
        
        
        //Creating the sub Panel 
        westPanel = new JPanel();
        centerPanel = new JPanel();
        topPanel = new JPanel();
        eastPanel = new JPanel();
        southPanel = new JPanel();
        

        
        //Defining Sub panels
        westPanel.setLayout(new BoxLayout(westPanel,BoxLayout.PAGE_AXIS));
        eastPanel.setLayout(new BoxLayout(eastPanel,BoxLayout.PAGE_AXIS));
        centerPanel.setLayout(new FlowLayout()); 
        southPanel.setLayout(new FlowLayout());
        
        
        //Adding the components to the Sub Panels
        
        //East
        eastPanel.add(reportLabel);
        eastPanel.add(viewAllAvailableSeats);
        eastPanel.add(viewAllSeats);
        eastPanel.add(viewReservedSeats);
        eastPanel.add(viewSeatedSeats);
        eastPanel.add(viewReservedSeated);
        
        //West
        westPanel.add(nameLabel);
        westPanel.add(tfName);
        westPanel.add(seatNumberLabel);
        westPanel.add(tfSeat);
        westPanel.add(priceLabel);      
        westPanel.add(tfPrice);
        westPanel.add(enterButton);
        
        
        
        //Center
        centerPanel.add(centerTextScroll);
        centerSeatText.setText("Reservation Program");
        centerSeatText.setEditable(false);
        
        
        //South
        southPanel.add(removeLabel);
        southPanel.add(tfRemove);
        southPanel.add(removeButton);
        southPanel.add(changeSeatedL);
        southPanel.add(tfSeated);
        southPanel.add(changeSeatButton);
        
        
        //Setting the Layout of the entire frame
        this.setLayout(layout);
        
        add(westPanel,BorderLayout.WEST);
        add(centerPanel,BorderLayout.CENTER);
        add(southPanel,BorderLayout.SOUTH);
        add(eastPanel,BorderLayout.EAST);
        
        
        //ActionListeners
        //East 
        viewAllAvailableSeats.addActionListener(this);
        viewAllSeats.addActionListener(this);
        viewReservedSeats.addActionListener(this);
        viewSeatedSeats.addActionListener(this);
        viewReservedSeated.addActionListener(this);

        
        //West
        enterButton.addActionListener(this);

        

        
        
        //South
        removeButton.addActionListener(this);
        changeSeatButton.addActionListener(this);
        
        
        //
        
        
        
    }
    //Event Handlers
    public void actionPerformed(ActionEvent event)
    {
        //West
        if (event.getSource() == enterButton)
        {
            centerSeatText.setText("");
            int seatChoice = Integer.parseInt(tfSeat.getText());
            String nameChoice = tfName.getText();
            double payChoice = Double.parseDouble(tfPrice.getText());
            if (event2.isSeatOpen(seatChoice) == true)
            {
                event2.setSeat(seatChoice,nameChoice,payChoice);
            }   
            else
            {
                JOptionPane.showMessageDialog(null,"This seat does not exist please try again");

            }
        } 
        
        //East
        if (event.getSource() == viewAllAvailableSeats)
        {
            centerSeatText.setText("");
            centerSeatText.setText(event2.getAvailableSeats());
            
        }
        
        if (event.getSource() == viewAllSeats)
        {
            centerSeatText.setText("");
            centerSeatText.setText(event2.getAllValues());
            
        }
        
        if (event.getSource() == viewReservedSeats)
        {
            centerSeatText.setText("");
            if (event2.isSeatsUpdateable() == false)
            {
                centerSeatText.setText("There are no Reserved Seats please reserve a seat and update it."); 
                   
            }
            else
            {
                centerSeatText.setText("");
                centerSeatText.setText(event2.getReservedSeats2());
            }
            
        }
        
        if (event.getSource() == viewSeatedSeats)
        {
            centerSeatText.setText("");
            if (event2.isSeatsUpdateable() == false)
            {
                centerSeatText.setText("There are no Seated Seats please reserve a seat and update it."); 
                   
            }
            else
            {
                centerSeatText.setText(event2.getSeatedSeats2());                
            }

            
        }
        
        if (event.getSource() == viewReservedSeated)
        {
            centerSeatText.setText("");
            if (event2.isSeatsUpdateable() == false)
            {
                centerSeatText.setText("There are no Reserved" + "/n"  + "Seated"+" Seats please reserve a seat and update it."); 
                   
            }
            else
            {
                centerSeatText.setText("");
                centerSeatText.setText(event2.getReservedSeatedSeats2());    
            }
               
        }
        
        //South
        
        if (event.getSource() == removeButton)
        {
            int removeChoice = Integer.parseInt(tfRemove.getText());
            String nameChoice = tfName.getText();
            double payChoice = Double.parseDouble(tfPrice.getText());
            if(event2.isSeatOpen(removeChoice) != false)
            {
                JOptionPane.showMessageDialog(null,"Not a valid seat please try again.");
            }
            else
            {
                event2.changeSeatStatus(2, removeChoice);
            }
            
        }
        if (event.getSource() == changeSeatButton)
        {
            int seatedChoice = Integer.parseInt(tfSeated.getText());
            
            if(event2.isSeatOpen(seatedChoice) != false)
            {
                JOptionPane.showMessageDialog(null,"Not a valid seat please try again.");
            }
            else
            {
                event2.changeSeatStatus(0, seatedChoice);
            }
            
        }
     
        
    }

}
    
    

