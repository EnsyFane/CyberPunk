import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Elev here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Elev extends Actor
{
    /**
     * Act - do whatever the Elev wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private GreenfootImage alergare0dr = new GreenfootImage("character_run_0.png");
    private GreenfootImage alergare1dr = new GreenfootImage("character_run_1.png");
    private GreenfootImage alergare2dr = new GreenfootImage("character_run_2.png");
    private GreenfootImage alergare3dr = new GreenfootImage("character_run_3.png");
    private GreenfootImage alergare4dr = new GreenfootImage("character_run_4.png");
    private GreenfootImage alergare5dr = new GreenfootImage("character_run_5.png");
    private GreenfootImage alergare0st = new GreenfootImage("character_run_0_st.png");
    private GreenfootImage alergare1st = new GreenfootImage("character_run_1_st.png");
    private GreenfootImage alergare2st = new GreenfootImage("character_run_2_st.png");
    private GreenfootImage alergare3st = new GreenfootImage("character_run_3_st.png");
    private GreenfootImage alergare4st = new GreenfootImage("character_run_4_st.png");
    private GreenfootImage alergare5st = new GreenfootImage("character_run_5_st.png");
    private GreenfootImage saritura2 = new GreenfootImage("character_jump_2.png");
    private GreenfootImage saritura1 = new GreenfootImage("character_jump_1.png");
    private GreenfootImage idle0 = new GreenfootImage("character_idle_0.png");
    private GreenfootImage idle1 = new GreenfootImage("character_idle_1.png");
    private GreenfootImage idle2 = new GreenfootImage("character_idle_2.png");
    private GreenfootImage idle3 = new GreenfootImage("character_idle_3.png");
    private GreenfootImage idle0st = new GreenfootImage("character_idle_0_st.png");
    private GreenfootImage idle1st = new GreenfootImage("character_idle_1_st.png");
    private GreenfootImage idle2st = new GreenfootImage("character_idle_2_st.png");
    private GreenfootImage idle3st = new GreenfootImage("character_idle_3_st.png");
    private int cadru = 0,animare = 1;
    private final int gr = 1;
    int acceleratieg ;
    boolean st=false,dr = true;
    private int viteza = 4 , vitezaS = -15;
    private int contorBoostV = 0, contorBoostS = 0;
    private boolean pauza = false;
   
    public Elev()
    {
        acceleratieg = 0;
        setImage(idle0);
        GreenfootImage image = getImage();  
        image.scale(50, 50);
        setImage(image);
        
    }
    public void act() 
    {
        // Add your action code here
       if(!Pauza())
       {
        Gravitatie();
        VerifMiscare();
        VerifBooster();
        animare++;
        if(animare > 8)
         animare = 1;
        GreenfootImage image = getImage();  
        image.scale(50, 50);
        setImage(image);
        if(contorBoostV > 0)
         contorBoostV--;
        if(contorBoostS > 0)
         contorBoostS--;
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
    public void VerifMiscare()
    {int x = getX(),y = getY();
        boolean ok = false;
        if(contorBoostV == 0)
            viteza = 4;
        
        if(Greenfoot.isKeyDown("left"))
        {
            ok = true;
            st = true;
            dr = false;
            if(!BlocajStanga())
                x-=viteza;
            if(animare == 5 && (VerifJos()))
                AnimareStanga();
        }
        if(Greenfoot.isKeyDown("right"))
        {
            ok = true;
            st = false;
            dr = true;
            if(!BlocajDreapta())
                x+=viteza;
            if(animare == 5 && (VerifJos()))
              AnimareDreapta();
        }
        if(Greenfoot.isKeyDown("up") && (VerifJos()))
        {
         if(st)
            SarituraSt();
         else
            SarituraDr();
        }
        setLocation(x,y);
        if(animare == 8 && !ok && (VerifJos()))
        {
          if(dr)
            AnimareIdleDr();
          else 
            AnimareIdleSt();
        }
    }
    public void SarituraSt()
    {
        if(contorBoostS == 0)
            vitezaS = -15;
        acceleratieg = vitezaS;
        AnimareSusSt();
    }
    public void SarituraDr()
    {
        if(contorBoostS == 0)
            vitezaS = -15;
        acceleratieg = vitezaS;
        AnimareSusDr();
    }
    public void AnimareIdleDr()
    {
        if(cadru == 0)
        setImage(idle0);
        else if(cadru == 1)
        setImage(idle1);
      else if(cadru == 2)
        setImage(idle2);
      else 
      {
          setImage(idle3);
          cadru = 0;
          return;
       }
       cadru++;
    }
    public void AnimareIdleSt()
    {
       if(cadru==0)
        setImage(idle0st);
       else if(cadru==1)
        setImage(idle1st);
       else if(cadru==2)
        setImage(idle2st);
       else 
       {
           setImage(idle3st);
           cadru = 0;
           return;
       }
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
            setImage(alergare0dr);
        else if(cadru == 1)
            setImage(alergare1dr);
        else if(cadru == 2)
            setImage(alergare2dr);
        else if(cadru == 3)
            setImage(alergare3dr);
        else if(cadru == 4)
            setImage(alergare4dr);
        else 
        {
            setImage(alergare5dr);
            cadru = 0;
            return;
        }
        cadru++;
    }
    public void AnimareStanga()
    {
        if(cadru == 0)
            setImage(alergare0st);
        else if(cadru == 1)
            setImage(alergare1st);
        else if(cadru == 2)
            setImage(alergare2st);
        else if(cadru == 3)
            setImage(alergare3st);
        else if(cadru == 4)
            setImage(alergare4st);
        else 
        {
            setImage(alergare5st);
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
        int latime = getImage().getWidth();
        int inaltime = getImage().getHeight();
        if(getOneObjectAtOffset(latime /4 ,inaltime /2 ,Platforma.class)!=null||getOneObjectAtOffset(latime /-4 ,inaltime /2 ,Platforma.class)!=null
        ||getOneObjectAtOffset(latime /4 ,inaltime /2 ,Cutie.class)!=null||getOneObjectAtOffset(latime /-4 ,inaltime /2 ,Cutie.class)!=null)
            ok = true;
        if(getOneObjectAtOffset(latime /4 ,inaltime /2 ,Spikes.class)!=null||getOneObjectAtOffset(latime /-4 ,inaltime /2 ,Spikes.class)!=null)
        {   
            if(Nivele.getViata0())
                Nivele.setViata0(false);
            else if(Nivele.getViata1())
                Nivele.setViata1(false);
            else 
                Nivele.setViata2(false);
            ((Nivele)getWorld()).RestartNivel();
        }
        return ok;
    }
    public boolean BlocajSus()
    {
        boolean ok = false;
        int latime = getImage().getWidth();
        int inaltime = getImage().getHeight();
        if(getOneObjectAtOffset(latime /4 +4,inaltime /-4 ,Platforma.class)!=null||getOneObjectAtOffset(latime /-4 ,inaltime /-4 -4 ,Platforma.class)!=null
        ||getOneObjectAtOffset(latime /4 +4,-inaltime /-4 ,Cutie.class)!=null||getOneObjectAtOffset(latime /-4 -4,inaltime /-4 ,Cutie.class)!=null)
            ok = true;
        return ok;
    }
    public boolean BlocajDreapta()
    {
        boolean ok = false;
        int latime = getImage().getWidth();
        int inaltime = getImage().getHeight();
        if(getOneObjectAtOffset(latime /4 +8 ,inaltime /-4  ,Platforma.class)!=null||getOneObjectAtOffset(latime /4 +8,inaltime /4 ,Platforma.class)!=null
        ||getOneObjectAtOffset(latime /4 +8,inaltime /-4 ,Cutie.class)!=null||getOneObjectAtOffset(latime /4 +8,inaltime /4 ,Cutie.class)!=null
        ||getOneObjectAtOffset(latime /4 +1 ,inaltime /-4 ,Spikes.class)!=null||getOneObjectAtOffset(latime /4 +1 ,inaltime /4 ,Spikes.class)!=null)
            ok = true;
        return ok;
    }
    public boolean BlocajStanga()
    {
        boolean ok = false;
        int latime = getImage().getWidth();
        int inaltime = getImage().getHeight();
        if(getOneObjectAtOffset(latime /-4 -8 ,inaltime /-4 ,Platforma.class)!=null||getOneObjectAtOffset(latime /-4  -8,inaltime /4 ,Platforma.class)!=null
        ||getOneObjectAtOffset(latime /-4 -8 ,inaltime /-4 ,Cutie.class)!=null||getOneObjectAtOffset(latime /-4  -8,inaltime /4 ,Cutie.class)!=null
        ||getOneObjectAtOffset(latime /-4 -1 ,inaltime /-4 ,Spikes.class)!=null||getOneObjectAtOffset(latime /-4  -1,inaltime /4 ,Spikes.class)!=null)
            ok = true;
        return ok;
    }
    public void VerifBooster()
    {
        BoostViteza();
        BoostSaritura();
    }
    public void BoostViteza()
    {
        Actor speedb;
        speedb = getOneObjectAtOffset(0,10,SpeedBoost.class);
        if(speedb != null)
        {
            contorBoostV = 50;
            viteza = 8;
            World nivel;
            nivel = getWorld();
            nivel.removeObject(speedb);
        }
    }
    public void BoostSaritura()
    {
        Actor sariturab;
        sariturab = getOneObjectAtOffset(0,10,JumpBoost.class);
        if(sariturab != null)
        {
            contorBoostS=20;
            vitezaS = -20;
            World nivel;
            nivel = getWorld();
            nivel.removeObject(sariturab);
        }
    }
    /*public void PcSchimbareNivel()
    {
      Actor pc;
    pc = getOneObjectAtOffset(0,3,PC.class);
    if(pc!=null)
    {
       
       
    }
    }*/
    public boolean Pauza()
    {
        Nivele nivel =(Nivele) getWorld();
    return !nivel.play;
    }
}
