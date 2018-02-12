import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Intrebari here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Intrebare extends Static
{
    private int s=LumeScrolling.getRez();
    public Intrebare(int lungime,int inaltime,GreenfootImage x)
    {
        GreenfootImage image = x;
        image.scale(lungime*s/3,inaltime*s/3);
        setImage(image); 

    }
}
