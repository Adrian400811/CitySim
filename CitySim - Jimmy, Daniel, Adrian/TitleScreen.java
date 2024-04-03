import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class TitleScreen here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TitleScreen extends World
{
    Label titleLabel = new Label ("City Simulator", 75);
    Label startLabel = new Label ("Press <enter> to begin", 45);
    /**
     * Constructor for objects of class TitleScreen.
     * 
     */
    public TitleScreen()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        
        addObject(titleLabel, 300, 60);
        addObject(startLabel, 300, 200);
    }
    
    public void act()
    {
        if (Greenfoot.isKeyDown("enter")){
            MyWorld world = new MyWorld();
            Greenfoot.setWorld(world);
        }
    }
}
