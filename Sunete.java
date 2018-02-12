import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Sunete here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Sunete extends Actor
{
    /**
     * Act - do whatever the Sunete wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private static GreenfootSound muzica = new GreenfootSound("Fundal.wav");
    public static void Fundal()
    {
        if(!muzica.isPlaying())
        {
            muzica.setVolume(50);
            muzica.playLoop();
        }
    }

    public static void Mort()
    {
        GreenfootSound mort = new GreenfootSound("Mort.wav");
        mort.play();
    }

    public static void Pickup()
    {
        GreenfootSound pickup = new GreenfootSound("Pickup.wav");
        pickup.play();
    }

    public static void Ok()
    {
        GreenfootSound ok = new GreenfootSound("Ok.wav");
        ok.play();
    }

    public static void Saritura()
    {
        GreenfootSound saritura = new GreenfootSound("Saritura.wav");
        saritura.setVolume(85);
        saritura.play();
    }

    public static boolean On()
    {
        return muzica.isPlaying();
    }
}
