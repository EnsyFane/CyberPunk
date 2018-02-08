import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class CPUS here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CPUS extends Static
{
    /**
     * Act - do whatever the CPUS wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private int s=LumeScrolling.getRez();
    private boolean ok;
    private int x,y;
    private GreenfootImage aux;
    public CPUS()
    {
        this(40,40);
    }
    
    public CPUS(int lungime , int inaltime)
    {
        GreenfootImage image = getImage();
        image.scale(lungime*s/3,inaltime*s/3);//Setam imaginea in functie de rezolutie
        setImage(image); 
        x=lungime;
        y=inaltime;
        aux= new GreenfootImage("CPU.png");
    }
    public void act() 
    {
        ok=LumeScrolling.getCpu();
        if(ok)
        {
        setImage(aux);
        GreenfootImage image = getImage();
        image.scale(x*s/3,y*s/3);//Setam imaginea in functie de rezolutie
        setImage(image); 
        }

    }    
}
