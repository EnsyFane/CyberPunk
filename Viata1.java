import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Viata1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Viata1 extends Actor
{
    /**
     * Act - do whatever the Viata1 wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    boolean ok=true;
    private GreenfootImage viata100 = new GreenfootImage("InimaRosie.png");
    private GreenfootImage viata0 = new GreenfootImage("InimaGri.png");
     public Viata1()
    {
        this(41,41);
    }
    
    public Viata1(int lungime,int inaltime)
    {
        GreenfootImage image = getImage();
        image.scale(lungime,inaltime);
        setImage(image);
    }
    
    public void act() 
    {
        // Add your action code here.
        update();
    }
    
    public void update()
    {
        if(ok)
            setImage(viata100);
        else
            setImage(viata0);
    }
    
    public void Eliminat()
    {
        ok=false;
    }
    
     public boolean getOk()
    {
        return ok;
    }
    
    public void setOk(boolean x)
    {
        ok = x;
    }
}
