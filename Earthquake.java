import greenfoot.*; // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Earthquake Class
 *
 * @author Jimmy, Adrian, Daniel
 * @version April 24, 2024
 */
public class Earthquake extends Event {
  private GreenfootSound rumble = new GreenfootSound("rumble.wav");
  private MainWorld mw;
  private int actsLeft;

  Label earthquakeText = new Label("", 40);

  /** Constructor for Earthquake */
  public Earthquake() {
    changeIndex(-1, -3, -4);
    actsLeft = 700;
    setImage("CrackedStoneWallpaper.jpg");
  }

  public void act() {
    // Add your action code here.
    actsLeft--;

    if (actsLeft == 0) {
      rumble.stop();
      getWorld().removeObject(this.earthquakeText);
      getWorld().removeObject(this);
    }
  }

  /**
   * Adds label to the left side of the screen when an instance of Earthquake is added to the world
   */
  public void addedToWorld(World MainWorld) {
    rumble.play();
    earthquakeText.setValue("An Earthquake approaches..." + "\nSI -1" + "\nEPR -3" + "\nCWI -4");
    MainWorld.addObject(earthquakeText, 230, 360);
  }
}
