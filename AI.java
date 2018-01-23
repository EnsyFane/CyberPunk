import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class AI here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class AI extends Actor
{
    /**
     * Act - do whatever the AI wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private GreenfootImage mers0dr = new GreenfootImage("hell-hound-walk_0_dr.png");
    private GreenfootImage mers1dr = new GreenfootImage("hell-hound-walk_1_dr.png");
    private GreenfootImage mers2dr = new GreenfootImage("hell-hound-walk_2_dr.png");
    private GreenfootImage mers3dr = new GreenfootImage("hell-hound-walk_3_dr.png");
    private GreenfootImage mers4dr = new GreenfootImage("hell-hound-walk_4_dr.png");
    private GreenfootImage mers5dr = new GreenfootImage("hell-hound-walk_5_dr.png");
    private GreenfootImage mers6dr = new GreenfootImage("hell-hound-walk_6_dr.png");
    private GreenfootImage mers7dr = new GreenfootImage("hell-hound-walk_7_dr.png");
    private GreenfootImage mers8dr = new GreenfootImage("hell-hound-walk_8_dr.png");
    private GreenfootImage mers9dr = new GreenfootImage("hell-hound-walk_9_dr.png");
    private GreenfootImage mers10dr = new GreenfootImage("hell-hound-walk_10_dr.png");
    private GreenfootImage mers11dr = new GreenfootImage("hell-hound-walk_11_dr.png");
    private GreenfootImage mers0st = new GreenfootImage("hell-hound-walk_0.png");
    private GreenfootImage mers1st = new GreenfootImage("hell-hound-walk_1.png");
    private GreenfootImage mers2st = new GreenfootImage("hell-hound-walk_2.png");
    private GreenfootImage mers3st = new GreenfootImage("hell-hound-walk_3.png");
    private GreenfootImage mers4st = new GreenfootImage("hell-hound-walk_4.png");
    private GreenfootImage mers5st = new GreenfootImage("hell-hound-walk_5.png");
    private GreenfootImage mers6st = new GreenfootImage("hell-hound-walk_6.png");
    private GreenfootImage mers7st = new GreenfootImage("hell-hound-walk_7.png");
    private GreenfootImage mers8st = new GreenfootImage("hell-hound-walk_8.png");
    private GreenfootImage mers9st = new GreenfootImage("hell-hound-walk_9.png");
    private GreenfootImage mers10st = new GreenfootImage("hell-hound-walk_10.png");
    private GreenfootImage mers11st = new GreenfootImage("hell-hound-walk_11.png");
    private GreenfootImage saritura2 = new GreenfootImage("character_jump_2.png");
    private GreenfootImage saritura1 = new GreenfootImage("character_jump_1.png");
    private GreenfootImage idle0dr = new GreenfootImage("hell-hound-idle_0_dr.png");
    private GreenfootImage idle1dr = new GreenfootImage("hell-hound-idle_1_dr.png");
    private GreenfootImage idle2dr = new GreenfootImage("hell-hound-idle_2_dr.png");
    private GreenfootImage idle3dr = new GreenfootImage("hell-hound-idle_3_dr.png");
    private GreenfootImage idle4dr = new GreenfootImage("hell-hound-idle_4_dr.png");
    private GreenfootImage idle5dr = new GreenfootImage("hell-hound-idle_5_dr.png");
    private GreenfootImage idle0st = new GreenfootImage("hell-hound-idle_0.png");
    private GreenfootImage idle1st = new GreenfootImage("hell-hound-idle_1.png");
    private GreenfootImage idle2st = new GreenfootImage("hell-hound-idle_2.png");
    private GreenfootImage idle3st = new GreenfootImage("hell-hound-idle_3.png");
    private GreenfootImage idle4st = new GreenfootImage("hell-hound-idle_4.png");
    private GreenfootImage idle5st = new GreenfootImage("hell-hound-idle_5.png");
    private short cadru = 0,animare = 1,contor = 0;
    private final int gr = 1;
    private int acceleratieg ,distantaParcursa, distantaMaxima=200;
    private boolean st=false,dr = true;
    private int viteza = 4 , vitezaS = -15;
    private boolean pauza = false,decis = false;
    private boolean precedentIdle = false;
   
    public AI()
    {
        acceleratieg = 0;
        setImage(idle0dr);
        if(Greenfoot.getRandomNumber(2)==1)
        {
            st = true;
            dr = false;
            setImage(idle0dr);
        }
        else
        {
            st = false;
            dr = true;
            setImage(idle0st);
        } 
        GreenfootImage image = getImage();  
        image.scale(90, 45);
        setImage(image);
        
    }
    
    public void act() 
    {
        // Add your action code here
       if(!Pauza())
       {
           Gravitatie();
           if(contor<240)
           {
               Idle();
               contor++;
           }
           else
           {
               if(st)
               {
                   if(!decis)
                   {
                       distantaMaxima = 200+Greenfoot.getRandomNumber(200);
                       decis = true;
                   }
                   if(distantaParcursa>distantaMaxima)
                   {
                       contor= 0;
                       distantaParcursa = 0;
                       dr = true;
                       st = false;
                       decis = false;
                   }
                   else
                       DeplasareDreapta();
               }
               else
               {
                   if(!decis)
                   {
                       distantaMaxima = -200-Greenfoot.getRandomNumber(200);
                       decis =true;
                   }
                   if(distantaParcursa<distantaMaxima)
                   {
                       contor= 0;
                       distantaParcursa = 0;
                       dr = false;
                       st = true;
                       decis = false;
                   }
                   else
                    DeplasareStanga();
               }
           }
           animare++;
           if(animare > 8)
                animare = 1;
           GreenfootImage image = getImage();  
           image.scale(90, 45);
           setImage(image); 
       }
    }
    
    public void Gravitatie()
    {
      setLocation(getX(),getY() + acceleratieg);
      if(VerifJos())
      {
          acceleratieg = 0;
          while(VerifJos())
          {
              setLocation(getX(),getY() - 1);  
          }
          setLocation(getX(),getY() + 1); 
       }
      else if(acceleratieg<0&&BlocajSus())
      {
          acceleratieg = 0;
          while(BlocajSus())
                setLocation(getX(),getY() + 1);  
      }
      else 
            acceleratieg+=gr;
    
    }
    
    public void DeplasareDreapta()
    {
        int x = getX();
        if(!BlocajDreapta())
        {
            x+=viteza;
            distantaParcursa+=viteza;
        }
        else 
        {
            contor = 0; 
            dr = true;
            st = false;
            decis = false;
        }
        if(animare == 5 && (VerifJos()))
        {
            precedentIdle = false;
            AnimareDreapta();
        }
        setLocation(x,getY());
    }
    
    public void DeplasareStanga()
    {
        int x = getX();
        if(!BlocajStanga())
        {
            x-=viteza;
            distantaParcursa-=viteza;
        }
        else  
        {
            contor = 0;
            dr = false;
            st = true;
            decis = false;
        }
        if(animare == 5 && (VerifJos()))
        {
            precedentIdle = false;
            AnimareStanga();
        }
        setLocation(x,getY());
    }
    
    public void Idle()
    {
        if(animare == 8 && (VerifJos()))
        {
            if(dr)
                AnimareIdleDr();
            else 
                AnimareIdleSt();
        }
    }
    
    public void SarituraSt()
    {
        acceleratieg = vitezaS;
        AnimareSusSt();
    }
    
    public void SarituraDr()
    {
        acceleratieg = vitezaS;
        AnimareSusDr();
    }
    
    public void AnimareIdleDr()
    {
        if(cadru == 0)
            setImage(idle0dr);
        else if(cadru == 1)
            setImage(idle1dr);
        else if(cadru == 2)
            setImage(idle2dr);
        else if(cadru == 3)
            setImage(idle3dr);
        else if(cadru == 4)
            setImage(idle4dr);
        else 
        {
            setImage(idle5dr);
            if(!precedentIdle)
                cadru = 0;
            else
                cadru = 2;
            return;
        }
        precedentIdle = true;
        cadru++;
    }
    
    public void AnimareIdleSt()
    {
        if(cadru == 0)
            setImage(idle0st);
        else if(cadru == 1)
            setImage(idle1st);
        else if(cadru == 2)
            setImage(idle2st);
        else if(cadru == 3)
            setImage(idle3st);
        else if(cadru == 4)
            setImage(idle4st);
        else 
        {
            setImage(idle5st);
            if(!precedentIdle)
                cadru = 0;
            else
                cadru = 2;
            return;
        }
        precedentIdle = true;
        cadru++;
    }
    
    public void AnimareSusDr()
    {
        setImage(saritura1);
    }
    
     public void AnimareSusSt()
    {
        setImage(saritura2);
    }
    
    public void AnimareDreapta()
    {
        if(cadru == 0)
            setImage(mers0dr);
        else if(cadru == 1)
            setImage(mers1dr);
        else if(cadru == 2)
            setImage(mers2dr);
        else if(cadru == 3)
            setImage(mers3dr);
        else if(cadru == 4)
            setImage(mers4dr);
        else if(cadru == 5)
            setImage(mers5dr);
        else if(cadru == 6)
            setImage(mers6dr);
        else if(cadru == 7)
            setImage(mers7dr);
        else if(cadru == 8)
            setImage(mers8dr);
        else if(cadru == 9)
            setImage(mers9dr);
        else if(cadru == 10)
            setImage(mers10dr);
        else 
        {
            setImage(mers11dr);
            cadru = 0;
            return;
        }
        cadru++;
    }
    
    public void AnimareStanga()
    {
        if(cadru == 0)
            setImage(mers0st);
        else if(cadru == 1)
            setImage(mers1st);
        else if(cadru == 2)
            setImage(mers2st);
        else if(cadru == 3)
            setImage(mers3st);
        else if(cadru == 4)
            setImage(mers4st);
        else if(cadru == 5)
            setImage(mers5st);
        else if(cadru == 6)
            setImage(mers6st);
        else if(cadru == 7)
            setImage(mers7st);
        else if(cadru == 8)
            setImage(mers8st);
        else if(cadru == 9)
            setImage(mers9st);
        else if(cadru == 10)
            setImage(mers10st);
        else 
        {
            setImage(mers11st);
            cadru = 0;
            return;
        }
        cadru++;
    }
    
    public boolean VerifJos()
    {
        boolean ok = false;
        if(getY()>getWorld().getHeight()-70)
            ok = true;
        if(Jos(Platforma.class)||Jos(Cutie.class))
            ok = true;
        return ok;
    }
    
    public boolean BlocajSus()
    {
        boolean ok = false;
        int latime = getImage().getWidth();
        int inaltime = getImage().getHeight();
        if(Sus(Platforma.class)||Sus(Cutie.class))
            ok = true;
        return ok;
    }
    
    public boolean BlocajDreapta()
    {
        boolean ok = false;
        int latime = getImage().getWidth();
        int inaltime = getImage().getHeight();
        if(Dreapta(Platforma.class)||Dreapta(Cutie.class)||Dreapta(Spikes.class))
            ok = true;
        return ok;
    }
    
    public boolean BlocajStanga()
    {
        boolean ok = false;
        int latime = getImage().getWidth();
        int inaltime = getImage().getHeight();
        if(Stanga(Platforma.class)||Stanga(Cutie.class)||Stanga(Spikes.class))
            ok = true;
        return ok;
    }
    
    public boolean Pauza()
    {
        Nivele nivel = (Nivele) getWorld();
        return !nivel.play;
    }
    
    public boolean Jos(Class aux)
    {
        int latime = getImage().getWidth();
        int inaltime = getImage().getHeight();
        if(getOneObjectAtOffset(latime /4 ,inaltime /2 ,aux)!=null||getOneObjectAtOffset(latime /-4 ,inaltime /2,aux)!=null)
            return true;
        return false;
    }
    
    public boolean Sus(Class aux)
    {
        int latime = getImage().getWidth();
        int inaltime = getImage().getHeight();
        if(getOneObjectAtOffset(latime /4 +4,inaltime /-4 ,aux)!=null||getOneObjectAtOffset(latime /-4 ,inaltime /-4 -4 ,aux)!=null)
            return true;
        return false;
    }
    
    public boolean Stanga(Class aux)
    {
        int latime = getImage().getWidth();
        int inaltime = getImage().getHeight();
        if(getOneObjectAtOffset(latime /-4 -8 ,inaltime /-4 ,aux)!=null||getOneObjectAtOffset(latime /-4  -8,inaltime /4 ,aux)!=null)
            return true;
        return false;
    }
    
    public boolean Dreapta(Class aux)
    {
        int latime = getImage().getWidth();
        int inaltime = getImage().getHeight();
        if(getOneObjectAtOffset(latime /4 +8 ,inaltime /-4  ,aux)!=null||getOneObjectAtOffset(latime /4 +8,inaltime /4 ,aux)!=null)
            return true;
        return false;
    }
}