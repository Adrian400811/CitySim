import greenfoot.*; // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class ForestryAndConservation here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class ForestryAndConservation extends Industry {
  private int SI = +3;
  private int EPR = +1;
  private int CWI = +2;
  private int type = 4;

  public ForestryAndConservation() {
    super(+3, +1, +2, 4);
    L1 = new GreenfootImage("images/Industry/Forestry1.png");
    L2 = new GreenfootImage("images/Industry/Forestry2.png");
    L3 = new GreenfootImage("images/Industry/Forestry3.png");
  }

  /**
   * Act - do whatever the ForestryAndConservation wants to do. This method is called whenever the
   * 'Act' or 'Run' button gets pressed in the environment.
   */
  public void act() {
    checkImage();
  }
}
