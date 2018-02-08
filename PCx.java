import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class PCx here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PCx extends Actor
{
    public boolean afisatEcran = false;
    int s=LumeScrolling.getRez();
    World nivel;
    public  void act() 
    {
        // Add your action code here
        if(CheckActor())
        {
            if(!afisatEcran)
            {
                afisare();
            }

        }
        else
        {
            if(afisatEcran)
                stergere();

        }
    }   
    public boolean CheckActor()
    {
        if(getOneIntersectingObject(Elev.class)!=null)
            return true;
        else
            return false;
    }

    public void afisare()
    {

    }

    public void stergere()
    {

    }


}
