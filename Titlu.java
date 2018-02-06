import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Titlu here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Titlu extends Actor
{
    /**
     * Act - do whatever the Titlu wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public Titlu()
    {
        this(818,122);
        
    }
    
    public Titlu(int lungime , int inaltime)
    {
        int s=StartScreen.getRez();
        GreenfootImage image = getImage();
        image.scale(lungime*s/3,inaltime*s/3);//Setam imaginea in functie de rezolutie
        setImage(image);    
    }  
}
