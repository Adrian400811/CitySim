import greenfoot.*; // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Settings here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Settings extends World {
    Label title = new Label("Settings", 45);
    Label sustainable = new Label("Sustainability Index", 45);
    Label economic = new Label("Economic Prosperity Rating", 45);
    Label community = new Label("Community Well-being Index", 45);
    Label next = new Label("Next", 45);
    Button nextBtn = new NextButton();

    private int[] btnY = {180, 300, 420};
    private int dir;
    private int buttonCount = 6;
    private Button[] button;

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
    }

    public void act() {
        checkPressed();
    }

    public void spawnText(){
        addObject(title, getWidth() / 10, 60);
        addObject(sustainable, getWidth() / 2, 180);
        addObject(economic, getWidth() / 2, 300);
        addObject(community, getWidth() / 2, 420);
        addObject(next, getWidth() - 175, 650);
    }

    public void spawnButtons() {
        button = new Button[9];
        for (int i = 0; i < 6; i++) {
            if(i%2 == 0){
                button[i] = new AddButton();
                dir = 1;
            } else {
                button[i] = new SubtractButton();
                dir = -1;
            }
            addObject(button[i], getWidth()/2+(300*dir), btnY[i/2]);
        }
        addObject(nextBtn, getWidth() - 110, 650);
    }

    public void checkPressed(){
        for(int i = 0; i < button.length; i++){
            if(i%2 == 0){
                dir = 1;
            } else {
                dir = -1;
            }
            if(button[i] != null && button[i].checkClicked()){
                switch (i/2){
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
        if(nextBtn != null && nextBtn.checkClicked()){
            MainWorld main = new MainWorld(getWidth(), getHeight(), SI, CWI, EPR);
            Greenfoot.setWorld(main);
        }
    }
}
