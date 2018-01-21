import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class SpeedBoost here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SpeedBoost extends Actor
{
    /**
     * Act - do whatever the SpeedBoost wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public SpeedBoost()
    {
        this(300,40);
    }
    
    public SpeedBoost(int lungime , int inaltime)
    {
        GreenfootImage image = getImage();
        image.scale(lungime,inaltime);
        setImage(image);
    }
    
    public void act() 
    {
        // Add your action code here.
    }    
}
