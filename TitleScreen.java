import greenfoot.*; // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The title screen for the simulator
 *
 * @author Jimmy, Adrian Daniel
 * @version April 24, 2024
 */
public class TitleScreen extends World {
  private Label titleLabel = new Label("City Simulator", 75);
  private Label startLabel = new Label("Press <enter> to begin", 45);
  private static GreenfootSound bgm = new GreenfootSound("sounds/ittybitty8bit.mp3");

  /** Constructor for objects of class TitleScreen. */
  public TitleScreen() {
    // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
    super(1280, 720, 1);
    bgm.setVolume(60);

    addObject(titleLabel, getWidth() / 2, getHeight() / 2 - 60);
    addObject(startLabel, getWidth() / 2, getHeight() / 2 + 60);
  }

  /** Act method */
  public void act() {
    if (Greenfoot.isKeyDown("enter")) {
      Settings world = new Settings(getWidth(), getHeight());
      Greenfoot.setWorld(world);
    }
  }

  /** Play background music if world has started */
  public void started() {
    bgm.playLoop();
  }

  /** Pause background music if world has stopped */
  public void stopped() {
    bgm.pause();
  }

  /** Method to stop background music from any world */
  public static void stopBGM() {
    bgm.pause();
  }

  /** Method to play background music from any world */
  public static void playBGM() {
    bgm.playLoop();
  }
}
