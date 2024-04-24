import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class EventButton here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class EventButton extends Button
{
    boolean ifDiscbetion=true;
    private GreenfootImage unclickedEventButton = new GreenfootImage("Button/eventButton_unpressed.png");
    private GreenfootImage clickedEventButton = new GreenfootImage("Button/eventButton_pressed.png");
    /**
     * Act - do whatever the EventButton wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public EventButton(){
        super(true);
    }
    public void act()
    {
        if (Greenfoot.mouseClicked(this)) {
            clickedEventButton.scale(320, 160);
          setImage(clickedEventButton);
        } else {
            unclickedEventButton.scale(320, 160);
          setImage(unclickedEventButton);
        }
    }
}
