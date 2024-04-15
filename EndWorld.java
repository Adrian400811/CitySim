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
    
    
    addObject(index, getWidth()/2, getHeight()/2-60);
    index.setValue("SI: " + SI + " EPR: " + EPR + " CWI: " + CWI);
    addObject(level, getWidth()/2, getHeight()/2+60);
    level.setValue("SI: " + printLevel(siLevel) + " EPR: " + printLevel(eprLevel) + " CWI: " + printLevel(cwiLevel));
  }
  
  public int calculateLevel(int score){
      int level = 0;
      if (score > 30){
          level = 4;
      } else if (score > 20){
          level = 3;
      } else if (score > 11){
          level = 2;
      } else if (score > 0){
          level = 1;
      } else {
          level = 0;
      }
      System.out.println(level);
      return level;
  }
  
  public String printLevel(int level){
      String levelText = "";
      switch (level){
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
      System.out.println(levelText);
      return levelText;
  }
  
  public boolean[] getAchievements(){
      boolean[] achievement = {false, false, false, false, false, false, false, false, false};
      if(siLevel >= 3){
          achievement[0] = true;
      }
      if(eprLevel >= 3){
          achievement[1] = true;
      }
      if(cwiLevel >= 3){
          achievement[2] = true;
      }
      if(siLevel >= 2 && eprLevel >= 2 && cwiLevel >= 2){
          achievement[3] = true;
      }
      if(siLevel >= 3 && eprLevel >= 3 && cwiLevel >= 3){
          achievement[4] = true;
      }
      // if(){}
      if(siLevel>=3 && !(eprLevel >=3 && cwiLevel >=3)){
          achievement[6] = true;
      }
      if(cwiLevel>=3 && !(siLevel >=3 && eprLevel >=3)){
          achievement[7] = true;
      }
      // if(){}
      return achievement;
  }
}
