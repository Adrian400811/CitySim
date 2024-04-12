import greenfoot.*; // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class AdvancedManufacturing here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class AdvancedManufacturing extends Industry {
  private int SI = -1;
  private int EPR = +3;
  private int CWI = +1;
  private int type = 0;
  
  private GreenfootImage L1;
  private GreenfootImage L2;
  private GreenfootImage L3;

  public AdvancedManufacturing() {
    super(-1, +3, +1, 0);
    L1 = new GreenfootImage("images/Industry/AdvancedAndManufacturing_L1.png");
    L2 = new GreenfootImage("images/Industry/AdvancedAndManufacturing_L2.png");
    L3 = new GreenfootImage("images/Industry/AdvancedAndManufacturing_L3.png");
  }

  /**
   * Act - do whatever the AdvancedManufacturing wants to do. This method is called whenever the
   * 'Act' or 'Run' button gets pressed in the environment.
   */
  public void act() {
    checkImage();
  }
  
  
}
