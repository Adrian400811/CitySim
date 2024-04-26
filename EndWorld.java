import greenfoot.*; // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The ending screen for the simulator. Contains Achievements and Stats
 *
 * @author Jimmy, Adrian, Daniel
 * @version April 24, 2024
 */
public class EndWorld extends World {
  // Initializing all variables
  private Label siLabel, eprLabel, cwiLabel, cycleLabel, eventLabel, coinLabel;
  private Label level = new Label("", 45);
  private Image siImg, eprImg, cwiImg, coinImg, cycleImg, eventImg, ordinaryBG, specialBG, scBG;
  private int SI, EPR, CWI, coin, cycleCount, eventCount;
  private int siLevel, eprLevel, cwiLevel;
  private Industry[] industry;
  private String[] achievement = {
    "Sustainability Steward",
    "Economic Magnate",
    "Community Champion",
    "Balanced Developer",
    "Visionary Planner",
    "Capitalis",
    "Eco-Warrior",
    "People's Leader",
    "Industrial Tycoon"
  };
  private Label[] achievementString;
  private boolean[] earnedAchievements;

  /**
   * Constructor for objects of class EndWorld.
   *
   * @param width The width for the EndWorld
   * @param height The height for the EndWorld
   * @param SI Sustainability Index
   * @param EPR Economic Prosperity Rating
   * @param CWI Community Well-being Index
   * @param coin Remaining amount of coins from MainWorld
   * @param cycleCount Total # of cycles in the MainWorld
   * @param eventCount Total # of events in the MainWorld
   * @param industry Industry from the MainWorld
   */
  public EndWorld(
      int width,
      int height,
      int SI,
      int EPR,
      int CWI,
      int coin,
      int cycleCount,
      int eventCount,
      Industry[] industry) {
    // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
    super(width, height, 1);
    this.SI = SI;
    this.EPR = EPR;
    this.CWI = CWI;
    this.coin = coin;
    this.cycleCount = cycleCount;
    this.eventCount = eventCount;
    this.industry = industry;

    siLevel = calculateLevel(SI);
    eprLevel = calculateLevel(EPR);
    cwiLevel = calculateLevel(CWI);

    scBG=new Image("images/Background_endworld.png", 90);
    addObject(scBG, getWidth()/2, getHeight()/2);
    generateIndexLabel();
    generateStatsLabel();
    earnedAchievements = getAchievements();
    generateAchievement();
    
  }

  /**
   * Checks the score and gives level according to the score
   *
   * @param score Individual score of the index
   * @return int Level of the index
   */
  public int calculateLevel(int score) {
    int level = 0;
    if (score > 30) {
      level = 4;
    } else if (score > 20) {
      level = 3;
    } else if (score > 11) {
      level = 2;
    } else if (score > 0) {
      level = 1;
    } else {
      level = 0;
    }
    return level;
  }

  /**
   * Checks the level of the index and assigns a String accordingly
   *
   * @param level Level of the index
   * @return String Assigns a description for the level
   */
  public String getLevelText(int level) {
    String levelText = "";
    switch (level) {
      default:
        levelText = "NONE";
        break;
      case 1:
        levelText = "LOW";
        break;
      case 2:
        levelText = "MID";
        break;
      case 3:
        levelText = "HI";
        break;
      case 4:
        levelText = "EX";
        break;
    }
    return levelText;
  }

  /**
   * Checks the level of each index and returns achievements
   *
   * @return boolean True if level meets criteria for achievement, False if level does not meet
   *     criteria for achievement
   */
  public boolean[] getAchievements() {
    boolean[] achievement = {false, false, false, false, false, false, false, false, false};
    if (siLevel >= 3) {
      achievement[0] = true;
    }
    if (eprLevel >= 3) {
      achievement[1] = true;
    }
    if (cwiLevel >= 3) {
      achievement[2] = true;
    }
    if (siLevel >= 2 && eprLevel >= 2 && cwiLevel >= 2) {
      achievement[3] = true;
    }
    if (siLevel >= 3 && eprLevel >= 3 && cwiLevel >= 3) {
      achievement[4] = true;
    }
    if (eprLevel >= 3 && coin >= 2500 && siLevel <= 1 && cwiLevel <= 1) {
      achievement[5] = true;
    }
    if (siLevel >= 3 && !(eprLevel >= 3 && cwiLevel >= 3)) {
      achievement[6] = true;
    }
    if (cwiLevel >= 3 && !(siLevel >= 3 && eprLevel >= 3)) {
      achievement[7] = true;
    }
    if (getLevelThreeIndustryCount() >= 3 && siLevel <= 1 && cwiLevel <= 1) {
      achievement[8] = true;
    }
    return achievement;
  }

  /**
   * Checks the amount of level three Industries
   *
   * @return int the amount of level three Industries
   */
  public int getLevelThreeIndustryCount() {
    int count = 0;
    for (int i = 0; i < industry.length; i++) {
      if (industry[i].getLevel() >= 3) {
        count++;
      }
    }
    return count;
  }

  /** Generates all the achievements */
  public void generateAchievement() {
    achievementString = new Label[6];
    int count = 0;
    for (int i = 0; i < achievement.length; i++) {
      if (earnedAchievements[i] == true) {
        achievementString[count] = new Label(achievement[i], 28);
        ordinaryBG = new Image("images/achievement/ordinary_mid.png", 85);
        

        specialBG = new Image("images/achievement/special_mid.png", 85);
        int dir = 0;
        int upDown = 0;
        if (count == 0 || count == 3) {
          dir = -1;
        } else if (count == 2 || count == 5) {
          dir = 1;
        }
        if (count <= 2) {
          upDown = -1;
        } else {
          upDown = 1;
        }
        int x = getWidth() / 2 + (360 * dir);
        int y = getHeight() / 4 * 3 + (60 * upDown);
        if (i <= 4) {
          addObject(ordinaryBG, x - 30, y);
        }
        if (i >= 5) {
          addObject(specialBG, x - 30, y);
        }
        addObject(achievementString[count], x, y);
        count++;
      }
    }
  }

  /** Generates all the labels for each Index */
  public void generateIndexLabel() {
    int anchorX = getWidth() / 2;
    int anchorY = getHeight() / 4;
    int imgOffset = -60;
    int stringOffset = +60;
    int lrOffset = getWidth() / 4;
    
    siImg = new Image("images/icon/SI.png", 50);
    siLabel = new Label("SI " + SI + "\n" + getLevelText(calculateLevel(SI)), 45);
    eprImg = new Image("images/icon/EPR.png", 45);
    eprLabel = new Label("EPR " + EPR + "\n" + getLevelText(calculateLevel(EPR)), 45);
    cwiImg = new Image("images/icon/CWI.png", 50);
    cwiLabel = new Label("CWI " + CWI + "\n" + getLevelText(calculateLevel(CWI)), 45);
    addObject(siImg, anchorX + imgOffset - lrOffset, anchorY);
    addObject(siLabel, anchorX + stringOffset - lrOffset, anchorY);
    addObject(eprImg, anchorX + imgOffset, anchorY);
    addObject(eprLabel, anchorX + stringOffset, anchorY);
    addObject(cwiImg, anchorX + imgOffset + lrOffset, anchorY);
    addObject(cwiLabel, anchorX + stringOffset + lrOffset, anchorY);
  }

  /** Generates all the labels for each stat */
  public void generateStatsLabel() {
    int anchorX = getWidth() / 2;
    int anchorY = getHeight() / 2;
    int imfOffset = -60;
    int stringOffset = +60;
    int lrOffset = getWidth() / 4;
    cycleLabel = new Label(cycleCount, 40);
    eventLabel = new Label(eventCount, 40);
    coinLabel = new Label(coin, 40);
    coinImg=new Image("images/icon/money.png", 50);
    cycleImg =new Image("images/icon/cycle.png", 40);
    eventImg=new Image("images/icon/event.png", 35);
    addObject(cycleImg, anchorX + imfOffset - lrOffset, anchorY);
    addObject(cycleLabel, anchorX + stringOffset - lrOffset, anchorY);
    addObject(eventImg, anchorX + imfOffset, anchorY);
    addObject(eventLabel, anchorX + stringOffset, anchorY);
    addObject(coinImg, anchorX + imfOffset + lrOffset, anchorY);
    addObject(coinLabel, anchorX + stringOffset + lrOffset, anchorY);
    
  }

  public void stopped() {
    TitleScreen.stopBGM();
  }

  public void started() {
    TitleScreen.playBGM();
  }
}
