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
        nvl=0;
        if(getSave())
            Salvare.salveaza(getInf());
        prepare();

    }

    private void prepare()
    {
        s=LumeScrolling.getRez();//Retinem scala (rezoluta) jocului
        //Adaugam obiectele pentru nivelul respectiv
        PlatformaV platformav = new PlatformaV(80);
        addObject(platformav,265*s/3,519*s/3);
        PlatformaV platformav2 = new PlatformaV(150);
        addObject(platformav2,769*s/3,487*s/3);
        Cutie cutie = new Cutie(40, 40);
        addObject(cutie,494*s/3,496*s/3);
        cutie.setLocation(469*s/3,496*s/3);
        PlatformaV platformav3 = new PlatformaV(40);
        addObject(platformav3,1847*s/3,540*s/3);
        Cutie cutie2 = new Cutie(40, 40);
        addObject(cutie2,1160*s/3,461*s/3);
        AI ai = new AI();
        addObject(ai,1446*s/3,412*s/3);
        Laser laser = new Laser(300, 180, 100);
        addObject(laser,2292*s/3,406*s/3);
        Laser laser2 = new Laser(300, 180, 100);
        addObject(laser2,2397*s/3,406*s/3);
        Laser laser3 = new Laser(300, 180, 100);
        addObject(laser3,2502*s/3,406*s/3);
        PlatformaO platformao = new PlatformaO(150);
        addObject(platformao,2924*s/3,383*s/3);
        platformao.setLocation(2925*s/3,408*s/3);
        PlatformaO platformao2 = new PlatformaO(600);
        addObject(platformao2,2479*s/3,204*s/3);
        platformao2.setLocation(2414*s/3,250*s/3);
        PlatformaO platformao3 = new PlatformaO(40);
        addObject(platformao3,2744*s/3,302*s/3);
        PC0 pc0 = new PC0(40, 40);
        addObject(pc0,2369*s/3,211*s/3);
        PlatformaV platformav4 = new PlatformaV(40);
        addObject(platformav4,2177*s/3,204*s/3);
        platformav4.setLocation(1419*s/3,212*s/3);
        LaserOrizontal laserorizontal = new LaserOrizontal(60, 120, 150);
        addObject(laserorizontal,2178*s/3,217*s/3);
        laserorizontal.setLocation(1469*s/3,213*s/3);
        PlatformaV platformav5 = new PlatformaV(40);
        addObject(platformav5,2283*s/3,207*s/3);
        platformav5.setLocation(1519*s/3,213*s/3);
        PlatformaV x = new PlatformaV(20);
        addObject(x,2628*s/3,550*s/3);
        Tutorial0 tutorial0 = new Tutorial0(40, 40);
        addObject(tutorial0,113*s/3,536*s/3);
        cutie.setLocation(588*s/3,472*s/3);
        Tutorial1 tutorial1 = new Tutorial1(40, 40);
        addObject(tutorial1,374*s/3,536*s/3);
        PlatformaO platformao4 = new PlatformaO(150);
        addObject(platformao4,1940*s/3,252*s/3);
        PlatformaO p = new PlatformaO(350);
        addObject(p,1550*s/3,252*s/3);
        Tutorial2 tutorial2 = new Tutorial2();
        addObject(tutorial2,951*s/3,536*s/3);
        Tutorial3 tutorial3 = new Tutorial3();
        addObject(tutorial3,1957*s/3,536*s/3);
        Tutorial4 tutorial4 = new Tutorial4();
        addObject(tutorial4,2688*s/3,536*s/3);
        Tutorial5 tutorial5 = new Tutorial5();
        addObject(tutorial5,2535*s/3,211*s/3);
        Tutorial6 tutorial6 = new Tutorial6();
        addObject(tutorial6,2238*s/3,211*s/3);
        Tutorial7 tutorial7 = new Tutorial7();
        addObject(tutorial7,1621*s/3,213*s/3);
    }

    public void AddBoostere()//Adaugam 'boosterele'
    {
        SpeedBoost speedboost2 = new SpeedBoost(20, 20);
        addObject(speedboost2,2214*s/3-scroller.getScrolledX(),551*s/3);
        JumpBoost jumpboost = new JumpBoost(20, 20);
        addObject(jumpboost,2788*s/3-scroller.getScrolledX(),552*s/3);

    }

    public void AddCpu()
    {
        CPU cpu = new CPU(30, 30);
        addObject(cpu,1470*s/3,214*s/3);
    }

    public void AddViata()
    {
        ViataPickup viatapickup = new ViataPickup(25, 25);
        addObject(viatapickup,1938*s/3,218*s/3);
    }

    public void RestartNivel()//Restartam nivelul
    {
        Greenfoot.setWorld(new Nivel0());
    }

    public void NivelUrmator()//Schimbam nivelul cu urmatorul
    {
        LumeScrolling.setSave(true);
        LumeScrolling.setCpu(false);
        LumeScrolling.setVl(false);
        Greenfoot.setWorld(new Nivel1());
    }


}