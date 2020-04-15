
/**
 * The CarTest class is designed to help test the SimpleCar class.
 *
 * @author Kyle Jacobson
 * @version 1.0
 */
public class CarTest
{
    public static void main(String args[]){
        SimpleCar dodge = new SimpleCar("Dodge Ram SRT-10", 23.5);
        SimpleCar ford = new SimpleCar("Ford Edge", 23.5);
        int errors = 0;

        /*************************************
         * Dodge Ram SRT-10 Functionalities
         *************************************/
        // Test the Dodge Ram's ability to drive 100 miles
        dodge.drive(100);
        
        // Displays an error message when dodge.drive() does not use 100 miles
        if(dodge.checkOdometer() != 100)
        {
            System.out.println("ERROR! Odometer should have 100 miles!");
            errors++;
        }

        // Test the Dodge Ram's ability to run out of gas
        dodge.drive(900);
        
        // Displays an error message when dodge.drive() ends with leftover gas
        if(dodge.checkGasGauge() > 0)
        {
            System.out.println("ERROR! Gas tank should be empty!");
            errors++;
        } 
        
        // Test the Dodge Ram's ability to add gasoline
        dodge.addGas(0.0);
        
        // Displays an error message when dodge.addGas() sends a negative value
        if (dodge.checkGasGauge() < 0)
        {
            System.out.println("ERROR! Gas must be a positive number!");
            errors++;
        } 
        
        // Test the Dodge Ram's ability to check the oil levels
        dodge.checkOil();

        // Test the Dodge Ram's ability to change the oil and when it occurs again
        dodge.changeOil();

        // Test the Dodge Ram's ability to honk the horn
        dodge.honkHorn();

        // Adds a space between dodge and ford lines
        System.out.print("\n");

        /*************************************
         * Ford Edge Functionalities
         *************************************/
        // Test the Ford Edge's ability to drive 100 miles
        ford.drive(100);
        
        // Displays an error message when ford.drive() does not use 100 miles
        if(ford.checkOdometer() != 100)
        {
            System.out.println("ERROR! Odometer should have 100 miles.");
            errors++;
        }

        // Test the Ford Edge's ability to run out of gas
        ford.drive(4900);
        
        // Displays an error message when ford.drive() ends with leftover gas
        if(ford.checkGasGauge() > 0.0)
        {
            System.out.println("ERROR! Gas tank should be empty.");
            errors++;
        } 

        // Test the Ford Edge's ability to add gasoline
        ford.addGas(0.0);

        // Displays an error message when ford.addGas() sends a negative value
        if (ford.checkGasGauge() < 0)
        {
            System.out.println("ERROR! Gas must be a positive number!");
            errors++;
        } 
        
        // Test the Ford Edge's ability to check the oil levels
        ford.checkOil();

        // Test the Ford Edge's ability to change the oil and when it occurs again
        ford.changeOil();

        // Test the Ford Edge's ability to honk the horn
        ford.honkHorn();

        // Adds a space between ford and error count lines
        System.out.print("\n");  

        // Displays a message notifying if any errors occurred when executing
        System.out.println("Testing complete with " + errors + " errors.");
    }
}
