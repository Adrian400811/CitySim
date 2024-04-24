import greenfoot.*; // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Button Superclass
 *
 * @author Jimmy, Adrian, Daniel
 * @version April 24, 2024
 */
public abstract class Button extends Actor {
  /**
   * Act - do whatever the Button wants to do. This method is called whenever the 'Act' or 'Run'
   * button gets pressed in the environment.
   */
  public void act() {}

  /**
   * Checks if the button was clicked
   * 
   * @return boolean    True if clicked, false if not clicked
   */
  public boolean checkClicked() {
    if (Greenfoot.mouseClicked(this)) {
      return true;
    }
    return false;
  }
}
