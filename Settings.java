import greenfoot.*; // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The settings world for the simulator. Users can adjust values here.
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
  Label eventLabel = new Label("ON", 36);
  Label round = new Label("", 24);
  Button nextBtn = new NextButton();

  private EventButton eventButton = new EventButton();
  private RoundButton roundButton = new RoundButton();
  private CycleButton cycleButton = new CycleButton();
  private MoneyButton moneyButton = new MoneyButton();
  private Button[] indexButton;
  private IndustryButton[] industryButton;
  private boolean[] selectedIndustry = new boolean[9];

  private int[] btnY = {180, 240, 300};
  private int dir;
  private int buttonCount = 6;
  private int selectCount = 0;
  private int coinStep = 1000;
  private int numOfCycles = 6; // 5, 10, 15
  private boolean event = false;

  private int SI, EPR, CWI, cycle;

  // test text
  Label test = new Label("true", 45);

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
    spawnIndexButtons();
    spawnIndustryGrid();
  }

  /** Act method */
  public void act() {
    checkPressedButton();
  }

  /** Spawns the Labels for each Index and Industry */
  public void spawnText() {
    addObject(indexTitle, getWidth() / 10, 60);
    addObject(sustainable, getWidth() / 4, 180);
    addObject(economic, getWidth() / 4, 240);
    addObject(community, getWidth() / 4, 300);
    addObject(industryTitle, getWidth() / 10 * 6, 60);
    addObject(next, getWidth() - 175, 650);
    addObject(eventButton, getWidth() / 4, 400);
    addObject(moneyButton, getWidth() / 4, 560);
    addObject(cycleButton, getWidth() / 4 * 3, 580);
  }

  /** Spawns the Buttons */
  public void spawnIndexButtons() {
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

  /** Spawns the Industry grid */
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
          industryButton[i],
          getWidth() / 4 * 3 + (135 * dir),
          getHeight() / 7 * 3 + (135 * upDown));
    }
  }

  public void checkPressedButton() {
    for (int i = 0; i < indexButton.length; i++) {
        if(indexButton[i].checkClicked()){
          switch(i){
          case 0:
              if(SI<5){
                  SI++;
              }
              break;
          case 1:
              if(SI>-5){
                  SI--;
              }
              break;
          case 2:
              if(EPR<5){
                  EPR++;
              }
              break;
          case 3:
              if(EPR>-5){
                  EPR--;
              }
              break;
          case 4:
              if(CWI<5){
                  CWI++;
              }
              break;
          case 5:
              if(CWI>-5){
                  CWI--;
              }
              break;
          }
          sustainable.setValue("Sustainability Index: " + SI);
          economic.setValue("Economic Prosperity Rating: " + EPR);
          community.setValue("Community Well-being Index: " + CWI);
        }
    }

    for (int i = 0; i < industryButton.length; i++) {
      IndustryButton button = industryButton[i];
      if (button != null && industryButton[i].checkClicked()) {
        if (!button.toggleState && selectCount < 6) {
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

    if (eventButton.checkClicked()) {
      event = !event;
    } else if (eventButton.openDis(eventButton.cheakDis())) {
      addObject(test, getWidth() / 2, getHeight() / 2);
    }

    if (nextBtn != null && nextBtn.checkClicked() && selectCount >= 3) {
      MainWorld main =
          new MainWorld(
              getWidth(),
              getHeight(),
              SI,
              CWI,
              EPR,
              selectedIndustry,
              eventButton.getState(),
              cycleButton.getCycle(),
              moneyButton.getInitialMoney());
      Greenfoot.setWorld(main);
    }
  }

  public void stopped() {
    TitleScreen.stopBGM();
  }

  public void started() {
    TitleScreen.playBGM();
  }
}
