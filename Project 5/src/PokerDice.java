import java.util.ArrayList;

/**
 * The PokerDice class contains game functionalities.
 *
 * @author (Kyle Jacobson)
 * @version (04/15/18)
 */
public class PokerDice
{
    /** ArrayList of class GVdie named myDice */
    private ArrayList<GVdie> myDice;

    /** Variable for dice 1 */
    private GVdie d1;

    /** Variable for dice 2 */
    private GVdie d2;

    /** Variable for dice 3 */
    private GVdie d3;

    /** Variable for dice 4 */
    private GVdie d4;

    /** Variable for dice 5 */
    private GVdie d5;

    /** Variable for current value on dice 1 */
    private int v1;

    /** Variable for current value on dice 2 */
    private int v2;

    /** Variable for current value on dice 3 */
    private int v3;

    /** Variable for current value on dice 4 */
    private int v4;

    /** Variable for current value on dice 5 */
    private int v5;

    /** Total amount of points accrued */
    private int score; 

    /** Amount of rolls per round */
    private int numRolls;

    /** Amount of rounds per game */
    private int numRounds;

    /** Total amount of current values added together */
    private int singles;

    /** Array for keeping track of individual dice */
    private int[] tally;

    /** Score for three of a kind */
    public final static int THREE_OF_A_KIND = 25;

    /** Score for small straight */
    public final static int SMALL_STRAIGHT = 30;

    /** Score for full house */
    public final static int FULL_HOUSE = 35;

    /** Score for four of a kind */
    public final static int FOUR_OF_A_KIND = 40;

    /** Score for large straight */
    public final static int LARGE_STRAIGHT = 45;

    /** Score for five of a kind */
    public final static int FIVE_OF_A_KIND = 50;

    /** Score for bonus */
    public final static int BONUS = 35;

    /***************************************************************
     * Default Constructor
     ***************************************************************/
    public PokerDice()
    {
        myDice = new ArrayList<GVdie>(); 

        d1 = new GVdie();
        myDice.add(d1);

        d2 = new GVdie();
        myDice.add(d2);

        d3 = new GVdie();
        myDice.add(d3);

        d4 = new GVdie();
        myDice.add(d4);

        d5 = new GVdie();
        myDice.add(d5);

        tally = new int[7];

        resetGame();
    }

    /***************************************************************
     * Returns the score of the game after each round
     * @return int score
     ***************************************************************/
    public int getScore()
    {
        if(getBonusScore() == 35)
        {
            return BONUS + score;
        }

        return score;       
    }

    /***************************************************************
     * Checks if it is acceptable to roll the dice
     ***************************************************************/
    public boolean okToRoll()
    {
        if(numRolls < 3)
        {
            return true;
        }

        return false;
    }

    /***************************************************************
     * Checks if the total number of rounds exceeds 13
     ***************************************************************/
    public boolean gameOver()
    {
        if(numRounds == 13)
        {
            return true;
        }

        return false;
    }

    /***************************************************************
     * Returns the ArrayList of GVdie objects
     * @return ArrayList<GVdie> myDice
     ***************************************************************/
    public ArrayList<GVdie> getDice()
    {
        return myDice;
    }

    /***************************************************************
     * Tallies the number of 1s, 2s, 3s, 4s, 5s, 6s for current dice
     ***************************************************************/
    private void tallyDice()
    {
        for (int i=1; i<tally.length; i++)
        {
            tally[i] = 0;
        }

        for (GVdie d : myDice)
        {
            tally[d.getValue()]++;
        }
    }

    /***************************************************************
     * Checks for small straight and large straight conditions
     * @param int - length of streak of nonzero values within array
     ***************************************************************/
    private boolean hasStraight(int length)
    {
        int count = 0;
        tallyDice();

        for(int i = 1; i < tally.length; i++)
        {
            if(tally[i] == 0)
            {
                count = 0;
            }

            if(tally[i] != 0)
            {
                count++;
            }

            if(count >= length)
            {
                return true;
            }
        }

        return false;
    }

    /***************************************************************
     * Checks for threes of a kind, four of a kind, and five of a 
     * kind conditions
     * @param int - count of all dice with similar values
     ***************************************************************/
    private boolean hasMultiples(int count)
    {
        tallyDice();

        for(int i = 1; i < tally.length; i++)
        {
            if(tally[i] >= count)
            {
                return true;
            }
        }

        return false;
    }

    /***************************************************************
     * Checks for a pair of any numbers, and only a pair
     ***************************************************************/
    private boolean hasStrictPair()
    {
        tallyDice();

        for(int i = 1; i < tally.length; i++)
        {
            if(tally[i] == 2)
            {
                return true;
            }
        }

        return false;
    }

    /***************************************************************
     * Prepares for the next round
     ***************************************************************/
    private void nextRound()
    {
        numRounds++;
        numRolls = 0;

        d1.setBlank();
        d2.setBlank();
        d3.setBlank();
        d4.setBlank();
        d5.setBlank();

        d1.setHeld(false);
        d2.setHeld(false);
        d3.setHeld(false);
        d4.setHeld(false);
        d5.setHeld(false);
    }

    /***************************************************************
     * Resets all instance variables to zero and dice to blank
     ***************************************************************/
    public void resetGame()
    {      
        score = 0;
        numRounds = 0;
        numRolls = 0;

        d1.setBlank();
        d2.setBlank();
        d3.setBlank();
        d4.setBlank();
        d5.setBlank();

        d1.setHeld(false);
        d2.setHeld(false);
        d3.setHeld(false);
        d4.setHeld(false);
        d5.setHeld(false);
    }

    /***************************************************************
     * Increments the number of rolls and makes sure no dice are held
     ***************************************************************/
    public void rollDice()
    {   
        numRolls++;
        okToRoll();

        if(!d1.isHeld())
        {
            d1.roll();
        }

        if(!d2.isHeld())
        {
            d2.roll();
        }

        if(!d3.isHeld())
        {
            d3.roll();
        }

        if(!d4.isHeld())
        {
            d4.roll();
        }

        if(!d5.isHeld())
        {
            d5.roll();
        }
    }

    /***************************************************************
     * Adds the value of a three of a kind to the total score
     ***************************************************************/
    public void checkThreeOfAKind()
    {
        if(hasMultiples(3))
        {
            score = score + THREE_OF_A_KIND;
        }

        nextRound();
    }

    /***************************************************************
     * Adds the value of a full house to the total score
     ***************************************************************/
    public void checkFullHouse()
    {
        if(hasMultiples(3) == true && hasStrictPair() == true || hasMultiples(5) == true)
        {
            score = score + FULL_HOUSE;
        }

        nextRound();
    }

    /***************************************************************
     * Adds the value of a small straight to the total score
     ***************************************************************/
    public void checkSmallStraight()
    {
        if(hasStraight(4) == true)
        {
            score = score + SMALL_STRAIGHT;
        }

        nextRound();
    }

    /***************************************************************
     * Adds the value of a large straight to the total score
     ***************************************************************/
    public void checkLargeStraight()
    {
        if(hasStraight(5) == true)
        {
            score = score + LARGE_STRAIGHT;
        }

        nextRound();
    }

    /***************************************************************
     * Adds the value of a four of a kind to the total score
     ***************************************************************/
    public void checkFourOfAKind()
    {
        if(hasMultiples(4) == true)
        {
            score = score + FOUR_OF_A_KIND;
        }

        nextRound();
    }

    /***************************************************************
     * Adds the value of a five of a kind to the total score
     ***************************************************************/
    public void checkFiveOfAKind()
    {
        if(hasMultiples(5) == true)
        {
            score = score + FIVE_OF_A_KIND;
        }

        nextRound();
    }

    /***************************************************************
     * Adds the value of all dice with the value of val
     * @param int - value of current dice
     ***************************************************************/
    public void checkSingles(int val)
    {
        v1 = d1.getValue();
        v2 = d2.getValue();
        v3 = d3.getValue();
        v4 = d4.getValue();
        v5 = d5.getValue();

        if(v1 == val)
        {
            score = score + v1; 
            singles = singles + v1;
        }

        if(v2 == val)
        {
            score = score + v2; 
            singles = singles + v2;
        }

        if(v3 == val)
        {
            score = score + v3; 
            singles = singles + v3;
        }

        if(v4 == val)
        {
            score = score + v4; 
            singles = singles + v4;
        }

        if(v5 == val)
        {
            score = score + v5; 
            singles = singles + v5;
        }

        nextRound();
    }

    /***************************************************************
     * Updates the score with the sum of all dice
     ***************************************************************/
    public void checkChance()
    {        
        v1 = d1.getValue();
        v2 = d2.getValue();
        v3 = d3.getValue();
        v4 = d4.getValue();
        v5 = d5.getValue();

        score = score + v1 + v2 + v3 + v4 + v5;
        nextRound();
    }

    /***************************************************************
     * Checks if singles exceeded 63 and adds bonus accordingly
     ***************************************************************/
    public int getBonusScore()
    {
        if(singles >= 63)
        {
            return BONUS;
        }

        return 0;
    }

    /***************************************************************
     * Passes an array of five integers to set the dice values
     * @param int[] - values of the dice
     ***************************************************************/
    public void setDice(int[]values)
    {
        for(int i = 0; i < values.length; i++)
        {
            GVdie currentDice = myDice.get(i);

            while(currentDice.getValue() != values[i])
            {
                currentDice.roll();
            }
        }
    }
}
