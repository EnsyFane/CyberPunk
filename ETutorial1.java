import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class ETutorial1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ETutorial1 extends Tutoriale
{
    /**
     * Act - do whatever the ETutorial1 wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private int s=LumeScrolling.getRez();
    public ETutorial1()
    {
    this(40,40);
    }
    public ETutorial1(int lungime,int inaltime)
    {
    GreenfootImage image = getImage();
        image.scale(lungime*s/3,inaltime*s/3);
        setImage(image); 
    }
}
