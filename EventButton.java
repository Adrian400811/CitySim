import greenfoot.*; // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class EventButton here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class EventButton extends Button {
  boolean ifDiscbetion = true;
  private GreenfootImage unclickedEventButton;
  private GreenfootImage clickedEventButton;

  /**
   * Act - do whatever the EventButton wants to do. This method is called whenever the 'Act' or
   * 'Run' button gets pressed in the environment.
   */
  public EventButton() {
    super(true);
    toggleState = false;
    clickedEventButton = new GreenfootImage("button/eventButton_pressed.png");;
    unclickedEventButton = new GreenfootImage("button/eventButton_unpressed.png");
    clickedEventButton.scale(216, 100);
    unclickedEventButton.scale(216, 100);
    setImage(unclickedEventButton);
  }

  public void act() {
    if (Greenfoot.mouseClicked(this)) {
      toggle();
    }
  }
  public void toggle() {
    if (toggleState) {
      toggleState = false;
      setImage(unclickedEventButton);
    } else {
      toggleState = true;
      setImage(clickedEventButton);
    }
  }
}