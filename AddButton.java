import greenfoot.*; // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class AddButton here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class AddButton extends Button {

  private GreenfootImage unclickedButton = new GreenfootImage("Adjust_Up_Button_01.png");
  private GreenfootImage clickedButton = new GreenfootImage("Adjust_Up_Button_02.png");

  public AddButton() {}

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
