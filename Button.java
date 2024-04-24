import greenfoot.*; // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Button here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Button extends Actor {
  private GreenfootImage image;
  private GreenfootImage imageSelected;
  protected boolean toggleState = false;
  
  public Button(){}
  public Button(String path, int scalePercent){
    image = new GreenfootImage(path);
    double width = image.getWidth() * scalePercent / 100;
    double height = image.getHeight() * scalePercent / 100;
    image.scale((int) width, (int) height);
    setImage(image);
  }
  /**
   * Act - do whatever the Button wants to do. This method is called whenever the 'Act' or 'Run'
   * button gets pressed in the environment.
   */
  public void act() {}

  public boolean checkClicked() {
    if (Greenfoot.mouseClicked(this)) {
      return true;
    }
    return false;
  }
  public void toggle() {
    if (toggleState) {
      toggleState = false;
    } else {
      toggleState = true;
    }
  }
}
