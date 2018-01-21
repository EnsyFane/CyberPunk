import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Nivele here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Nivele extends World
{

    /**
     * Constructor for objects of class Nivele.
     * 
     */
    private boolean pause = false,unpause = true,afisat = false,ok = false;
    boolean play = true;
    private static boolean okv0 = true,okv1 = true,okv2 = true;
    private static int width = 1024, height = 600;
    Pauza pauza = new Pauza(width,height);
    Viata0 viata0 = new Viata0(41, 41);
    Viata1 viata1 = new Viata1(41, 41);
    Viata2 viata2 = new Viata2(41, 41);
    public Nivele()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(width, height, 1);
        Elev elev = new Elev();
        addObject(elev,88,530);
        elev.setLocation(129,158);
        GreenfootImage bg = new GreenfootImage("cyberpunk-street.png"); 
        bg.scale(getWidth(), getHeight());
        setBackground(bg);
        setPaintOrder(Pauza.class,Elev.class,Platforma.class,Cutie.class,PC.class);
        addObject(viata0,width-41,37);
        addObject(viata1,width-41-50,37);
        addObject(viata2,width-41-50*2,37);
        viata0.setOk(okv0);
        viata1.setOk(okv1);
        viata2.setOk(okv2);
    }
 
    public void act()
    {
        String kInput = Greenfoot.getKey();
        okv0 = viata0.getOk();
        okv1 = viata1.getOk();
        okv2 = viata2.getOk();
        if(!okv2)
            play = false;
        if(unpause)
        {
            CheckPause(kInput);
            ok = true;
        }
        else if(pause)
        {
            CheckUnpause(kInput);
            ok = true;
        }
    }
  
    public void CheckPause(String key)
    {
        if(key != null)
        {
            if("f".equals(key))
            {
                if(!afisat)
                {
                    addObject(pauza,width/2,height/2);
                    afisat = true;
                }
                play = false;
                pause = true;
                unpause = false;
            }
        }
    }

    public void CheckUnpause(String key)
    {
        if(key != null)
        {
            if("f".equals(key))
            {
                removeObject(pauza);
                afisat = false;
                play = true;
                pause = false;
                unpause = true;
            }
        }
    }
        
    public void NivelUrmator()
    {
        
    }
    
    public void RestartNivel()
    {
        
    }
    
    public static void setViata0(boolean x)
    {
        okv0=x;
    }
    
    public static void setViata1(boolean x)
    {
        okv1=x;
    }
    
    public static void setViata2(boolean x)
    {
        okv2=x;
    }
    
    public static boolean getViata0()
    {
        return okv0;
    }
    
    public static boolean getViata1()
    {
        return okv1;
    }
    
    public static boolean getViata2()
    {
        return okv1;
    }
}
