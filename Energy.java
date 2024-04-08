import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Energy here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Energy extends Industry
{
    private int level=1; //defualt varible
    GreenfootImage im=new GreenfootImage("images/Industry/Energy_L"+level+".png");
    /**
     * Act - do whatever the Energy wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public Energy(){
        
    }
    public void act()
    {
        setImage(im);
    }
}
