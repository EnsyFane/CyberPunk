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
    //Pregatim imaginile animatiei
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
    //Setam cadrul la 0 si stadiul animatiei la 1
    private int cadru = 0,animare = 1;
    private int s=LumeScrolling.getRez();//Retinem rezolutia (scala)
    private double acceleratieg ;
    //Setam pozitia precedenta la dreapta
    boolean st=false,dr = true;
    private double vitezaS = -15*s/3; //Setam viteza sariturii (in functie de rezolutie)
    private static double viteza=5;
    private int contorBoostV = 0, contorBoostS = 0;//Setam efectele 'boosterelor' la 0
    private boolean pauza = false;
    private int k=1;//Contor pentru incetinirea gravitatie (in cazul rezolutiei 720p)
    public Elev()
    {
        acceleratieg = 0;
        s=LumeScrolling.getRez();//Retinem rezolutia (scala)
        if(s==2)//Daca avem rezolutia setata pe 720p incetinim viteza de miscare altfel aceasta functioneaza normal
            viteza *=s/3;
        //Setam imaginea in functie de rezolutie
        setImage(idle0);
        GreenfootImage image = getImage();  
        image.scale(50*s/3, 50*s/3);
        setImage(image); 
    }

    public void act() 
    {
         if(!Pauza())//Daca jocul nu este pe pauza
        {
        Gravitatie();//Simulam gravitatia
        VerifMort();//Verificam daca caracterul trebuie sa moara
        VerifMiscare();//Verificam daca caracterul trebuie sa se miste
        VerifBooster();//Verificam daca caracterul a activat 'boostere'
        PikcupViata();//Verifcam daca caracterul a luat o viata din nivel
        PickupCPU();//Verifcam daca caracterul a luat procesorul din nivel
        animare++;//Creste stadiul animatiei
        if(animare > 8)//Daca ajunge la 8 incepe de la capat
            animare = 1;
        GreenfootImage image = getImage();  
        image.scale(50*s/3, 50*s/3);//Setam imaginea in functie de rezolutie
        setImage(image);
        if(contorBoostV > 0)//Daca este activ efectul de viteza scadem din timpul de actiune al acestuia
            contorBoostV--;
        if(contorBoostS > 0)//Daca este activ efectul de saritura scadem din timpul de actiune al acestuia
            contorBoostS--;
        if(BlocajStanga())
        {
            while(BlocajStanga())
            {
                setLocation(getX()+1,getY());  
            }
            setLocation(getX()-1,getY()); 
        }
        if(BlocajDreapta())
        {
            while(BlocajDreapta())
            {
                setLocation(getX()-1,getY());  
            }
            setLocation(getX()+1,getY()); 
        }
         }

    }

    public void Gravitatie()
    {
        //Simulam gravitatia
        setLocation(getX(),getY() + (int)acceleratieg);//Actualizam pozitia caracterului
        if(VerifJos())//Daca se afla pe un solid setam viteza verticala la 0
        {
            acceleratieg = 0;
            while(VerifJos())//Actualizam pozitia caracterului la suprafata solidului 
            {
                setLocation(getX(),getY() - 1);  
            }
            setLocation(getX(),getY() + 1); 
        }
        else if(acceleratieg<0&&BlocajSus())//Daca caracterul se misca in jus si se loveste cu capul de un solid setam viteza veritcala la 0
        {
            acceleratieg = 0;
            while(BlocajSus())//Actualizam pozitia caracterului sub solid 
                setLocation(getX(),getY() + 1);  
        }
        else //Daca caracterul este in cadere crestem acceleratia in jos
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
    {   double x = getX(),y = getY();
        boolean ok = false;
        if(contorBoostV == 0)//Daca nu se afla sub un efect de viteza reinitializam viteza caracterului
        {
            if(s==2)//Daca avem rezolutia setata pe 720p incetinim viteza de miscare
                viteza = 3;
            else //Daca avem rezolutia setata pe 1080p viteza de miscare functioneaza normal
                viteza =5;
        }
        if(Greenfoot.isKeyDown("left") || Greenfoot.isKeyDown("a"))//Daca este apasata tasta 'a' sau sageata stanga
        {
            //Retinem daca caracterul s-a miscat si actualizam directia in care s-a miscat ultima data
            ok = true;
            st = true;
            dr = false;
            if(!BlocajStanga())//Daca nu exista un blocaj in stanga deplasam caracterul la stanga
                x-=viteza;
            if(animare == 5 && (VerifJos()))//Daca animatia este la stadiul 5 si exista un solid jos
                AnimareStanga();//Animam miscarea la stanga
        }
        if(Greenfoot.isKeyDown("right") || Greenfoot.isKeyDown("d"))//Daca este apasata tasta 'd' sau sageata dreapta
        {
            //Retinem daca caracterul s-a miscat si actualizam directia in care s-a miscat ultima data
            ok = true;
            st = false;
            dr = true;
            if(!BlocajDreapta())//Daca nu exista un blocaj in dreapta deplasam caracterul la dreapta
                x+=viteza;
            if(animare == 5 && (VerifJos()))//Daca animatia este la stadiul 5 si exista un solid jos
                AnimareDreapta();//Animam miscarea la dreapta
        }
        if((Greenfoot.isKeyDown("up") || Greenfoot.isKeyDown("w")) && (VerifJos()))//Daca este apasata tasta 'w' sau sageata sus
        {
            Sunete.Saritura();
            if(st)//Daca starea precedenta a fost de miscare la stanga
                SarituraSt();//Animam saritura pentru partea stanga

            else//Daca starea precedenta a fost de miscare la dreapta
                SarituraDr();//Animam saritura pentru partea dreapta

        }
        setLocation((int)x,(int)y);//Actualizam locatia caracterului
        if(animare == 8 && !ok && (VerifJos()))//Daca stadiul animatiei este 8 , caracterul nu se misca si jos avem un solid
        {
            if(dr)//Daca starea precedenta a fost de miscare la dreapta
                AnimareIdleDr();//Animam caracterul pe loc la dreapta
            else //Daca starea precedenta a fost de miscare la stanga
                AnimareIdleSt();//Animam caracterul pe loc la stanga
        }
    }

    public void SarituraSt()
    {
        if(contorBoostS == 0)//Daca nu exista un efect de saritura
            vitezaS = -15*s/3;//Reactualizam viteza de saritura
        acceleratieg = vitezaS;
        AnimareSusSt();//Animam saritura pentru partea stanga
    }

    public void SarituraDr()
    {
        if(contorBoostS == 0)//Daca nu exista un efect de saritura
            vitezaS = -15*s/3;//Reactualizam viteza de saritura
        acceleratieg = vitezaS;
        AnimareSusDr();//Animam saritura pentru partea dreapta
    }

    public void AnimareIdleDr()
    {
        //Setam partea din animatie pentru 'idle' la stanga in functie de cadrul din animatie la care am ramas
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
        //Setam partea din animatie pentru 'idle' la dreapta in functie de cadrul din animatie la care am ramas
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
        setImage(saritura1);//Animam saritura pentru partea dreapta
    }

    public void AnimareSusSt()
    {
        setImage(saritura2);//Animam saritura pentru partea stanga
    }

    public void AnimareDreapta()
    {
        //Setam partea din animatie pentru miscare la dreapta in functie de cadrul din animatie la care am ramas
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
        //Setam partea din animatie pentru miscare la stanga in functie de cadrul din animatie la care am ramas
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
        if(getOneObjectAtOffset(latime /4 -14*s/3 ,inaltime /-4  ,AI.class)!=null||getOneObjectAtOffset(latime /4 -14*s/3,inaltime /4 ,AI.class)!=null)//Daca caracterul atinge un inamic (AI)
        {   
            Sunete.Mort();
            //Scadem viata corespunzatoare
            if(LumeScrolling.getViata0())
                LumeScrolling.setViata0(false);
            else if(LumeScrolling.getViata1())
                LumeScrolling.setViata1(false);
            else
                LumeScrolling.setViata2(false);
            System.gc();//Sugeram o curatare de memorie
            ((LumeScrolling)getWorld()).RestartNivel();//Restartam nivelul

        }
    }

    public boolean VerifJos()
    {
        if(getY()>getWorld().getHeight()-(70*s/3))//Verificam daca caracterul se afla pe sol 
            return true;
        if(Jos(Platforma.class)||Jos(Cutie.class))//Verificam daca caracterul se afla pe o platforma sau o cutie
            return true;
        return false;
    }

    public boolean BlocajSus()
    {
        if(Sus(Platforma.class,4)||Sus(Cutie.class,4))//Verificam daca deasupra caracterului se afla o cutie sau o platforma
            return true;
        return false;
    }

    public boolean BlocajDreapta()
    {
        if(Dreapta(Platforma.class,9)||Dreapta(Cutie.class,8))//Verificam daca in dreapta caracterului se afla o cutie sau o platforma
            return true;
        return false;
    }

    public boolean BlocajStanga()
    {
        if(Stanga(Platforma.class,9)||Stanga(Cutie.class,8))//Verificam daca in stanga caracterului se afla o cutie sau o platforma
            return true;
        return false;
    }

    public void PikcupViata()
    {
        Actor pv;
        pv = getOneIntersectingObject(ViataPickup.class);
        if(pv!=null)//Daca caracterul se intesecteaza cu o viata
        {

            World nivelV;
            nivelV = getWorld();
            //Reinitializam viata corespunzatoare in functie de numarul de vieti consumate
            if(!LumeScrolling.getViata1())
            {
                Sunete.Pickup();
                LumeScrolling.setViata1(true);
                nivelV.removeObject(pv);
                LumeScrolling.setVl(true);
            }
            else if(!LumeScrolling.getViata0())
            {
                Sunete.Pickup();
                LumeScrolling.setViata0(true);
                LumeScrolling.setVl(true);
                nivelV.removeObject(pv);
            }

        }
    }

    public void PickupCPU()
    {
        Actor pv;
        pv = getOneIntersectingObject(CPU.class);
        if(pv!=null)//Daca caracterul se intesecteaza cu o viata
        {
            Sunete.Pickup();
            World nivel;
            nivel = getWorld();
            LumeScrolling.setCpu(true);
            nivel.removeObject(pv);
        }
    }

    public void VerifBooster()
    {
        BoostViteza();//Vertificam daca caracterul se intesecteaza cu un 'boost' de viteza
        BoostSaritura();//Verificam daca caracterul se intesecteaza cu un 'boost' de saritura
    }

    public void BoostViteza()
    {
        Actor speedb;
        speedb = getOneIntersectingObject(SpeedBoost.class);
        if(speedb != null)//Daca caracterul se intesecteaza cu un 'boost' de viteza
        {
            Sunete.Pickup();
            contorBoostV = 80;//Pornim contorul pentru efectul de viteza
            //Marim viteza in functie de rezolutie
            if(s==2)
                viteza = 6.5;
            else
                viteza = 10;
            World nivel;
            nivel = getWorld();
            nivel.removeObject(speedb);//Stergem obiectul din lume
            LumeScrolling.setShouldAddB(0);//Pornim contorul pentru 'respawn' al obiectelor de tip 'booster'
        }
    }

    public void BoostSaritura()
    {
        Actor sariturab;
        sariturab = getOneIntersectingObject(JumpBoost.class);
        if(sariturab != null)//Daca caracterul se intesecteaza cu un 'boost' de saritura
        {
            Sunete.Pickup();
            contorBoostS = 55;//Pornim contorul pentru efectul de saritura
            vitezaS = -20*s/3;//Marim saritura in functie de rezolutie
            World nivel;
            nivel = getWorld();
            nivel.removeObject(sariturab);//Stergem obiectul din lume
            LumeScrolling.setShouldAddB(0);//Pornim contorul pentru 'respawn' al obiectelor de tip 'booster'
        }
    }

    public boolean Pauza()
    {
        //Verificam daca jocul este pe pauza
        LumeScrolling nivel = (LumeScrolling) getWorld();
        return !nivel.play;
    }

    public boolean Jos(Class aux)
    {
        //Verificam sub caracter pentru o clasa
        int latime = getImage().getWidth();
        int inaltime = getImage().getHeight();
        if(getOneObjectAtOffset(latime /4 ,inaltime /2 ,aux)!=null||getOneObjectAtOffset(latime /-4 ,inaltime /2,aux)!=null)
            return true;
        return false;
    }

    public boolean Sus(Class aux,int prox)
    {
        //Verificam deasupra caracterului pentru o clasa in functie de proximitate
        int latime = getImage().getWidth();
        int inaltime = getImage().getHeight();
        if(getOneObjectAtOffset(latime /4 +prox*s/3,inaltime /-4 ,aux)!=null||getOneObjectAtOffset(latime /-4 ,inaltime /-4 -prox*s/3 ,aux)!=null)
            return true;
        return false;
    }

    public boolean Stanga(Class aux,int prox)
    {
        //Verificam in stanga caracterului pentru o clasa in functie de proximitate
        int latime = getImage().getWidth();
        int inaltime = getImage().getHeight();
        if(getOneObjectAtOffset(latime /-4 -prox*s/3 ,inaltime /-4 ,aux)!=null||getOneObjectAtOffset(latime /-4  -prox*s/3,inaltime /4 ,aux)!=null)
            return true;
        return false;
    }

    public boolean Dreapta(Class aux,int prox)
    {
        //Verificam in dreapta caracterului pentru o clasa in functie de proximitate
        int latime = getImage().getWidth();
        int inaltime = getImage().getHeight();
        if(getOneObjectAtOffset(latime /4 +prox*s/3 ,inaltime /-4  ,aux)!=null||getOneObjectAtOffset(latime /4 +prox*s/3,inaltime /4 ,aux)!=null)
            return true;
        return false;
    }
    //Functie 'getter' pentru returnarea vitezei caracterului
    public static int getViteza()
    {
        return (int)viteza;
    }
}
