import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
/**
 * Write a description of class HD here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class HD extends Clickabile
{
    private boolean clicked = false;
    private int x,y;
    public HD()
    {
        this(362,170);
        
    }
    
    public HD(int lungime , int inaltime)
    {
        int s=StartScreen.getRez();
        GreenfootImage image = getImage();
        image.scale(lungime*s/3,inaltime*s/3);
        setImage(image);    
        x=lungime*s/3;
        y=inaltime*s/3;
    }
    
    public void act() 
    {
        // Add your action code here.
        CheckMouseOver();
        CheckClick();
    }
    
    public void CheckMouseOver()
    {
        MouseInfo mouse = Greenfoot.getMouseInfo();
        //Change Button.class to the name of your button class.
        if (mouse != null) {
            //change the file to what you want for when the mouse is not over the button.
            setImage("720p.png");
            GreenfootImage image = getImage();
            image.scale(x,y);
            setImage(image);   
            List objects = getWorld().getObjectsAt(mouse.getX(), mouse.getY(), HD.class);
            for (Object object : objects)
            {
                if (object == this)
                {
                    //change the file to what you want for when the mouse is over the button.
                    setImage("720pInverted.png");
                    image = getImage();
                    image.scale(x,y);
                    setImage(image);   
                }
            }
        }
    }
    
    public void CheckClick()
    {
        MouseInfo mouse = Greenfoot.getMouseInfo();
        if(Greenfoot.mouseClicked(this))
        clicked = true;
    }
    
    public boolean getClicked()
    {
        return clicked;
    }
}
