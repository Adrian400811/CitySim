import greenfoot.*; // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class MainWorld extends World {

  private MouseInfo m;

  Label title = new Label("MainWorld", 45);
  Label index = new Label("", 45);

  Label cycle = new Label("Day", 45);
  Label cycleNum = new Label("", 45);

  Label moneyNum = new Label("", 45);

  Button nextBtn = new NextButton();

  private static int SI, EPR, CWI;
  private static int totalCoin;
  private int numOfCycles;
  private int timeElapsed;
  private int dir;
  private boolean[] selIndustry;

  private static Industry[] industry;

  // 0 Energy, 1 Minerals, 2 Agriculture, 3 Conservation, 4 Manufacturing
  // 5 Recreation, 6 Technology, 7 Development, 8 Education

  /** Constructor for objects of class MyWorld. */
  public MainWorld(int width, int height, int SI, int CWI, int EPR, boolean[] selIndustry) {
    super(width, height, 1);
    addObject(title, getWidth() / 10, 60);
    addObject(cycle, getWidth() - 115, 60);
    addObject(cycleNum, getWidth() - 60, 60);
    addObject(moneyNum, getWidth() / 2, 60);
    industry = new Industry[9];
    prepareIndustries();

    numOfCycles = 0;

    this.SI = SI;
    this.CWI = CWI;
    this.EPR = EPR;
    this.selIndustry = selIndustry;

    // for dev use
    addObject(index, getWidth() / 4 * 3, getHeight() / 2);
    index.setValue("SI     " + SI + "\nEPR  " + EPR + "\nCWI " + CWI);
    addObject(nextBtn, getWidth() - 110, 650);

    timeElapsed = 0;
    setPaintOrder(Industry.class, Button.class, Label.class, SuperTextBox.class, Virus.class, Earthquake.class);
  }

  public void act() {
    m = Greenfoot.getMouseInfo();
    timeElapsed++;

    moneyNum.setValue("Money: $" + getTotalCoin());
    if (numOfCycles == 0) {
      updateCycles();
      moneyNum.setValue("Money: $" + getTotalCoin());
    } else if (timeElapsed >= (55 * 20)) {
      updateCycles();
      moneyNum.setValue("Money: $" + getTotalCoin());
      timeElapsed = 0;
    }

    if (nextBtn != null && nextBtn.checkClicked()) {
      end();
    }
  }

  public void updateCycles() {
    index.setValue("SI:     " + getSI() + "\nEPR:  " + getEPR() + "\nCWI: " + getCWI());
    cycleNum.setValue(numOfCycles);
    if (numOfCycles == 6) {
      end();
    } else {
      if (numOfCycles % 2 == 0 && numOfCycles != 0) {
        // 2 of selected industry duplicates
        for (int i = 0; i < 2; i++) {
          getRandomSelectedIndustry();
        }
        generateRandomEvent();
        index.setValue("SI:     " + getSI() + "\nEPR:  " + getEPR() + "\nCWI: " + getCWI());
      }

      if (numOfCycles % 2 != 0) {
        generateIncome();
      }
    }
    numOfCycles++;
  }

  public Industry getRandomSelectedIndustry() {
    Industry randIndustry = null;
    while (true) {
      int rand = Greenfoot.getRandomNumber(selIndustry.length);
      if (selIndustry[rand] == true) {
        randIndustry = industry[rand];
        if (randIndustry.getLevel() != 3) {
          randIndustry.levelUp();
        }
        break;
      }
    }
    return randIndustry;
  }

  public void generateRandomEvent() {
    int rand = Greenfoot.getRandomNumber(3);
    if (rand == 0) {
      addObject(new Storm(), getWidth() / 2, getHeight() / 2);
    } else if (rand == 1) {
      addObject(new Virus(), getWidth() / 2, getHeight() / 2);
    } else if (rand == 2) {
      addObject(new Earthquake(), getWidth() / 2, getHeight() / 2);
    }
  }

  public void generateIncome() {
    for (int i = 0; i < 9; i++) {
      changeTotalCoin((int) industry[i].income());
    }
  }

  public void prepareIndustries() {
    for (int i = 0; i < 9; i++) {
      switch (i) {
        case 0:
          industry[i] = new AdvancedManufacturing();
          addObject(industry[i], getWidth() / 5 * 2, getHeight() / 2 - 144);
        case 1:
          industry[i] = new AgricultureAndFood();
          addObject(industry[i], getWidth() / 5 * 2 + 144, getHeight() / 2 - 144);
        case 2:
          industry[i] = new EducationAndResearch();
          addObject(industry[i], getWidth() / 5 * 2 + 288, getHeight() / 2 - 144);
        case 3:
          industry[i] = new Energy();
          addObject(industry[i], getWidth() / 5 * 2, getHeight() / 2);
        case 4:
          industry[i] = new ForestryAndConservation();
          addObject(industry[i], getWidth() / 5 * 2 + 144, getHeight() / 2);
        case 5:
          industry[i] = new MiningAndMaterial();
          addObject(industry[i], getWidth() / 5 * 2 + 288, getHeight() / 2);
        case 6:
          industry[i] = new TechnologyAndInnovation();
          addObject(industry[i], getWidth() / 5 * 2, getHeight() / 2 + 144);
        case 7:
          industry[i] = new TourismAndRecreation();
          addObject(industry[i], getWidth() / 5 * 2 + 144, getHeight() / 2 + 144);
        case 8:
          industry[i] = new UrbanDevelopment();
          addObject(industry[i], getWidth() / 5 * 2 + 288, getHeight() / 2 + 144);
      }
    }
  }

  public void end() {
    EndWorld ew = new EndWorld(getWidth(), getHeight(), SI, EPR, CWI, totalCoin, industry);
    Greenfoot.setWorld(ew);
  }

  public MouseInfo getMouseInfo() {
    if (m == null) {
      m = Greenfoot.getMouseInfo();
    }
    return m;
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

  public static void changeTotalCoin(int delta) {
    totalCoin += delta;
  }

  // getters
  public static int getSI() {
    return SI;
  }

  public static int getEPR() {
    return EPR;
  }

  public static int getCWI() {
    return CWI;
  }

  public static int getTotalCoin() {
    return totalCoin;
  }

  public static int getIndustryLevel(int industryCode) {
    return industry[industryCode].getLevel();
  }
}
