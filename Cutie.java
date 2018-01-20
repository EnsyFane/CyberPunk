import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Platforma here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Cutie extends Actor
{
    /**
     * Act - do whatever the Platforma wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
   private final int gr=1;
   int acceleratieg = 0;
    public Cutie()
    {
    this(300,40);
    
    }
    public Cutie(int lungime , int inaltime)
    {
    GreenfootImage image = getImage();
    image.scale(lungime,inaltime);
    setImage(image);
    
    }
    public void act() 
    {
        // Add your action code here.
        Gravitatie();
        VerifMiscare();
       
    }
     public void Gravitatie()
    {
      setLocation(getX(),getY()+acceleratieg);
      if(VerifJos())
      {acceleratieg=0;
          while(VerifJos())
          {
          setLocation(getX(),getY()-1);  
          }
          setLocation(getX(),getY()+1); 
          
       }
      else acceleratieg+=gr;
    
    }
    
    public void VerifMiscare()
    {
     int latime = getImage().getWidth();
    int inaltime = getImage().getHeight();
    if((getOneObjectAtOffset(latime /4 +8 ,inaltime /-4 ,Elev.class)!=null||getOneObjectAtOffset(latime /4 +8 ,inaltime /4 ,Elev.class)!=null)
    &&!BlocajStanga())
    setLocation(getX()-2,getY());
    if((getOneObjectAtOffset(latime /-4 -8 ,inaltime /-4 ,Elev.class)!=null||getOneObjectAtOffset(latime /-4  -8,inaltime /4 ,Elev.class)!=null)
    &&!BlocajDreapta())
    setLocation(getX()+2,getY());
    
    }
    public boolean VerifJos()
    {
    boolean ok=false;
    if(getY()>getWorld().getHeight()-63)
    ok=true;
    int latime = getImage().getWidth();
    int inaltime = getImage().getHeight();
    if(getOneObjectAtOffset(latime /2 ,inaltime /2 ,Platforma.class)!=null||getOneObjectAtOffset(latime /-2 ,inaltime /2 ,Platforma.class)!=null
     ||getOneObjectAtOffset(latime /2 ,inaltime /2 ,Cutie.class)!=null||getOneObjectAtOffset(latime /-2 ,inaltime /2 ,Cutie.class)!=null)
    ok=true;
    return ok;
    }
    public boolean BlocajStanga()
    {
    boolean ok=false;
    int latime = getImage().getWidth();
    int inaltime = getImage().getHeight();
    if(getOneObjectAtOffset(latime /-2 -1 ,inaltime /-4 ,Platforma.class)!=null||getOneObjectAtOffset(latime /-2  -2,inaltime /4 ,Platforma.class)!=null
     ||getOneObjectAtOffset(latime /-2 -3 ,inaltime /-4 ,Cutie.class)!=null||getOneObjectAtOffset(latime /-2 -3,inaltime /4 ,Cutie.class)!=null)
   ok=true;
    return ok;
    }
     public boolean BlocajDreapta()
    {
    boolean ok=false;
    int latime = getImage().getWidth();
    int inaltime = getImage().getHeight();
    if(getOneObjectAtOffset(latime /2 +1 ,inaltime /4 ,Platforma.class)!=null||getOneObjectAtOffset(latime /2  +1,inaltime /-4 ,Platforma.class)!=null
     ||getOneObjectAtOffset(latime /2 +2 ,inaltime /4 ,Cutie.class)!=null||getOneObjectAtOffset(latime /2 +2,inaltime /-4 ,Cutie.class)!=null)
   ok=true;
    return ok;
    
    }
     
}
