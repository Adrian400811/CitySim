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
  private int SI, EPR, CWI;
  private int siLevel, eprLevel, cwiLevel;

  /** Constructor for objects of class EndWorld. */
  public EndWorld(int width, int height, int SI, int EPR, int CWI) {
    // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
    super(width, height, 1);
    this.SI = SI;
    this.EPR = EPR;
    this.CWI = CWI;

    siLevel = calculateLevel(SI);
    eprLevel = calculateLevel(EPR);
    cwiLevel = calculateLevel(CWI);

    addObject(index, getWidth() / 2, getHeight() / 2 - 60);
    index.setValue("SI: " + SI + " EPR: " + EPR + " CWI: " + CWI);
    addObject(level, getWidth() / 2, getHeight() / 2 + 60);
    level.setValue(
        "SI: " + printLevel(SI) + " EPR: " + printLevel(EPR) + " CWI: " + printLevel(CWI));
  }

  public int calculateLevel(int score) {
    int level = 0;
    if (SI > 30) {
      level = 4;
    } else if (SI > 20) {
      level = 3;
    } else if (SI > 11) {
      level = 2;
    } else if (SI > 0) {
      level = 1;
    } else {
      level = 0;
    }

    return level;
  }

  public String printLevel(int level) {
    String levelText = "";
    switch (level) {
      case 1:
        levelText = "LOW";
      case 2:
        levelText = "MID";
      case 3:
        levelText = "HI";
      case 4:
        levelText = "EX";
      default:
        levelText = "NONE";
    }
    return levelText;
  }
}
