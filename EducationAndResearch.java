import greenfoot.*; // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class EducationAndResearch here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class EducationAndResearch extends Industry {
  private int SI = +2;
  private int EPR = +2;
  private int CWI = +3;
  private int type = 2;


  public EducationAndResearch() {
    super(+2, +2, +3, 2);
    L1 = new GreenfootImage("images/Industry/Education1.png");
    L2 = new GreenfootImage("images/Industry/Education2.png");
    L3 = new GreenfootImage("images/Industry/Education3.png");
  }

  /**
   * Act - do whatever the EducationAndResearch wants to do. This method is called whenever the
   * 'Act' or 'Run' button gets pressed in the environment.
   */
  public void act() {
    checkImage();
  }
}
