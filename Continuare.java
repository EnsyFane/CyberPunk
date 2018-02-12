import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
/**
 * Write a description of class Continuare here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Continuare extends Clickabile
{
    /**
     * Act - do whatever the Continuare wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private boolean clicked = false;
    private int x,y;
    public Continuare()
    {
        this(502,77);

    }

    public Continuare(int lungime , int inaltime)
    {
        int s=StartScreen.getRez();
        GreenfootImage image = getImage();
        image.scale(lungime*s/3,inaltime*s/3);//Setam imaginea in functie de rezolutie
        setImage(image);    
        x=lungime*s/3;
        y=inaltime*s/3;
    }

    public void act() 
    {
        CheckMouseOver();//Verificam daca mouse-ul se afla pe buton
        CheckClick();//Verificam daca buotnul este apasat
    }

    public void CheckMouseOver()
    {
        MouseInfo mouse = Greenfoot.getMouseInfo();
        if (mouse != null) 
        {
            setImage("Continuare.png");
            GreenfootImage image = getImage();
            image.scale(x,y);
            setImage(image);   
            List objects = getWorld().getObjectsAt(mouse.getX(), mouse.getY(), Continuare.class);
            for (Object object : objects)
            {
                if (object == this)//Daca mouse-ul se afla pe suprafata butonului
                {
                    setImage("ContinuareIn.png");//Setam imaginea 'Inverted'
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
        if(Greenfoot.mouseClicked(this))//Verificam daca este apasat butonul
        {
            clicked = true;
            Greenfoot.playSound("SunetButon.wav");
        }
    }

    public boolean getClicked()
    {
        return clicked;
    }
}
