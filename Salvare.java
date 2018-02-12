import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.io.*;
/**
 * Write a description of class Salvare here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Salvare extends Actor
{
    private static String r;
    private static int s,nivel,viata0,viata1,viata2,cpu,vl,egg;
    public static int citireS(int aux)
    {
        try{
            //Citim informatiile salvate
            FileReader fr = new FileReader("Salvare.txt");
            BufferedReader br = new BufferedReader(fr);
            r=br.readLine();
            br.close();

        }
        catch(IOException e)
        {
            return -1;
        }
        if(r == null)
            return -1;
        if(r.indexOf(' ')!=-1)
            return -1;
        //Retunram informatia ceruta daca exista folderul 'Salvare' si nu este gol (sau cu un spatiu)    
        s = Integer.parseInt(r);
        if(aux==1)//Nivelul
            return s/1000000;
        else if(aux==2)//Prima viata
            return s/100000%10;
        else if(aux==3)//A 2-a viata
            return s/10000%10;
        else if(aux==4)//A 3-a viata
            return s/1000%10;
        else if(aux==5)//Cpu nivel
            return s/100%10;
        else if(aux==6)//Viata nivel
            return s/10%10;
        else //Sondajul din nivelul 5
            return s%10;
    }

    public static void stergere()
    {
        try
        {
            FileWriter fw = new FileWriter("Salvare.txt");
            PrintWriter pw= new PrintWriter(fw);
            //Stergem salvarea;
            pw.println(" ");
            pw.close();
        }
        catch(IOException e)
        {

        }
    }

    public static void salveaza(int x)
    {
        try
        {
            FileWriter fw = new FileWriter("Salvare.txt");
            PrintWriter pw= new PrintWriter(fw);
            //Scriem in fisierul "Salvare" informatiile actuale;
            pw.println(x);
            pw.close();
        }
        catch(IOException e)
        {

        }
    }
}
