import greenfoot.*; // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class MainWorld extends World {
  Label title = new Label("MainWorld", 45);
  Label cycle = new Label("Day", 45);
  Label cycleNum = new Label("", 45);

  private int SI;
  private int EPR;
  private int CWI;
  private int totalCoin;
  private int numOfCycles;
  private int timeElapsed;

  private Industry[] industry;

  // 0 Energy, 1 Minerals, 2 Agriculture, 3 Conservation, 4 Manufacturing
  // 5 Recreation, 6 Technology, 7 Development, 8 Education

  /** Constructor for objects of class MyWorld. */
  public MainWorld(int width, int height, int SI, int CWI, int EPR) {
    // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
    super(width, height, 1);
    addObject(title, getWidth() / 10, 60);
    addObject(cycle, getWidth()-115, 60);
    addObject(cycleNum, getWidth() - 60, 60);
    industry = new Industry[9];
    prepareIndustries();
    
    numOfCycles = 0;

    this.SI = SI;
    this.CWI = CWI;
    this.EPR = EPR;
    
    timeElapsed = 0;
  }
  
  public void act(){
    timeElapsed++;
    
    if (numOfCycles == 0){
        updateCycles();
    } else if (timeElapsed >= (55 * 20)){
        updateCycles();
        timeElapsed = 0;
    }
  }
  
  public void updateCycles(){
      cycleNum.setValue(numOfCycles);
      if (numOfCycles % 2 == 0){
          
      } else {
          if (numOfCycles == 6){
              EndWorld end = new EndWorld();
              Greenfoot.setWorld(end);
          }
          if (numOfCycles == 1 || numOfCycles == 3){

          }
      }
      numOfCycles++;
  }
  
  

  public void prepareIndustries() {
    for (int i = 0; i < 9; i++) {
      switch (i) {
        case 0:
          industry[i] = new AdvancedManufacturing();
        case 1:
          industry[i] = new AgricultureAndFood();
        case 2:
          industry[i] = new EducationAndResearch();
        case 3:
          industry[i] = new Energy();
        case 4:
          industry[i] = new ForestryAndConservation();
        case 5:
          industry[i] = new MiningAndMaterial();
        case 6:
          industry[i] = new TechnologyAndInnovation();
        case 7:
          industry[i] = new TourismAndRecreation();
        case 8:
          industry[i] = new UrbanDevelopment();
      }
    }
  }

  // adjusters
  public void changeSI(int delta) {
    SI += delta;
  }

  public void changeEPR(int delta) {
    EPR += delta;
  }

  public void changeCWI(int delta) {
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
}
