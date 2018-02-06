import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Intrebare1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Intrebare1 extends Intrebari
{
    /**
     * Act - do whatever the Intrebare1 wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private int s=LumeScrolling.getRez();
    
    public Intrebare1()
    {
    this(40,40);
    }
    public Intrebare1(int lungime,int inaltime)
    {
    GreenfootImage image = getImage();
        image.scale(lungime*s/3,inaltime*s/3);
        setImage(image); 
    
    }

}
