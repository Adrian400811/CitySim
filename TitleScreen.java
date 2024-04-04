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
        super(1280, 720, 1); 
        
        addObject(titleLabel, getWidth()/2, getHeight()/2-60);
        addObject(startLabel, getWidth()/2, getHeight()/2+60);
    }
    
    public void act()
    {
        if (Greenfoot.isKeyDown("enter")){
            MainWorld world = new MainWorld(getWidth(), getHeight());
            Greenfoot.setWorld(world);
        }
    }
}
