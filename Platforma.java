import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Platforma here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Platforma extends Actor
{
    /**
     * Act - do whatever the Platforma wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private int s=LumeScrolling.getRez();
    public Platforma(int lungime)
    {
        GreenfootImage stock = new GreenfootImage("bricks3.jpg");
        GreenfootImage platforma = new GreenfootImage(lungime,40);
        for(int x=0;x<lungime;x+=40)
        {
            platforma.drawImage(stock,x,0);
        }
        setImage(platforma);
        GreenfootImage image = getImage();
        image.scale(lungime*s/3,40*s/3);
        setImage(image);
    }
    
    public void act() 
    {
        // Add your action code here.
    }    
}
