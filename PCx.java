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
        if(CheckActor())
        {
            if(!afisatEcran)//Daca nu am afisat pop-up-ul il afisam
            {
                afisare();
            }

        }
        else //Daca actorul nu se mai intersecteaza cu obiectul
        {
            if(afisatEcran)//Daca am afisat pop-up-ul il stergem
                stergere();

        }
    }   
    public boolean CheckActor()
    {
        //Verificam daca se intersecteaza cu un actor principal
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
