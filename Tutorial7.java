import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Tutorial7 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Tutorial7 extends PCx
{
   private int s=LumeScrolling.getRez();
    private GreenfootImage x = new GreenfootImage("Tutorial7.png");
    private Tutoriale tutorial7 = new Tutoriale(700,600,x);
    public Tutorial7()
    {
        this(40,40);
    }

    public Tutorial7(int lungime,int inaltime)
    {
        GreenfootImage image = getImage();
        image.scale(lungime*s/3,inaltime*s/3);
        setImage(image); 
    }

    public void afisare()
    {

        nivel = getWorld();
        nivel.addObject(tutorial7,750*s/3,300*s/3);
        afisatEcran = true;

    }

    public void stergere()
    {
        nivel.removeObject(tutorial7);
        afisatEcran = false;
    }
}
