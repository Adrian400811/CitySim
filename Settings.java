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
    Label sustainable = new Label ("Sustainability Index", 45);
    Label economic = new Label ("Economic Prosperity Rating", 45);
    Label community = new Label ("Community Well-being Index", 45);
    
    /**
     * Constructor for objects of class Settings.
     * 
     */
    public Settings(int width, int height)
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(width, height, 1);
        addObject(title, getWidth()/10, 60);
        addObject (sustainable, getWidth()/2, 180);
        addObject (economic, getWidth()/2, 300);
        addObject (community, getWidth()/2, 420);
    }
    
    public void act()
    {
        Greenfoot.delay(10);
        if (Greenfoot.isKeyDown("enter")){
            MainWorld mainWorld = new MainWorld(getWidth(), getHeight());
            Greenfoot.setWorld(mainWorld);
        }
        spawnButtons();
    }
    
    public void spawnButtons(){
        addObject(new AddButton("SI"), getWidth()/2+300, 180);
        addObject(new SubtractButton("SI"), getWidth()/2-300, 180);
        
        addObject(new AddButton("EPR"), getWidth()/2+300, 300);
        addObject(new SubtractButton("EPR"), getWidth()/2-300, 300);
        
        addObject(new AddButton("CWI"), getWidth()/2+300, 420);
        addObject(new SubtractButton("CWI"), getWidth()/2-300, 420);
        
    }
}
