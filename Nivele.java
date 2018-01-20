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
    private boolean pause=false,unpause=true,afisat = false,ok= false;
    boolean play=true;
    boolean okv0,okv1,okv2;
    Pauza pauza = new Pauza(100,100);
    Viata0 viata0 = new Viata0(41, 41);
    Viata1 viata1 = new Viata1(41, 41);
    Viata2 viata2 = new Viata2(41, 41);
  public Nivele()
  {    
    // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
    super(1500, 600, 1);
    Elev elev = new Elev();
    addObject(elev,88,530);
    elev.setLocation(129,158);
    GreenfootImage bg = new GreenfootImage("cyberpunk-street.png"); 
    bg.scale(getWidth(), getHeight());
    setBackground(bg);
    setPaintOrder(Elev.class,Platforma.class,Cutie.class,PC.class);
    addObject(viata0,1441,37);
    addObject(viata1,1391,37);
    addObject(viata2,1341,37);
    okv0 = viata0.getOk();
    okv1 = viata1.getOk();
    okv2 = viata2.getOk();
  }
 
    public void act()
  {
    String kInput = Greenfoot.getKey();
    if(!okv0)
     play = false;
    if(unpause)
    {CheckPause(kInput);
     ok = true;
    }
    else if(pause)
    {CheckUnpause(kInput);
     ok = true;
    }
    viata0.setOk(okv0);
    viata1.setOk(okv1);
    viata2.setOk(okv2);
  }
  
  public void CheckPause(String key)
  {
   if(key != null)
   {
    if("f".equals(key))
    {
     if(!afisat)
     {addObject(pauza,750,300);
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
}
