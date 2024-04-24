import greenfoot.*; // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * EducationAndResearch Class
 *
 * @author Jimmy, Adrian, Daniel
 * @version April 24, 2024
 */
public class EducationAndResearch extends Industry {
  private int SI = +2;
  private int EPR = +2;
  private int CWI = +3;
  private int type = 2;

  /**
   * Constructor for EducationAndResearch
   */
  public EducationAndResearch() {
    super(+2, +2, +3, 2);
    L1 = new GreenfootImage("images/industry/Education1.png");
    L2 = new GreenfootImage("images/industry/Education2.png");
    L3 = new GreenfootImage("images/industry/Education3.png");
  }

  /**
   * Act - do whatever the EducationAndResearch wants to do. This method is called whenever the
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
    if (MainWorld.getTotalCoin() >= 1300 && level == 0) {
      levelUp();
      MainWorld.changeTotalCoin(-1300);
      MainWorld.changeCWI(2);
    } else if (MainWorld.getTotalCoin() >= 1950 && level == 1) {
      levelUp();
      MainWorld.changeTotalCoin(-1950);
      MainWorld.changeCWI(3);
      MainWorld.changeSI(1);
    } else if (MainWorld.getTotalCoin() >= 975 && level == 2) {
      levelUp();
      MainWorld.changeTotalCoin(-975);
      MainWorld.changeCWI(3);
      MainWorld.changeSI(1);
    }
  }
}
