import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Nivel8 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Nivel8 extends LumeScrolling
{

    /**
     * Constructor for objects of class Nivel8.
     * 
     */
    public Nivel8()
    {
        nvl=8;
        if(getSave())
            Salvare.salveaza(getInf());
    }

    public void RestartNivel()//Restartam nivelul
    {
        Greenfoot.setWorld(new Nivel8());
    }

    public void NivelUrmator()//Schimbam nivelul cu urmatorul
    {
        LumeScrolling.setSave(true);
        LumeScrolling.setCpu(false);
        LumeScrolling.setVl(false);
        Greenfoot.setWorld(new Nivel9());
    }
}
