import greenfoot.*; // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class AddButton here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class AddButton extends Button {
    private boolean ifDiscbetion=false;
  private GreenfootImage unclickedButton = new GreenfootImage("Button/buttonR_unpressed.png");
  private GreenfootImage clickedButton = new GreenfootImage("Button/buttonR_pressed.png");

  public AddButton(){
      super(false);
      clickedButton.scale(32, 32);
      unclickedButton.scale(32, 32);
  }

  /**
   * Act - do whatever the AddButton wants to do. This method is called whenever the 'Act' or 'Run'
   * button gets pressed in the environment.
   */
  public void act() {
    if (Greenfoot.mouseClicked(this)) {
      setImage(clickedButton);
    } else {
      setImage(unclickedButton);
    }
  }
}
