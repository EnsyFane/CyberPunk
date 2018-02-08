import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Snd here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Snd extends PCx
{
    private int s=LumeScrolling.getRez();
    private static boolean k=false;
    private Esnd x = new Esnd(700,600);
    SondajA a = new SondajA();
    SondajB b = new SondajB();
    SondajC c = new SondajC();
    SondajD d = new SondajD();
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
    }

    public void afisare()
    {

        nivel = getWorld();
        nivel.addObject(x,750*s/3,300*s/3);
        nivel.addObject(a,700*s/3,223*s/3);
        nivel.addObject(b,603*s/3,263*s/3);
        nivel.addObject(c,594*s/3,301*s/3);
        nivel.addObject(d,750*s/3,343*s/3);
        afisatEcran = true;

    }

    public void stergere()
    {
        nivel.removeObject(x);
        nivel.removeObject(a);
        nivel.removeObject(b);
        nivel.removeObject(c);
        nivel.removeObject(d);
        afisatEcran = false;
        if(k)
        nivel.removeObject(this);
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
