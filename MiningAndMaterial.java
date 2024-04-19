import greenfoot.*; // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MiningAndMaterial here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class MiningAndMaterial extends Industry {
  private int SI = -2;
  private int EPR = +2;
  private int CWI = -1;
  private int type = 5;

  public MiningAndMaterial() {
    super(-2, +2, -1, 5);
    L1 = new GreenfootImage("images/industry/Material1.png");
    L2 = new GreenfootImage("images/industry/Material2.png");
    L3 = new GreenfootImage("images/industry/Material3.png");
  }

  /**
   * Act - do whatever the MiningAndMaterial wants to do. This method is called whenever the 'Act'
   * or 'Run' button gets pressed in the environment.
   */
  public void act() {
    checkHover("Mining");
    checkNextLevel();
    checkImage();
  }

  public void checkNextLevel() {
    if (MainWorld.getTotalCoin() >= 1500 && level == 0) {
      levelUp();
      MainWorld.changeTotalCoin(-1500);
    } else if (MainWorld.getTotalCoin() >= 2250 && level == 1) {
      levelUp();
      MainWorld.changeTotalCoin(-2250);
    } else if (MainWorld.getTotalCoin() >= 1125 && level == 2) {
      levelUp();
      MainWorld.changeTotalCoin(-1125);
    }
  }
}
