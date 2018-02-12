import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.io.*;
/**
 * Write a description of class StartScreen here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class StartScreen2 extends World
{

    /**
     * Constructor for objects of class StartScreen.
     * 
     */
    JocNouClick jocnou = new JocNouClick(362, 70);
    Rezolutie rezolutie = new Rezolutie(440,70);        
    Continuare continuare = new Continuare();
    private static String r;
    private static int s=StartScreen.Rez();
    private int nv;
    public StartScreen2()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1500*StartScreen.Rez()/3, 600*StartScreen.Rez()/3, 1); 
        GreenfootImage bg = new GreenfootImage("EcranStart.jpg");
        setBackground(bg);
        prepare();
    }

    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        //Pregatim butoanele pe ecran
        Sunete.Fundal();
        s=StartScreen.Rez();
        addObject(jocnou,746*s/3,236*s/3);
        jocnou.setLocation(757*s/3,373*s/3);
        addObject(rezolutie,791*s/3,344*s/3);
        rezolutie.setLocation(769*s/3,481*s/3);
        addObject(new Titlu(),757*s/3,100*s/3);
        addObject(continuare,767*s/3,258*s/3);
    }

    public void act()
    {
        Check();
    }

    public void Check()
    {
        if(jocnou.getClicked())//Verificam daca este apasat butonul joc nou
        {
            //Stergem salvarea
            Salvare.stergere();
            //Pregatim vietiile caracterului
            LumeScrolling.setViata0(true);
            LumeScrolling.setViata1(true);
            LumeScrolling.setViata2(true);
            //Pornim de la primul nivel
            LumeScrolling.setCpu(false);
            LumeScrolling.setVl(false);
            LumeScrolling.setSave(false);
            Greenfoot.setWorld(new Nivel0());

        }
        else if(rezolutie.getClicked())//Verificam daca este apasat butonul rezolutie
        {
            //Intram in meniul de rezolutie
            Greenfoot.setWorld(new EcranRezolutie());
        }
        else if(continuare.getClicked())
        {
            LumeScrolling.setSave(false);
            if(Salvare.citireS(2)==1)
                LumeScrolling.setViata0(true);                
            else
                LumeScrolling.setViata0(false);
            if(Salvare.citireS(3)==1)
                LumeScrolling.setViata1(true);                
            else
                LumeScrolling.setViata1(false);    
            if(Salvare.citireS(4)==1)
                LumeScrolling.setViata2(true);                
            else
                LumeScrolling.setViata2(false);
            if(Salvare.citireS(5)==1)
                LumeScrolling.setCpu(true);                
            else
                LumeScrolling.setCpu(false);
            if(Salvare.citireS(6)==1)
                LumeScrolling.setVl(true);                
            else
                LumeScrolling.setVl(false);
            nv=Salvare.citireS(1);
            if(nv==0)
                Greenfoot.setWorld(new Nivel0());
            else if(nv==1)
                Greenfoot.setWorld(new Nivel1());
            else if(nv==2)
                Greenfoot.setWorld(new Nivel2());
            else if(nv==3)
                Greenfoot.setWorld(new Nivel3());
            else if(nv==4)
                Greenfoot.setWorld(new Nivel4());
            else if(nv==5)
                Greenfoot.setWorld(new Nivel5());
            else if(nv==6)
                Greenfoot.setWorld(new Nivel6());
            else if(nv==7)
                Greenfoot.setWorld(new Nivel7());
            else if(nv==8)
                Greenfoot.setWorld(new Nivel8());
            else if(nv==9)
                Greenfoot.setWorld(new Nivel9());
        }
    }

}
