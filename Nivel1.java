import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Nivel1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Nivel1 extends LumeScrolling
{

    /**
     * Constructor for objects of class Nivel1.
     * 
     */
    public Nivel1()
    {
        LumeScrolling.setShouldAddB(600);
        nvl=1;
        if(getSave())
            Salvare.salveaza(getInf());
    }

    public int getInf()
    {
        int slv;
        slv=(nvl*10);
        if(getViata0())
            slv+=1;
        slv*=10;
        if(getViata1())
            slv+=1;
        slv*=10;
        if(getViata2())
            slv+=1;
        slv*=10;
        if(getCpu())
            slv+=1;
        slv*=10;
        if(getVl())
            slv+=1;
        slv*=10;
        if(getEgg())
            slv+=1;
        return slv;
    }
}
