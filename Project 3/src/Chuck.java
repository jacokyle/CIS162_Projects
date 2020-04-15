
/**
 * The Chuck class contains game functionalities.
 *
 * @author Kyle Jacobson
 * @version 3/11/18
 */
public class Chuck
{
    /** Variable for dice 1 */
    private GVdie d1;

    /** Variable for dice 2 */
    private GVdie d2;

    /** Variable for dice 3 */
    private GVdie d3;

    /** Current value on dice 1 */
    private int currentValueD1;

    /** Current value on dice 2 */
    private int currentValueD2;

    /** Current value on dice 3 */
    private int currentValueD3; 

    /** Amount of credits */
    private int credits;

    /** Variable for the message */
    private String message;

    /** Variable for betting on ones */
    private boolean betOnOnes;

    /** Variable for betting on twos */
    private boolean betOnTwos;   

    /** Variable for betting on threes */
    private boolean betOnThrees;   

    /** Variable for betting on fours */
    private boolean betOnFours;     

    /** Variable for betting on fives */
    private boolean betOnFives;

    /** Variable for betting on sixes */
    private boolean betOnSixes; 

    /** Variable for betting on small */
    private boolean betOnSmall;

    /** Variable for betting on field */
    private boolean betOnField;

    /** Variable for betting on large */
    private boolean betOnLarge;

    /** Value for betting on ones */
    public static final int ONES = 1;

    /** Value for betting on twos */
    public static final int TWOS = 2;

    /** Value for betting on threes */
    public static final int THREES = 3; 

    /** Value for betting on fours */
    public static final int FOURS = 4;    

    /** Value for betting on fives */
    public static final int FIVES = 5;    

    /** Value for betting on sixes */
    public static final int SIXES = 6;    

    /** Value for betting on small */
    public static final int SMALL = 7;

    /** Value for betting on field */
    public static final int FIELD = 8;

    /** Value for betting on large */
    public static final int LARGE = 9;

    /***************************************************************
     * Default Constructor
     ***************************************************************/
    public Chuck()
    {
        d1 = new GVdie();
        d2 = new GVdie();
        d3 = new GVdie();
        credits = 10;
        message = "Welcome to Kyle's game!";
        d1.setBlank();
        d2.setBlank();
        d3.setBlank();

        currentValueD1 = 0;
        currentValueD2 = 0;
        currentValueD3 = 0; 

        betOnOnes = false;
        betOnTwos = false;   
        betOnThrees = false;       
        betOnFours = false;                 
        betOnFives = false;    
        betOnSixes = false; 
        betOnSmall = false;
        betOnField = false;
        betOnLarge = false;
    }

    /***************************************************************
     * Returns the message displayed during the game
     * @return String message
     ***************************************************************/
    public String getMessage()
    {
        return message;
    }

    /***************************************************************
     * Returns the credits displaying during the game
     * @return int credits
     ***************************************************************/
    public int getCredits()
    {
        return credits;
    }

    /***************************************************************
     * Adds credits to the current amount
     * @param int - amount to be added
     ***************************************************************/
    public void addCredits(int amount)
    {   
        if(amount > 0)
        {
            credits = credits + amount;
        }
    }

    /***************************************************************
     * Places bet on any nine bets by making them true
     * @param int - one of nine choices
     ***************************************************************/
    public void placeBet(int choice)
    {
        if(choice == Chuck.ONES)
        {
            betOnOnes = true;
        }

        else if(choice == Chuck.TWOS)
        {
            betOnTwos = true;
        }

        else if(choice == Chuck.THREES)
        {
            betOnThrees = true;
        }

        else if(choice == Chuck.FOURS)
        {
            betOnFours = true;
        }

        else if(choice == Chuck.FIVES)
        {
            betOnFives = true;
        }

        else if(choice == Chuck.SIXES)
        {
            betOnSixes = true;
        }

        else if(choice == Chuck.SMALL)
        {
            betOnSmall = true;
        }

        else if(choice == Chuck.FIELD)
        {
            betOnField = true;
        }

        else
        {
            betOnLarge = true;
        }
    }

    /***************************************************************
     * Cancels bet of any nine bets by making them false
     * @param int - one of nine bets
     ***************************************************************/
    public void cancelBet(int bet)
    {
        if(bet == Chuck.ONES)
        {
            betOnOnes = false;
        }

        else if(bet == Chuck.TWOS)
        {
            betOnTwos = false;
        }

        else if(bet == Chuck.THREES)
        {
            betOnThrees = false;
        }

        else if(bet == Chuck.FOURS)
        {
            betOnFours = false;
        }

        else if(bet == Chuck.FIVES)
        {
            betOnFives = false;
        }

        else if(bet == Chuck.SIXES)
        {
            betOnSixes = false;
        }

        else if(bet == Chuck.SMALL)
        {
            betOnSmall = false;
        }

        else if(bet == Chuck.FIELD)
        {
            betOnField = false;
        }

        else
        {
            betOnLarge = false;
        }
    } 

    /***************************************************************
     * Rolls the die for the game to play
     ***************************************************************/
    public void roll()
    {
        if(enoughCredits())
        {
            d1.roll();
            d2.roll();
            d3.roll();

            currentValueD1 = d1.getValue();
            currentValueD2 = d2.getValue();
            currentValueD3 = d3.getValue();

            checkAllBets();

            clearAllBets();
        }

        else
        {
            message = "You do not have enough credits!";

            d1.setBlank();
            d2.setBlank();
            d3.setBlank();
        }
    }

    /***************************************************************
     * Resets all variables to default for new game
     ***************************************************************/
    public void reset()
    {
        credits = 10;
        message = "Welcome to Kyle's Game";

        d1.setBlank();
        d2.setBlank();
        d3.setBlank();

        currentValueD1 = 0;
        currentValueD2 = 0;
        currentValueD3 = 0;
        
        clearAllBets();
    }

    /***************************************************************
     * Clears all bets that were selected
     ***************************************************************/
    private void clearAllBets()
    {
        int bet = 1;

        while(bet <= 9)
        {
            cancelBet(bet);
            bet++;
        }
    }

    /***************************************************************
     * Checks if two dies are identical
     * @param int - number on each die
     ***************************************************************/
    private boolean isDoubles(int num)
    {
        if ((num == currentValueD1 && num == currentValueD2) || (num == currentValueD2 && num == currentValueD3) || (num == currentValueD1 && num == currentValueD3))
        {
            return true;
        }

        else
        {
            return false; 
        }
    }

    /***************************************************************
     * Checks if three dies are indentical
     ***************************************************************/
    private boolean isTriplets()
    {                  
        if(currentValueD1 == currentValueD2 && currentValueD2 == currentValueD3)
        {
            return true;
        } 

        else 
        {
            return false;
        }
    }

    /***************************************************************
     * Checks if added die values are greater than ten and are a triplet
     ***************************************************************/
    private void checkLarge()
    { 
        credits = credits - 1;

        if(currentValueD1 + currentValueD2 + currentValueD3 > 10 && isTriplets() == false)
        {
            credits = credits + 2;
            message = "You won, dice total greater than 10!";
        }
    }

    /***************************************************************
     * Checks if added die values are less than eleven and are a triplet
     ***************************************************************/
    private void checkSmall()
    {
        credits = credits - 1;

        if(currentValueD1 + currentValueD2 + currentValueD3 < 11 && isTriplets() == false)
        {
            credits = credits + 2;
            message = "You won, dice total less than 11!";
        }
    } 

    /***************************************************************
     * Checks if added die values are less than eight or greater than twelve
     ***************************************************************/
    private void checkField()
    {
        credits = credits - 1;

        if((currentValueD1 + currentValueD2 + currentValueD3 < 8))
        {
            credits = credits + 2;
            message = "You won, dice total was less than 8!";
        }
        
        if((currentValueD1 + currentValueD2 + currentValueD3 > 12))
        {
            credits = credits + 2;
            message = "You won, dice total was greater than 12!";
        }
    }  

    /***************************************************************
     * Checks how many die match the number
     * @param int - number that must be matched to win
     ***************************************************************/
    private void checkNumber(int num)
    { 
        credits = credits - 1;

        if(isTriplets() && currentValueD1 == num)
        {
            credits = credits + 11;
            message = "Three of a kind!";
        }

        else if (isDoubles(num))
        {
            credits = credits + 3;
            message = "A pair!";
        }

        else if (currentValueD1 == num || currentValueD2 == num || currentValueD3 == num)
        {
            credits = credits + 2;
            message = "One match!";
        } 
    } 

    /***************************************************************
     * Checks if the bet selected was a winner
     ***************************************************************/
    private void checkAllBets()
    {
        message = "Sorry, you lose. Try again.";

        if(betOnOnes)
        {
            checkNumber(Chuck.ONES);
        }

        if(betOnTwos)
        {
            checkNumber(Chuck.TWOS);
        }

        if(betOnThrees)
        {
            checkNumber(Chuck.THREES);
        }

        if(betOnFours)
        {
            checkNumber(Chuck.FOURS);
        }

        if(betOnFives)
        {
            checkNumber(Chuck.FIVES);
        }

        if(betOnSixes)
        {
            checkNumber(Chuck.SIXES);
        }

        if(betOnSmall)
        {
            checkSmall();
        }

        if(betOnField)
        {
            checkField();
        }

        if(betOnLarge)
        {
            checkLarge();
        }
    }  

    /***************************************************************
     * Checks if the player has enough credits to cover all bets
     ***************************************************************/
    public boolean enoughCredits()
    {
        int activeBets = 0;

        if(betOnOnes == true)
        {
            activeBets++;
        }

        if(betOnTwos == true)
        {
            activeBets++;
        }

        if(betOnThrees == true)
        {
            activeBets++;
        }

        if(betOnFours == true)
        {
            activeBets++;
        }

        if(betOnFives == true)
        {
            activeBets++;
        }

        if(betOnSixes == true)
        {
            activeBets++;
        }

        if(betOnSmall == true)
        {
            activeBets++;
        }

        if(betOnField == true)
        {
            activeBets++;
        }

        if(betOnLarge == true)
        {
            activeBets++;
        }

        if(credits >= activeBets)
        {
            return true;
        }

        else
        {
            return false;
        }
    }

    /***************************************************************
     * Used for testing the games functionality
     ***************************************************************/
    public void testRoll(int v1, int v2, int v3)
    {
        if(enoughCredits())
        {
            currentValueD1 = v1;
            currentValueD2 = v2;
            currentValueD3 = v3;

            checkAllBets();

            clearAllBets();
        }

        else
        {
            message = "You do not have enough credits!";

            d1.setBlank();
            d2.setBlank();
            d3.setBlank();
        }
    }

    /***************************************************************
     * Helps allow each die appear in the graphical user interface
     ***************************************************************/
    public GVdie getDie(int num)
    {
        if (num == 1)
        {
            return d1;
        }

        else if (num == 2)
        {
            return d2;
        }

        else 
        {
            return d3;
        }
    }
}
