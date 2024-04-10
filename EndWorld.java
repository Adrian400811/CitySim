import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class EndWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class EndWorld extends World
{
    Label index = new Label("", 45);
    private int SI, EPR, CWI;
    /**
     * Constructor for objects of class EndWorld.
     * 
     */
    public EndWorld(int width, int height, int SI, int EPR, int CWI)
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(width, height, 1); 
        this.SI = SI;
        this.EPR = EPR;
        this.CWI = CWI;
        
        // for dev use
        addObject(index, getWidth()/2, getHeight()/2);
        index.setValue("SI"+SI+"EPR"+EPR+"CWI"+CWI);
    }
}
