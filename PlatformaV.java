import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class PlatformaV here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PlatformaV extends Platforma

{
    private int s=LumeScrolling.getRez();
    public PlatformaV(int inaltime)
    {
        GreenfootImage stock = new GreenfootImage("bricks3.jpg");
        GreenfootImage platforma = new GreenfootImage(40,inaltime);
        //Desenam imaginea pentru platforma in functie de lungime si rezolutie
        for(int y=0;y<inaltime;y+=40)
        {
            platforma.drawImage(stock,0,y);
        }
        setImage(platforma);
        GreenfootImage image = getImage();
        image.scale(40*s/3,inaltime*s/3);
        setImage(image);
    }  
}
