import greenfoot.*; // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class NextButton here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class NextButton extends Button {

  private GreenfootImage unclickedButton = new GreenfootImage("Confirm_Button_01.png");
  private GreenfootImage clickedButton = new GreenfootImage("Confirm_Button_02.png");

  public NextButton() {}

  /**
   * Act - do whatever the NextButton wants to do. This method is called whenever the 'Act' or 'Run'
   * button gets pressed in the environment.
   */
  public void act() {
    if (Greenfoot.mouseClicked(this)) {
      setImage(clickedButton);
      MainWorld main = new MainWorld(1280, 720);
      Greenfoot.setWorld(main);
    } else {
      setImage(unclickedButton);
    }
  }
}