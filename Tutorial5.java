import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Tutorial5 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Tutorial5 extends PCx
{
   private int s=LumeScrolling.getRez();
    private GreenfootImage x = new GreenfootImage("Tutorial5.png");
    private Tutoriale tutorial5 = new Tutoriale(700,600,x);
    public Tutorial5()
    {
        this(40,40);
    }

    public Tutorial5(int lungime,int inaltime)
    {
        GreenfootImage image = getImage();
        image.scale(lungime*s/3,inaltime*s/3);
        setImage(image); 
    }

    public void afisare()
    {

        nivel = getWorld();
        nivel.addObject(tutorial5,750*s/3,300*s/3);
        afisatEcran = true;

    }

    public void stergere()
    {
        nivel.removeObject(tutorial5);
        afisatEcran = false;
    }
}
