import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class StartScreen here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class StartScreen extends World
{

    /**
     * Constructor for objects of class StartScreen.
     * 
     */
    JocNouClick jocnou = new JocNouClick(362, 70);
    private boolean ok = false;
    private static boolean debug = true;
    public StartScreen()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1500, 600, 1); 
        prepare();
    }

    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        addObject(jocnou,746,236);
        jocnou.setLocation(757,223);
    }
    public void act()
    {
        Check();
    }
    public void Check()
    {
        ok = jocnou.getClicked();
        if(debug) ok = true;
        if(ok)
        {
            Nivele.setViata0(true);
            Nivele.setViata1(true);
            Nivele.setViata2(true);
            Greenfoot.setWorld(new Nivel0());
        }
    }
}
