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
    private boolean pornit = false; //Setam starea laserului ca oprit
    private int timpPornit,timpOprit,contor=0;
    private int lung,inal;
    private GreenfootImage lp;
    private GreenfootImage lo;
    private GreenfootImage image;
    public LaserOrizontal(int lungime,int ton,int toff)
    {
    //Cream imaginea laserului pe secvente (inceput si continuare)
    GreenfootImage inceputPornit = new GreenfootImage("LaserHst.png");
    GreenfootImage continuarePornit = new GreenfootImage("LaserHContinuare.png");
    GreenfootImage sfarsitPornit = new GreenfootImage("LaserHdr.png");
    GreenfootImage laserPornit = new GreenfootImage(lungime,inceputPornit.getHeight());
    laserPornit.drawImage(inceputPornit,0,0);
    for(int in=30;in<lungime;in+=inceputPornit.getWidth())
    {
    laserPornit.drawImage(continuarePornit,in,-1);
    }
    laserPornit.drawImage(sfarsitPornit,lungime-30,-1);
    
    GreenfootImage inceputOprit = new GreenfootImage("LaserOpritH.png");
    GreenfootImage continuareOprit= new GreenfootImage("LaserOpritContinuareH.png");
    GreenfootImage sfarsitOprit = new GreenfootImage("LaserOpritHdr.png");
    GreenfootImage laserOprit = new GreenfootImage(lungime,inceputPornit.getHeight());
    laserOprit.drawImage(inceputOprit,0,0);
    for(int in=30;in<lungime;in+=inceputOprit.getWidth())
    {
    laserOprit.drawImage(continuareOprit,in,-1);
    }
    laserOprit.drawImage(sfarsitOprit,lungime-30,-1);
   
    lp=laserPornit;
    lo=laserOprit;
    setImage(laserOprit);
    //Retinem cat timp trebuie sa fie pornit/oprit
    timpPornit = ton;
    timpOprit = toff;
    image = getImage();
    lung=image.getWidth();
    inal=image.getHeight();
    }
    public void act() 
    {
        if(pornit)//Daca laserul este pornit
        {
         if(contor==timpPornit)//Daca a fost pornit o perioada fixa de timp
            {
                //Oprim laserul
            contor = 0;
            pornit = false;
            setImage(lo);
            }
        
        }
        else//Daca laserul este oprit
        {
         if(contor==timpOprit)//Daca a fost oprit o perioada fixa de timp
         {
             //Pornim laserul
          contor = 0;
          pornit = true;
          setImage(lp);
         }
            
        
        }
        contor++;//Creste contorul
        image = getImage();
        image.scale(lung*s/3,inal*s/3);//Setam imaginea in functie de rezolutie
        setImage(image);
       checkActor();//Verificam daca se intersecteaza cu un actor
    }
    public void checkActor()
    {
        Actor actor;
        actor = getOneIntersectingObject(Elev.class);
    if(actor != null && pornit)//Daca se intersecteaza cu un actor
        {
            Sunete.Mort();
            //Scadem viata corespunzatoare
            if(LumeScrolling.getViata0())
                LumeScrolling.setViata0(false);
            else if(LumeScrolling.getViata1())
                LumeScrolling.setViata1(false);
            else
                LumeScrolling.setViata2(false);
            ((LumeScrolling)getWorld()).RestartNivel();//Restartam nivelul        
        
        } 
    
    }
}
