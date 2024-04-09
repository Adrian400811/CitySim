import greenfoot.*; // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class MainWorld extends World {
  Label title = new Label("MainWorld", 45);

  private static int SI;
  private static int EPR;
  private static int CWI;
  private static int totalCoin;

  private int[] industryCount = {0, 0, 0, 0, 0, 0, 0, 0, 0};

  // 0 Energy, 1 Minerals, 2 Agriculture, 3 Conservation, 4 Manufacturing
  // 5 Recreation, 6 Technology, 7 Development, 8 Education

  /** Constructor for objects of class MyWorld. */
  public MainWorld(int width, int height) {
    // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
    super(width, height, 1);
    addObject(title, getWidth() / 10, 60);

    SI = 0;
    EPR = 0;
    CWI = 0;
    
    addObject(new Storm(), getWidth()/2, getHeight()/2);
  }

  // adjusters
  public static void changeSI(int delta) {
    SI += delta;
  }

  public static void changeEPR(int delta) {
    EPR += delta;
  }

  public static void changeCWI(int delta) {
    CWI += delta;
  }

  public void changeTotalCoin(int delta) {
    totalCoin += delta;
  }

  // getters
  public int getSI() {
    return SI;
  }

  public int getEPR() {
    return EPR;
  }

  public int getCWI() {
    return CWI;
  }

  public int getTotalCoin() {
    return totalCoin;
  }

  public int getIndustryCount(int type) {
    return industryCount[type];
  }
}
