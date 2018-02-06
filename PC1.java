import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class PC1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PC1 extends PC
{
    /**
     * Act - do whatever the PC1 wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private int s=LumeScrolling.getRez();

    Intrebare1 intrebare1 = new Intrebare1(700,600);
    ZeroA a = new ZeroA();
    ZeroB b = new ZeroB();
    ZeroC c = new ZeroC();
    ZeroD d = new ZeroD();
    public PC1()
    {
        this(40,40);
    }

    public PC1(int lungime,int inaltime)
    {
        GreenfootImage image = getImage();
        image.scale(lungime*s/3,inaltime*s/3);
        setImage(image); 
    }

    public void afisare()
    {

        nivel = getWorld();
        nivel.addObject(intrebare1,750*s/3,300*s/3);
        nivel.addObject(a,750*s/3,223*s/3);
        nivel.addObject(b,750*s/3,263*s/3);
        nivel.addObject(c,750*s/3,303*s/3);
        nivel.addObject(d,750*s/3,343*s/3);
        afisatEcran = true;

    }

    public void stergere()
    {
        nivel.removeObject(intrebare1);
        nivel.removeObject(a);
        nivel.removeObject(b);
        nivel.removeObject(c);
        nivel.removeObject(d);
        afisatEcran = false;
    }

}
