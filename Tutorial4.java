import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Tutorial4 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Tutorial4 extends PCx
{
    private int s=LumeScrolling.getRez();
    private GreenfootImage x = new GreenfootImage("Tutorial4.png");
    private Tutoriale tutorial4 = new Tutoriale(700,600,x);
    public Tutorial4()
    {
        this(40,40);
    }

    public Tutorial4(int lungime,int inaltime)
    {
        GreenfootImage image = getImage();
        image.scale(lungime*s/3,inaltime*s/3);
        setImage(image); 
    }

    public void afisare()
    {

        nivel = getWorld();
        nivel.addObject(tutorial4,750*s/3,300*s/3);
        afisatEcran = true;

    }

    public void stergere()
    {
        nivel.removeObject(tutorial4);
        afisatEcran = false;
    }
}
