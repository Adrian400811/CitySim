import greenfoot.*; // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class TechnologyAndInnovation here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class TechnologyAndInnovation extends Industry {
  private int SI = +2;
  private int EPR = +3;
  private int CWI = +3;
  private int type = 6;
  
  private GreenfootImage L1;
  private GreenfootImage L2;
  private GreenfootImage L3;

  public TechnologyAndInnovation() {
    super(+2, +3, +3, 6);
    L1 = new GreenfootImage("images/Industry/TechnologyAndInnovation_L1.png");
    L2 = new GreenfootImage("images/Industry/TechnologyAndInnovation_L2.png");
    L3 = new GreenfootImage("images/Industry/TechnologyAndInnovation_L3.png");
  }

  /**
   * Act - do whatever the TechnologyAndInnovation wants to do. This method is called whenever the
   * 'Act' or 'Run' button gets pressed in the environment.
   */
  public void act() {
    checkImage();
  }
  
}
