import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Tutoriale here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Tutoriale extends Static
{

    private int s=LumeScrolling.getRez();
    public Tutoriale(int lungime,int inaltime,GreenfootImage x)
    {
        GreenfootImage image = x;
        image.scale(lungime*s/3,inaltime*s/3);
        setImage(image); 
    }
}
