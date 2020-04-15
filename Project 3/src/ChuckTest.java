
/**
 * The ChuckTest class communicates with the Chuck class.
 *
 * @author Kyle Jacobson
 * @version 3/11/18
 */
public class ChuckTest
{
    public static void main(String [] args)
    {
        int before = 0;
        Chuck game = new Chuck();
        
        game.getMessage();
        game.getCredits();
        
        System.out.println("Testing begins...");
        if(game.getCredits() != 10)
        {
            System.out.println("FAIL: credits should start at 10");
        }
        
        // wins bet on Small
        before = game.getCredits();
        game.placeBet(Chuck.SMALL);
        game.testRoll(1,2,2);
        if(game.getCredits() != (before+1))
        {
            System.out.println("FAIL: should have won betting on Small");
        }
        
        // loses bet on Small
        before = game.getCredits();
        game.placeBet(Chuck.SMALL);
        game.testRoll(6,4,1);
        if(game.getCredits() != (before-1)){
            System.out.println("FAIL: should have lost betting on Small");
        }
        
        // wins bet on Field above 12
        before = game.getCredits();
        game.placeBet(Chuck.FIELD);
        game.testRoll(6,3,4);
        if(game.getCredits() != (before+1))
        {
            System.out.println("FAIL: should have won betting on Field");
        }
        
        // wins bet on Field below 8
        before = game.getCredits();
        game.placeBet(Chuck.FIELD);
        game.testRoll(1,2,3);
        if(game.getCredits() != (before+1))
        {
            System.out.println("FAIL: should have won betting on Field");
        }
        
        // loses bet on Field
        before = game.getCredits();
        game.placeBet(Chuck.FIELD);
        game.testRoll(3,4,3);
        if(game.getCredits() != (before-1)){
            System.out.println("FAIL: should have lost betting on Field");
        }
        
        // wins bet on Large
        before = game.getCredits();
        game.placeBet(Chuck.LARGE);
        game.testRoll(6,3,3);
        if(game.getCredits() != (before+1))
        {
            System.out.println("FAIL: should have won betting on Large");
        }

        // loses bet on Large
        before = game.getCredits();
        game.placeBet(Chuck.LARGE);
        game.testRoll(2,3,3);
        if(game.getCredits() != (before-1)){
            System.out.println("FAIL: should have lost betting on Large");
        }
        System.out.println("Testing completed.");
    }
}
