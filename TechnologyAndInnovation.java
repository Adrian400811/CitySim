import greenfoot.*; // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class TechnologyAndInnovation here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class TechnologyAndInnovation extends Industry {
  private int SI = +2;
  private int EPR = +3;
  private int CWI = +3;
  private int type = 6;

  public TechnologyAndInnovation() {
    super(+2, +3, +3, 6);
    L1 = new GreenfootImage("images/Industry/Technology1.png");
    L2 = new GreenfootImage("images/Industry/Technology2.png");
    L3 = new GreenfootImage("images/Industry/Technology3.png");
  }

  /**
   * Act - do whatever the TechnologyAndInnovation wants to do. This method is called whenever the
   * 'Act' or 'Run' button gets pressed in the environment.
   */
  public void act() {
    checkNextLevel();
    checkImage();
  }
  
  public void checkNextLevel(){
      if (MainWorld.getTotalCoin() >= 2500 && level == 0){
          levelUp();
          MainWorld.changeTotalCoin(-2500);
      } else if (MainWorld.getTotalCoin() >= 3750 && level == 1){
          levelUp();
          MainWorld.changeTotalCoin(-3750);
      } else if (MainWorld.getTotalCoin() >= 1875 && level == 2 && MainWorld.getEducationAndResearchLevel() >= 2){
          levelUp();
          MainWorld.changeTotalCoin(-1875);
      }
  }
}
