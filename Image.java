import greenfoot.*; // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Image class. Allows for easier modification of images
 *
 * @author Jimmy, Adrian, Daniel
 * @version April 24, 2024
 */
public class Image extends Actor {
  private GreenfootImage image;

  /**
   * Sets image with its original proportions
   *
   * @param path Location of the file
   */
  public Image(String path) {
    image = new GreenfootImage(path);
    setImage(image);
  }

  /**
   * Sets image with scaled proportions in its X and Y
   *
   * @param path Location of the file
   * @param scaleX Amount of X scaled
   * @param scaleY Amount of Y scaled
   */
  public Image(String path, int scaleX, int scaleY) {
    image = new GreenfootImage(path);
    image.scale(scaleX, scaleY);
    setImage(image);
  }

  /**
   * Sets image with percentage scaled proportions
   *
   * @param path Location of the file
   * @param scalePercent Percentage scaled
   */
  public Image(String path, int scalePercent) {
    image = new GreenfootImage(path);
    double width = image.getWidth() * scalePercent / 100;
    double height = image.getHeight() * scalePercent / 100;
    image.scale((int) width, (int) height);
    setImage(image);
  }

  /**
   * Act - do whatever the Image wants to do. This method is called whenever the 'Act' or 'Run'
   * button gets pressed in the environment.
   */
  public void act() {
    // Add your action code here.
  }
}
