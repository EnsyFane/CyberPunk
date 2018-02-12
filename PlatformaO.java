import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class PlatformaO here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PlatformaO extends Platforma
{
    private int s=LumeScrolling.getRez();
    public PlatformaO(int lungime)
    {
        GreenfootImage stock = new GreenfootImage("bricks3.jpg");
        GreenfootImage platforma = new GreenfootImage(lungime,40);
        //Desenam imaginea pentru platforma in functie de lungime si rezolutie
        for(int x=0;x<lungime;x+=40)
        {
        platforma.drawImage(stock,x,0);
        }
        setImage(platforma);
        GreenfootImage image = getImage();
        image.scale(lungime*s/3,40*s/3);
        setImage(image);
    }
}
