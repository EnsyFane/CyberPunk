import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Laser here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Laser extends Actor

{
    /**
     * Act - do whatever the Laser wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private boolean pornit = false;
    private int s=LumeScrolling.getRez();
    private int timpPornit,timpOprit,contor=0;
    private int lung,inal;
    private GreenfootImage lp;
    private GreenfootImage lo;
    private GreenfootImage image;
    public Laser(int inaltime,int ton,int toff)
    {
        GreenfootImage inceputPornit = new GreenfootImage("Laser.png");
        GreenfootImage continuarePornit = new GreenfootImage("LaserContinuare.png");
        GreenfootImage laserPornit = new GreenfootImage(inceputPornit.getWidth(),inaltime);
        laserPornit.drawImage(continuarePornit,0,0);
        for(int in=30;in<inaltime;in+=inceputPornit.getHeight())
        {
            laserPornit.drawImage(continuarePornit,0,in);
        }
        laserPornit.drawImage(inceputPornit,0,inaltime-30);

        GreenfootImage inceputOprit = new GreenfootImage("LaserOprit.png");
        GreenfootImage continuareOprit= new GreenfootImage("LaserOpritContinuare.png");
        GreenfootImage laserOprit = new GreenfootImage(inceputOprit.getWidth(),inaltime);
        laserOprit.drawImage(continuareOprit,0,0);
        for(int in=30;in<inaltime;in+=inceputOprit.getHeight())
        {
            laserOprit.drawImage(continuareOprit,0,in);
        }
        laserOprit.drawImage(inceputOprit,0,inaltime-30);
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
