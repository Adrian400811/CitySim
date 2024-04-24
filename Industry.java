import greenfoot.*; // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Industry Abstract Superclass
 *
 * @author Jimmy, Adrian, Daniel
 * @version April 24, 2024
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
  private GreenfootSound money = new GreenfootSound("sounds/kaching.mp3");

  private Font font;
  SuperTextBox text;

  private int textTimer;
  
  private static GreenfootSound[] levelSound;
  private static int levelSoundIndex;

  /**
   * Constructor for Industry
   * 
   * @param SI      The value of Sustainability Index
   * @param EPR     The value of Economic Prosperity Rating
   * @param CWI     The value of Community Well-being Index
   * @param type    The corresponding index for the Indsutry
   */
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

  /**
   * Checks the level and updates the image accordingly
   */
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

  /**
   * Sets the variable mw to MainWorld 
   */
  public void addedToWorld(World w) {
    mw = (MainWorld) w;
  }

  /**
   * Generates the income for the industry
   */
  public double income() {
    int baseIncome = 100 * mw.getEPR();
    double industryIncome = count * lvlMultipliers[level - 1] * level;
    double totalIncome = (baseIncome + industryIncome) * growthRate[type];
    double bonus; // TODO
    double grandTotal = totalIncome; // + bonus;
    money.play();
    return grandTotal;
  }

  /**
   * Levels up the industry
   */
  public void levelUp() {
     level++;
     playLevelUp();
  }

  /**
   * Getter method for the level
   * 
   * @return level  The level of the industry
   */
  public int getLevel() {
    return level;
  }
  
  /**
    * Plays level up sound
    */
  public void playLevelUp(){
    levelSound[levelSoundIndex].setVolume(100);
    levelSound[levelSoundIndex].play();
    levelSoundIndex++;
    if (levelSoundIndex >= levelSound.length){
        levelSoundIndex = 0;
    }
  }
    
  /**
   * Pre-loads sounds for level up
   * From Mr.Cohen's Demo Tutorial
   */
  public static void init(){
    levelSoundIndex = 0;
    levelSound = new GreenfootSound[48]; 
    for (int i = 0; i < levelSound.length; i++){
        levelSound[i] = new GreenfootSound("levelup.wav");
        levelSound[i].play();
        Greenfoot.delay(1);
        levelSound[i].stop();
    }   
  }
}
