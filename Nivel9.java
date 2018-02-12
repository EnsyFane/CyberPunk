import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Nivel9 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Nivel9 extends LumeScrolling
{

    /**
     * Constructor for objects of class Nivel9.
     * 
     */
    public Nivel9()
    {
        nvl=9;
        if(getSave())
            Salvare.salveaza(getInf());
    }

    public void RestartNivel()//Restartam nivelul
    {
        Greenfoot.setWorld(new Nivel9());
    }

    public void NivelUrmator()//Schimbam nivelul cu urmatorul
    {
        LumeScrolling.setSave(true);
        LumeScrolling.setCpu(false);
        LumeScrolling.setVl(false);
        Greenfoot.setWorld(new Nivel9());
    }
}
