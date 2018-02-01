import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class LaserOrizontal here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class LaserOrizontal extends Actor
{
    private int s=LumeScrolling.getRez();
    private boolean pornit = false;
    private int timpPornit,timpOprit,contor=0;
    private int lung,inal;
    private GreenfootImage lp;
    private GreenfootImage lo;
    private GreenfootImage image;
    public LaserOrizontal(int lungime,int ton,int toff)
    {
        GreenfootImage inceputPornit = new GreenfootImage("LaserHst.png");
        GreenfootImage continuarePornit = new GreenfootImage("LaserHContinuare.png");
        GreenfootImage laserPornit = new GreenfootImage(lungime,inceputPornit.getHeight());
        laserPornit.drawImage(inceputPornit,0,0);
        for(int in=30;in<lungime;in+=inceputPornit.getWidth())
        {
            laserPornit.drawImage(continuarePornit,in,-1);
        }
        GreenfootImage inceputOprit = new GreenfootImage("LaserOpritH.png");
        GreenfootImage continuareOprit= new GreenfootImage("LaserOpritContinuareH.png");
        GreenfootImage laserOprit = new GreenfootImage(lungime,inceputPornit.getHeight());
        laserOprit.drawImage(inceputOprit,0,0);
        for(int in=30;in<lungime;in+=inceputOprit.getWidth())
        {
            laserOprit.drawImage(continuareOprit,in,-1);
        }
        lp=laserPornit;
        lo=laserOprit;
        setImage(laserOprit);
        timpPornit = ton;
        timpOprit = toff;
        image = getImage();
        lung=image.getWidth();
        inal=image.getHeight();
    }
    
    public void act() 
    {
        // Add your action code here.
        if(pornit)
        {
            if(contor==timpPornit)
            {
                contor = 0;
                pornit = false;
                setImage(lo);
            }
        }
        else
        {
            if(contor==timpOprit)
            {
                contor = 0;
                pornit = true;
                setImage(lp);
            }
        }
        contor++;
        image = getImage();
        image.scale(lung*s/3,inal*s/3);
        setImage(image);
        checkActor();
    }
    
    public void checkActor()
    {
        Actor actor;
        actor = getOneIntersectingObject(Elev.class);
        if(actor != null && pornit)
        {
            if(LumeScrolling.getViata0())
                LumeScrolling.setViata0(false);
            else if(LumeScrolling.getViata1())
                LumeScrolling.setViata1(false);
            else
                LumeScrolling.setViata2(false);
            ((LumeScrolling)getWorld()).RestartNivel();             
        } 
    }
}
