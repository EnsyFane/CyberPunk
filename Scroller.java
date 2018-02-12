import greenfoot.*;
//Functie pentru scroll
public class Scroller extends Actor
{
    private World world; // partea din lume vizibila
    private GreenfootImage scrollImage; // fundalul pentru scroll
    private int scrolledX; // distanta de la lumea vizibila initiala
    private int wide, high; // dimensiunea totala a lumii

    public Scroller(World viewWorld, GreenfootImage image, int wide, int high)
    {
        this.wide = wide;
        this.high = high;
        world = viewWorld;
        if (image != null)
        {
            scrollImage = image;
            scroll(0, 0);
        }
    }

    public void scroll(int dsx, int dsy)
    {
        //calculam limita de scroll
        int maxX = wide-world.getWidth();
        // verificam ca ecranul vizibil sa nu depaseasca marimea lumii
        if (scrolledX+dsx < 0) dsx = -scrolledX;
        if (scrolledX+dsx >= maxX) dsx = maxX-scrolledX;
        // actualizam distanta parcursa de la lumea vizibila initiala
        scrolledX += dsx;
        // actualizam imaginea de fundal pentru effectul de 'scroll'
        if (scrollImage != null)
        {
            world.getBackground().drawImage
            (   
                scrollImage,
                -scrolledX*world.getCellSize(),
                0
            );
        }

        // schimbam pozitia obiectelor in functie de distanta parcursa de la lumea vizibila initiala 
        for (Object obj : world.getObjects(null))
        {
            Actor actor = (Actor) obj;
            actor.setLocation(actor.getX()-dsx, actor.getY());
        }
    }

    //returnam distanta parcursa de la lumea vizibila initiala 
    public int getScrolledX()
    {
        return scrolledX;
    }

}