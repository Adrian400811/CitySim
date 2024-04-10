import greenfoot.*; // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class MainWorld extends World {
  Label title = new Label("MainWorld", 45);
  Label index = new Label("", 45);
  Button nextBtn = new NextButton();

  private int SI;
  private int EPR;
  private int CWI;
  private int totalCoin;

  private Industry[] industry;

  // 0 Energy, 1 Minerals, 2 Agriculture, 3 Conservation, 4 Manufacturing
  // 5 Recreation, 6 Technology, 7 Development, 8 Education

  /** Constructor for objects of class MyWorld. */
  public MainWorld(int width, int height, int SI, int CWI, int EPR) {
    // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
    super(width, height, 1);

    this.SI = SI;
    this.CWI = CWI;
    this.EPR = EPR;
    
    // for dev use
    addObject(index, getWidth()/2, getHeight()/2);
    index.setValue("SI"+SI+"EPR"+EPR+"CWI"+CWI);
    addObject(nextBtn, getWidth() - 110, 650);
    
    addObject(title, getWidth() / 10, 60);
    industry = new Industry[9];
    prepareIndustries();
  }
  
  public void act(){
      if (nextBtn != null && nextBtn.checkClicked()) {
      end();
    }
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

  public void end() {
      EndWorld ew = new EndWorld(getWidth(), getHeight(), SI, EPR, CWI);
      Greenfoot.setWorld(ew);
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
