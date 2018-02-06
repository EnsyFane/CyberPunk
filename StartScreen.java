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
        addObject(jocnou,746,236);
        jocnou.setLocation(757*s/3,273*s/3);
        addObject(rezolutie,791,344);
        rezolutie.setLocation(769*s/3,381*s/3);
        addObject(new Titlu(),757*s/3,100*s/3);
    }


    public void act()
    {
        Check();
    }
    public void Check()
    {
        if(jocnou.getClicked())//Verificam daca este apasat butonul joc nou
        {
            //Pregatim vietiile caracterului
            LumeScrolling.setViata0(true);
            LumeScrolling.setViata1(true);
            LumeScrolling.setViata2(true);
            //Pornim de la primul nivel
            Greenfoot.setWorld(new Nivel0());
        }
        else if(rezolutie.getClicked())//Verificam daca este apasat butonul rezolutie
        {
            //Intram in meniul de rezolutie
        Greenfoot.setWorld(new EcranRezolutie());
        }
    }
    public static int Rez()
    {
        try{
            //Citim scala (rezolutia) pentru care trebuie creat jocul
            FileReader fr = new FileReader("Rezolutie.txt");
            BufferedReader br = new BufferedReader(fr);
            r=br.readLine();
            br.close();
            s = Integer.parseInt(r);
        }
        catch(IOException e)
        {
            //Daca nu exista folderul este setata automat pe 1080p
            s=3;
        }
        return s;
    }
    public static int getRez()
    {
    //Returnam scala (rezolutia) jocului
    return s;
    }
}
