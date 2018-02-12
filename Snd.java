import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Snd here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Snd extends PCx
{
    private static int s=LumeScrolling.getRez();
    private static boolean k=false;
    private static Intrebare y = new Intrebare(700,600,new GreenfootImage("haha.png"));
    private static Intrebare x = new Intrebare(700,600,new GreenfootImage("Sondaj.png"));
    private static SondajA a = new SondajA();
    private static SondajB b = new SondajB();
    private static SondajC c = new SondajC();
    private static SondajD d = new SondajD();
    private static boolean trist = false;
    private static World nv;
    public Snd()
    {
        this(40,40);
    }

    public Snd(int lungime,int inaltime)
    {
        GreenfootImage image = getImage();
        image.scale(lungime*s/3,inaltime*s/3);
        setImage(image);
        k=false;
        trist = false;
    }

    public void afisare()
    {

        nv = getWorld();
        nv.addObject(x,750*s/3,300*s/3);
        nv.addObject(a,700*s/3,223*s/3);
        nv.addObject(b,603*s/3,263*s/3);
        nv.addObject(c,594*s/3,301*s/3);
        nv.addObject(d,750*s/3,343*s/3);
        afisatEcran = true;

    }

    public  void stergere()
    {
        nv.removeObject(x);
        nv.removeObject(a);
        nv.removeObject(b);
        nv.removeObject(c);
        nv.removeObject(d);
        afisatEcran = false;
        if(k)
            nv.removeObject(this);
        if(trist)
            nv.removeObject(y);
    }

    public static void replace()
    {        
        nv.removeObject(x);
        nv.removeObject(a);
        nv.removeObject(b);
        nv.removeObject(c);
        nv.removeObject(d);
        nv.addObject(y,750*s/3,300*s/3);
        trist = true;

    }

    public static void setK(boolean aux)
    {
        k=aux;
    }

    public static boolean getK()
    {
        return k;
    }

}
