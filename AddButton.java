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

  private String type = "";

  public AddButton(String type) {
    if (type.equals("SI")) {
      this.type = "SI";
    } else if (type.equals("EPR")) {
      this.type = "EPR";
    } else if (type.equals("CWI")) {
      this.type = "CWI";
    }
  }

  /**
   * Act - do whatever the AddButton wants to do. This method is called whenever the 'Act' or 'Run'
   * button gets pressed in the environment.
   */
  public void act() {
    if (Greenfoot.mouseClicked(this)) {
      setImage(clickedButton);
      if (type.equals("SI")) {
        MainWorld.changeSI(1);
      } else if (type.equals("CWI")) {
        MainWorld.changeCWI(1);
      } else if (type.equals("EPR")) {
        MainWorld.changeEPR(1);
      }
    } else {
      setImage(unclickedButton);
    }
  }
}
