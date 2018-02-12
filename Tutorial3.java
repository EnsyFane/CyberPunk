import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Tutorial3 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Tutorial3 extends PCx
{
    private int s=LumeScrolling.getRez();
    private GreenfootImage x = new GreenfootImage("Tutorial3.png");
    private Tutoriale tutorial3 = new Tutoriale(700,600,x);
    public Tutorial3()
    {
        this(40,40);
    }

    public Tutorial3(int lungime,int inaltime)
    {
        GreenfootImage image = getImage();
        image.scale(lungime*s/3,inaltime*s/3);
        setImage(image); 
    }

    public void afisare()
    {

        nivel = getWorld();
        nivel.addObject(tutorial3,750*s/3,300*s/3);
        afisatEcran = true;

    }

    public void stergere()
    {
        nivel.removeObject(tutorial3);
        afisatEcran = false;
    }
}
