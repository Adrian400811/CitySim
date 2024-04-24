import greenfoot.*; // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The settings world for the simulator. 
 * Users can adjust values here.
 *
 * @author Jimmy, Adrian, Daniel
 * @version April 24, 2024
 */
public class Settings extends World {
  Label indexTitle = new Label("Index", 45);
  Label sustainable = new Label("Sustainability Index: 0", 36);
  Label economic = new Label("Economic Prosperity Rating: 0", 36);
  Label community = new Label("Community Well-being Index: 0", 36);
  Label industryTitle = new Label("Industry (Select 3-6)", 45);
  Label next = new Label("Next", 45);
  Button nextBtn = new NextButton();

  private int[] btnY = {180, 300, 420};
  private int dir;
  private int buttonCount = 6;
  private Button[] indexButton;
  private IndustryButton[] industryButton;
  private boolean[] selectedIndustry = new boolean[9];
  private int selectCount = 0;

  private int SI, EPR, CWI;

  /** 
   * Constructor for objects of class Settings. 
   * 
   * @param width The width for the world
   * @param height The height for the world
   */
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

  /**
   * Act method
   */
  public void act() {
    checkPressedButton();
  }

  /**
   * Spawns the Labels for each Index and Industry
   */
  public void spawnText() {
    addObject(indexTitle, getWidth() / 10, 60);
    addObject(sustainable, getWidth() / 4, 180);
    addObject(economic, getWidth() / 4, 300);
    addObject(community, getWidth() / 4, 420);
    addObject(industryTitle, getWidth() / 10 * 6, 60);
    addObject(next, getWidth() - 175, 650);
  }

  /**
   * Spawns the Buttons 
   */
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
      addObject(indexButton[i], getWidth() / 4 + (245 * dir), btnY[i / 2]);
    }

    addObject(nextBtn, getWidth() - 110, 650);
  }

  /**
   * Spawns the Industry grid
   */
  public void spawnIndustryGrid() {
    industryButton = new IndustryButton[9];
    for (int i = 0; i < 9; i++) {
      industryButton[i] = new IndustryButton(i);
      int upDown = 0;
      if (i == 1 | i == 4 | i == 7) {
        dir = 0;
      } else if (i == 2 | i == 5 | i == 8) {
        dir = 1;
      } else {
        dir = -1;
      }
      if (i < 3) {
        upDown = -1;
      } else if (i > 2 && i < 6) {
        upDown = 0;
      } else {
        upDown = 1;
      }
      addObject(
          industryButton[i], getWidth() / 4 * 3 + (135 * dir), getHeight() / 2 + (135 * upDown));
    }
  }

  /**
   * Checks if button is pressed. 
   * Subtract button subtracts from each index
   * Add button adds to each index
   * Next button sets world to the MainWorld
   */
  public void checkPressedButton() {
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
            sustainable.setValue("Sustainability Index: " + SI);
            break;
          case 1:
            EPR += dir;
            economic.setValue("Economic Prosperity Rating: " + EPR);
            break;
          case 2:
            CWI += dir;
            community.setValue("Community Well-being Index: " + CWI);
            break;
        }
      }
    }
    for (int i = 0; i < industryButton.length; i++) {
      IndustryButton button = industryButton[i];
      if (button != null && industryButton[i].checkClicked()) {
        if (!button.toggleState) {
          button.toggle();
          selectedIndustry[i] = true;
          selectCount++;
        } else if (button.toggleState) {
          button.toggle();
          selectedIndustry[i] = false;
          selectCount--;
        }
      }
    }
    if (nextBtn != null && nextBtn.checkClicked() && selectCount <= 6 && selectCount >= 3) {
      MainWorld main = new MainWorld(getWidth(), getHeight(), SI, CWI, EPR, selectedIndustry);
      Greenfoot.setWorld(main);
    }
  }
}
