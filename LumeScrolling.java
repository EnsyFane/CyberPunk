import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.io.*;
/**
 * Write a description of class LumeScrolling here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class LumeScrolling extends World
{

    public static final int lungime = 1500;
    public static final int inaltime = 600;

    Actor actorPrincipal;
    Scroller scroller;
    private boolean pause = false,unpause = true,afisat = false,ok = false,caf = false, vaf = false;;
    boolean play = true;
    private static boolean okv0 = true,okv1 = true,okv2 = true;
    private static String r;
    private static int s=Rez();
    private static int shouldAddB =600;
    private boolean afisatB=false ;
    private static boolean cpu = false,vl = false,egg=false,shouldSave=false;
    static int nvl;
    Pauza pauza = new Pauza(1500,600);
    Viata0 viata0 = new Viata0(41, 41);
    Viata1 viata1 = new Viata1(41, 41);
    Viata2 viata2 = new Viata2(41, 41);
    CPUS c = new CPUS(35,35);
    public LumeScrolling()
    {    
        super(lungime*Rez()/3,inaltime*Rez()/3, 1,false);//Setam dimensiune lumii in functie de rezolutie
        GreenfootImage bg = new GreenfootImage("cyberpunk-street-dublu.png");
        setBackground(bg);
        bg.scale(lungime*s/3*2,inaltime*s/3);
        int lungBg = bg.getWidth();
        int inalBg = bg.getHeight();
        setPaintOrder(Pauza.class,RaspunsC.class,RaspunsG.class,CPUS.class,Viata0.class,Viata1.class,Viata2.class,Tutoriale.class,Intrebari.class,Elev.class,Platforma.class,Cutie.class,PC.class,Laser.class,LaserOrizontal.class,CPU.class);
        //Pregatim actorul principal ,vietiile si viteza de joc
        actorPrincipal = new Elev();
        scroller = new Scroller(this, bg,2*lungime*s/3,inaltime*s/3);
        addObject(actorPrincipal ,100,100);
        Greenfoot.setSpeed(49);
        addObject(viata0,lungime*s/3-(59*s/3),37*s/3);
        addObject(viata1,lungime*s/3-(59*s/3)-(50*s/3),37*s/3);
        addObject(viata2,lungime*s/3-(59*s/3)-2*(50*s/3),37*s/3);
        addObject(c,lungime*s/3-(59*s/3)-3*(50*s/3),37*s/3);
        viata0.setOk(okv0);
        viata1.setOk(okv1);
        viata2.setOk(okv2);

    }

    public void act()
    {
        if(actorPrincipal!=null)//Daca avem un actor principal setat apelam functia de scroll a lumii
            scroll();
        String kInput = Greenfoot.getKey();

        if(!okv2)//Daca ultima viata este consumata oprim jocul
            play = false;
        if(unpause)//Daca jocul nu este pe pauza verificam daca trebuie pus pe pauza
        {
            CheckPause(kInput);
            ok = true;
        }
        else if(pause)//Daca jocul este pe pauza verificam daca trebuie scos de pe pauza
        {
            CheckUnpause(kInput);
            ok = true;
        }
        if(shouldAddB==600&&!afisatB)//Daca contorul pentru "boostere" ajunge la 600 si nu avem afisat pana acum obiectele le afisam
        {
            AddBoostere();
            afisatB=true;
        }
        else//In caz contrar contorul creste
        {
            shouldAddB++;
            afisatB=false;
        }
        //Actualizam starea vietiilor
        viata0.setOk(okv0);
        viata1.setOk(okv1);
        viata2.setOk(okv2);
        if(!cpu&&!caf)
        {
            AddCpu();
            caf = true;
        }
        if(!vl&&!vaf)
        {
            AddViata();
            vaf = true;
        }

    }

    public void scroll()
    {

        int x = actorPrincipal.getX()-lungime/2;
        int y = actorPrincipal.getY()-inaltime/2;
        scroller.scroll(x,y);//Apelam functia de scroll a lumii

    }

    public void CheckPause(String key)
    {
        if(key != null)
        {
            if("p".equals(key))
            {
                //Daca este apasata tasta 'p' punem jocul pe pauza si afisam ecranul de pauza
                if(!afisat)
                {
                    addObject(pauza,1500/2*s/3,600/2*s/3);
                    afisat = true;
                }
                play = false;
                pause = true;
                unpause = false;
            }
        }
    }

    public void CheckUnpause(String key)
    {
        if(key != null)
        {
            if("p".equals(key))
            {
                //Daca este apasata tasta 'p' scoatem jocul de pe pauza si stergem ecranul de pauza
                removeObject(pauza);
                afisat = false;
                play = true;
                pause = false;
                unpause = true;
            }
        }
    }

    public void AddBoostere()//Adaugam 'boosterele'
    {}

    public void AddCpu()
    {}

    public void AddViata()
    {}

    public static void setShouldAddB(int x)//Setam contorul pentru 'boostere'
    {
        shouldAddB=x;
    }

    public void NivelUrmator()//Schimbam nivelul cu urmatorul
    {

    }

    public void RestartNivel()//Restartam nivelul
    {

    }
    //Functii 'getter' 'setter' pentru varabila pentru salvare
    public static void setSave(boolean x)
    {
    shouldSave = x;
    }
    public static boolean getSave()
    {
    return shouldSave;
    }
    //Functii 'getter' 'setter' pentru vieti
    public static void setViata0(boolean x)
    {
        okv0=x;
    }

    public static void setViata1(boolean x)
    {
        okv1=x;
    }

    public static void setViata2(boolean x)
    {
        okv2=x;
    }

    public static boolean getViata0()
    {
        return okv0;
    }

    public static boolean getViata1()
    {
        return okv1;
    }

    public static boolean getViata2()
    {
        return okv2;
    }

    public static int Rez()
    {
        try{
            //Citim scala (rezoluta) la care trebuie creat jocul
            FileReader fr = new FileReader("Rezolutie.txt");
            BufferedReader br = new BufferedReader(fr);
            r=br.readLine();
            br.close();
            s = Integer.parseInt(r);
        }
        catch(IOException e)
        {
            //Daca folderul "Rezolutie" nu exista este automat setat pe 1080p
            s=3;
        }
        return s;
    }

    public static int getRez()
    {
        //Returnam scala (rezoluta) la care trebuie creat jocul
        return s;
    }
    //Setam variabila pentru procesorul si viata(pickup) din nivel
    public static void setCpu(boolean x)
    {
        cpu = x;
    }

    public static void setVl(boolean x)
    {
        vl = x;
    }
    //Setam variabila pentru sondajul din nivelul 5
    public static void setEgg(boolean x)
    {
        egg = x;
    }
    //Functii 'getter' pentru variabilele respective
    public static boolean getCpu()
    {
        return cpu;
    }

    public static boolean getVl()
    {
        return vl;
    }

    public static boolean getEgg()
    {
        return egg;
    }

    public static int getNvl()
    {
        return nvl;
    }
}