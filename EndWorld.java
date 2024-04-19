import greenfoot.*; // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class EndWorld here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class EndWorld extends World {
  private Label siLabel, eprLabel, cwiLabel;
  private Label level = new Label("", 45);
  private Image siImg, eprImg, cwiImg, ordinaryBG, specialBG;
  private int SI, EPR, CWI, coin;
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

  /** Constructor for objects of class EndWorld. */
  public EndWorld(int width, int height, int SI, int EPR, int CWI, int coin, Industry[] industry) {
    // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
    super(width, height, 1);
    this.SI = SI;
    this.EPR = EPR;
    this.CWI = CWI;
    this.coin = coin;
    this.industry = industry;

    siLevel = calculateLevel(SI);
    eprLevel = calculateLevel(EPR);
    cwiLevel = calculateLevel(CWI);
    
    generateIndexLabel();
    earnedAchievements = getAchievements();
    generateAchievement();
  }

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

  public int getLevelThreeIndustryCount() {
    int count = 0;
    for (int i = 0; i < industry.length; i++) {
      if (industry[i].getLevel() >= 3) {
        count++;
      }
    }
    return count;
  }

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
  
  public void generateIndexLabel() {
      int anchorX = getWidth()/2;
      int anchorY = getHeight()/4;
      int imgOffset = -60;
      int stringOffset = +60;
      int lrOffset = getWidth()/4;
      siImg = new Image("images/icon/SI.png", 50);
      siLabel = new Label("SI "+SI+"\n"+getLevelText(calculateLevel(SI)),45);
      eprImg = new Image("images/icon/EPR.png", 50);
      eprLabel = new Label("EPR "+EPR+"\n"+getLevelText(calculateLevel(EPR)),45);
      cwiImg = new Image("images/icon/CWI.png", 50);
      cwiLabel = new Label("CWI "+CWI+"\n"+getLevelText(calculateLevel(CWI)),45);
      addObject(siImg, anchorX+imgOffset-lrOffset, anchorY);
      addObject(siLabel, anchorX+stringOffset-lrOffset, anchorY);
      addObject(eprImg, anchorX+imgOffset, anchorY);
      addObject(eprLabel, anchorX+stringOffset, anchorY);
      addObject(cwiImg, anchorX+imgOffset+lrOffset, anchorY);
      addObject(cwiLabel, anchorX+stringOffset+lrOffset, anchorY);
  }
}
