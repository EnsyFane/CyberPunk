import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Spikes here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Spikes extends Actor
{
    /**
     * Act - do whatever the Spikes wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public Spikes()
    {
        this(30,30);
    }
    
    public Spikes(int lungime,int inaltime)
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
