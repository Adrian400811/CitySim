import greenfoot.*; // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * IndustryButton Class
 *
 * @author Jimmy, Adrian, Daniel
 * @version April 24, 2024
 */
public class IndustryButton extends Button {
  private GreenfootImage image;
  private GreenfootImage imageSelected;
  private int type;
  protected boolean toggleState = false;
  private String[] icons = {
    "Manufacturing",
    "Agriculture",
    "Education",
    "Energy",
    "Forestry",
    "Material",
    "Technology",
    "Recreation",
    "UrbanDev"
  };

  /**
   * Constructor for IndustryButton
   * 
   * @param type    The index of the corresponding Industry
   */
  public IndustryButton(int type) {
    this.type = type;
    image = new GreenfootImage("images/industry/" + icons[type] + "1.png");
    imageSelected = new GreenfootImage("images/industry/" + icons[type] + "Selected.png");
    image.scale(128, 128);
    imageSelected.scale(128, 128);
    setImage(image);
  }

  /**
   * Act - do whatever the IndustryButton wants to do. This method is called whenever the 'Act' or
   * 'Run' button gets pressed in the environment.
   */
  public void act() {
    // Add your action code here.
  }

  /**
   * Sets image and value for variable if it is toggled on/off
   */
  public void toggle() {
    if (toggleState) {
      toggleState = false;
      setImage(image);
    } else {
      toggleState = true;
      setImage(imageSelected);
    }
  }
}
