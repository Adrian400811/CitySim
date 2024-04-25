import greenfoot.*; // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class EventButton here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class EventButton extends Button
{
    /**
     * Act - do whatever the EventButton wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    boolean OnOrOff=true;
    boolean ifDiscbetion=true;
    private GreenfootImage unclickedEventButton = new GreenfootImage("button/eventButton_unpressed_ON.png");
    private GreenfootImage clickedEventButton = new GreenfootImage("button/eventButton_pressed_ON.png");
    /**
     * Act - do whatever the EventButton wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public EventButton(){
        super(true);
    }
    public boolean getState(){
        return OnOrOff;
    }
    public void act()
    {
        if (Greenfoot.mouseClicked(this)) {
            OnOrOff=!OnOrOff;
            if(OnOrOff){
                clickedEventButton = new GreenfootImage("button/eventButton_pressed_ON.png");
            }
            else{
                clickedEventButton = new GreenfootImage("button/eventButton_pressed_OFF.png");
            }
            clickedEventButton.scale(400, 120);
          setImage(clickedEventButton);
        } else {
            if(OnOrOff){
                unclickedEventButton = new GreenfootImage("button/eventButton_unpressed_ON.png");
            }
            else{
                unclickedEventButton = new GreenfootImage("button/eventButton_unpressed_OFF.png");
            }
            unclickedEventButton.scale(400, 120);
          setImage(unclickedEventButton);
        }
    }
  }
