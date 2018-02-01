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
    //private final int gr=1;
    //int acceleratieg = 0;
    private int s=LumeScrolling.getRez();
    private int viteza;
    private int acceleratieg = 0;
    private int latime = getImage().getWidth();
    private int inaltime = getImage().getHeight();
    int k=1;
    public Cutie()
    {
        this(300,40);
    }
    
    public Cutie(int lungime , int inaltime)
    {
        s=LumeScrolling.getRez();
        GreenfootImage image = getImage();
        image.scale(lungime*s/3,inaltime*s/3);
        setImage(image);
    }
    
    public void act() 
    {
        // Add your action code here.
        viteza =Elev.getViteza();//Getting speed from the main actor
        Gravitatie();
        VerifMiscare();
    }
    
     public void Gravitatie()//Falling
    {
        int gr=1;
        
      setLocation(getX(),getY()+acceleratieg);
      if(VerifJos())
      {
          acceleratieg=0;
          while(VerifJos())
          {
              setLocation(getX(),getY()-1);  
          }
              setLocation(getX(),getY()+1); 
       }
      else 
      {
         

            if(s==2)
            {

                //Daca avem rezolutia setata pe 720p incetinim gravitatia
                if(k<=3)
                    acceleratieg+=gr;
                else k=1;
                k++;
            }
            else
            {
                //Daca avem rezolutia setata pe 1080p gravitatia functioneaza normal
                acceleratieg+=gr;
            }
          
      }
    }
    
    public void VerifMiscare()//Checking if it is pushed
    {
        
        if((getOneObjectAtOffset(latime /4 +8*s/3 ,inaltime /-4 ,Elev.class)!=null||getOneObjectAtOffset(latime /4 +8*s/3 ,inaltime /4 ,Elev.class)!=null)
        &&!BlocajStanga())
            setLocation(getX()-viteza,getY());
        if((getOneObjectAtOffset(latime /-4 -8*s/3 ,inaltime /-4 ,Elev.class)!=null||getOneObjectAtOffset(latime /-4 -8*s/3,inaltime /4 ,Elev.class)!=null)
        &&!BlocajDreapta())
            setLocation(getX()+viteza,getY());
    }
    
    public boolean VerifJos()//Checking under for objects
    {
        if(getY()>getWorld().getHeight()-65*s/3)
           return true;
        if(getOneObjectAtOffset(latime /2 ,inaltime /2 ,Platforma.class)!=null||getOneObjectAtOffset(latime /-2 ,inaltime /2 ,Platforma.class)!=null
        ||getOneObjectAtOffset(latime /2 ,inaltime /2 ,Cutie.class)!=null||getOneObjectAtOffset(latime /-2 ,inaltime /2 ,Cutie.class)!=null)
            return true;
        return false;
    }
    
    public boolean BlocajStanga()//Checking left for objects
    {
        if(getOneObjectAtOffset(latime /-2 -1 ,inaltime /-4 ,Platforma.class)!=null||getOneObjectAtOffset(latime /-2  -2,inaltime /4 ,Platforma.class)!=null
        ||getOneObjectAtOffset(latime /-2 -3*s/3,inaltime /-4 ,Cutie.class)!=null||getOneObjectAtOffset(latime /-2 -3*s/3,inaltime /4 ,Cutie.class)!=null
        ||getOneObjectAtOffset(latime /-2 +8*s/3 ,inaltime /-4 ,AI.class)!=null||getOneObjectAtOffset(latime /-2 +8*s/3,inaltime /4 ,AI.class)!=null)
            return true;
        return false;
    }
    
     public boolean BlocajDreapta()//Checking right for objects
    {
        if(getOneObjectAtOffset(latime /2 +1 ,inaltime /4 ,Platforma.class)!=null||getOneObjectAtOffset(latime /2  +1,inaltime /-4 ,Platforma.class)!=null
        ||getOneObjectAtOffset(latime /2 +2 ,inaltime /4 ,Cutie.class)!=null||getOneObjectAtOffset(latime /2 +2,inaltime /-4 ,Cutie.class)!=null
        ||getOneObjectAtOffset(latime /2 -8*s/3,inaltime /4 ,AI.class)!=null||getOneObjectAtOffset(latime /2 -8*s/3,inaltime /-4 ,AI.class)!=null)
            return true;
        return false;
    }
}
