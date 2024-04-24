import greenfoot.*; // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import greenfoot.GreenfootSound;

/**
 * Storm class
 *
 * @author Jimmy, Adrian, Daniel
 * @version April 24, 2024
 */
public class Storm extends Event {
  private GreenfootSound storm = new GreenfootSound("storm.wav");
  private int actsLeft;
  private int direction;
  private double speed;

  private GreenfootImage image;

  private MainWorld mw;

  Label stormText = new Label("", 45);

  /** Constructor for Storm */
  public Storm() {
    changeIndex(-1, -1, -2);
    image = Utility.drawStorm(2560, 1440, 100);
    setImage(image);

    actsLeft = 700;

    speed = 0.55;
  }

  /**
   * Act - do whatever the Storm wants to do. This method is called whenever the 'Act' or 'Run'
   * button gets pressed in the environment.
   */
  public void act() {
    actsLeft--;

    setLocation((double) (getX() - speed), (double) (getY() + speed));

    if (actsLeft == 0) {
      storm.stop();
      getWorld().removeObject(this.stormText);
      getWorld().removeObject(this);
    }
  }

  /** Adds label to the left side of the screen when an instance of Storm is added to the world */
  public void addedToWorld(World MainWorld) {
    storm.play();
    stormText.setValue("A Storm approaches..." + "\nSI -1" + "\nEPR -1" + "\nCWI -2");
    MainWorld.addObject(stormText, 230, 360);
  }
}
