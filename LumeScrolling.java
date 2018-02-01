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
    Inapoi inapoi=new Inapoi(300,70);
    Inapoi inapoi2 = new Inapoi(362,70);
    Pauza_BtMM mainmenu = new Pauza_BtMM(460,70);
    Pauza_Restart restart = new Pauza_Restart(300,70);
    HD hd =new HD(510,70);
    FHD fhd=new FHD(533,70);
    Actor actorPrincipal;
    Scroller scroller;
    private boolean pause = false,unpause = true,afisat = false,ok = false;
    boolean play = true;
    private static boolean okv0 = true,okv1 = true,okv2 = true;
    private static String r;
    private static int s=Rez();
    private static int shouldAddB =600;
    private boolean afisatB=false;
    private boolean newRez = false;
    Pauza pauza = new Pauza(1500,600);
    Viata0 viata0 = new Viata0(41, 41);
    Viata1 viata1 = new Viata1(41, 41);
    Viata2 viata2 = new Viata2(41, 41);
    public LumeScrolling()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(lungime*Rez()/3,inaltime*Rez()/3, 1,false);
        GreenfootImage bg = new GreenfootImage("cyberpunk-street.png");
        setBackground(bg);
        bg.scale(lungime*s/3*2,inaltime*s/3);
        int lungBg = bg.getWidth();
        int inalBg = bg.getHeight();
        setPaintOrder(Pauza.class,Viata0.class,Viata1.class,Viata2.class,Tutoriale.class,Intrebari.class,Elev.class,Platforma.class,Cutie.class,PC.class);
        actorPrincipal = new Elev();
        scroller = new Scroller(this, bg,2*lungime*s/3,inaltime*s/3);
        addObject(actorPrincipal ,100,100);
        Greenfoot.setSpeed(49);
        addObject(viata0,lungime*s/3-(59*s/3),37*s/3);
        addObject(viata1,lungime*s/3-(59*s/3)-(50*s/3),37*s/3);
        addObject(viata2,lungime*s/3-(59*s/3)-2*(50*s/3),37*s/3);
        viata0.setOk(okv0);
        viata1.setOk(okv1);
        viata2.setOk(okv2);  
    }
     
    public void act()
    {
        if(actorPrincipal!=null)
            scroll();
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
     
    public void scroll()
    {     
        int x = actorPrincipal.getX()-lungime/2;
        int y = actorPrincipal.getY()-inaltime/2;
        scroller.scroll(x,y);
    }
    
    public void CheckPause(String key)
    {
        if(key != null)
        {
            if("p".equals(key) || "escape".equals(key))
            {
                if(!afisat)
                {
                    setPaintOrder(FHD.class,HD.class,Inapoi.class,Pauza_BtMM.class,Pauza_Restart.class,Pauza.class);
                    addObject(pauza,1500/2*s/3,600/2*s/3);
                    addObject(mainmenu,0,0);
                    mainmenu.setLocation(757*s/3,223*s/3);
                    addObject(restart,0,0);
                    restart.setLocation(760*s/3,331*s/3);
                    //addObject(inapoi,0,0);
                    //inapoi.setLocation(250*s/3,509*s/3);
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
                removeObject(mainmenu);
                removeObject(restart);
                //removeObject(inapoi);
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
            removeObject(mainmenu);
            removeObject(restart);
            afisat = false;
            play = true;
            pause = false;
            unpause = true;
            Greenfoot.setWorld(new Nivel0());
        }
        if(mainmenu.getClicked())
        {
            Greenfoot.setWorld(new StartScreen());
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
            //addObject(pauza,1500/2*s/3,600/2*s/3);
            addObject(mainmenu,0,0);
            mainmenu.setLocation(757*s/3,223*s/3);
            addObject(restart,0,0);
            restart.setLocation(760*s/3,331*s/3);
           //addObject(inapoi,0,0);
            //inapoi.setLocation(250*s/3,509*s/3);
        }
        /*if(inapoi.getClicked())
        {
            removeObject(pauza);
            removeObject(mainmenu);
            removeObject(restart);
            removeObject(inapoi);
            afisat = false;
            play = true;
            pause = false;
            unpause = true;
        }*/
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
     
    public void RestartNivel()
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
        try
        {
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
