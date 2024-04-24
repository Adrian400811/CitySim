import greenfoot.*; // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Virus class
 *
 * @author Jimmy, Adrian, Daniel
 * @version April 24, 2024
 */
public class Virus extends Event {

  private GreenfootSound virusSound = new GreenfootSound("virus.wav");
  private MainWorld mw;

  private GreenfootImage virus;

  private int actsLeft;

  Label virusText = new Label("", 45);

  /** Constructor for Virus class */
  public Virus() {
    changeIndex(0, -2, -3);
    virus = new GreenfootImage(1280, 720);
    virus.setColor(Color.GREEN);
    virus.fillRect(0, 0, 1280, 720);
    virus.setTransparency(100);
    setImage(virus);

    actsLeft = 400;
  }

  public void act() {
    // Add your action code here.
    actsLeft--;

    if (actsLeft == 0) {
      virusSound.stop();
      getWorld().removeObject(this.virusText);
      getWorld().removeObject(this);
    }
  }

  /** Adds label to the left side of the screen when an instance of Virus is added to the world */
  public void addedToWorld(World MainWorld) {
    virusSound.play();
    virusText.setValue("A Virus approaches..." + "\nEPR -2" + "\nCWI -3");
    MainWorld.addObject(virusText, 230, 360);
  }
}
