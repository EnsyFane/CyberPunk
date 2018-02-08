import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class JumpBoost here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class JumpBoost extends Pickup
{
    /**
     * Act - do whatever the JumpBoost wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private int s=LumeScrolling.getRez();
       public JumpBoost()
    {
        this(300,40);
    }
    
    public JumpBoost(int lungime , int inaltime)
    {
        GreenfootImage image = getImage();
        image.scale(lungime*s/3,inaltime*s/3);//Setam imaginea in functie de rezolutie
        setImage(image); 
    }
    
    public void act() 
    {
        // Add your action code here.
    }    
}
