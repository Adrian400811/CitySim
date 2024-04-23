import greenfoot.*; // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Earthquake here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Earthquake extends Event {
  private MainWorld mw;
  private int actsLeft;

  Label earthquakeText = new Label("", 40);

  /**
   * Act - do whatever the Earthquake wants to do. This method is called whenever the 'Act' or 'Run'
   * button gets pressed in the environment.
   */
  public Earthquake() {
    changeIndex(-1, -3, -4);
    actsLeft = 300;
    setImage("CrackedStoneWallpaper.jpg");
  }

  public void act() {
    // Add your action code here.
    actsLeft--;

    if (actsLeft == 0) {
      getWorld().removeObject(this.earthquakeText);
      getWorld().removeObject(this);
    }
  }

  public void addedToWorld(World MainWorld) {
    earthquakeText.setValue("An Earthquake approaches..." + "\nSI -1" + "\nEPR -3" + "\nCWI -4");
    MainWorld.addObject(earthquakeText, 230, 360);
  }
}
