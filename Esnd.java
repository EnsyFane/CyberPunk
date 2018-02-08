import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Esnd here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Esnd extends Intrebari
{
    /**
     * Act - do whatever the Esnd wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private int s=LumeScrolling.getRez();
    private int x,y;
    public Esnd()
    {
    this(40,40);
    }
    public Esnd(int lungime,int inaltime)
    {
    GreenfootImage image = getImage();
        image.scale(lungime*s/3,inaltime*s/3);
        setImage(image); 
    x=lungime;
    y=inaltime;
    }
    public void setK(GreenfootImage aux)
    {
    aux.scale(x*s/3,y*s/3);
    setImage(aux); 
    }
}
