import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Creare here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Creare extends World
{

    /**
     * Constructor for objects of class Creare.
     * 
     */
    public Creare()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(3000, 600, 1); 
        prepare();
    }

    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {

        PlatformaV platformav = new PlatformaV(80);
        addObject(platformav,265,519);
        PlatformaV platformav2 = new PlatformaV(150);
        addObject(platformav2,769,487);
        Cutie cutie = new Cutie(40, 40);
        addObject(cutie,494,496);
        cutie.setLocation(469,496);
        PlatformaV platformav3 = new PlatformaV(40);
        addObject(platformav3,1847,540);
        Cutie cutie2 = new Cutie(40, 40);
        addObject(cutie2,1160,461);
        AI ai = new AI();
        addObject(ai,1446,412);
        Laser laser = new Laser(300, 180, 80);
        addObject(laser,2292,406);
        Laser laser2 = new Laser(300, 180, 80);
        addObject(laser2,2397,406);
        Laser laser3 = new Laser(300, 180, 80);
        addObject(laser3,2502,406);
        SpeedBoost speedboost = new SpeedBoost();
        addObject(speedboost,2327,554);
        removeObject(speedboost);
        SpeedBoost speedboost2 = new SpeedBoost(20, 20);
        addObject(speedboost2,2314,551);
        PlatformaO platformao = new PlatformaO(150);
        addObject(platformao,2924,383);
        platformao.setLocation(2925,408);
        PlatformaO platformao2 = new PlatformaO(600);
        addObject(platformao2,2479,204);
        platformao2.setLocation(2414,250);
        PlatformaO platformao3 = new PlatformaO(40);
        addObject(platformao3,2744,302);
        JumpBoost jumpboost = new JumpBoost(20, 20);
        addObject(jumpboost,2788,552);
        PC0 pc0 = new PC0(40, 40);
        addObject(pc0,2369,211);

        PlatformaV platformav4 = new PlatformaV(40);
        addObject(platformav4,2177,204);
        platformav4.setLocation(2134,210);

        LaserOrizontal laserorizontal = new LaserOrizontal(60, 120, 150);
        addObject(laserorizontal,2178,217);
        laserorizontal.setLocation(2184,211);
        PlatformaV platformav5 = new PlatformaV(40);
        addObject(platformav5,2283,207);
        platformav5.setLocation(2234,211);
        CPU cpu = new CPU(30, 30);
        addObject(cpu,2190,220);
        cpu.setLocation(2184,212);
        PlatformaV x = new PlatformaV(20);
        addObject(x,2728,550);
        PlatformaO platformao4 = new PlatformaO(150);
        addObject(platformao4,1860,252);
        ViataPickup viatapickup = new ViataPickup(25, 25);
        addObject(viatapickup,1858,218);

        PlatformaO p = new PlatformaO(350);
        addObject(p,1550,252);
        platformav4.setLocation(1419,212);
        laserorizontal.setLocation(1469,213);
        platformav5.setLocation(1519,213);
        cpu.setLocation(1572,145);
        cpu.setLocation(1468,212);
        cpu.setLocation(1470,214);
    }
}
