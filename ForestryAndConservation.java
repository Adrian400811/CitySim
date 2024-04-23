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
    L1 = new GreenfootImage("images/industry/Forestry1.png");
    L2 = new GreenfootImage("images/industry/Forestry2.png");
    L3 = new GreenfootImage("images/industry/Forestry3.png");
  }

  /**
   * Act - do whatever the ForestryAndConservation wants to do. This method is called whenever the
   * 'Act' or 'Run' button gets pressed in the environment.
   */
  public void act() {
    checkNextLevel();
    checkImage();
  }

  public void checkNextLevel() {
    if (MainWorld.getTotalCoin() >= 1000 && level == 0) {
      levelUp();
      MainWorld.changeTotalCoin(-1000);
      MainWorld.changeCWI(2);
      MainWorld.changeSI(1);
    } else if (MainWorld.getTotalCoin() >= 1500 && level == 1) {
      levelUp();
      MainWorld.changeTotalCoin(-1500);
      MainWorld.changeCWI(1);
      MainWorld.changeSI(1);
    } else if (MainWorld.getTotalCoin() >= 750
        && level == 2
        && MainWorld.getIndustryLevel(3) >= 2) {
      levelUp();
      MainWorld.changeTotalCoin(-750);
      MainWorld.changeSI(1);
    }
  }
}
