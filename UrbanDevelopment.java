import greenfoot.*; // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class UrbanDevelopment here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class UrbanDevelopment extends Industry {
  private int SI = -2;
  private int EPR = +2;
  private int CWI = +1;
  private int type = 8;

  public UrbanDevelopment() {
    super(-2, +2, +1, 8);
    L1 = new GreenfootImage("images/Industry/UrbanDev1.png");
    L2 = new GreenfootImage("images/Industry/UrbanDev2.png");
    L3 = new GreenfootImage("images/Industry/UrbanDev3.png");
  }

  /**
   * Act - do whatever the UrbanDevelopment wants to do. This method is called whenever the 'Act' or
   * 'Run' button gets pressed in the environment.
   */
  public void act() {
    // Add your action code here.
    checkImage();
  }
}
