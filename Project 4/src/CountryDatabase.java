import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Collections;
/**
 * The CountryDatabase class maintains the collection of countries.
 *
 * @author (Kyle Jacobson)
 * @version (03/31/2018)
 */
public class CountryDatabase
{
    /** ArrayList of class Country named info */
    private ArrayList<Country> info;

    /***********************************************************
     * Constructor that is used to assign instance variables
     ***********************************************************/
    public CountryDatabase()
    {
        info = new ArrayList<Country>();
    }

    /***************************************************************
     * Returns the country with highest GDP within specific continent
     * @return Country entry
     ***************************************************************/
    public Country highestGdp(String continent)
    {
        Country entry = new Country();
        entry.setGDP(0.0);

        for(Country c: info)
        {
            if(c.getContinent().equalsIgnoreCase(continent) && c.getGDP() > entry.getGDP())
            {
                entry = c;
            }
        }
        return entry;
    }

    /***************************************************************
     * Returns the country with smallest area within specific continent
     * @return Country entry
     ***************************************************************/
    public Country smallestArea(String continent)
    {
        Country entry = new Country();
        int max = Integer.MAX_VALUE;
        entry.setArea(max);

        for(Country c : info)
        {
            if(c.getContinent().equalsIgnoreCase(continent) && c.getArea() < entry.getArea())
            {
                entry = c;
            }
        }
        return entry;
    }

    /***************************************************************
     * Returns the capital of the country entered as input parameter
     * @return String capital
     ***************************************************************/
    public String searchForCapital(String countryName)
    {   
        for(Country c : info)
        {
            if(c.getCountry().equalsIgnoreCase(countryName))
            {
                return c.getCapital();
            }
        }
        return null;
    }

    /***************************************************************
     * Returns the details of the country entered as input parameter
     * @return Country country
     ***************************************************************/
    public Country findCountryDetails(String countryName)
    {
        for(Country c : info)
        {
            if(c.getCountry().equalsIgnoreCase(countryName))
            {
                return c;
            }
        }
        return null;
    }

    /***************************************************************
     * Returns a list of countries within a specific continent
     * @return ArrayList<Country> temp
     ***************************************************************/
    public ArrayList<Country> searchCountriesInContinent(String continent)
    {
        ArrayList<Country> temp = new ArrayList<Country>();

        for(Country c : info)
        {
            if(c.getContinent().equalsIgnoreCase(continent))
            {
               temp.add(c);
            }
        }
       
        return temp;
    }

    /***************************************************************
     * Returns a list of countries with populations larger than input parameter
     * @return ArrayList<Country> temp
     ***************************************************************/
    public ArrayList<Country> searchCountriesWithPopulation(double population)
    {
        ArrayList<Country> temp = new ArrayList<Country>();

        for(Country c : info)
        {
            if(c.getPopulation() > population)
            {
                temp.add(c);
            }
        }

        return temp;
    }

    /***************************************************************
     * Returns a list of countries that are located around the world
     * @return ArrayList<Country> info
     ***************************************************************/
    public ArrayList<Country> getAllCountries()
    {
        return info;
    }

    /***************************************************************
     * Returns the total number of all countries within the ArrayList
     * @return int info.size()
     ***************************************************************/
    public int countAllCountries()
    {
        return info.size();
    }

    /***************************************************************
     * Returns a list of ten countries with highest GDP within continent
     * @return ArrayList<Country> temp
     ***************************************************************/
    public ArrayList<Country> topTenGdpCountries (String continent)
    {          
        ArrayList<Country> temp = searchCountriesInContinent(continent);
        Collections.sort(temp);

        while(temp.size() > 10)
        {
            temp.remove(10);
        }
        
        return temp;
    }

    /***************************************************************
     * Opens the provided filename and reads all the given data
     ***************************************************************/
    public void readCountriesData(String filename){

        // Read the full set of data from a text file
        try{
            // open the text file and use a Scanner to read the text
            FileInputStream fileByteStream = new FileInputStream(filename);
            Scanner scnr = new Scanner(fileByteStream);
            scnr.useDelimiter("[,\r\n]+");

            // keep reading as long as there is more data
            while(scnr.hasNext()) {
                // reading the fields from the record one at the time
                String name = scnr.next();
                String continent = scnr.next();
                int area = scnr.nextInt();
                double population = scnr.nextDouble();
                double gdp = scnr.nextDouble();
                String capital = scnr.next();

                Country entry = new Country(name, continent, area, population, gdp, capital);
                info.add(entry);
            }
            fileByteStream.close();
        }
        catch(IOException e) {
            System.out.println("Failed to read the data file: " + filename);
        }
    }
}
