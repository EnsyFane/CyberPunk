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
    int s=Nivele.getRez();
    World nivel;
    public  void act() 
    {
        // Add your action code here.
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
