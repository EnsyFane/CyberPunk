import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.io.*;
/**
 * Write a description of class Nivele here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Nivele extends World
{

    /**
     * Constructor for objects of class Nivele.
     * 
     */

    HD hd =new HD(510,70);
    FHD fhd=new FHD(533,70);
    Inapoi inapoi=new Inapoi(362,70);
    Inapoi inapoi2 = new Inapoi(362,70);
    Pauza_Optiuni optiuni = new Pauza_Optiuni(280,70);
    Pauza_Restart restart = new Pauza_Restart(440,70);
    private boolean pause = false,unpause = true,afisat = false,ok = false;
    boolean play = true;
    private static boolean okv0 = true,okv1 = true,okv2 = true;
    private static String r;
    private static int s=Rez();
    private int lungime=1500,inaltime=600;
    private static int shouldAddB =600;
    private boolean afisatB=false;
    private boolean newRez = false;
    Pauza pauza = new Pauza(1500,600);
    Viata0 viata0 = new Viata0(41, 41);
    Viata1 viata1 = new Viata1(41, 41);
    Viata2 viata2 = new Viata2(41, 41);
    public Nivele()
    {          
        super(1500*Rez()/3,600*Rez()/3, 1);
        Elev elev = new Elev();
        addObject(elev,88,530);
        elev.setLocation(129,158);
        GreenfootImage bg = new GreenfootImage("cyberpunk-street.png"); 
        bg.scale(getWidth(), getHeight());
        setBackground(bg);
        setPaintOrder(Pauza.class,Tutoriale.class,Intrebari.class,Elev.class,Platforma.class,Cutie.class,PC.class);
        addObject(viata0,lungime*s/3-(59*s/3),37*s/3);
        addObject(viata1,lungime*s/3-(59*s/3)-(50*s/3),37*s/3);
        addObject(viata2,lungime*s/3-(59*s/3)-2*(50*s/3),37*s/3);
        viata0.setOk(okv0);
        viata1.setOk(okv1);
        viata2.setOk(okv2);
         
    }

    public void act()
    {
        
        String kInput = Greenfoot.getKey();
        okv0 = viata0.getOk();
        okv1 = viata1.getOk();
        okv2 = viata2.getOk();
        if(!okv2)
            play = false;
        if(unpause)
        {
            CheckPause(kInput);
            ok = true;
        }
        else if(pause)
        {
            CheckUnpause(kInput);
            ok = true;
        }
        if(shouldAddB==600&&!afisatB)
        {
            AddBoostere();
            afisatB=true;
        }
        else
        {
            shouldAddB++;
            afisatB=false;
        }
        Check();
    }
  
    public void CheckPause(String key)
    {
        if(key != null)
        {
            if("p".equals(key) || "escape".equals(key))
            {
                if(!afisat)
                {
                    setPaintOrder(FHD.class,HD.class,Inapoi.class,Pauza_Optiuni.class,Pauza_Restart.class,Pauza.class);
                    addObject(pauza,1500/2*s/3,600/2*s/3);
                    addObject(optiuni,0,0);
                    optiuni.setLocation(757*s/3,223*s/3);
                    addObject(restart,0,0);
                    restart.setLocation(769*s/3,331*s/3);
                    addObject(inapoi,0,0);
                    inapoi.setLocation(299*s/3,509*s/3);
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
            if("p".equals(key) || "escape".equals(key))
            {
                removeObject(pauza);
                removeObject(optiuni);
                removeObject(restart);
                removeObject(inapoi);
                afisat = false;
                play = true;
                pause = false;
                unpause = true;
            }
        }
    }
    
    public void Check()
    {
        if(restart.getClicked())
        {
            removeObject(pauza);
            removeObject(optiuni);
            removeObject(restart);
            afisat = false;
            play = true;
            pause = false;
            unpause = true;
            Greenfoot.setWorld(new Nivel0());
        }
        if(optiuni.getClicked())
        {
            removeObject(optiuni);
            removeObject(inapoi);
            removeObject(restart);
            s=StartScreen.Rez();
            addObject(hd,746,236);
            hd.setLocation(757*s/3,223*s/3);
            addObject(fhd,746,236);
            fhd.setLocation(769*s/3,331*s/3);
            addObject(inapoi2,746,236);
            inapoi2.setLocation(299*s/3,509*s/3);
        }
        if(inapoi2.getClicked())
        {
            if(newRez==true)
            {
                newRez=false;
                Greenfoot.setWorld(new Nivel0());
            }
            removeObject(inapoi2);
            removeObject(fhd);
            removeObject(hd);
            addObject(pauza,1500/2*s/3,600/2*s/3);
            addObject(optiuni,0,0);
            optiuni.setLocation(757*s/3,223*s/3);
            addObject(restart,0,0);
            restart.setLocation(769*s/3,331*s/3);
            addObject(inapoi,0,0);
            inapoi.setLocation(299*s/3,509*s/3);
        }
        if(inapoi.getClicked())
        {
            removeObject(pauza);
            removeObject(optiuni);
            removeObject(restart);
            removeObject(inapoi);
            afisat = false;
            play = true;
            pause = false;
            unpause = true;
        }
        if(fhd.getClicked())
        {
            newRez=true;
            try
            {
                FileWriter fw = new FileWriter("Rezolutie.txt");
                PrintWriter pw= new PrintWriter(fw);
                
                pw.println("3");
                pw.close();
            }
            catch(IOException e)
            {
           
            }
        }
        if(hd.getClicked())
        {
            newRez=true;
            try
            {
                FileWriter fw = new FileWriter("Rezolutie.txt");
                PrintWriter pw= new PrintWriter(fw);
                
                pw.println("2");
                pw.close();
            }
            catch(IOException e)
            {
           
            }
        }
    }
    
    public void AddBoostere()
    {
    
    }
  
    public static void setShouldAddB(int x)
    {
        shouldAddB=x;
    }
        
    public void NivelUrmator()
    {
        
    }
    
    public void RestartNivel(boolean dead)
    {
        
    }
    
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
        return okv1;
    }
    
    public static int Rez()
    {
        try{
            FileReader fr = new FileReader("Rezolutie.txt");
            BufferedReader br = new BufferedReader(fr);
            r=br.readLine();
            br.close();
            s = Integer.parseInt(r);
        }
        catch(IOException e)
        {
            s=3;
        }
        return s;
    }
    
     public static int getRez()
    {
        return s;
    }
}
