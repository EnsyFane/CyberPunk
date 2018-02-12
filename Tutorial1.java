import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Tutorial1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Tutorial1 extends PCx
{
    private int s=LumeScrolling.getRez();
    private GreenfootImage x = new GreenfootImage("Tutorial1.png");
    private Tutoriale tutorial1 = new Tutoriale(700,600,x);
    public Tutorial1()
    {
        this(40,40);
    }

    public Tutorial1(int lungime,int inaltime)
    {
        GreenfootImage image = getImage();
        image.scale(lungime*s/3,inaltime*s/3);
        setImage(image); 
    }

    public void afisare()
    {

        nivel = getWorld();
        nivel.addObject(tutorial1,750*s/3,300*s/3);
        afisatEcran = true;

    }

    public void stergere()
    {
        nivel.removeObject(tutorial1);
        afisatEcran = false;
    }
}
