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
    L1 = new GreenfootImage("images/industry/Energy1.png");
    L2 = new GreenfootImage("images/industry/Energy2.png");
    L3 = new GreenfootImage("images/industry/Energy3.png");
  }

  /**
   * Act - do whatever the Energy wants to do. This method is called whenever the 'Act' or 'Run'
   * button gets pressed in the environment.
   */
  public void act() {
    checkNextLevel();
    checkImage();
  }

  public void checkNextLevel() {
    if (MainWorld.getTotalCoin() >= 1200 && level == 0) {
      levelUp();
      MainWorld.changeTotalCoin(-1200);
    } else if (MainWorld.getTotalCoin() >= 1800 && level == 1) {
      levelUp();
      MainWorld.changeTotalCoin(-1800);
    } else if (MainWorld.getTotalCoin() >= 900 && level == 2) {
      levelUp();
      MainWorld.changeTotalCoin(-900);
    }
  }
}
