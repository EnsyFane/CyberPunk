import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.io.*;
/**
 * Write a description of class StartScreen here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class StartScreen extends World
{

    /**
     * Constructor for objects of class StartScreen.
     * 
     */
    JocNouClick jocnou = new JocNouClick(362, 70);
    Rezolutie rezolutie = new Rezolutie(440,70);
    private static String r;
    private static int s=Rez();
    public StartScreen()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1500*Rez()/3, 600*Rez()/3, 1); 
        prepare();
    }

    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        addObject(jocnou,746,236);
        jocnou.setLocation(757*s/3,223*s/3);
        addObject(rezolutie,791,344);
        rezolutie.setLocation(769*s/3,331*s/3);
    }


    public void act()
    {
        Check();
    }
    public void Check()
    {
        if(jocnou.getClicked())
        {
            Nivele.setViata0(true);
            Nivele.setViata1(true);
            Nivele.setViata2(true);
            Greenfoot.setWorld(new Nivel0());
        }
        else if(rezolutie.getClicked())
        {
            Greenfoot.setWorld(new EcranRezolutie());
        }
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
