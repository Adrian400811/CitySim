import greenfoot.*; // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * SubtractButton class
 *
 * @author Jimmy, Adrian, Daniel
 * @version April 24, 2024
 */
public class SubtractButton extends Button {
  private boolean ifDiscbetion = false;
  private GreenfootImage unclickedButton = new GreenfootImage("Adjust_Down_Button_01.png");
  private GreenfootImage clickedButton = new GreenfootImage("Adjust_Down_Button_02.png");

  public SubtractButton() {
    super(false);
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
