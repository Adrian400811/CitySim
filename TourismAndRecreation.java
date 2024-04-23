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

  public TourismAndRecreation() {
    super(+2, +2, +2, 7);
    L1 = new GreenfootImage("images/industry/Recreation1.png");
    L2 = new GreenfootImage("images/industry/Recreation2.png");
    L3 = new GreenfootImage("images/industry/Recreation3.png");
  }

  /**
   * Act - do whatever the TourismAndRecreation wants to do. This method is called whenever the
   * 'Act' or 'Run' button gets pressed in the environment.
   */
  public void act() {
    checkNextLevel();
    checkImage();
  }

  public void checkNextLevel() {
    if (MainWorld.getTotalCoin() >= 700 && level == 0) {
      levelUp();
      MainWorld.changeTotalCoin(-700);
      MainWorld.changeCWI(2);
    } else if (MainWorld.getTotalCoin() >= 1050 && level == 1) {
      levelUp();
      MainWorld.changeTotalCoin(-1050);
      MainWorld.changeCWI(1);
    } else if (MainWorld.getTotalCoin() >= 525 && level == 2) {
      levelUp();
      MainWorld.changeTotalCoin(-525);
      MainWorld.changeCWI(1);
    }
  }
}
