import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
/**
 * The PokerGUI class serves as the GUI of the PokerDice class.
 *
 * @author (Kyle Jacobson)
 * @version (04/15/18)
 */
public class PokerGUI extends JFrame implements ActionListener{
    /** visual representation of the dice */
    GVdie d1, d2, d3, d4, d5;

    /** buttons and labels */
    JButton onesBtn, twosBtn, threesBtn, foursBtn, fivesBtn, sixesBtn, smallStraightBtn, largeStraightBtn, fullHouseBtn, threeKindBtn, fourKindBtn, fiveKindBtn, chanceBtn, rollBtn;
    JLabel bonus, score;
    PokerDice game;

    /** menu items */
    JMenuBar menus;
    JMenu fileMenu;
    JMenuItem quitItem;
    JMenuItem newGameItem; 

    /****************************************************************
     * Main method used to start the game
     ****************************************************************/    
    public static void main(String args[])
    {        
        PokerGUI gui = new PokerGUI();
        gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gui.setTitle("Kyle's Poker Dice Game");
        gui.pack();
        gui.setVisible(true);
    }

    /****************************************************************
     * Creates all elements and displays them within the GUI
     ****************************************************************/ 
    public PokerGUI()
    {
        // create the game object as well as the GUI Frame   
        game = new PokerDice();

        // request the ArrayList of GVdie
        ArrayList<GVdie> theDice = game.getDice();

        // create the lay out
        setLayout(new GridBagLayout());
        GridBagConstraints position = new GridBagConstraints();
        position.insets = new Insets(5,5,5,5);
        setBackground(Color.lightGray);

        // position die 1
        d1 = game.getDice().get(0);
        position.gridx = 0;
        position.gridy = 0;
        add(d1, position);

        // position die 2
        d2 = game.getDice().get(1);
        position.gridx = 1;
        position.gridy = 0;
        add(d2, position);

        // position die 3
        d3 = game.getDice().get(2);  
        position.gridx = 2;
        position.gridy = 0;
        add(d3, position);

        // position die 4
        d4 = game.getDice().get(3);  
        position.gridx = 3;
        position.gridy = 0;
        add(d4, position);

        // position die 5
        d5 = game.getDice().get(4);  
        position.gridx = 4;
        position.gridy = 0;
        add(d5, position);

        // positions the 1s button
        onesBtn = new JButton("1s");
        onesBtn.addActionListener(this);
        position.gridx = 1;
        position.gridy = 10;
        add(onesBtn, position);

        // positions the 2s button
        twosBtn = new JButton("2s");
        twosBtn.addActionListener(this);
        position.gridx = 1;
        position.gridy = 20;
        add(twosBtn, position);

        // positions the 3s button
        threesBtn = new JButton("3s");
        threesBtn.addActionListener(this);
        position.gridx = 1;
        position.gridy = 30;
        add(threesBtn, position);

        // positions the 4s button
        foursBtn = new JButton("4s");
        foursBtn.addActionListener(this);
        position.gridx = 1;
        position.gridy = 40;
        add(foursBtn, position);

        // positions the 5s button
        fivesBtn = new JButton("5s");
        fivesBtn.addActionListener(this);
        position.gridx = 1;
        position.gridy = 50;
        add(fivesBtn, position);

        // positions the 6s button
        sixesBtn = new JButton("6s");
        sixesBtn.addActionListener(this);
        position.gridx = 1;
        position.gridy = 60;
        add(sixesBtn, position);

        // position bonus label
        bonus = new JLabel();
        bonus.setText("Bonus: " + game.getBonusScore()); 
        position.gridx = 1;
        position.gridy = 70;
        add(bonus, position);

        // positions the small straight button
        smallStraightBtn = new JButton("Small Straight");
        smallStraightBtn.addActionListener(this);
        position.gridx = 3;
        position.gridy = 10;
        add(smallStraightBtn, position);

        // positions the large straight button
        largeStraightBtn = new JButton("Large Straight");
        largeStraightBtn.addActionListener(this);
        position.gridx = 3;
        position.gridy = 20;
        add(largeStraightBtn, position);

        // positions the full house button
        fullHouseBtn = new JButton("Full House");
        fullHouseBtn.addActionListener(this);
        position.gridx = 3;
        position.gridy = 30;
        add(fullHouseBtn, position);

        // positions the 3 of a kind button
        threeKindBtn = new JButton("3 of a Kind");
        threeKindBtn.addActionListener(this);
        position.gridx = 3;
        position.gridy = 40;
        add(threeKindBtn, position);

        // positions the 4 of a kind button
        fourKindBtn = new JButton("4 of a Kind");
        fourKindBtn.addActionListener(this);
        position.gridx = 3;
        position.gridy = 50;
        add(fourKindBtn, position);

        // positions the 5 of a kind button
        fiveKindBtn = new JButton("5 of a Kind");
        fiveKindBtn.addActionListener(this);
        position.gridx = 3;
        position.gridy = 60;
        add(fiveKindBtn, position);

        // positions the chance button
        chanceBtn = new JButton("Chance");
        chanceBtn.addActionListener(this);
        position.gridx = 3;
        position.gridy = 70;
        add(chanceBtn, position);

        // creates and positions the roll button
        rollBtn = new JButton("Roll");
        rollBtn.addActionListener(this);
        position.gridx = 2;
        position.gridy = 80;
        add(rollBtn, position);

        // position score label
        score = new JLabel();
        score.setText("Score: " + game.getScore()); 
        position.gridx = 4;
        position.gridy = 80;
        add(score, position);

        // set up File menu
        fileMenu = new JMenu("File");
        quitItem = new JMenuItem("Quit");
        newGameItem = new JMenuItem("New Game");
        fileMenu.add(newGameItem);
        fileMenu.add(quitItem);
        menus = new JMenuBar();
        setJMenuBar(menus);
        menus.add(fileMenu); 

        // register the three menu items with this action listener
        newGameItem.addActionListener(this);
        quitItem.addActionListener(this);
    }

    /****************************************************************
     * Starts a new game
     ****************************************************************/
    private void reset()
    {
        // reset the game
        game.resetGame();

        // enables the buttons
        onesBtn.setEnabled(true);
        twosBtn.setEnabled(true);
        threesBtn.setEnabled(true);
        foursBtn.setEnabled(true);
        fivesBtn.setEnabled(true);
        sixesBtn.setEnabled(true);
        smallStraightBtn.setEnabled(true);
        largeStraightBtn.setEnabled(true);
        fullHouseBtn.setEnabled(true);
        threeKindBtn.setEnabled(true);
        fourKindBtn.setEnabled(true);
        fiveKindBtn.setEnabled(true);
        chanceBtn.setEnabled(true);
        rollBtn.setEnabled(true);
    }

    /****************************************************************
     * This method called when the roll button or a menu item is selected
     * @param event - the JComponent just selected
     ****************************************************************/
    public void actionPerformed(ActionEvent event){
        // players presses the roll button
        if (event.getSource() == rollBtn) 
        {
            game.rollDice();
        }

        // player selects menu to quit the game
        if (event.getSource() == quitItem)
        {
            System.exit(1);
        }

        // player selects menu item to start a new game    
        if (event.getSource() == newGameItem)
        {
            game.resetGame();
            reset();
        }

        // players presses the 1s button
        if (event.getSource() == onesBtn){
            game.checkSingles(1);
            onesBtn.setEnabled(false);
        }

        // players presses the 2s button
        if (event.getSource() == twosBtn){
            game.checkSingles(2);
            twosBtn.setEnabled(false);
        }

        // players presses the 3s button
        if (event.getSource() == threesBtn){
            game.checkSingles(3);
            threesBtn.setEnabled(false);
        }

        // players presses the 4s button
        if (event.getSource() == foursBtn){
            game.checkSingles(4);
            foursBtn.setEnabled(false);
        }

        // players presses the 5s button
        if (event.getSource() == fivesBtn){
            game.checkSingles(5);
            fivesBtn.setEnabled(false);
        }

        // players presses the 6s button
        if (event.getSource() == sixesBtn){
            game.checkSingles(6);
            sixesBtn.setEnabled(false);
        }

        // players presses the small straight button
        if (event.getSource() == smallStraightBtn){
            game.checkSmallStraight();
            smallStraightBtn.setEnabled(false);
        }

        // players presses the large straight button
        if (event.getSource() == largeStraightBtn){
            game.checkLargeStraight();
            largeStraightBtn.setEnabled(false);
        }

        // players presses the full house button
        if (event.getSource() == fullHouseBtn){
            game.checkFullHouse();
            fullHouseBtn.setEnabled(false);
        }

        // players presses the three of a kind button
        if (event.getSource() == threeKindBtn){
            game.checkThreeOfAKind();
            threeKindBtn.setEnabled(false);
        }

        // players presses the four of a kind button
        if (event.getSource() == fourKindBtn){
            game.checkFourOfAKind();
            fourKindBtn.setEnabled(false);
        }

        // players presses the five of a kind button
        if (event.getSource() == fiveKindBtn){
            game.checkFiveOfAKind();
            fiveKindBtn.setEnabled(false);
        }

        // players presses the chance button
        if (event.getSource() == chanceBtn){
            game.checkChance();
            chanceBtn.setEnabled(false);
        }

        // checks if it is acceptable to roll
        if(game.okToRoll() == false)
        {
            rollBtn.setEnabled(false);
        }

        else
        {
            rollBtn.setEnabled(true);
        }

        // notifies the player that the game is over
        if (game.gameOver())
        {
            JOptionPane.showMessageDialog(null, "Game Over! Your score was: " + game.getScore());
            rollBtn.setEnabled(false);
        }

        // update the bonus label  
        bonus.setText("Bonus: " + game.getBonusScore());
    
        // update the score label      
        score.setText("Score: " + game.getScore());
    }
}
