import java.text.DecimalFormat;
import javax.swing.JOptionPane;
/**
 * The SimpleCar class outlines the basic functionalities of the project.
 *
 * @author Kyle Jacobson
 * @version 1.0
 */
public class SimpleCar
{     
    /** model of the car */
    private String carModel;

    /** numbers of miles on odometer */
    private int numMiles;

    /** mileage for the next oil change */
    private int mileage;

    /** amount of gas within the tank */
    private double gasAmount;

    /** miles per gallon for the car */
    private double milesPerGallon = 24.6;

    /** miles between oil changes */
    private final int MILE_LIMIT = 5000;

    /** max capacity of gas within tank */
    private final double TANK_CAPACITY = 12.0;

    /***********************************************************
     * Default Constructor
     ***********************************************************/
    public SimpleCar()
    {
        milesPerGallon = 22.7;
        carModel = "Generic Car";
        gasAmount = TANK_CAPACITY;
        numMiles = 0;
        mileage = MILE_LIMIT;
    }

    /***********************************************************
     * Constructor that is used to assign instance variables
     * @param String - model of the car
     * @param double - value of miles per gallon
     ***********************************************************/
    public SimpleCar(String model, double mpg)
    {
        milesPerGallon = mpg;
        carModel = model;
        gasAmount = TANK_CAPACITY;
        numMiles = 0;
        mileage = MILE_LIMIT;
    }

    /***********************************************************
     * Returns the current mileage
     * @return int - number of miles on odometer
     ***********************************************************/
    public int checkOdometer() 
    {
        return numMiles;
    }

    /***********************************************************
     * Returns the amount of gas in the tank
     * @return double - amount of gas
     ***********************************************************/
    public double checkGasGauge() 
    {
        return gasAmount;
    }

    /***********************************************************
     * Returns the mileage for the next oil change
     * @return double - mileage
     ***********************************************************/
    public double checkNextOilChange() 
    {
        return mileage;
    }

    /***********************************************************
     * Prints out a statement confirming the horn is activated
     ***********************************************************/
    public void honkHorn()
    {
        System.out.println(carModel + " toots at you with its horn.");
    }

    /***********************************************************
     * Adds additional gas to the amount of gas within the tank
     ***********************************************************/
    public void addGas(double g)
    {
        DecimalFormat fmt = new DecimalFormat("#.00");

        gasAmount = gasAmount + g;

        if(gasAmount < 0.0)
        {
            JOptionPane.showMessageDialog(null, "Warning: Gas must be a positive number!");
            System.out.println(carModel + " now has " + fmt.format(gasAmount) + " gallons of gas.");
        }
        
        else 
        {
            System.out.println(carModel + " now has " + fmt.format(gasAmount) + " gallons of gas.");  
        }

        if(gasAmount > 12.0)
        {
            JOptionPane.showMessageDialog(null, "Warning: Gas tank overflow has occurred!");
            System.out.println(carModel + " now has " + fmt.format(12.0) + " gallons of gas.");
        }
    }

    /***********************************************************
     * Test drives the vehicle a specific amount of miles
     ***********************************************************/
    public void drive(int miles)
    {
        numMiles = numMiles + miles;
        gasAmount = 12.0 - (numMiles / milesPerGallon);

        // Displays a warning message when miles is a negative value
        if (miles < 0)
        {
            JOptionPane.showMessageDialog(null, "Warning: Miles must be a positive number!");
        }

        // Displays the amount of miles driven
        if (gasAmount <= 0.0)
        {
            gasAmount = 0;
            System.out.println(carModel + " drove " + numMiles + " miles before running out of a gas...");
        }
        
        else 
        {
            System.out.println(carModel + " drove " + numMiles + " miles.");
        }
    }

    /***********************************************************
     * Sets the mileage for the next oil change
     ***********************************************************/
    public void changeOil()
    {
        mileage = numMiles + 5000;

        if (numMiles >= 5000)
        {
            System.out.println(carModel + " oil has changed. Next change at " + mileage + ".");
        }
    }

    /***********************************************************
     * Sets the mileage for the next oil change
     ***********************************************************/
    public void checkOil()
    {
        // Displays a message notifying the oil must be changed
        if (numMiles >= 5000)
        {
            System.out.println("You should change the oil.");
        }

        // Displays a message confirming oil levels are acceptable
        if (numMiles < 5000)
        {
            System.out.println("Your oil levels are good.");
        }
    }
}
