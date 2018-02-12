import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Tutorial2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Tutorial2 extends PCx
{
    private int s=LumeScrolling.getRez();
    private GreenfootImage x = new GreenfootImage("Tutorial2.png");
    private Tutoriale tutorial2 = new Tutoriale(700,600,x);
    public Tutorial2()
    {
        this(40,40);
    }

    public Tutorial2(int lungime,int inaltime)
    {
        GreenfootImage image = getImage();
        image.scale(lungime*s/3,inaltime*s/3);
        setImage(image); 
    }

    public void afisare()
    {

        nivel = getWorld();
        nivel.addObject(tutorial2,750*s/3,300*s/3);
        afisatEcran = true;

    }

    public void stergere()
    {
        nivel.removeObject(tutorial2);
        afisatEcran = false;
    }
}
