import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Industry here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public abstract class Industry extends Actor
{
    private MainWorld mw;
    private int level = 0;
    private int coins = 0;
    private int count = 0;
    private int type;
    private int SI, EPR, CWI;
    
    private double[] growthRate = {1.2, 1.1, 1.3, 1.2, 1.1, 1.3, 1.3, 1.1, 1.2};
    private double[] lvlMultipliers = {1.0, 1.5, 2.0};
    public Industry(int SI, int EPR, int CWI, int type){
        this.SI = SI;
        this.EPR = EPR;
        this.CWI = CWI;
        this.type = type;
    }
    
    /**
     * Act - do whatever the Industry wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        // Add your action code here.
    }
    
    public void addedToWorld(World w){
        mw = (MainWorld) w;
    }
    
    public double income(){
        int baseIncome = 100 * mw.getEPR();
        double industryIncome = count * lvlMultipliers[level] * level;
        double totalIncome = (baseIncome + industryIncome) * growthRate[type];
        double bonus; // TODO
        double grandTotal = totalIncome;// + bonus;
        return grandTotal;
    }
}
