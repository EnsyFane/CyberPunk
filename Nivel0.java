import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Nivel0 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Nivel0 extends LumeScrolling
{

    /**
     * Constructor for objects of class Nivel0.
     * 
     */
    private int s,x=0;
    public Nivel0()
    {
        //Setam contorulo pentru 'boostere' la 600 pentru a le afisa la inceput
        LumeScrolling.setShouldAddB(600);
        prepare();

    }

    private void prepare()
    {
        s=LumeScrolling.getRez();//Retinem scala (rezoluta) jocului
        //Adaugam obiectele pentru nivelul respectiv
        AI ai = new AI();
        addObject(ai,659,525);
        Platforma platforma2 = new Platforma(300);
        addObject(platforma2,895,471);
        platforma2.setLocation(903,426);
        Cutie cutie = new Cutie(40, 40);
        addObject(cutie,395,337);
        platforma2.setLocation(745,514);
        Cutie cutie2 = new Cutie(40, 40);
        addObject(cutie2,349*2/3,343*2/3);
        removeObject(cutie);
        platforma2.setLocation(924*s/3,459*s/3);
        platforma2.setLocation(924*s/3,448*s/3);
        ViataPickup viatapickup = new ViataPickup(20, 20);
        addObject(viatapickup,609*s/3,550*s/3);
        addObject(new PC1(),609,550);

    }

    public void AddBoostere()//Adaugam 'boosterele'
    {

        JumpBoost jumpboost = new JumpBoost(20, 20);
        addObject(jumpboost,659*s/3-scroller.getScrolledX(),550*s/3);
    }

    public void RestartNivel()//Restartam nivelul
    {
        Greenfoot.setWorld(new Nivel0());
    }

    public void NivelUrmator()//Schimbam nivelul cu urmatorul
    {
        LumeScrolling.setCpu(false);
        Greenfoot.setWorld(new Nivel1());
    }

}