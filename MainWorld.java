import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MainWorld extends World
{
    Label title = new Label ("MainWorld", 45);
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public  MainWorld(int width, int height)
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(width, height, 1); 
        addObject(title, getWidth()/10, 60);
    }
    
}