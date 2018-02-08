import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Tutorial0 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Tutorial0 extends PCx
{
    /**
     * Act - do whatever the Tutorial0 wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private int s=LumeScrolling.getRez();
    private ETutorial0 tutorial0 = new ETutorial0(700,600);
    public Tutorial0()
    {
    this(40,40);
    }
    public Tutorial0(int lungime,int inaltime)
    {
    GreenfootImage image = getImage();
        image.scale(lungime*s/3,inaltime*s/3);
        setImage(image); 
    }
     public void afisare()
    {
   
    nivel = getWorld();
    nivel.addObject(tutorial0,750*s/3,300*s/3);
    afisatEcran = true;
    
    }
    public void stergere()
    {
    nivel.removeObject(tutorial0);
    afisatEcran = false;
    }
}
