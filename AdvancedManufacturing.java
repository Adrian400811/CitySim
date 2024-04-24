import greenfoot.*; // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * AdvanedManufacturing Class
 *
 * @author Jimmy, Adrian, Daniel
 * @version April 24, 2024
 */
public class AdvancedManufacturing extends Industry {
  private int SI = -1;
  private int EPR = +3;
  private int CWI = +1;
  private int type = 0;

  /**
   * Constructor for Advanced Manufacturing
   */
  public AdvancedManufacturing() {
    super(-1, +3, +1, 0);
    L1 = new GreenfootImage("images/industry/Manufacturing1.png");
    L2 = new GreenfootImage("images/industry/Manufacturing2.png");
    L3 = new GreenfootImage("images/industry/Manufacturing3.png");
  }

  /**
   * Act - do whatever the AdvancedManufacturing wants to do. This method is called whenever the
   * 'Act' or 'Run' button gets pressed in the environment.
   */
  public void act() {
    checkNextLevel();
    checkImage();
  }

  /**
   * Checks if it can level up based on the criteria
   */
  public void checkNextLevel() {
    if (MainWorld.getTotalCoin() >= 2000 && level == 0) {
      levelUp();
      MainWorld.changeTotalCoin(-2000);
      MainWorld.changeEPR(2);
    } else if (MainWorld.getTotalCoin() >= 3000 && level == 1) {
      levelUp();
      MainWorld.changeTotalCoin(-3000);
      MainWorld.changeEPR(4);
    } else if (MainWorld.getTotalCoin() >= 1500
        && level == 2
        && MainWorld.getIndustryLevel(6) >= 2) {
      levelUp();
      MainWorld.changeTotalCoin(-1500);
      MainWorld.changeEPR(5);
    }
  }
}
