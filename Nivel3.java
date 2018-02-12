import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Nivel3 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Nivel3 extends LumeScrolling
{

    /**
     * Constructor for objects of class Nivel3.
     * 
     */
    public Nivel3()
    {
        nvl=3;
        if(getSave())
            Salvare.salveaza(getInf());
    }

    public void RestartNivel()//Restartam nivelul
    {
        Greenfoot.setWorld(new Nivel3());
    }

    public void NivelUrmator()//Schimbam nivelul cu urmatorul
    {
        LumeScrolling.setSave(true);
        LumeScrolling.setCpu(false);
        LumeScrolling.setVl(false);
        Greenfoot.setWorld(new Nivel4());
    }
}
