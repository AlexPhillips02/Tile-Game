import javax.swing.*;

/**
 * This class holds the main 
 */
public class TileGame 
{
    /**
    * Creates the board aswell as loading levels
    *
    * @param gameBoard Instance of Board which creates the basic game
    * @param level Establishes what level to load (Is incremented by 1 when the game is won)
    */
    public static void main(String[] arguemnts) {
        //Creates the gameboard
        Board gameBoard = new Board();
        int level = 1;

        gameBoard.firstLevel();
        checkForWin(gameBoard, level);
        
        level++;
        gameBoard.secondLevel();
        checkForWin(gameBoard, level);
        
        level++;
        gameBoard.thirdLevel();
        checkForWin(gameBoard, level);
    }

    /**
    * Validates if the game has been won
    *
    * @param win Boolean which is set to true when all squirrels have dropped their nut
    */
    private static void checkForWin(Board gameBoard, int level) {
        // sets win = false
        boolean win = false;

        while (win == false) 
        {
            try 
            {
                //Pause game for 0.5 second to reduce calls
                Thread.sleep(500);
            } catch (InterruptedException e)
            { 
                //Will catch if another thread attempts to interupt this thread
            }

            win = gameBoard.checkForWin(level);
        }

        //Displays win message
        infoBox("Level Complete", "You Win!");
    }

    /**
    * Displays an info box notifying the user that the level has been completed
    */
    private static void infoBox(String infoMessage, String titleBar)
    {
        JOptionPane.showMessageDialog(null, infoMessage, "InfoBox: " + titleBar, JOptionPane.INFORMATION_MESSAGE);
    }
}