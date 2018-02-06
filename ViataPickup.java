import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class ViataPickup here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ViataPickup extends Pickup
{
    int s=LumeScrolling.getRez();
       public ViataPickup()
    {
        this(300,40);
    }
    
    public ViataPickup(int lungime , int inaltime)
    {
        //Setam imaginea in functie de rezolutie
        GreenfootImage image = getImage();
        image.scale(lungime*s/3,inaltime*s/3);
        setImage(image); 
    }
    
    public void act() 
    {
        // Add your action code here.
    }    
}
