import greenfoot.*; // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * AgricultureAndFood Class
 *
 * @author Jimmy, Adrian, Daniel
 * @version April 24, 2024
 */
public class AgricultureAndFood extends Industry {
  private int SI = +1;
  private int EPR = +2;
  private int CWI = +2;
  private int type = 1;

  /**
   * Constructor for AgricultureAndFood
   */
  public AgricultureAndFood() {
    super(+1, +2, +2, 1);
    L1 = new GreenfootImage("images/industry/Agriculture1.png");
    L2 = new GreenfootImage("images/industry/Agriculture2.png");
    L3 = new GreenfootImage("images/industry/Agriculture3.png");
  }

  /**
   * Act - do whatever the AgricultureAndFood wants to do. This method is called whenever the 'Act'
   * or 'Run' button gets pressed in the environment.
   */
  public void act() {
    checkNextLevel();
    checkImage();
  }

  /**
   * Checks if it can level up based on the criteria
   */
  public void checkNextLevel() {
    if (MainWorld.getTotalCoin() >= 800 && level == 0) {
      levelUp();
      MainWorld.changeTotalCoin(-800);
      MainWorld.changeSI(3);
    } else if (MainWorld.getTotalCoin() >= 1200 && level == 1) {
      levelUp();
      MainWorld.changeTotalCoin(-1200);
      MainWorld.changeSI(4);
    } else if (MainWorld.getTotalCoin() >= 600 && level == 2) {
      levelUp();
      MainWorld.changeTotalCoin(-600);
      MainWorld.changeSI(5);
    }
  }
}
