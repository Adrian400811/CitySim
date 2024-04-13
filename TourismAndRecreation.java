import greenfoot.*; // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class TourismAndRecreation here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class TourismAndRecreation extends Industry {
  private int SI = +2;
  private int EPR = +2;
  private int CWI = +2;
  private int type = 7;
  
  private GreenfootImage L1;
  private GreenfootImage L2;
  private GreenfootImage L3;

  public TourismAndRecreation() {
    super(+2, +2, +2, 7);
    L1 = new GreenfootImage("images/Industry/Recreation1.png");
    L2 = new GreenfootImage("images/Industry/Recreation2.png");
    L3 = new GreenfootImage("images/Industry/Recreation3.png");
  }

  /**
   * Act - do whatever the TourismAndRecreation wants to do. This method is called whenever the
   * 'Act' or 'Run' button gets pressed in the environment.
   */
  public void act() {
    // Add your action code here.
    checkImage();
  }
  
}
