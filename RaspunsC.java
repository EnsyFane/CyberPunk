import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;

public class RaspunsC extends Raspunsuri

{
    private int x,y;
    private GreenfootImage n,in;
    public RaspunsC(GreenfootImage a,GreenfootImage b)
    {

        this(a.getWidth(),b.getHeight(),a,b);

    }

    public RaspunsC(int lungime , int inaltime,GreenfootImage a,GreenfootImage b)
    {
        int s=StartScreen.getRez();
        GreenfootImage image = a;
        image.scale(lungime*s/3,inaltime*s/3);
        setImage(image);    
        x=lungime*s/3;
        y=inaltime*s/3;
        n=a;
        in=b;
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
            setImage(n);
            GreenfootImage image = getImage();
            image.scale(x,y);
            setImage(image);   
            List objects = getWorld().getObjectsAt(mouse.getX(), mouse.getY(), RaspunsC.class);
            for (Object object : objects)
            {
                if (object == this)
                {
                    //change the file to what you want for when the mouse is over the button.
                    setImage(in);
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
        {
            Sunete.Ok();
            ((LumeScrolling)getWorld()).NivelUrmator();
        }
    } 
}
