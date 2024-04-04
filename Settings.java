import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Settings here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Settings extends World
{
    Label title = new Label ("Settings", 45);
    
    /**
     * Constructor for objects of class Settings.
     * 
     */
    public Settings(int width, int height)
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(width, height, 1);
        addObject(title, getWidth()/10, 60);
    }
    
    public void act()
    {
        if (Greenfoot.isKeyDown("enter")){
            MainWorld mainWorld = new MainWorld(getWidth(), getHeight());
            Greenfoot.setWorld(mainWorld);
        }
    }
}