import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class RoundButton here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class RoundButton extends Button
{
    /**
     * Act - do whatever the RoundButton wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
     boolean ifDiscbetion=true;
    private GreenfootImage unclickedEventButton = new GreenfootImage("Button/roundButton_unpressed.png");
    private GreenfootImage clickedEventButton = new GreenfootImage("Button/roundButton_pressed.png");
    public RoundButton(){
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
