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
    public Platforma()
    {
    this(300,40);
    }
    public Platforma(int lungime , int inaltime)
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
