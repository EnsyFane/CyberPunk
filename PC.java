import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class PC here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PC extends Actor
{
    /**
     * Act - do whatever the PC wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public boolean afisatEcran = false;
    int s=LumeScrolling.getRez();
    World nivel;
    public  void act() 
    {

        if(LumeScrolling.getCpu())
        {
            if(CheckActor())
            {
                if(!afisatEcran)//Daca nu am afisat pop-up-ul il afisam
                {
                    afisare();
                }
            }
            else//Daca actorul nu se mai intersecteaza cu obiectul
            {
                if(afisatEcran)//Daca am afisat pop-up-ul il stergem
                    stergere();
            }
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
