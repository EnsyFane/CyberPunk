import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class CPU here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CPU extends Pickup
{
    private int s=LumeScrolling.getRez();
      public CPU()
    {
        this(25,25);
    }
    
    public CPU(int lungime , int inaltime)
    {
        GreenfootImage image = getImage();
        image.scale(lungime*s/3,inaltime*s/3);//Setam imaginea in functie de rezolutie
        setImage(image); 
    }
}
