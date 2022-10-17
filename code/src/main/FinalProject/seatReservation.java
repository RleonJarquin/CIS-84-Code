/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import javax.swing.JOptionPane;

/**
 *
 * @author Ruben Leon
 */

// Notify Ruben. Change ll the default string values to the attribute statuses.
// 5/19/2021 Update to ruben in line 73 you have a commen waiting for you.
public class seatReservation {
    // Variables
    // Temp Values
    private String tempSeatState;
    private int tempSeatNumber;
    private String tempSeatName;
    private double tempSeatPrice;
    private boolean seatOpen;

    // Storing Values
    private String[] seatStatusArray = new String[99];
    private int[] seatNumberArray = new int[99];
    private double[] seatPriceArray = new double[99];
    private String[] seatNameArray = new String[99];
    private double totalPrice = 0;
    // Sub values boolean Statis
    private String available = "Available";
    private String reserved = "Reserved";
    private String seated = "Seated";
    // Add in values
    private int[] alligner = new int[99];
    // private int [] index = new int[99]; // Might be uneccesary

    // Setters

    public void setDefault() {
        // Setting the alligner values

        for (int x = 0; x < 99; x++) {
            alligner[x] = 101 + x;
            seatNumberArray[x] = alligner[x];
            if (seatStatusArray[x] == null) {
                seatStatusArray[x] = available;
                seatNameArray[x] = "None";
                seatPriceArray[x] = 0.0;
                totalPrice = totalPrice + seatPriceArray[x];

            }

        }

        // Setting the default seats to be all "Open"

    }

    // Seat Setter

    // Addtional note the Input for state is 0 for Seated or 1 for reserved Might
    // change this to only be reserved and not seated/Reserved
    // Have to update set Seat because it is defaulting to Seated instead of
    // reserved
    public void setSeat(int seatNumber, String name, double Price) {
        // go from index position 0 to 97

        // Random thought. I should not reset the seatNumber value but is should use
        // another variable. Example Seat Index
        int index = 0;

        if (seatNumber > 199 || seatNumber < 101) {
            JOptionPane.showMessageDialog(null, "This seat does not exist please try again");
        } else {
            for (int x = 0; x < 99; x++) {
                if (seatNumber == alligner[x]) {
                    index = x;
                    break;
                }
            }
            // If the seat number state is "Seated" or it is "Reserved" then notify user
            // that they picked a wrong seat.
            if (seatStatusArray[index] == seated || seatStatusArray[index] == reserved) {
                JOptionPane.showMessageDialog(null, "This seat is unavailable please choose another");
            }

            else {
                seatNameArray[index] = name;
                seatPriceArray[index] = Price;
                // assert (state == 0 || state == 1); MIght be Redundant
                // If it is 0 then it
                totalPrice = totalPrice + seatPriceArray[index];
                seatStatusArray[index] = reserved;
            }
        }
    }

    // Getters

    // This function is useless all things considered
    public int getSeatNumber() {
        for (int x = 0; x < 99; x = x + 1)
            return 0; // Correct this value
        return 0;
    }

    public String getSeatState(int seatNumber) {
        if (seatNumber > 199 || seatNumber < 101) {
            JOptionPane.showMessageDialog(null, "Not a valid seat number please try again..");
            return null;
        } else {
            int index = 0;
            for (int x = 0; x < 99; x++) {
                if (seatNumber > 199 || seatNumber < 101) {
                    break;
                }
                if (seatNumber == alligner[x]) {
                    index = x;
                    break;
                }
            }
            return seatStatusArray[index];
        }

    }

    public double getSeatPrice(int seatNumber) {
        if (seatNumber > 199 || seatNumber < 101) {
            JOptionPane.showMessageDialog(null, "Not a valid seat number please try again..");
            return -1;
        } else {
            int index = 0;
            for (int x = 0; x < 99; x++) {
                if (seatNumber > 199 || seatNumber < 101) {
                    break;
                }
                if (seatNumber == alligner[x]) {
                    index = x;
                    break;
                }
            }
            return seatPriceArray[index];
        }

    }

    public String getSeatName(int seatNumber) {
        if (seatNumber > 199 || seatNumber < 101) {
            JOptionPane.showMessageDialog(null, "Not a valid seat number please try again..");
            return null;
        } else {
            int index = 0;
            for (int x = 0; x < 99; x++) {
                if (seatNumber > 199 || seatNumber < 101) {
                    break;
                }
                if (seatNumber == alligner[x]) {
                    index = x;
                    break;
                }
            }
            return seatNameArray[index];
        }

    }

    // Helper Functions

    // Printer Functions
    public String getAvailableSeats() {
        int seatCounter = 0;
        String output = "";
        for (int x = 0; x < 99; x++) {
            if (seatStatusArray[x] == available) {
                output = output + "The seat Number is: " + seatNumberArray[x] + "\n";
                seatCounter = seatCounter + 1;
            }

        }
        output = output + "The number of Available seats is: " + seatCounter;
        return output;
    }

    public String getReservedSeatedSeats() {
        int seatCounter = 0;
        String output = "";
        for (int x = 0; x < 99; x++) {
            if (seatStatusArray[x] == reserved || seatStatusArray[x] == seated) {
                output = output + "The seat Number is: " + seatNumberArray[x] + "\n";
                seatCounter = seatCounter + 1;

            }
        }
        output = output + "The number of Reserved/Seated seats is: " + seatCounter;
        return output;
    }

    public String getReservedSeats() {
        int seatCounter = 0;
        String output = "";
        for (int x = 0; x < 99; x++) {
            if (seatStatusArray[x] == reserved) {
                output = output + "The seat Number is: " + seatNumberArray[x] + "\n";
                seatCounter = seatCounter + 1;
            }
        }
        output = output + "The number of Reserved seats is: " + seatCounter;
        return output;
    }

    public String getSeatedSeats() {
        int seatCounter = 0;
        String output = "";
        for (int x = 0; x < 99; x++) {
            if (seatStatusArray[x] == seated) {
                output = output + "The seat Number is: " + seatNumberArray[x] + "\n";
                seatCounter = seatCounter + 1;

            }
        }
        output = output + "The number of Seated seats is: " + seatCounter;
        return output;
    }

    // Getter Functions with attribute---------------------------------
    public String getReservedSeatedSeats2() {
        int seatCounter = 0;
        String output = "";
        for (int x = 0; x < 99; x++) {
            if (seatStatusArray[x] == reserved || seatStatusArray[x] == seated) {
                output = output + "The seat Number is: " + seatNumberArray[x] + " The seat State is: "
                        + seatStatusArray[x] + " The name of the person is: " + seatNameArray[x]
                        + " The seat price paid for is: " + seatPriceArray[x] + "\n";
                seatCounter = seatCounter + 1;
            }
        }
        output = output + "The number of Reserved/Seated seats is: " + seatCounter;

        return output;
    }

    public String getReservedSeats2() {
        int seatCounter = 0;
        String output = "";
        for (int x = 0; x < 99; x++) {
            if (seatStatusArray[x] == reserved) {
                output = output + "The seat Number is: " + seatNumberArray[x] + " The seat State is: "
                        + seatStatusArray[x] + " The name of the person is: " + seatNameArray[x]
                        + " The seat price paid for is: " + seatPriceArray[x] + "\n";
                seatCounter = seatCounter + 1;

            }
        }
        output = output + "The number of Reserved seats is: " + seatCounter;
        return output;
    }

    public String getSeatedSeats2() {
        int seatCounter = 0;
        String output = "";
        for (int x = 0; x < 99; x++) {
            if (seatStatusArray[x] == seated) {
                output = output + "The seat Number is: " + seatNumberArray[x] + " The seat State is: "
                        + seatStatusArray[x] + " The name of the person is: " + seatNameArray[x]
                        + " The seat price paid for is: " + seatPriceArray[x] + "\n";
                seatCounter = seatCounter + 1;
            }
        }
        output = output + "The number of Seated seats is: " + seatCounter;
        return output;
    }

    public String getAllValues() {
        String output = "";
        for (int x = 0; x < 99; x++) {
            output = output + "The seat Number is: " + seatNumberArray[x] + " The seat State is: " + seatStatusArray[x]
                    + " The name of the person is: " + seatNameArray[x] + " The seat price paid for is: "
                    + seatPriceArray[x] + "\n";
        }
        output = output + "\n" + "The Total Price is: " + totalPrice;
        return output;
    }

    // Helper function to see if the seat is already taken or does not exist
    // Currently not being implemented
    public boolean isSeatOpen(int seatNumber) {
        int index = 0;
        if (seatNumber > 199 || seatNumber < 101) {
            return false;
        }
        for (int x = 0; x < 99; x++) {

            if (seatNumber == alligner[x]) {
                index = x;
                break;
            }
        }
        // If the seat number state is "Seated" or it is "Reserved" then notify user
        // that they picked a wrong seat.
        if (seatStatusArray[index] == seated || seatStatusArray[index] == reserved) {
            return false;
        } else {
            return true;
        }
    }

    // If there are there are reserved or seated seats then the the seats are able
    // to be updated/ (allows that status to be changed)
    public boolean isSeatsUpdateable() {
        boolean updateable = false;
        for (int x = 0; x < 99; x++) {
            if (seatStatusArray[x] == reserved || seatStatusArray[x] == seated) {
                updateable = true;
                return updateable;
            }

        }
        return updateable;
    }

    // Pick a number to see if the seat state update the seat 0 for Reserved. 1 for
    // Seated. 2 for Available
    // 2 inputs from the fcn 1 state (options 0/1/2)
    public void changeSeatStatus(int state, int seatNumber) {
        // If the seat number is greater tha 199 or is lower than 101 then execute this
        // code
        // if the seat number is not 0 and is not 1 and is not 2 then execute this code
        // Having problems with this relational statement
        if (seatNumber > 199 || seatNumber < 101) {
            JOptionPane.showMessageDialog(null, "Not a valid seat please try again.");
        } else {
            if (state != 0 && state != 1 && state != 2) {
                JOptionPane.showMessageDialog(null, "Invalid Command please try again..");
            } else {
                int index = 0;
                for (int x = 0; x < 99; x++) {
                    if (seatNumber == alligner[x]) {
                        index = x;
                        break;
                    }
                }
                // Option 0 for Seated, 1 for Reserved, 2 for Avaliable.
                if (state == 0) {
                    seatStatusArray[index] = seated;
                }
                if (state == 1) {
                    seatStatusArray[index] = reserved;

                }
                if (state == 2) // Should update names asweel
                {
                    seatStatusArray[index] = available;
                    seatNameArray[index] = "None";
                    totalPrice = totalPrice - seatPriceArray[index];
                    seatPriceArray[index] = 0;
                }
            }
        }

    }

}
