import greenfoot.*; // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Energy here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Energy extends Industry {
  private int SI = +2;
  private int EPR = +2;
  private int CWI = +1;
  private int type = 3;

  public Energy() {
    super(+2, +2, +1, 3);
    L1 = new GreenfootImage("images/Industry/Energy1.png");
    L2 = new GreenfootImage("images/Industry/Energy2.png");
    L3 = new GreenfootImage("images/Industry/Energy3.png");
  }

  /**
   * Act - do whatever the Energy wants to do. This method is called whenever the 'Act' or 'Run'
   * button gets pressed in the environment.
   */
  public void act() {
    checkImage();
  }
}
