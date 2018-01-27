import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class ViataPickup here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ViataPickup extends Actor
{
    int s=Nivele.getRez();
       public ViataPickup()
    {
        this(300,40);
    }
    
    public ViataPickup(int lungime , int inaltime)
    {
        GreenfootImage image = getImage();
        image.scale(lungime*s/3,inaltime*s/3);
        setImage(image); 
    }
    
    public void act() 
    {
        // Add your action code here.
    }    
}
