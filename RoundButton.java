import greenfoot.*; // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class RoundButton here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class RoundButton extends Button {
  /**
   * Act - do whatever the RoundButton wants to do. This method is called whenever the 'Act' or
   * 'Run' button gets pressed in the environment.
   */
  boolean ifDiscbetion = true;

  private boolean holdState = false;
  private GreenfootImage clickedEventButton;
  private GreenfootImage unclickedEventButton;

  public RoundButton() {
    super(true);
    clickedEventButton = new GreenfootImage("button/roundButton_pressed.png");
    unclickedEventButton = new GreenfootImage("button/roundButton_unpressed.png");
    clickedEventButton.scale(216, 100);
    unclickedEventButton.scale(216, 100);
    setImage(unclickedEventButton);
  }
}
