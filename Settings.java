import greenfoot.*; // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Settings here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Settings extends World {
  Label indexTitle = new Label("Index", 45);
  Label sustainable = new Label("Sustainability Index", 36);
  Label economic = new Label("Economic Prosperity Rating", 36);
  Label community = new Label("Community Well-being Index", 36);
  Label industryTitle = new Label("Industry", 45);
  Label next = new Label("Next", 45);
  Button nextBtn = new NextButton();

  private int[] btnY = {180, 300, 420};
  private int dir;
  private int buttonCount = 6;
  private Button[] indexButton;
  private IndustryButton[] industryButton;

  private int SI, EPR, CWI;

  /** Constructor for objects of class Settings. */
  public Settings(int width, int height) {
    // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
    super(width, height, 1);
    SI = 0;
    EPR = 0;
    CWI = 0;
    spawnText();
    spawnButtons();
    spawnIndustryGrid();
  }

  public void act() {
    checkPressed();
  }

  public void spawnText() {
    addObject(indexTitle, getWidth() / 10, 60);
    addObject(sustainable, getWidth() / 4, 180);
    addObject(economic, getWidth() / 4, 300);
    addObject(community, getWidth() / 4, 420);
    addObject(industryTitle, getWidth()/10*6, 60);
    addObject(next, getWidth() - 175, 650);
  }

  public void spawnButtons() {
    indexButton = new Button[6];
    for (int i = 0; i < 6; i++) {
      if (i % 2 == 0) {
        indexButton[i] = new AddButton();
        dir = 1;
      } else {
        indexButton[i] = new SubtractButton();
        dir = -1;
      }
      addObject(indexButton[i], getWidth() / 4 + (225 * dir), btnY[i / 2]);
    }
    
    addObject(nextBtn, getWidth() - 110, 650);
  }
  
  public void spawnIndustryGrid(){
      industryButton = new IndustryButton[9];
      for(int i=0; i<9; i++){
          industryButton[i] = new IndustryButton(i);
          int upDown = 0;
          if(i==1|i==4|i==7){
              dir = 0;
          } else if (i==2|i==5|i==8){
              dir = 1;
          } else {
              dir = -1;
          }
          if(i<3){
              upDown = -1;
          } else if (i>2 && i<6){
              upDown = 0;
          } else {
              upDown = 1;
          }
          addObject(industryButton[i], getWidth()/4*3+(135*dir), getHeight()/2+(135*upDown));
      }
  }

  public void checkPressed() {
    for (int i = 0; i < indexButton.length; i++) {
      if (i % 2 == 0) {
        dir = 1;
      } else {
        dir = -1;
      }
      if (indexButton[i] != null && indexButton[i].checkClicked()) {
        switch (i / 2) {
          case 0:
            SI += dir;
            break;
          case 1:
            EPR += dir;
            break;
          case 2:
            CWI += dir;
            break;
        }
      }
    }
    if (nextBtn != null && nextBtn.checkClicked()) {
      MainWorld main = new MainWorld(getWidth(), getHeight(), SI, CWI, EPR);
      Greenfoot.setWorld(main);
    }
  }
}
