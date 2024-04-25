import greenfoot.*; // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class NextButton here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class NextButton extends Button {
  private boolean ifDiscbetion=false;
  private GreenfootImage unclickedCycleButton = new GreenfootImage("Button/buttonR_unpressed.png");
  private GreenfootImage clickedCycleButton = new GreenfootImage("Button/buttonR_pressed.png");

  public NextButton(){
      super(false);
      clickedCycleButton.scale(32, 32);
      unclickedCycleButton.scale(32, 32);
  }

  /**
   * Act - do whatever the NextButton wants to do. This method is called whenever the 'Act' or 'Run'
   * button gets pressed in the environment.
   */
  public void act() {
    if (Greenfoot.mouseClicked(this)) {
      setImage(clickedCycleButton);
    } else {
      setImage(unclickedCycleButton);
    }
  }
}
