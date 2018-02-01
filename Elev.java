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
    private int s=LumeScrolling.getRez();
    
    private double acceleratieg ;
    boolean st=false,dr = true;
    private double vitezaS = -15*s/3;
    private static double viteza=4;
    private int contorBoostV = 0, contorBoostS = 0;
    private boolean pauza = false;
    int k=1;

    public Elev()
    {
        System.gc();
        acceleratieg = 0;
        s=LumeScrolling.getRez();
        if(s==2)//Daca avem rezolutia setata pe 720p incetinim viteza de miscare altfel aceasta functioneaza normal
            viteza=3;
        setImage(idle0);
        GreenfootImage image = getImage();  
        image.scale(50*s/3, 50*s/3);
        setImage(image); 
    }

    public void act() 
    {
        // Add your action code here
        if(!Pauza())
        {
            Gravitatie();
            VerifMort();
            VerifMiscare();
            VerifBooster();
            PikcupViata();
            animare++;
            if(animare > 8)
                animare = 1;
            GreenfootImage image = getImage();  
            image.scale(50*s/3, 50*s/3);
            setImage(image);
            if(contorBoostV > 0)
                contorBoostV--;
            if(contorBoostS > 0)
                contorBoostS--;
        }
    }

    public void Gravitatie()
    {
        int gr = 1;
        setLocation(getX(),getY() + (int)acceleratieg);
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

    public void VerifMiscare()
    {   double x = getX(),y = getY();
        boolean ok = false;
        if(contorBoostV == 0)
        {
            if(s==2)//Daca avem rezolutia setata pe 720p incetinim viteza de miscare
                viteza = 3;
            else //Daca avem rezolutia setata pe 1080p viteza de miscare functioneaza normal
                viteza =4;
        }
        if(Greenfoot.isKeyDown("left") || Greenfoot.isKeyDown("a"))
        {
            ok = true;
            st = true;
            dr = false;
            if(!BlocajStanga())
                x-=viteza;
            if(animare == 5 && (VerifJos()))
                AnimareStanga();
        }
        if(Greenfoot.isKeyDown("right") || Greenfoot.isKeyDown("d"))
        {
            ok = true;
            st = false;
            dr = true;
            if(!BlocajDreapta())
                x+=viteza;
            if(animare == 5 && (VerifJos()))
                AnimareDreapta();
        }
        if((Greenfoot.isKeyDown("up") ||Greenfoot.isKeyDown("space") || Greenfoot.isKeyDown("w")) && (VerifJos()))
        {
            if(st)
                SarituraSt();
            else
                SarituraDr();
        }
        setLocation((int)x,(int)y);
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
            vitezaS = -15*s/3;
        acceleratieg = vitezaS;
        AnimareSusSt();
    }

    public void SarituraDr()
    {
        if(contorBoostS == 0)
            vitezaS = -15*s/3;
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

    public void VerifMort()
    {
        int latime = getImage().getWidth();
        int inaltime = getImage().getHeight();
        if(getOneObjectAtOffset(latime /4 -14*s/3 ,inaltime /-4  ,AI.class)!=null||getOneObjectAtOffset(latime /4 -14*s/3,inaltime /4 ,AI.class)!=null)
        {   
            if(LumeScrolling.getViata0())
                LumeScrolling.setViata0(false);
            else if(LumeScrolling.getViata1())
                LumeScrolling.setViata1(false);
            else
                LumeScrolling.setViata2(false);
            System.gc();
            ((LumeScrolling)getWorld()).RestartNivel();
        }
    }

    public boolean VerifJos()
    {
        boolean ok = false;
        if(getY()>getWorld().getHeight()-(70*s/3))
            ok = true;
        int latime = getImage().getWidth();
        int inaltime = getImage().getHeight();
        if(Jos(Platforma.class)||Jos(Cutie.class))
            ok = true;
        return ok;
    }

    public boolean BlocajSus()
    {
        boolean ok = false;
        int latime = getImage().getWidth();
        int inaltime = getImage().getHeight();
        if(Sus(Platforma.class,4)||Sus(Cutie.class,4))
            ok = true;
        return ok;
    }

    public boolean BlocajDreapta()
    {
        boolean ok = false;
        int latime = getImage().getWidth();
        int inaltime = getImage().getHeight();
        if(Dreapta(Platforma.class,8)||Dreapta(Cutie.class,8))
            ok = true;
        return ok;
    }

    public boolean BlocajStanga()
    {
        boolean ok = false;
        int latime = getImage().getWidth();
        int inaltime = getImage().getHeight();
        if(Stanga(Platforma.class,8)||Stanga(Cutie.class,8))
            ok = true;
        return ok;
    }

    public void PikcupViata()
    {
        Actor pv;
        pv = getOneIntersectingObject(ViataPickup.class);
        if(pv!=null)
        {
            World nivelV;
            nivelV = getWorld();
            if(!LumeScrolling.getViata1())
            {
                Viata1.setOk(true);
                nivelV.removeObject(pv);
            }
            else if(!LumeScrolling.getViata0())
            {
                Viata0.setOk(true);
                nivelV.removeObject(pv);
            }
        }
    }

    public void VerifBooster()
    {
        BoostViteza();
        BoostSaritura();
    }

    public void BoostViteza()
    {
        Actor speedb;
        speedb = getOneIntersectingObject(SpeedBoost.class);
        if(speedb != null)
        {
            contorBoostV = 50;
            if(s==2)
                viteza = 6;
            else
                viteza = 8;
            World nivel;
            nivel = getWorld();
            nivel.removeObject(speedb);
            LumeScrolling.setShouldAddB(0);
        }
    }

    public void BoostSaritura()
    {
        Actor sariturab;
        sariturab = getOneIntersectingObject(JumpBoost.class);
        if(sariturab != null)
        {
            contorBoostS = 20;
            vitezaS = -20*s/3;
            World nivel;
            nivel = getWorld();
            nivel.removeObject(sariturab);
            LumeScrolling.setShouldAddB(0);
        }
    }

    public boolean Pauza()
    {
        LumeScrolling nivel = (LumeScrolling) getWorld();
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

    public boolean Sus(Class aux,int prox)
    {
        int latime = getImage().getWidth();
        int inaltime = getImage().getHeight();
        if(getOneObjectAtOffset(latime /4 +prox*s/3,inaltime /-4 ,aux)!=null||getOneObjectAtOffset(latime /-4 ,inaltime /-4 -prox*s/3 ,aux)!=null)
            return true;
        return false;
    }

    public boolean Stanga(Class aux,int prox)
    {
        int latime = getImage().getWidth();
        int inaltime = getImage().getHeight();
        if(getOneObjectAtOffset(latime /-4 -prox*s/3 ,inaltime /-4 ,aux)!=null||getOneObjectAtOffset(latime /-4  -prox*s/3,inaltime /4 ,aux)!=null)
            return true;
        return false;
    }

    public boolean Dreapta(Class aux,int prox)
    {
        int latime = getImage().getWidth();
        int inaltime = getImage().getHeight();
        if(getOneObjectAtOffset(latime /4 +prox*s/3 ,inaltime /-4  ,aux)!=null||getOneObjectAtOffset(latime /4 +prox*s/3,inaltime /4 ,aux)!=null)
            return true;
        return false;
    }


    public static int getViteza()
    {
        return (int)viteza;
    }
}
