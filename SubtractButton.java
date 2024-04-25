import greenfoot.*; // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * SubtractButton class
 *
 * @author Jimmy, Adrian, Daniel
 * @version April 24, 2024
 */
public class SubtractButton extends Button {
  private boolean ifDiscbetion=false;
  private GreenfootImage unclickedButton = new GreenfootImage("button/buttonL_unpressed.png");
  private GreenfootImage clickedButton = new GreenfootImage("button/buttonL_pressed.png");

  public SubtractButton() {
    super(false);
    clickedButton.scale(32, 32);
      unclickedButton.scale(32, 32);
}

  /** Act - Sets image to clicked if clicked on. Button image stays the same if not clicked */
  public void act() {
    if (Greenfoot.mouseClicked(this)) {
      setImage(clickedButton);
    } else {
      setImage(unclickedButton);
    }
  }
}
