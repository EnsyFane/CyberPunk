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
    //Pregatim imaginile animatiei
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
    private int s=LumeScrolling.getRez();//Retinem rezolutia (scala)
    //Setam cadrul la 0 ,stadiul animatiei la 1 si contorul de miscare la 0
    private short cadru = 0,animare = 1,contor = 0;
    private double distantaParcursa, distantaMaxima=200*s/3;
    //Setam pozitia precedenta la dreapta
    private boolean st=false,dr = true;
    private int viteza = 4;
    private boolean pauza = false,decis = false;//Setam stadiul inamicului la indecis (in legatura cu urmatoare miscare)
    private boolean precedentIdle = false;//Setam precedenta a caracterului la miscare
    private int acceleratieg;
    int k=1;//Contor pentru incetinirea gravitatie (in cazul rezolutiei 720p)
    private int latime;
    private int inaltime;
    public AI()
    {
        acceleratieg = 0;
        setImage(idle0dr);
        s=LumeScrolling.getRez();
        if(s==2) //Daca avem rezolutia setata pe 720p incetinim viteza de miscare altfel aceasta functioneaza normal
            viteza = 3;
        //Alegem o pozitie de incepere random (stanga/dreapta) si o retinem
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
        image.scale(90*s/3, 45*s/3);//Setam imaginea in functie de rezolutie
        setImage(image);
        latime = getImage().getWidth();
        inaltime = getImage().getHeight();
    }

    public void act() 
    {
        if(!Pauza())//Daca jocul nu este pe pauza
        {
            
            Gravitatie();//Simulam gravitatia
            if(contor<240)//Daca caracterul s-a miscat recent acesta sta pe loc pana anunge contorul la 240
            {
                Idle();
                contor++;
            }
            else//Dupa ce contorul ajunge la 240
            {
                if(st)//Daca pozitia precedenta a fost la stanga
                {
                    if(!decis)//Daca caracterul este indecis
                    {
                        distantaMaxima = 200*s/3+Greenfoot.getRandomNumber(200*s/3);//Decide o distanga de miscare intre 200 si 400 de pixel (pentru 1080p)
                        decis = true;
                    }
                    if(distantaParcursa>distantaMaxima)//Daca distanga parcursa este mai mare decat distanta maxima
                    {
                        //Reactualizam contorul , distanta parcursa si pozitia precedenta
                        contor= 0;
                        distantaParcursa = 0;
                        dr = true;
                        st = false;
                        decis = false;
                    }
                    else//In caz contrar caracterul se deplaseaza la dreapta
                        DeplasareDreapta();
                }
                else//Daca pozitia precedenta a fost la dreapta
                {
                    if(!decis)//Daca caracterul este indecis
                    {
                        distantaMaxima = -200*s/3-Greenfoot.getRandomNumber(200*s/3);//Decide o distanga de miscare intre 200 si 400 de pixel (pentru 1080p)
                        decis =true;
                    }
                    if(distantaParcursa<distantaMaxima)//Daca distanga parcursa este mai mare decat distanta maxima
                    {
                        //Reactualizam contorul , distanta parcursa si pozitia precedenta
                        contor= 0;
                        distantaParcursa = 0;
                        dr = false;
                        st = true;
                        decis = false;
                    }
                    else//In caz contrar caracterul se deplaseaza la stanga
                        DeplasareStanga();
                }
            }
            animare++;//Crestem stadiul de animare
            if(animare > 8)//Daca acesta ajunge la 8 , incepem de la capat
                animare = 1;
            GreenfootImage image = getImage();  
            image.scale(90*s/3, 45*s/3);//Setam imaginea in functie de rezolutie
            setImage(image);
            VerifMort();//Verificam daca caracterul trebuie sa moara
        }
    }

    public void Gravitatie()
    {
        //Simulam gravitatia
        setLocation(getX(),getY() + acceleratieg);//Actualizam pozitia caracterului
        if(VerifJos())//Daca se afla pe un solid setam viteza verticala la 0
        {
            acceleratieg = 0;
            while(VerifJos())//Actualizam pozitia caracterului la suprafata solidului 
            {
                setLocation(getX(),getY() - 1);  
            }
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


    public void DeplasareDreapta()
    {
        double x = getX();
        if(!BlocajDreapta())//Daca nu exista un blocaj la dreapta
        {
            x+=viteza;
            distantaParcursa+=viteza;//Creste distanta parcursa
        }
        else //Daca caracterul se blocheaza
        {
            //Reinitalizam contorul si pozitia precedenta
            contor = 0; 
            dr = true;
            st = false;
            decis = false;
        }
        if(animare == 5 && (VerifJos()))//Daca animatia este la stadiul 5 si exista un solid jos
        {
            precedentIdle = false;//Setam starea precedenta la miscare
            AnimareDreapta();//Animam miscarea la dreapta
        }
        setLocation((int)x,getY());//Reactualizam pozitia caracterului
    }

    public void DeplasareStanga()
    {
        double x = getX();
        if(!BlocajStanga())//Daca nu exista un blocaj la stanga
        {
            x-=viteza;
            distantaParcursa-=viteza;//"Creste" distanta parcursa
        }
        else//Daca caracterul se blocheaza  
        {
            //Reinitalizam contorul si pozitia precedenta
            contor = 0;
            dr = false;
            st = true;
            decis = false;
        }
        if(animare == 5 && (VerifJos()))//Daca animatia este la stadiul 5 si exista un solid jos
        {
            precedentIdle = false;//Setam starea precedenta la miscare
            AnimareStanga();//Animam miscarea la stanga
        }
        setLocation((int)x,getY());//Reactualizam pozitia caracterului
    }

    public void Idle()
    {
        if(animare == 8 && (VerifJos()))//Daca animatia este la stadiul 8 si exista un solid jos
        {
            if(dr)//Daca pozitia precedenta este la dreapta
                AnimareIdleDr();//Animam caracterul pe loc la dreapta
            else //Daca pozitia precedenta este la stanga
                AnimareIdleSt();//Animam caracterul pe loc la stanga
        }
    }

    public void AnimareIdleDr()
    {
        //Setam partea din animatie pentru 'idle' la dreapta in functie de cadrul din animatie la care am ramas
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
        //Setam partea din animatie pentru 'idle' la stanga in functie de cadrul din animatie la care am ramas
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

    public void AnimareDreapta()
    {
        //Setam partea din animatie pentru miscare la dreapta in functie de cadrul din animatie la care am ramas
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
        //Setam partea din animatie pentru miscare la dreapta in functie de cadrul din animatie la care am ramas
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

        if(getY()>getWorld().getHeight()-65*s/3)//Verificam daca caracterul se afla pe sol 
            return true;
        //Verificam daca caracterul se afla pe o platforma sau o cutie
        if(getOneObjectAtOffset(latime /2 ,inaltime /2 ,Platforma.class)!=null||getOneObjectAtOffset(latime /-2 ,inaltime /2 ,Platforma.class)!=null
        ||getOneObjectAtOffset(latime /2 ,inaltime /2 ,Cutie.class)!=null||getOneObjectAtOffset(latime /-2 ,inaltime /2 ,Cutie.class)!=null)
            return true;
        return false;
    }

    public void VerifMort()
    {
        if(Sus(Cutie.class))//Daca deasupra caracterului se afla o cutie
            getWorld().removeObject(this);//Eliminam caracterul
    }

    public boolean BlocajDreapta()
    {
     //Verificam daca in dreapta caracterului se afla o cutie sau o platforma
        if(Dreapta(Platforma.class)||Dreapta(Cutie.class))
            return true;
        return false;
    }

    public boolean BlocajStanga()
    {
     //Verificam daca in stanga caracterului se afla o cutie sau o platforma
        if(Stanga(Platforma.class)||Stanga(Cutie.class))
            return true;
        return false;
    }

    public boolean Pauza()
    {
        LumeScrolling nivel = (LumeScrolling) getWorld();
        return !nivel.play;//Verificam daca jocul este pe pauza
    }

    public boolean Jos(Class aux)
    {
        //Verificam sub caracter pentru o clasa
        if(getOneObjectAtOffset(latime /4 ,inaltime /2 ,aux)!=null||getOneObjectAtOffset(latime /-4 ,inaltime /2,aux)!=null)
            return true;
        return false;
    }

    public boolean Sus(Class aux)
    {
        //Verificam deasupra caracterului pentru o clasa
        if(getOneObjectAtOffset(latime /4 +4*s/3,inaltime /-4 ,aux)!=null||getOneObjectAtOffset(latime /-4 ,inaltime /-4 -4*s/3 ,aux)!=null)
            return true;
        return false;
    }

    public boolean Stanga(Class aux)
    {
        //Verificam in stanga caracterului pentru o clasa
        if(getOneObjectAtOffset(latime /-4 -8*s/3 ,inaltime /-4 ,aux)!=null||getOneObjectAtOffset(latime /-4  -8*s/3,inaltime /4 ,aux)!=null)
            return true;
        return false;
    }

    public boolean Dreapta(Class aux)
    {
        //Verificam in dreapta caracterului pentru o clasa
        if(getOneObjectAtOffset(latime /4 +8*s/3 ,inaltime /-4  ,aux)!=null||getOneObjectAtOffset(latime /4 +8*s/3,inaltime /4 ,aux)!=null)
            return true;
        return false;
    }

}