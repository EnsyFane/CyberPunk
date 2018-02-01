import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.io.*;
/**
 * Write a description of class EcranRezolutie here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class EcranRezolutie extends World
{

    /**
     * Constructor for objects of class EcranRezolutie.
     * 
     */
    private int s;
    HD hd =new HD(510,70);
    FHD fhd=new FHD(533,70);
    Inapoi inapoi=new Inapoi(362,70);
    public EcranRezolutie()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1500*StartScreen.Rez()/3, 600*StartScreen.Rez()/3, 1); 
        prepare();
    }
    public void prepare()
    {
        s=StartScreen.Rez();
        addObject(hd,746,236);
        hd.setLocation(757*s/3,223*s/3);
        addObject(fhd,746,236);
        fhd.setLocation(769*s/3,331*s/3);
        addObject(inapoi,746,236);
        inapoi.setLocation(299*s/3,509*s/3);
    
    }
    public void act()
    {
        Check();
    }
    public void Check()
    {
        if(fhd.getClicked())
        {
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
        if(inapoi.getClicked())
        {
            Greenfoot.setWorld(new StartScreen());
        }
    }
}
