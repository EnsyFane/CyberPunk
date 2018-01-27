import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Tutorial1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ETutorial0 extends Tutoriale
{
    /**
     * Act - do whatever the Tutorial1 wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private int s=Nivele.getRez();
    public ETutorial0()
    {
    this(40,40);
    }
    public ETutorial0(int lungime,int inaltime)
    {
    GreenfootImage image = getImage();
        image.scale(lungime*s/3,inaltime*s/3);
        setImage(image); 
    }
    
}
