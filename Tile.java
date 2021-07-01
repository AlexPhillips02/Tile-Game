public class Tile
{
/**
* This class represents a squirrel tile (or squirrel flower)
*/
    private int position;
    private String previousIcon;
    private boolean droppedNut;
    private Picture icon;

    /**
     * Constructor. Creates a new instance of the Tile class based on the starting postion and the Picture
     * 
     * @param position the position of the particular tile stored as an int 
     * @param previousIcon a string for what was previously at the location (to replace when the tile is moved)
     * @param droppedNut if the tile is a head. Stores if the head has dropped its nut already
     * @param icon stores a Picture of the current icon (is updated when the nut is dropped)
     */

    public Tile(int position, Picture icon)
    {
        this.icon = icon;
        this.position = position;
        previousIcon = "Dirt";
        droppedNut = false;
    }

    /**
     * Returns the position of the Tile
     */
    public int getPosition()
    {
        return position;
    }

    /**
     * Returns the previous icon that the Tile now occupies 
     */
    public String getPreviousIcon()
    {
        return previousIcon;
    }

    /**
     * Returns if the Tile has dropped a nut
     */
    public boolean getDroppedNut()
    {
        return droppedNut;
    }

    /**
     * Returns the current icon of the Tile
     */
    public Picture getIcon()
    {
        return icon;
    }

    /**
     * Sets the tile to a new icon (once the nut is dropped --> Updates to nutless head)
     */
    public void setIcon(Picture icon)
    {
        this.icon = icon;
    }

    /**
     * Sets the new position of the Tile if it is moved by a certain amount
     * 
     * @param changeAmount Changes the position of the tile by this (int) amount
     */
    public void changePosition(int changeAmount)
    {
        int newPosition = position + changeAmount;
        position = newPosition;
    }

    /**
     * Sets the previous icon to a new icon (string)
     */
    public void setPreviousIcon(String previousIcon)
    {
        this.previousIcon = previousIcon;
    }

    /**
     * Updates the droppednut variable
     */
    public void setDroppedNut(boolean droppedNut)
    {
        this.droppedNut = droppedNut;
    }
}