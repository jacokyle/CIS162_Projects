import java.text.DecimalFormat;
/**
 * The Country class is used to store facts about a country.
 *
 * @author (Kyle Jacobson)
 * @version (03/28/18)
 */
public class Country implements Comparable
{
    /** string data type for country */
    private String country;

    /** string data type for continent */
    private String continent;

    /** integer data type for area */
    private int area;

    /** double data type for population */
    private double population;

    /** double data type for gross domestic product */
    private double gdp;

    /** string data type for capital of country */
    private String capital;

    /***************************************************************
     * Default Constructor
     ***************************************************************/
    public Country()
    {
        country = "Default";
    }

    /***********************************************************
     * Constructor that is used to assign instance variables
     * @param String - name of the country
     * @param String - name of the continent
     * @param int - value for area in square kilometers
     * @param double - value of population in millions
     * @param double - value of gross domestic product in billions
     * @param String - name of the capital of a country
     ***********************************************************/
    public Country(String name, String continent, int area,
    double population, double gdp, String capital)
    {
        country = name;
        this.continent = continent;
        this.area = area;
        this.population = population;
        this.gdp = gdp;
        this.capital = capital;
    }

    /***************************************************************
     * Returns the name of the country
     * @return String country
     ***************************************************************/
    public String getCountry()
    {
        return country;
    }

    /***************************************************************
     * Returns the name of the continent
     * @return String continent
     ***************************************************************/
    public String getContinent()
    {
        return continent;
    }

    /***************************************************************
     * Returns the amount of the area in kilometers
     * @return int area
     ***************************************************************/
    public int getArea()
    {
        return area;
    }

    /***************************************************************
     * Returns the amount of people within a country in millions
     * @return double population
     ***************************************************************/
    public double getPopulation()
    {
        return population;
    }

    /***************************************************************
     * Returns the value of the gross domestic product in billions
     * @return double gdp
     ***************************************************************/
    public double getGDP()
    {
        return gdp;
    }

    /***************************************************************
     * Returns the name of the capital of a country
     * @return String capital
     ***************************************************************/
    public String getCapital()
    {
        return capital;
    }

    /***************************************************************
     * Assigns the parameter called name to country
     ***************************************************************/
    public void setCountry(String name)
    {
        country = name;
    }

    /***************************************************************
     * Assigns the parameter called continent to this.continent
     ***************************************************************/
    public void setContinent(String continent)
    {
        this.continent = continent;
    }

    /***************************************************************
     * Assigns the parameter called area to this.area
     ***************************************************************/
    public void setArea(int area)
    {
        this.area = area;
    }

    /***************************************************************
     * Assigns the parameter called population to this.population
     ***************************************************************/
    public void setPopulation(double population)
    {
        this.population = population;
    }

    /***************************************************************
     * Assigns the parameter called gdp to this.gdp
     ***************************************************************/
    public void setGDP(double gdp)
    {
        this.gdp = gdp;
    }

    /***************************************************************
     * Assigns the parameter called capital to this.capital
     ***************************************************************/
    public void setCapital(String capital)
    {
        this.capital = capital;
    }

    /***************************************************************
     * Returns a formatted String of the country
     ***************************************************************/
    public String toString()
    {
        DecimalFormat fmt = new DecimalFormat("##,###");
        
        return country + ", Capital: " + capital + ", GDP: " + fmt.format(gdp/1000000000) + " billion, Per Capita GDP: " + fmt.format(gdp/population);
    }

    /***************************************************************
     * Compares the gdp values of two individual Country objects
     ***************************************************************/
    public int compareTo(Object other){
        Country c = (Country) other;
        return (int)(c.gdp - gdp);
    }

    /***************************************************************
     * Test to ensure format of toString method is correct
     ***************************************************************/
    public static void main(String[]args)
    {
        Country c = new Country("United States", "North America", 9826675, 318320000.0, 16200000000000.0, "Washington D.C.");
        System.out.println(c);
    }
}
