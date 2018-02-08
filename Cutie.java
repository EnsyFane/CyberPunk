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
    private int s=LumeScrolling.getRez();//Retinem rezolutia (scala) jocului
    private int viteza;
    private int acceleratieg = 0;
    private int latime = getImage().getWidth();
    private int inaltime = getImage().getHeight();
    private int prox = 5;
    int k=1;
    public Cutie()
    {
        this(300,40);
    }
    
    public Cutie(int lungime , int inaltime)
    {
        s=LumeScrolling.getRez();
        GreenfootImage image = getImage();
        image.scale(lungime*s/3,inaltime*s/3);//Setam imaginea in functie de rezolutie
        setImage(image);
        if(s==2)
        prox=-4;
    }
    
    public void act() 
    {
        viteza =Elev.getViteza();//Folosim viteza caracterului pentru o animatie lina
        Gravitatie();//Simulam gravitatia
        VerifMiscare();//Verificam daca cutia este impinsa
    }
    
     public void Gravitatie()
    {
       //Simulam gravitatia
      setLocation(getX(),getY()+acceleratieg);//Actualizam pozitia cutiei
      if(VerifJos())//Daca se afla pe un solid setam viteza verticala la 0
      {
          acceleratieg=0;
          while(VerifJos())//Actualizam pozitia cutiei la suprafata solidului 
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
                    acceleratieg+=1;
                else k=1;
                k++;
            }
            else
            {
                //Daca avem rezolutia setata pe 1080p gravitatia functioneaza normal
                acceleratieg+=1;
            }
          
      }
    }
    
    public void VerifMiscare()
    {
        if((getOneObjectAtOffset(latime /4 +8*s/3 ,inaltime /-4 ,Elev.class)!=null||getOneObjectAtOffset(latime /4 +8*s/3 ,inaltime /4 ,Elev.class)!=null)//Verificam daca cutia este impinsa la stanga si nu avem blocaj la stanga
        &&!BlocajStanga())
            setLocation(getX()-viteza,getY());//Actualizam pozitia cutiei
        if((getOneObjectAtOffset(latime /-4 -8*s/3 ,inaltime /-4 ,Elev.class)!=null||getOneObjectAtOffset(latime /-4 -8*s/3,inaltime /4 ,Elev.class)!=null)//Verificam daca cutia este impinsa la dreapta si nu avem blocaj la dreapta
        &&!BlocajDreapta())
            setLocation(getX()+viteza,getY());//Actualizam pozitia cutiei
    }
    
    public boolean VerifJos()
    {
        if(getY()>getWorld().getHeight()-63*s/3)//Verificam daca cutia se afla pe sol 
           return true;
        if(getOneObjectAtOffset(latime /2 ,inaltime /2 ,Platforma.class)!=null||getOneObjectAtOffset(latime /-2 ,inaltime /2 ,Platforma.class)!=null//Verificam daca cutia se afla pe o platforma sau o cutie
        ||getOneObjectAtOffset(latime /2 ,inaltime /2 ,Cutie.class)!=null||getOneObjectAtOffset(latime /-2 ,inaltime /2 ,Cutie.class)!=null)
            return true;
        return false;
    }
    
    public boolean BlocajStanga()
    {
        //Verificam daca in stanga cutiei se afla o cutie, o platforma sau un inamic (AI)
        if(getOneObjectAtOffset(latime /-2 -prox ,inaltime /-2 ,Platforma.class)!=null||getOneObjectAtOffset(latime /-2  -prox,inaltime /2 ,Platforma.class)!=null
        ||getOneObjectAtOffset(latime /-2 -4*s/3,inaltime /-4 ,Cutie.class)!=null||getOneObjectAtOffset(latime /-2 -4*s/3,inaltime /4 ,Cutie.class)!=null
        ||getOneObjectAtOffset(latime /-2 +8*s/3 ,inaltime /-4 ,AI.class)!=null||getOneObjectAtOffset(latime /-2 +8*s/3,inaltime /4 ,AI.class)!=null)
            return true;
        return false;
    }
    
     public boolean BlocajDreapta()
    {
        //Verificam daca in dreapta cutiei se afla o cutie, o platforma sau un inamic (AI)
        if(getOneObjectAtOffset(latime /2 +prox  ,inaltime /2 ,Platforma.class)!=null||getOneObjectAtOffset(latime /2 +prox,inaltime /-2 ,Platforma.class)!=null
        ||getOneObjectAtOffset(latime /2 +4*s/3 ,inaltime /4 ,Cutie.class)!=null||getOneObjectAtOffset(latime /2 +4*s/3,inaltime /-4 ,Cutie.class)!=null
        ||getOneObjectAtOffset(latime /2 -8*s/3,inaltime /4 ,AI.class)!=null||getOneObjectAtOffset(latime /2 -8*s/3,inaltime /-4 ,AI.class)!=null)
            return true;
        return false;
    }
}
