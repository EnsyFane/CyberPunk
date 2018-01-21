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
    public Nivel0()
    {
        prepare();
    }

 
    private void prepare()
    {

        Platforma platforma = new Platforma();
        addObject(platforma,376,522);
        platforma.setLocation(398,535);
        SpeedBoost speedboost = new SpeedBoost();
        addObject(speedboost,500,503);
        removeObject(speedboost);
        SpeedBoost speedboost2 = new SpeedBoost(20, 20);
        addObject(speedboost2,503,508);
        JumpBoost jumpboost = new JumpBoost(20, 20);
        addObject(jumpboost,659,550);
        removeObject(jumpboost);
        AI ai = new AI();
        addObject(ai,659,525);
        Platforma platforma2 = new Platforma();
        addObject(platforma2,895,471);
        platforma2.setLocation(903,426);
        Cutie cutie = new Cutie(40, 40);
        addObject(cutie,395,337);
        platforma2.setLocation(745,514);
        Cutie cutie2 = new Cutie(40, 40);
        addObject(cutie2,349,343);
        Spikes spikes = new Spikes(30, 30);
        addObject(spikes,717,479);
        removeObject(cutie);
        platforma2.setLocation(924,459);
        removeObject(spikes);
        Spikes spikes2 = new Spikes(30, 30);
        addObject(spikes2,863,431);
        spikes2.setLocation(862,424);
        spikes2.setLocation(836,418);
        removeObject(spikes2);
        Spikes spikes3 = new Spikes(30, 30);
        addObject(spikes3,823,429);
        spikes3.setLocation(824,424);
        spikes3.setLocation(824,412);
        platforma2.setLocation(924,448);
    }
    public void RestartNivel()
    {
        Greenfoot.setWorld(new Nivel0());
    }
    public void NivelUrmator()
    {
        Greenfoot.setWorld(new Nivel1());
    }
}
