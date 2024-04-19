import greenfoot.*; // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Industry here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public abstract class Industry extends Actor {
  private MainWorld mw;
  protected int level = 1;
  private int coins = 0;
  private int count = 1000;
  private int type;
  private int SI, EPR, CWI;

  private double[] growthRate = {1.2, 1.1, 1.3, 1.2, 1.1, 1.3, 1.3, 1.1, 1.2};
  private double[] lvlMultipliers = {1.0, 1.5, 2.0};

  protected GreenfootImage L1;
  protected GreenfootImage L2;
  protected GreenfootImage L3;

  private Font font;
  SuperTextBox text;

  private int textTimer;

  public Industry(int SI, int EPR, int CWI, int type) {
    this.SI = SI;
    this.EPR = EPR;
    this.CWI = CWI;
    this.type = type;

    font = new Font("Comic Sans MS", false, false, 16);
    textTimer = 0;
  }

  /**
   * Act - do whatever the Industry wants to do. This method is called whenever the 'Act' or 'Run'
   * button gets pressed in the environment.
   */
  public void act() {
    // Add your action code here.
  }

  public void checkImage() {
    if (level == 1) {
      L1.scale(144, 144);
      setImage(L1);
    } else if (level == 2) {
      L2.scale(144, 144);
      setImage(L2);
    } else if (level == 3) {
      L3.scale(144, 144);
      setImage(L3);
    }
  }

  public void addedToWorld(World w) {
    mw = (MainWorld) w;
  }

  public double income() {
    int baseIncome = 100 * mw.getEPR();
    double industryIncome = count * lvlMultipliers[level - 1] * level;
    double totalIncome = (baseIncome + industryIncome) * growthRate[type];
    double bonus; // TODO
    double grandTotal = totalIncome; // + bonus;
    return grandTotal;
  }

  public void checkHover(String name) {
    textTimer--;
    String[] allText = {name, "Level: " + getLevel(), "Income: " + income()};
    text = new SuperTextBox(allText, font, 132);
    if (Greenfoot.mouseMoved(this)) {
      mw.addObject(text, getX(), getY());
      textTimer = 10;
    }
    if (Greenfoot.mouseMoved(null) && !Greenfoot.mouseMoved(this)) {
      mw.removeObject(this.text);
    } else {
      text.update(allText);
    }
  }

  public void levelUp() {
    level++;
  }

  public int getLevel() {
    return level;
  }
}
