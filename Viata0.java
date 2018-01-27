import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Viata0 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Viata0 extends Actor
{
    /**
     * Act - do whatever the Viata0 wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private static boolean ok=true;
    private GreenfootImage viata100 = new GreenfootImage("InimaRosie.png");
    private GreenfootImage viata0 = new GreenfootImage("InimaGri.png");
    private int x,y;
    public Viata0()
    {
        this(41,41);
        update();
    }
    
    public Viata0(int lungime,int inaltime)
    {
        int s=Nivele.getRez();
        x=lungime*s/3;
        y=inaltime*s/3;
        GreenfootImage image = getImage();
        image.scale(lungime*s/3,inaltime*s/3);
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
            {
            setImage(viata100);
            GreenfootImage image = getImage();
            image.scale(x,y);
            setImage(image);
            }
        else
            {
            setImage(viata0);
            GreenfootImage image = getImage();
            image.scale(x,y);
            setImage(image);
            }
    }
    
    public void Eliminat()
    {
        ok=false;
    }
    
    public boolean getOk()
    {
        return ok;
    }
    
    public static void setOk(boolean x)
    {
        ok = x;
    }
}
