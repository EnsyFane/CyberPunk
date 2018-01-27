import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Nivel0 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Nivel0 extends Nivele
{

    /**
     * Constructor for objects of class Nivel0.
     * 
     */
    private int s;
    public Nivel0()
    {
       Nivele.setShouldAddB(600);
        prepare();
       
    }
 
    private void prepare()
    {
        s=Nivele.getRez();
        Platforma platforma = new Platforma();
        addObject(platforma,376,522);
        platforma.setLocation(398*s/3,535*s/3);
        AI ai = new AI();
        addObject(ai,659,525);
        Platforma platforma2 = new Platforma();
        addObject(platforma2,895,471);
        platforma2.setLocation(745,514);
        Cutie cutie2 = new Cutie(40, 40);
        addObject(cutie2,349*2/3,343*2/3);
        Spikes spikes3 = new Spikes(30, 30);
        addObject(spikes3,823,429);
        spikes3.setLocation(824*s/3,412*s/3);
        platforma2.setLocation(924*s/3,448*s/3);
        ViataPickup viatapickup = new ViataPickup(20, 20);
        addObject(viatapickup,609,550);
        Tutorial0 tutorial0 = new Tutorial0(30, 30);
        addObject(tutorial0,403*s/3,498*s/3);
    }
    
    public void AddBoostere()
    {
        JumpBoost jumpboost = new JumpBoost(20, 20);
        addObject(jumpboost,659*s/3,550*s/3);
    }
    
    public void RestartNivel(boolean dead)
    {
        if(dead) Greenfoot.setWorld(new StartScreen());
        else Greenfoot.setWorld(new Nivel0());
    }
    
    public void NivelUrmator()
    {
        Greenfoot.setWorld(new Nivel1());
    }
}
