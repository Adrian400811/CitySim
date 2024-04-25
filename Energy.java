import greenfoot.*; // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Energy Class
 *
 * @author Jimmy, Adrian, Daniel
 * @version April 24, 2024
 */
public class Energy extends Industry {
  private int SI = +2;
  private int EPR = +2;
  private int CWI = +1;
  private int type = 3;

  /** Constructor for Energy */
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

  /** Checks if it can level up based on the criteria */
  public void checkNextLevel() {
    if (MainWorld.getTotalCoin() >= 1200 && level == 0) {
      levelUp();
      MainWorld.changeTotalCoin(-1200);
      MainWorld.changeEPR(2);
    } else if (MainWorld.getTotalCoin() >= 1800 && level == 1) {
      levelUp();
      MainWorld.changeTotalCoin(-1800);
      MainWorld.changeEPR(2);
    } else if (MainWorld.getTotalCoin() >= 900 && level == 2) {
      levelUp();
      MainWorld.changeTotalCoin(-900);
      MainWorld.changeEPR(1);
      MainWorld.changeSI(1);
      MainWorld.changeCWI(1);
    }
  }
}
