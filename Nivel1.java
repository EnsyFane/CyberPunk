import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Nivel1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Nivel1 extends Nivele
{

    /**
     * Constructor for objects of class Nivel1.
     * 
     */
    public Nivel1()
    {
        Inceput();
    }
    public void Inceput()
    {
        Elev elev = new Elev();
        addObject(elev,88,530);
        elev.setLocation(129,158);
        PC pc = new PC();
        addObject(pc,1367,537);
    }
}
