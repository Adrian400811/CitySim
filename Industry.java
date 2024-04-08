import greenfoot.*; // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Industry here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public abstract class Industry extends Actor {
  private MainWorld mw;
  private int level;
  private int coins;
  private int industryType;

  private double[] growthRate = {1.2, 1.1, 1.3, 1.2, 1.1, 1.3, 1.3, 1.1, 1.2};
  private double[] lvlMultipliers = {1.0, 1.5, 2.0};

  /**
   * Act - do whatever the Industry wants to do. This method is called whenever the 'Act' or 'Run'
   * button gets pressed in the environment.
   */
  public void act() {
    // Add your action code here.
  }

  public void addedToWorld(World w) {
    mw = (MainWorld) w;
  }

  public void income() {
    int baseIncome = 100 * mw.getEPR();
    double industryIncome = mw.getIndustryCount(industryType) * lvlMultipliers[level] * level;
    double totalIncome = (baseIncome + industryIncome) * growthRate[industryType];
    // TODO: bonus
  }
}
