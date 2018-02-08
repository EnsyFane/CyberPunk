import greenfoot.*;

//Functie pentru scroll
public class Scroller extends Actor
{
    private World world; // view window world
    private GreenfootImage scrollImage; // scrolling image
    private int scrolledX, scrolledY; // current scrolled distances
    private int wide, high; // if limited, dimensions of scrolling area else of image to wrap
   
    /**
     * This constructor is for a limited scrolling world;
     * If 'image' is smaller than the given total scrolling area, it will be tiled
     * If 'image' is null, the background will not change
     * 
     * @param viewWorld the world that scrolling will be performed on
     * @param image the background image that will be tiled, if needed, to fill the scrolling area
     * @param wide the width of the visible area encompassed through scrolling;
     * the given value must be at least equal to the width of 'viewWorld' and
     * is given in world cells (not in pixels)
     * @param high the height of the visible area encompassed through scrolling;
     * the given value must be at least equal to the height of 'viewWorld' and
     * is given in world cells (not in pixels)
     */
    public Scroller(World viewWorld, GreenfootImage image, int wide, int high)
    {
        this.wide = wide;
        this.high = high;
        world = viewWorld;
        if (image != null)
        {
            scrollImage = image;
            scroll(0, 0);
        }
    }
   
    /**
     * performs scrolling on 'world' by the given distances along the horizontal and vertical;
     * if 'limited' is false, requested distances are actual scrolling distances;
     * if 'limited' is true, the distances may be adjusted due to the limits of scrolling
     *
     * @param dsx the requested distance to shift everything horizontally
     * @param dsy the requested distance to shift everything vertically
     */
    public void scroll(int dsx, int dsy)
    {
        // adjust scroll amounts and scroll background image
            // calculate limits of scrolling
            int maxX = wide-world.getWidth();
            int maxY = high-world.getHeight();
            // apply limits to distances to scroll
            if (scrolledX+dsx < 0) dsx = -scrolledX;
            if (scrolledX+dsx >= maxX) dsx = maxX-scrolledX;
            if (scrolledY+dsy < 0) dsy = -scrolledY;
            if (scrolledY+dsy >= maxY) dsy = maxY-scrolledY;
            // update scroll positions
            scrolledX += dsx;
            scrolledY += dsy;
            // scroll background image
            if (scrollImage != null)
            {
                world.getBackground().drawImage
                (   
                    scrollImage,
                    -scrolledX*world.getCellSize(),
                    -scrolledY*world.getCellSize()
                );
            }
        
        // adjust position of all actors (that can move with 'setLocation')
        for (Object obj : world.getObjects(null))
        {
            Actor actor = (Actor) obj;
            actor.setLocation(actor.getX()-dsx, actor.getY()-dsy);
        }
    }
   
    /**
     * getter method for the current total scrolled distance horizontally
     *
     * @return the current total offset of horizontal scrolling
     */
    public int getScrolledX()
    {
        return scrolledX;
    }
   
    /**
     * getter method for the current total scrolled distance vertically
     *
     * @return the current total offset of vertical scrolling
     */
    public int getScrolledY()
    {
        return scrolledY;
    }
}