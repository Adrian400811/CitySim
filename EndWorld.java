import greenfoot.*; // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class EndWorld here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class EndWorld extends World {
  Label index = new Label("", 45);
  Label level = new Label("", 45);
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

    earnedAchievements = getAchievements();

    String indexString = "SI: " + SI + " EPR: " + EPR + " CWI: " + CWI;
    String levelString =
        "SI: "
            + printLevel(siLevel)
            + " EPR: "
            + printLevel(eprLevel)
            + " CWI: "
            + printLevel(cwiLevel);

    addObject(index, getWidth() / 2, getHeight() / 4 - 60);
    index.setValue(indexString);
    addObject(level, getWidth() / 2, getHeight() / 4 + 60);
    level.setValue(levelString);
    generateAchievementString();
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

  public String printLevel(int level) {
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

  public void generateAchievementString() {
    achievementString = new Label[6];
    int count = 0;
    for (int i = 0; i < achievement.length; i++) {
      if (earnedAchievements[i] == true) {
        achievementString[count] = new Label(achievement[i], 36);
        int dir = 0;
        int upDown = 0;
        if (count == 0 || count == 3) {
          dir = -1;
        } else if (count == 2 || count == 4) {
          dir = 1;
        }
        if (count <= 2) {
          upDown = -1;
        } else {
          upDown = 1;
        }
        addObject(
            achievementString[count],
            getWidth() / 2 + (300 * dir),
            getHeight() / 4 * 3 + (60 * upDown));
        count++;
      }
    }
  }
}
