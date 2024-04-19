import greenfoot.*; // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class AgricultureAndFood here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class AgricultureAndFood extends Industry {
  private int SI = +1;
  private int EPR = +2;
  private int CWI = +2;
  private int type = 1;

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
    checkHover("Agriculture");
    checkNextLevel();
    checkImage();
  }

  public void checkNextLevel() {
    if (MainWorld.getTotalCoin() >= 800 && level == 0) {
      levelUp();
      MainWorld.changeTotalCoin(-800);
    } else if (MainWorld.getTotalCoin() >= 1200 && level == 1) {
      levelUp();
      MainWorld.changeTotalCoin(-1200);
    } else if (MainWorld.getTotalCoin() >= 600 && level == 2) {
      levelUp();
      MainWorld.changeTotalCoin(-600);
    }
  }
}
