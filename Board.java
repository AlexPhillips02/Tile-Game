import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * This class represents the board and is responsible for displaying all the GUI
 *     
 *@param greySquirrelHead Instance of picture that holds image of the grey squirrel head
 *@param greySquirrelBottom Instance of picture that holds the image of the grey squirrel bottom
 *@param greySquirrelNuttlessHead Instance of picture that holds the image of the grey squirrel nutless head
*/

public class Board implements ActionListener
{
    //Loading in universal images for all levels
    private Picture emptyDirt = new Picture("Icons/Empty.png", 0);
    private Picture hole = new Picture("Icons/Hole.png", 0);
    private Picture nutHole = new Picture("Icons/HoleNut.png", 0);
    private Picture flower = new Picture("Icons/Flower.png", 0);

    //Loads all the parts of the red squirrel Picture (directions set for first red squirrel apperance (Level 1))
    private Picture redSquirrelHead = new Picture("Icons/RedSquirrel1Nut.png", 270);
    private Picture redSquirrelBottom = new Picture("Icons/RedSquirrel2.png", 270);
    private Picture redSquirrelNutlessHead = new Picture("Icons/RedSquirrel1.png", 270);

    //Creates grey squirrel Picture (values assigned within level creation as has mulitple orintations depneding on level)
    private Picture greySquirrelHead;
    private Picture greySquirrelBottom;
    private Picture greySquirrelNutlessHead;

    //Creates black squirrel Picture
    private Picture blackSquirrelHead = new Picture("Icons/BlackSquirrel1Nut.png", 180);
    private Picture blackSquirrelBottom = new Picture("Icons/BlackSquirrel2.png", 180);
    private Picture blackSquirrelNutlessHead = new Picture("Icons/BlackSquirrel1.png", 180);

    //Creates brown squirrel pictures
    private Picture brownSquirrelHead = new Picture("Icons/BrownSquirrel1Nut.png", 180);
    private Picture brownSquirrelBottom = new Picture("Icons/BrownSquirrel2.png", 180);
    private Picture brownSquirrelNutlessHead = new Picture("Icons/BrownSquirrel1.png", 180);

    //Creates the Picture for the 3-Tiled squirrel
    private Picture squirrelFlower = new Picture("Icons/SquirrelFlower.png", 0);

    //Instatiates the tile class to create each of the squirrel parts
    private Tile redSquirrel;
    private Tile redSquirrelBot;

    private Tile greySquirrel;
    private Tile greySquirrelBot;

    private Tile blackSquirrel;
    private Tile blackSquirrelBot;
    private Tile blackFlower;

    private Tile brownSquirrel;
    private Tile brownSquirrelBot;
    private Tile brownFlower;

    private String selectedSquirrel = null;

    private JFrame gameWindow = new JFrame("Tile Game");

    private JButton upButton = new JButton(new Picture("Icons/BigArrow.png", 0));
    private JButton downButton = new JButton(new Picture("Icons/BigArrow.png", 180));
    private JButton leftButton = new JButton(new Picture("Icons/Arrow.png", 270));
    private JButton rightButton = new JButton(new Picture("Icons/Arrow.png", 90));

    private JButton[] gameSquares = new JButton[16];

    /**
    * Constructor: This loads the inital board and direction buttons setting them up appropriatly
    * It also creates the inital grid of empty dirt tiles
    *
    *@param gameSquares[] Array of buttons that represent the 4 x 4 grid of Tiles
    *@param gameWindow A JFrame which holds all of the layouts
    *@param bLayout A boarder layout which holds the directional buttons
    *@param gLayout A grid layout that holds the gameSquares[] buttons (Creating the game grid)
    *@param emptyDirt An instance of Picture that holds the empty dirt image
    */
    public Board()
    {
        //Creates game window and sets size
        gameWindow.setSize(600,600);

        gameWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Background boarder panel created
        JPanel bPanel = new JPanel();
        BorderLayout bLayout = new BorderLayout();
        bPanel.setLayout(bLayout);

        //Grid layout for game created
        GridLayout gLayout = new GridLayout(4, 4, 0, 0);
        JPanel gPanel = new JPanel();
        gPanel.setLayout(gLayout);

        gameWindow.setContentPane(bPanel);

        //Adding 16 empty game squares and action listeners to all squares
        for (int i = 0; i < 16; i++) 
        {
            gPanel.add(gameSquares[i] = new JButton(emptyDirt));
            gameSquares[i].addActionListener(this); 
        }

        //Adds listeners to all direction buttons
        upButton.addActionListener(this); 
        downButton.addActionListener(this); 
        leftButton.addActionListener(this); 
        rightButton.addActionListener(this); 

        //Setting the border of the directional buttons to null
        upButton.setBorder(null);
        downButton.setBorder(null);
        leftButton.setBorder(null);
        rightButton.setBorder(null);
        
        //Adds the buttons and game grid to the game window
        bPanel.add("Center", gPanel);
        bPanel.add("North", upButton);
        bPanel.add("South", downButton);
        bPanel.add("East", rightButton);
        bPanel.add("West", leftButton);
    }

    /**
    * Creates the first level and loads the approprate squirrels
    */

    public void firstLevel()
    {
        greySquirrelHead = new Picture("Icons/GreySquirrel1Nut.png", 0);
        greySquirrelBottom = new Picture("Icons/GreySquirrel2.png", 0);
        greySquirrelNutlessHead = new Picture("Icons/GreySquirrel1.png", 0);

        redSquirrel = new Tile(5, redSquirrelHead);
        redSquirrelBot = new Tile(6, redSquirrelBottom);

        greySquirrel = new Tile(10, greySquirrelHead);
        greySquirrelBot = new Tile(14, greySquirrelBottom);

        gameSquares[2].setIcon(hole);
        gameSquares[4].setIcon(hole);
        gameSquares[11].setIcon(hole);

        gameSquares[5].setIcon(redSquirrelHead);
        gameSquares[6].setIcon(redSquirrelBottom);
        gameSquares[10].setIcon(greySquirrelHead);
        gameSquares[14].setIcon(greySquirrelBottom);
        gameSquares[9].setIcon(flower);

        gameWindow.setVisible(true);
    }

    /**
    * Creates the second level and loads the approprate squirrels and holes
    */

    public void secondLevel()
    {
        //Invisible to reset square and load new level
        gameWindow.setVisible(false);

        //Clears game screen
        resetLevel();

        //creates new red squirrel
        redSquirrel = new Tile(0, redSquirrelHead);
        redSquirrelBot = new Tile(1, redSquirrelBottom);

        //creates new grey squirrel
        greySquirrel = new Tile(10, greySquirrelHead);
        greySquirrelBot = new Tile(14, greySquirrelBottom);

        //displays starting position of red squirrel
        gameSquares[0].setIcon(redSquirrelHead);
        gameSquares[1].setIcon(redSquirrelBottom);

        //displays starting postion of grey squirrel
        gameSquares[10].setIcon(greySquirrelHead);
        gameSquares[14].setIcon(greySquirrelBottom);

        gameSquares[3].setIcon(hole);
        gameSquares[12].setIcon(hole);
        gameSquares[5].setIcon(flower);
        gameSquares[15].setIcon(flower);

        gameWindow.setVisible(true);
    }

    /**
    * Creates the thrid level and loads the approprate squirrels and holes
    */

    public void thirdLevel()
    {
        //Invisible to reset square and load new level
        gameWindow.setVisible(false);

        //Clears game screen
        resetLevel();

        greySquirrelHead = new Picture("Icons/GreySquirrel1Nut.png", 180);
        greySquirrelBottom = new Picture("Icons/GreySquirrel2.png", 180);
        greySquirrelNutlessHead = new Picture("Icons/GreySquirrel1.png", 180);

        gameSquares[2].setIcon(hole);
        gameSquares[4].setIcon(hole);
        gameSquares[9].setIcon(hole);
        gameSquares[15].setIcon(hole);

        //creates new black squirrel
        blackSquirrel = new Tile(6, blackSquirrelHead);
        blackSquirrelBot = new Tile(2, blackSquirrelBottom);
        blackFlower = new Tile(1, squirrelFlower);
        blackFlower.setPreviousIcon("Hole");

        redSquirrel = new Tile(8, redSquirrelHead);
        redSquirrelBot = new Tile(9, redSquirrelBottom);
        redSquirrelBot.setPreviousIcon("Hole");

        greySquirrel = new Tile(11, greySquirrelHead);
        greySquirrelBot = new Tile(7, greySquirrelBottom);

        brownSquirrel = new Tile(14, brownSquirrelHead);
        brownSquirrelBot = new Tile(10, brownSquirrelBottom);
        brownFlower = new Tile(13, squirrelFlower);

        gameSquares[6].setIcon(blackSquirrelHead);
        gameSquares[2].setIcon(blackSquirrelBottom);
        gameSquares[1].setIcon(squirrelFlower);

        gameSquares[8].setIcon(redSquirrelHead);
        gameSquares[9].setIcon(redSquirrelBottom);

        gameSquares[11].setIcon(greySquirrelHead);
        gameSquares[7].setIcon(greySquirrelBottom);

        gameSquares[14].setIcon(brownSquirrelHead);
        gameSquares[10].setIcon(brownSquirrelBottom);
        gameSquares[13].setIcon(squirrelFlower);

        gameWindow.setVisible(true);
    }

    /**
    * Resets the level back to a grid of empty dirt for a new level to be generated
    */

    public void resetLevel()
    {
        //Invisible to reset square and load new level
        gameWindow.setVisible(false);

        //Clears game screen
        for (int i = 0; i < 16; i++) 
        {
            gameSquares[i].setIcon(emptyDirt);
        }
    }

    /**
    * Checks if a button has been pressed and identifes which button
    *
    */

    public void actionPerformed(ActionEvent e)
    {
        for (int i = 0; i < gameSquares.length; i++) 
        {
            if(e.getSource() == gameSquares[i])
            {
                if(gameSquares[i].getIcon() == redSquirrelHead || gameSquares[i].getIcon() == redSquirrelNutlessHead || gameSquares[i].getIcon() == redSquirrelBottom)
                {
                    selectedSquirrel = "redSquirrel";
                }

                if(gameSquares[i].getIcon() == greySquirrelHead || gameSquares[i].getIcon() == greySquirrelNutlessHead || gameSquares[i].getIcon() == greySquirrelBottom)
                {
                    selectedSquirrel = "greySquirrel";
                }
                if(gameSquares[i].getIcon() == blackSquirrelHead || gameSquares[i].getIcon() == blackSquirrelNutlessHead || gameSquares[i].getIcon() == blackSquirrelBottom)
                {
                    selectedSquirrel = "blackSquirrel";
                } 
                if(gameSquares[i].getIcon() == brownSquirrelHead || gameSquares[i].getIcon() == brownSquirrelNutlessHead || gameSquares[i].getIcon() == brownSquirrelBottom)
                {
                    selectedSquirrel = "brownSquirrel";
                }
            }
        }
        
        if (selectedSquirrel != null) 
        {
            if(e.getSource() == upButton)
            {
                moveSquirrel(-4);
            }
            if(e.getSource() == downButton)
            {
                moveSquirrel(+4);
            }
            if(e.getSource() == leftButton)
            {
                moveSquirrel(-1);
            }
            if(e.getSource() == rightButton)
            {
                moveSquirrel(+1);
            }
        }
    }

    /**
    * Establishes which direction to move the squirrel in and calls moveSquirrel with appropriate squirel tiles and direction
    *
    *@param moveAmount The amount that the squirrel is to be moved (int)
    */
    public void moveSquirrel(int moveAmount)
    {
        if (selectedSquirrel == "redSquirrel") 
        {
            moveSquirrel(moveAmount, redSquirrel, redSquirrelBot, null);
        }
        else if (selectedSquirrel == "greySquirrel")
        {
            moveSquirrel(moveAmount, greySquirrel, greySquirrelBot, null);
        }
        else if (selectedSquirrel == "blackSquirrel")
        {
            moveSquirrel(moveAmount, blackSquirrel, blackSquirrelBot, blackFlower);
        }
        else
        {
            moveSquirrel(moveAmount, brownSquirrel, brownSquirrelBot, brownFlower);
        }
    }

    /**
    * Checks if the move is valid
    *
    *@param moveAmount The amount (int) that the squirrel is to be moved
    *@param head The Tile representing the head
    *@param body The Tile representing the body
    *@param flower The tile representing the flower (If the squirrel doesn't have a flower attached --> set to null)
    *@param validSquirrel Returns true if the move is valid
    *@param clipping Identifies if the squirrel attempts to clip through the walls of the grid onto the other side
    *@param proposedPositionHead Holds the proposed positon of the new head
    *@param proposedPositionBot Holds the proposed postion of the new body
    */

    public boolean validMove(int moveAmount, Tile head, Tile body, Tile flower)
    {
        boolean validSquirrel = false;
        boolean clipping = false;
        boolean validSquirrelHead = false;

        int proposedPositionHead = head.getPosition() + moveAmount;
        int proposedPostionBot = body.getPosition() + moveAmount;
        
        //If the head attempts to clip to the other side of the screen
        if ((head.getPosition() == 12 && proposedPositionHead == 11) || (head.getPosition() == 8 && proposedPositionHead == 7) || (head.getPosition() == 4 && proposedPositionHead == 3)) 
        {
            clipping = true;
        }
        
        //If the body attempts to clip to the other side of the screen
        if ((body.getPosition() == 3 && proposedPostionBot == 4) || (body.getPosition() == 7 && proposedPostionBot == 8) || (body.getPosition() == 11 && proposedPostionBot == 12) || (body.getPosition() == 12 && proposedPostionBot == 11))
        {
            clipping = true;
        }
        
        //If tile has a flower and the flower attempts to clip through the other side of the screen or is < 0 or < 16
        if (flower != null) 
        {
            int proposedPostionFlower = flower.getPosition() + moveAmount;

            if ((flower.getPosition() == 12 && proposedPostionFlower == 11) || (flower.getPosition() == 8 && proposedPostionFlower == 7) || (flower.getPosition() == 4 && proposedPostionFlower == 3))
            {
                clipping = true;
            }

            if (proposedPostionFlower < 0 || proposedPostionFlower >= 16) 
            {
                clipping = true;
            }
        }

        //Cheaking if within the boundries
        if (clipping == false && (head.getPosition() + moveAmount) >= 0 && (head.getPosition() + moveAmount) < 16 && (body.getPosition() + moveAmount) >= 0 && (body.getPosition() + moveAmount) < 16)
        {
            //Checking validSquirrel move for head
            if (gameSquares[proposedPositionHead].getIcon() == hole || gameSquares[proposedPositionHead].getIcon() == emptyDirt || gameSquares[proposedPositionHead].getIcon() == body.getIcon() || gameSquares[proposedPositionHead].getIcon() == nutHole)
            {
                validSquirrelHead = true;
            }
            
            //If is an L-Shaped peice and the head wants to move to the position of the flower
            if (flower != null && flower.getPosition() == proposedPositionHead) 
            {
                validSquirrelHead = true;
            }
        
            //If the head is validSquirrel
            if (validSquirrelHead == true) 
            {
                //Cheaking validSquirrel move for tail
                if (gameSquares[proposedPostionBot].getIcon() == hole || gameSquares[proposedPostionBot].getIcon() == emptyDirt || gameSquares[proposedPostionBot].getIcon() == head.getIcon() || gameSquares[proposedPostionBot].getIcon() == nutHole)
                {
                    validSquirrel = true;
                }

                if (flower != null && flower.getPosition() == proposedPostionBot) 
                {
                    validSquirrel = true;
                }
            }
        }

        //If the move remains on the screen and the tile has a flower
        if (clipping == false && flower != null) 
        {
            int proposedPostionFlower = flower.getPosition() + moveAmount;

            //Checks if the flower collides with any object
            if (!(gameSquares[proposedPostionFlower].getIcon() == hole || gameSquares[proposedPostionFlower].getIcon() == emptyDirt || gameSquares[proposedPostionFlower].getIcon() == nutHole || proposedPostionFlower == head.getPosition() || proposedPostionFlower == body.getPosition()))// ||gameSquares[proposedPositionHead].getIcon() == flower.getIcon()))
            {
                validSquirrel = false;
            }
        }

        return validSquirrel;
    }

    /**
    * Moves the squirrel to the correct location
    *@param moveAmount The amount (int) that the squirrel is to be moved
    *@param head The Tile representing the head
    *@param body The Tile representing the body
    *@param flower The tile representing the flower (If the squirrel doesn't have a flower attached --> set to null)
    */
    public void moveSquirrel(int moveAmount, Tile head, Tile body, Tile flower)
    {
        //Stopping squirrles from deleting themselves
        boolean headCollisionOnBody = false;

        //If the move is within the boundries 
        if (validMove(moveAmount, head, body, flower) == true) 
        {
            //Moving the flower if an L shapped peice
            if (flower != null)
            {
                //Updates what was previously in the location of the flower
                if(flower.getPreviousIcon() == "Dirt")
                {
                    changeButtonIcon(flower.getPosition(), emptyDirt);
                }
                else if(flower.getPreviousIcon() == "Hole")
                {
                    changeButtonIcon(flower.getPosition(), hole);
                }
                else if(flower.getPreviousIcon() == "Nut Hole")
                {
                    changeButtonIcon(flower.getPosition(), nutHole);
                }

                //Updates flower to new position (mathematically)
                flower.changePosition(moveAmount);
            
                //Updates what the flower is now ontop of
                if (gameSquares[flower.getPosition()].getIcon() == hole)
                {
                    flower.setPreviousIcon("Hole");
                }
                else if(gameSquares[flower.getPosition()].getIcon() == nutHole)
                {
                    flower.setPreviousIcon("Nut Hole");
                }
                else if(gameSquares[flower.getPosition()].getIcon() == emptyDirt)
                {
                    flower.setPreviousIcon("Dirt");
                }
                else if (gameSquares[flower.getPosition()].getIcon() == body.getIcon())
                {
                    flower.setPreviousIcon(body.getPreviousIcon());
                }
                else if (gameSquares[flower.getPosition()].getIcon() == head.getIcon())
                {
                    flower.setPreviousIcon(head.getPreviousIcon());
                }
                
                //Changes position of the flower (On the screen)
                changeButtonIcon(flower.getPosition(), flower.getIcon());
            }

            //Cheaking what block type the head was previously on and replaces current head with old block   
            if (flower == null)
            {
                if(head.getPreviousIcon() == "Dirt")
                {
                    changeButtonIcon(head.getPosition(), emptyDirt);
                }
                else if(head.getPreviousIcon() == "Hole")
                {
                    changeButtonIcon(head.getPosition(), hole);
                }
                else if(head.getPreviousIcon() == "Nut Hole")
                {
                    changeButtonIcon(head.getPosition(), nutHole);
                }
            }

            if (flower != null && head.getPosition() != flower.getPosition()) 
            {
                if(head.getPreviousIcon() == "Dirt")
                {
                    changeButtonIcon(head.getPosition(), emptyDirt);
                }
                else if(head.getPreviousIcon() == "Hole")
                {
                    changeButtonIcon(head.getPosition(), hole);
                }
                else if(head.getPreviousIcon() == "Nut Hole")
                {
                    changeButtonIcon(head.getPosition(), nutHole);
                }
            }
 
            //Getting new position for head
            head.changePosition(moveAmount);

            //Calculates what is on the new postion and stores as the previous block
            if(gameSquares[head.getPosition()].getIcon() == body.getIcon())
            {
                head.setPreviousIcon(body.getPreviousIcon());
                headCollisionOnBody = true;
            }
            else if(gameSquares[head.getPosition()].getIcon() == nutHole)
            {
                head.setPreviousIcon("Nut Hole");
            }
            else
            {
                head.setPreviousIcon("Dirt");
            }

            //Checking if the new block is a regular hole and needs to be converted into a nut hole
            if (gameSquares[head.getPosition()].getIcon() == hole || (body.getPreviousIcon() == "Hole" && gameSquares[head.getPosition()].getIcon() == body.getIcon()))
            {
                head.setPreviousIcon("Hole");

                if (head.getDroppedNut() == false) 
                {
                    head.setDroppedNut(true);
                
                    if (head.getIcon() == redSquirrelHead)
                    {
                        head.setIcon(redSquirrelNutlessHead);
                    }
                    else if (head.getIcon() == greySquirrelHead)
                    {
                        head.setIcon(greySquirrelNutlessHead);
                    }
                    else if (head.getIcon() == blackSquirrelHead)
                    {
                        head.setIcon(blackSquirrelNutlessHead);
                    }
                    else if (head.getIcon() == brownSquirrelHead)
                    {
                        head.setIcon(brownSquirrelNutlessHead);
                    }

                    head.setPreviousIcon("Nut Hole");
                }
            }

            //Replaces new position with head
            changeButtonIcon(head.getPosition(), head.getIcon());

            //Replaces the current bottom with what was previously there
            //If head replaced bodys location then dont redraw the old body block
            if (headCollisionOnBody == false && flower == null) 
            {
                if(body.getPreviousIcon() == "Dirt")
                {
                    changeButtonIcon(body.getPosition(), emptyDirt);
                }   
                else if(body.getPreviousIcon() == "Hole")
                {
                    changeButtonIcon(body.getPosition(), hole);
                }
                else if(body.getPreviousIcon() == "Nut Hole")
                {                        
                    changeButtonIcon(body.getPosition(), nutHole);
                }
            }

            if (flower != null && body.getPosition() != flower.getPosition() && head.getPosition() != flower.getPosition() && headCollisionOnBody == false) 
            {
                if(body.getPreviousIcon() == "Dirt")
                {
                    changeButtonIcon(body.getPosition(), emptyDirt);
                }   
                else if(body.getPreviousIcon() == "Hole")
                {                        
                    changeButtonIcon(body.getPosition(), hole);
                }
                else if(body.getPreviousIcon() == "Nut Hole")
                {
                    changeButtonIcon(body.getPosition(), nutHole);
                }
            }

            //Calculates the new position for bottom
            body.changePosition(moveAmount);

            //Collects what is currently on the square and updates the previous icon
            if (gameSquares[body.getPosition()].getIcon() == hole) 
            {
                body.setPreviousIcon("Hole");
            }
            else if(gameSquares[body.getPosition()].getIcon() == nutHole)
            {
                body.setPreviousIcon("Nut Hole");
            }
            else
            {
                body.setPreviousIcon("Dirt");
            }

            //Replaces new square with squirrel bottom
            changeButtonIcon(body.getPosition(), body.getIcon()); 
        }
    }

    /**
    * Checks if the level has been completed
    *
    *@param levels The current level that the user is on
    *@param win Returns true if the level has been completed
    */

    public boolean checkForWin(int levels)
    {
        boolean win = false;
        
        //Returns true if the squirrels on that level have all dropped nuts
        switch (levels) {
            case 1:
                if (redSquirrel.getDroppedNut() == true && greySquirrel.getDroppedNut() == true) 
                {
                    win = true;
                }
                break;
                
            case 2:
                if (redSquirrel.getDroppedNut() == true && greySquirrel.getDroppedNut() == true) 
                {
                    win = true;
                }
                break;
            
            case 3:
                if (redSquirrel.getDroppedNut() == true && greySquirrel.getDroppedNut() == true && blackSquirrel.getDroppedNut() == true && brownSquirrel.getDroppedNut() == true) 
                {
                    win = true;
                }
                break;
        
            default:
                break;
        }

        return win;
    }

    /**
    * Changes the icon on the grid to the new icon
    *
    *@param squareNumber The location of the square to be updated
    *@param newIcon The Picture icon of the new image
    */
    public void changeButtonIcon(int squareNumber, Picture newIcon)
    {
        gameSquares[squareNumber].setIcon(newIcon);
    }
}