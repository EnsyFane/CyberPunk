import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class PC1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PC0 extends PC
{
    /**
     * Act - do whatever the PC1 wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private int s=LumeScrolling.getRez();
    private GreenfootImage aux = new GreenfootImage("Intrebare1.png");
    private Intrebare intrebare1 = new Intrebare(700,600,aux);
    private GreenfootImage Ai = new GreenfootImage("0A.png");
    private GreenfootImage AiIn = new GreenfootImage("0Ain.png");
    private GreenfootImage Bi = new GreenfootImage("0B.png");
    private GreenfootImage BiIn = new GreenfootImage("0Bin.png");
    private GreenfootImage Ci = new GreenfootImage("0C.png");
    private GreenfootImage CiIn = new GreenfootImage("0Cin.png");
    private GreenfootImage Di = new GreenfootImage("0D.png");
    private GreenfootImage DiIn = new GreenfootImage("0Din.png");
    private RaspunsG a = new RaspunsG(Ai,AiIn);
    private RaspunsC b = new RaspunsC(Bi,BiIn);
    private RaspunsG c = new RaspunsG(Ci,CiIn);
    private RaspunsG d = new RaspunsG(Di,DiIn);

    public PC0()
    {
        this(40,40);
    }

    public PC0(int lungime,int inaltime)
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
