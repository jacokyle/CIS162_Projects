import java.util.ArrayList;
/**
 * The CountryTest class tests the Country class.
 *
 * @author (Kyle Jacobson)
 * @version (03/31/18)
 */
public class CountryTest
{
    public static void main(String args[]){
        CountryDatabase db = new CountryDatabase();
        
        // read the countries of the world file
        db.readCountriesData("Countries.csv");
        System.out.println("****Begin test***");
        
        // Testing Count - ensures count for all countries functions
        if(db.countAllCountries() != 195){
            System.out.println("Error: Number of countries should be 195.");
        }
        
        // Testing Population - ensures population above paramenter functions
        ArrayList <Country> testPopulation = db.searchCountriesWithPopulation(900000000);
        if(testPopulation.size() != 2){
            System.out.println("Error: it should be two countries with a " +
                "population greater than 900 million.");
        }
        
        // Testing Countries in Continent - ensures all countries in North America function
        ArrayList <Country> testContinent = db.searchCountriesInContinent("North America");
        if(testContinent.size() != 22){
            System.out.println("Error: there should only be 22 countries " +
                "within North America.");
        }
        
        // Testing Top Ten GDP - ensures there are 10 countries within the list
        ArrayList <Country> testTenGDP = db.topTenGdpCountries("North America");
        if(testTenGDP.size() != 10){
            System.out.println("Error: there should only be 10 countries " +
                "when counting the top ten countries with highest GDP in a continent.");
        }
        
        // Testing Get All Countries - ensures there are 195 countries within the list
        ArrayList <Country> testAllCountries = db.getAllCountries();
        if(testAllCountries.size() != 195){
            System.out.println("Error: Number of countries should be 195.");
        }
        
        // Testing Capital - ensures capital of United States functions
        String testCapital = db.searchForCapital("United States");
        if(db.searchForCapital("United States") != testCapital)
        {
            System.out.println("Error: Washington D.C. should be the capital "
                + "of the United States.");
        }
        
        // Testing Details - ensures details for country functions
        Country testCountry = db.findCountryDetails("United States");
        if(db.findCountryDetails("United States") != testCountry)
        {
            System.out.println("Error: Details for the United States should "
                + "be properly displayed.");
        }
        
        // Testing Smallest Area - ensures smallest area in Asia functions
        Country testArea = db.smallestArea("Asia");
        if(db.smallestArea("Asia") != testArea)
        {
            System.out.println("Error: The country with the smallest area "
                + "in Asia should be Maldives.");
        }
        
        // Testing Highest Area - ensures highest GDP in Asia functions
        Country testHighGDP = db.highestGdp("Asia");
        if(db.highestGdp("Asia") != testHighGDP)
        {
            System.out.println("Error: The country with the highest GDP "
                + "in Asia should be China.");
        }
        
        System.out.println("*** Test complete***");
    }
}
