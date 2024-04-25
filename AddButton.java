import greenfoot.*; // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * AddButton Class
 *
 * @author Jimmy, Adrian, Daniel
 * @version April 24, 2024
 */
public class AddButton extends Button {
  private boolean ifDiscbetion = false;
  private GreenfootImage unclickedButton = new GreenfootImage("Adjust_Up_Button_01.png");
  private GreenfootImage clickedButton = new GreenfootImage("Adjust_Up_Button_02.png");

  public AddButton() {
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
