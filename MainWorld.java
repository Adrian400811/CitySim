import greenfoot.*; // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The main world for the simulator.
 *
 * @author Jimmy, Adrian, Daniel
 * @version April 24, 2024
 */
public class MainWorld extends World {

  private MouseInfo m;

  Label title = new Label("MainWorld", 45);
  Label index = new Label("", 45);

  Label cycle = new Label("Day", 45);
  Label cycleNum = new Label("", 45);

  Label moneyNum = new Label("", 45);

  Button nextBtn = new NextButton();

  private static int SI, EPR, CWI, totalCoin;
  private int numOfCycles, maxCycle, eventCount, timeElapsed;
  private int dir;
  private boolean[] selIndustry;

  private static Industry[] industry;

  // 0 Energy, 1 Minerals, 2 Agriculture, 3 Conservation, 4 Manufacturing
  // 5 Recreation, 6 Technology, 7 Development, 8 Education

  /**
   * Constructor for objects of class MainWorld.
   *
   * @param width The width of the world
   * @param height The height of the world
   * @param SI Initial values for Sustainability Index
   * @param CWI Initial values for Community Well-being Index
   * @param EPR Initial values for Economic Prosperity Rating
   * @param sellIndustry Boolean for if each Industry is able to be sold
   * @param event Boolean for if events can happen
   * @param maxCycle Max Number of cycles
   */
  public MainWorld(
      int width,
      int height,
      int SI,
      int CWI,
      int EPR,
      boolean[] selIndustry,
      boolean event,
      int maxCycle) {
    super(width, height, 1);
    addObject(title, getWidth() / 10, 60);
    addObject(cycle, getWidth() - 115, 60);
    addObject(cycleNum, getWidth() - 60, 60);
    addObject(moneyNum, getWidth() / 2, 60);
    industry = new Industry[9];
    prepareIndustries();

    this.SI = SI;
    this.CWI = CWI;
    this.EPR = EPR;
    this.selIndustry = selIndustry;
    this.maxCycle = maxCycle;

    numOfCycles = 0;

    // for dev use
    addObject(index, getWidth() / 4 * 3, getHeight() / 2);
    index.setValue("SI     " + SI + "\nEPR  " + EPR + "\nCWI " + CWI);
    // addObject(nextBtn, getWidth() - 110, 650);

    timeElapsed = 0;
    Greenfoot.setSpeed(50);
    Industry.init();
    setPaintOrder(
        Industry.class,
        Button.class,
        Label.class,
        SuperTextBox.class,
        Virus.class,
        Earthquake.class);
  }

  /** Act method */
  public void act() {
    m = Greenfoot.getMouseInfo();
    timeElapsed++;

    index.setValue("SI:     " + getSI() + "\nEPR:  " + getEPR() + "\nCWI: " + getCWI());
    moneyNum.setValue("Money: $" + getTotalCoin());
    if (numOfCycles == 0) {
      numOfCycles++;
      updateCycles();
    }
    if (timeElapsed % 3 == 0) {
      generatePassiveIncome();
    } else if (timeElapsed >= (55 * 20)) {
      updateCycles();
      timeElapsed = 0;
    }

    if (nextBtn != null && nextBtn.checkClicked()) {
      end();
    }
  }

  /** Creates passive income for the city */
  public void generatePassiveIncome() {
    if (getEPR() > 0){
        changeTotalCoin((int) 1 * (getEPR() / 2));
    } else {
        changeTotalCoin(1);
    }
  }

  /** Updates total amount of cycles and calls other methods on certain cycles */
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
      }

      if (numOfCycles % 2 != 0) {
        generateIncome();
      }
    }
    numOfCycles++;
  }

  /**
   * Gets random selected industry
   *
   * @return randIndustry Industry that got selected
   */
  public Industry getRandomSelectedIndustry() {
    Industry randIndustry = null;
    while (true) {
      int rand = Greenfoot.getRandomNumber(selIndustry.length);
      if (selIndustry[rand] == true) {
        randIndustry = industry[rand];
        randIndustry.levelUp();
        break;
      }
    }
    return randIndustry;
  }

  /** Generates a random event and adds to the total event count */
  public void generateRandomEvent() {
    int rand = Greenfoot.getRandomNumber(3);
    if (rand == 0) {
      addObject(new Storm(), getWidth() / 2, getHeight() / 2);
    } else if (rand == 1) {
      addObject(new Virus(), getWidth() / 2, getHeight() / 2);
    } else if (rand == 2) {
      addObject(new Earthquake(), getWidth() / 2, getHeight() / 2);
    }
    eventCount++;
  }

  /** Generates all income for every Industry */
  public void generateIncome() {
    for (int i = 0; i < 9; i++) {
      changeTotalCoin((int) industry[i].income());
    }
  }

  /** Adds all Industries to the MainWorld */
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

  /** Sets the world to EndWorld */
  public void end() {
    EndWorld ew =
        new EndWorld(
            getWidth(), getHeight(), SI, EPR, CWI, totalCoin, numOfCycles, eventCount, industry);
    Greenfoot.setWorld(ew);
  }

  /**
   * Gets all the MouseInfo
   *
   * @return MouseInfo Information of the mouse
   */
  public MouseInfo getMouseInfo() {
    if (m == null) {
      m = Greenfoot.getMouseInfo();
    }
    return m;
  }

  /**
   * Changes Sustainability Index
   *
   * @param delta The amount to change the index
   */
  public static void changeSI(int delta) {
    SI += delta;
  }

  /**
   * Changes Economic Prosperity Rating
   *
   * @param delta The amount to change the index
   */
  public static void changeEPR(int delta) {
    EPR += delta;
  }

  /**
   * Changes Community Well-being Index
   *
   * @param delta The amount to change the index
   */
  public static void changeCWI(int delta) {
    CWI += delta;
  }

  /**
   * Changes the Total Coins in the world
   *
   * @param delta The amount to change the coins
   */
  public static void changeTotalCoin(int delta) {
    totalCoin += delta;
  }

  /**
   * Getter method for Sustainability Index
   *
   * @return SI Sustainability Index
   */
  public static int getSI() {
    return SI;
  }

  /**
   * Getter method for Economic Prosperity Rating
   *
   * @return EPR Economic Prosperity Rating
   */
  public static int getEPR() {
    return EPR;
  }

  /**
   * Getter method for Community Well-being Index
   *
   * @return CWI Community Well-being Index
   */
  public static int getCWI() {
    return CWI;
  }

  /**
   * Getter method for Total coins
   *
   * @return totalCoin The total amount of coins
   */
  public static int getTotalCoin() {
    return totalCoin;
  }

  /**
   * Getter method for Industry Level
   *
   * @param industryCode The index for the assigned industry
   * @return industry[industryCode].getLevel() The level for the industry
   */
  public static int getIndustryLevel(int industryCode) {
    return industry[industryCode].getLevel();
  }

  public void stopped() {
    TitleScreen.stopBGM();
  }

  public void started() {
    TitleScreen.playBGM();
  }
}
