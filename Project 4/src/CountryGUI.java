import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;
import java.text.*;
import java.io.IOException;

/*************************************************************
 * GUI for a Country Database class
 * 
 * @Ana Posada
 * @version March 2018
 ************************************************************/
public class CountryGUI extends JFrame implements ActionListener{
    /** instance variable for CountryDatabase object */
    CountryDatabase database;

    /** JButtons */
    private JButton smallestArea;
    private JButton highestGdp;
    private JButton countriesInContinent;    
    private JButton topTenGdp;
    private JButton populationBtn;
    private JButton capital;
    private JButton details;

    /** JTextFields */
    private JTextField continent;
    private JTextField population;
    private JTextField countryName;

    /** Results text area */
    private JTextArea resultsArea;

    /** menu items */
    private JMenuBar menus;
    private JMenu fileMenu;
    private JMenuItem listAllItem;
    private JMenuItem quitItem;
    private JMenuItem openItem;
    private JMenuItem countItem;

    /*****************************************************************
     * Main Method
     ****************************************************************/ 
    public static void main(String args[]){
        CountryGUI gui = new CountryGUI();
        gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gui.setTitle("Countries of the world");
        gui.pack();
        gui.setVisible(true);
    }

    /*****************************************************************
     * constructor installs all of the GUI components
     ****************************************************************/    
    public CountryGUI(){
        // instantiates an object of type CountryDatabase  
        database = new CountryDatabase();

        // set the layout to GridBag
        setLayout(new GridBagLayout());
        GridBagConstraints loc = new GridBagConstraints();

        // create results area to span one column and 10 rows
        resultsArea = new JTextArea(20,30);
        JScrollPane scrollPane = new JScrollPane(resultsArea);
        loc.gridx = 0;
        loc.gridy = 1;
        loc.gridheight = 10;  
        loc.insets.left = 20;
        loc.insets.right = 20;
        loc.insets.bottom = 20;
        add(scrollPane, loc);  

        // create Results label
        loc = new GridBagConstraints();
        loc.gridx = 0;
        loc.gridy = 0;
        loc.insets.bottom = 20;
        loc.insets.top = 20;
        add(new JLabel("Results"), loc);

        // create Searches label
        loc = new GridBagConstraints();
        loc.gridx = 1;
        loc.gridy = 0;
        loc.gridwidth = 2;
        add(new JLabel("Searches"), loc);     

        // instantiates the JTextFields and JButtons 
        smallestArea = new JButton ("Smallest Area");
        highestGdp = new JButton ("Highest GDP");      
        topTenGdp = new JButton ("Top Ten GDP");      
        countriesInContinent = new JButton ("Countries in Continent");    
        populationBtn = new JButton ("Population");   
        capital = new JButton ("Capital");      
        details = new JButton ("Details"); 

        continent = new JTextField (20);
        population = new JTextField (20);
        countryName = new JTextField (20);

        // adding labels and buttons
        loc = new GridBagConstraints();

        //adding the JLabel for the Continent 
        loc.anchor = GridBagConstraints.LINE_END;
        loc.insets = new Insets(5,5,5,5);
        loc.gridx = 1;
        loc.gridy = 1;
        add(new JLabel ("Continent"), loc);

        //adding the JTextField for the continent
        loc.gridx = 2;
        loc.gridy = 1;
        loc.anchor = GridBagConstraints.LINE_START;
        add(continent, loc);

        //adding the smallestArea JButton
        loc.gridy = 2;
        add(smallestArea, loc);

        //adding the highestGdp JButton
        loc.gridy = 3;
        add(highestGdp, loc);

        //adding the topTenGdp JButton
        loc.gridy = 4;
        add(topTenGdp, loc);

        //adding the countriesInContinent JButton
        loc.gridy = 5;
        add(countriesInContinent, loc);

        //adding the populationBtn JButton
        loc.gridy = 7;
        add(populationBtn, loc);

        //adding the details JButton
        loc.gridy = 11;
        add(details, loc);

        //adding the JLabel for population 
        loc.gridx = 1;
        loc.gridy = 7;
        loc.insets = new Insets(30,5,5,5);
        loc.anchor = GridBagConstraints.LINE_END;
        add(new JLabel ("Population"), loc);

        //adding the JTextField for the population
        loc.gridx = 2;
        loc.gridy = 7;
        loc.anchor = GridBagConstraints.LINE_START;
        add(population, loc);

        //adding the JButton for the population
        loc.gridy = 8;
        loc.insets = new Insets(5,5,5,5);
        loc.anchor = GridBagConstraints.LINE_START;
        add(populationBtn, loc);

        //adding the JLabel for country 
        loc.gridx = 1;
        loc.gridy = 10;
        loc.insets = new Insets(0,5,5,5);
        loc.anchor = GridBagConstraints.LINE_END;
        add(new JLabel ("Country"), loc);

        //adding the JTextField for the country
        loc.gridx = 2;
        loc.gridy = 10;
        loc.anchor = GridBagConstraints.LINE_START;
        add(countryName, loc);

        //adding the JButton for the capital
        loc.gridy = 10;
        loc.insets = new Insets(60,5,5,5);
        loc.anchor = GridBagConstraints.LINE_START;
        add(capital, loc);

        // registering the listeners for the buttons
        highestGdp.addActionListener(this); 
        smallestArea.addActionListener(this); 
        topTenGdp.addActionListener(this); 
        countriesInContinent.addActionListener(this);        
        populationBtn.addActionListener(this);    
        capital.addActionListener(this); 
        details.addActionListener(this);                      

        // hide details of creating menus
        setupMenus();
    }

    /*****************************************************************
     * This method is called when any button is clicked.  The proper
     * internal method is called as needed.
     * 
     * @param e the event that was fired
     ****************************************************************/       
    public void actionPerformed(ActionEvent e){

        // extract the button that was clicked
        JComponent buttonPressed = (JComponent) e.getSource();

        // loads the file with the countries of the world    
        if (buttonPressed == openItem){
            openFile();
        }  

        // quit item 
        if (buttonPressed == quitItem){
            System.exit(1);
        }

        if (database.countAllCountries() == 0)
            JOptionPane.showMessageDialog(this, "Forgot to read the file?");
        else { 
            if (buttonPressed == countItem)
                displayCounts();

            else if (buttonPressed == listAllItem)
                displayCountries (database.getAllCountries ());   

            // displays the smallest area 
            else if (buttonPressed == smallestArea){
                displaySmallestArea();
            }

            // displays the highest GDP
            else if (buttonPressed == highestGdp){
                displayHighestGdp();
            }

            // displays the top ten highest GDP
            else if (buttonPressed == topTenGdp){
                displayTopTen();
            }

            // displays the countries in the continent
            else if (buttonPressed == countriesInContinent){
                displayCountriesInContinent();
            }

            // displays the countries with selected population
            else if (buttonPressed == populationBtn){
                displayPopulation();
            }

            // displays the capital of a country
            else if (buttonPressed == capital){
                displaySearchForCapital();
            }

            // displays the details of a specific country
            else if (buttonPressed == details){
                displaySearchForCountry();
            }
        }
    }

    /*****************************************************************
     * displays the ArrayList passed as input parameter
     * @param - ArrayList <Country>
     ****************************************************************/ 
    private void displayCountries(ArrayList <Country> list) {
        resultsArea.setText("");
        for(Country c : list){
            resultsArea.append("\n" + c.toString());
        }
    }

    /*****************************************************************
     * display country with smallest area
     ****************************************************************/ 
    private void displaySmallestArea (){
        if (continent.getText().length() > 0)
        {
            Country temp = database.smallestArea(continent.getText());
            resultsArea.setText("\n" + temp.toString());
        }
        else
        {
            JOptionPane.showMessageDialog(this, "Enter a continent");
        }
    }

    /*****************************************************************
     * display country with highest GDP
     ****************************************************************/ 
    private void displayHighestGdp ()  {
        if (continent.getText().length() > 0) 
        {
            Country temp = database.highestGdp(continent.getText());
            resultsArea.setText("\n" + temp.toString());
        }
        else 
        {
            JOptionPane.showMessageDialog(this, "Enter a continent");
        }
    }

    /*****************************************************************
     * display the countries in a particular continent
     ****************************************************************/ 
    private void displayCountriesInContinent() {
        if (continent.getText().length() > 0) 
            displayCountries (database.searchCountriesInContinent(continent.getText()));     
        else
            JOptionPane.showMessageDialog(this, "Enter a continent");
    }

    /*****************************************************************
     * display top ten GDP countries
     ****************************************************************/ 
    private void displayTopTen () {
        if (continent.getText().length() > 0)
            displayCountries (database.topTenGdpCountries(continent.getText()));   
        else
            JOptionPane.showMessageDialog(this, "Enter a continent");
    }

    /*****************************************************************
     * display the capital for a particular country
     ****************************************************************/ 
    private void displaySearchForCapital ()  
    {
        if (countryName.getText().length() > 0){
            Country country = database.findCountryDetails (countryName.getText());
            if (country != null){
                resultsArea.setText("\nCapital:\t" + database.searchForCapital(countryName.getText()));
            }
            else 
                resultsArea.setText ("Country not found");
        }
        else
            JOptionPane.showMessageDialog(this, "Enter a country");
    }

    /*****************************************************************
     * display the facts about a country
     ****************************************************************/ 
    private void displaySearchForCountry ()  {
        DecimalFormat fmt = new DecimalFormat ("###,###,###,###");
        if (countryName.getText().length() > 0){
            Country country = database.findCountryDetails (countryName.getText());
            if (country != null){
                resultsArea.setText ("\nCountry Name:\t" + country.getCountry() + 
                    "\nContinent:\t" + country.getContinent() +
                    "\nCapital:\t" + country.getCapital() +
                    "\nArea in sq km:\t" + fmt.format(country.getArea()) +
                    "\nPopulation:\t" + fmt.format (country.getPopulation() / 1000000) + " million" +
                    "\nGDP:\t" + fmt.format (country.getGDP() / 1000000000) + " billion" +
                    "\nPerCapita GDP:\t" + fmt.format (country.getGDP() / country.getPopulation()));
            }
            else 
                resultsArea.setText ("Country not found");
        }
        else
            JOptionPane.showMessageDialog(this, "Enter a country");
    }

    /*****************************************************************
     * display counts - total number of countries
     ****************************************************************/ 
    private void displayCounts () {
        resultsArea.setText("\nTotal Countries: " + database.countAllCountries() + "");
    }

    /*****************************************************************
     * display countries with a population greater than a specific value
     ****************************************************************/ 
    private void displayPopulation () {
        try {
            double people = Double.parseDouble(population.getText());
            displayCountries (database.searchCountriesWithPopulation(people));
        }
        catch(NumberFormatException e){
            JOptionPane.showMessageDialog(this, "Enter a valid number for population");
        }
    }

    /*****************************************************************
     * open a data file with the name selected by the user
     ****************************************************************/ 
    private void openFile(){

        // create File Chooser so that it starts at the current directory
        String userDir = System.getProperty("user.dir");
        JFileChooser fc = new JFileChooser(userDir);

        // show File Chooser and wait for user selection
        int returnVal = fc.showOpenDialog(this);

        // did the user select a file?
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            String filename = fc.getSelectedFile().getName();

            // change world to the name of your instance variable
            database.readCountriesData(filename);          
        }
    }

    /*******************************************************
     * reates the menu items
     *******************************************************/    
    private void setupMenus(){
        fileMenu = new JMenu("File");
        quitItem = new JMenuItem("Quit");
        countItem = new JMenuItem("Counts");
        listAllItem = new JMenuItem("List Countries");
        openItem = new JMenuItem("Open...");

        fileMenu.add(openItem);
        fileMenu.add(countItem);
        fileMenu.add(listAllItem);
        fileMenu.add(quitItem);
        menus = new JMenuBar();
        setJMenuBar(menus);
        menus.add(fileMenu);

        // register the menu items with the action listener
        countItem.addActionListener(this); 
        quitItem.addActionListener(this); 
        listAllItem.addActionListener(this);
        openItem.addActionListener(this);

    }
}