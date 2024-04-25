import greenfoot.*; // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * UrbanDevelopment Class
 *
 * @author Jimmy, Adrian, Daniel
 * @version April 24, 2024
 */
public class UrbanDevelopment extends Industry {
  private int SI = -2;
  private int EPR = +2;
  private int CWI = +1;
  private int type = 8;

  /** Constructor for UrbanDevelopment */
  public UrbanDevelopment() {
    super(-2, +2, +1, 8);
    L1 = new GreenfootImage("images/industry/UrbanDev1.png");
    L2 = new GreenfootImage("images/industry/UrbanDev2.png");
    L3 = new GreenfootImage("images/industry/UrbanDev3.png");
  }

  /**
   * Act - do whatever the UrbanDevelopment wants to do. This method is called whenever the 'Act' or
   * 'Run' button gets pressed in the environment.
   */
  public void act() {
    checkNextLevel();
    checkImage();
  }

  /** Checks if it can level up based on the criteria */
  public void checkNextLevel() {
    if (MainWorld.getTotalCoin() >= 1700 && level == 0) {
      levelUp();
      MainWorld.changeTotalCoin(-1700);
      MainWorld.changeSI(1);
    } else if (MainWorld.getTotalCoin() >= 2550 && level == 1) {
      levelUp();
      MainWorld.changeTotalCoin(-2550);
      MainWorld.changeSI(2);
    } else if (MainWorld.getTotalCoin() >= 1275
        && level == 2
        && MainWorld.getIndustryLevel(4) >= 2
        && MainWorld.getIndustryLevel(3) >= 2) {
      levelUp();
      MainWorld.changeTotalCoin(-1275);
      MainWorld.changeSI(1);
      MainWorld.changeCWI(1);
    }
  }
}
