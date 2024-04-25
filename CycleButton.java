import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class CycleButton here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CycleButton extends Button
{
    /**
     * Act - do whatever the CycleButton wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    int numOfCycles=5; //5, 10, 15
    boolean ifDiscbetion=true;
    private GreenfootImage unclickedCycleButton = new GreenfootImage("Button/cycleButton_unpressed_5.png");
    private GreenfootImage clickedCycleButton = new GreenfootImage("Button/cycleButton_pressed_5.png");
    public CycleButton(){
        super(true);
    }
    public void act()
    {
        if (Greenfoot.mouseClicked(this)) {
            if(numOfCycles<15){
              numOfCycles+=5;
          }
          else{
              numOfCycles=5;
          }
          clickedCycleButton = new GreenfootImage("Button/cycleButton_pressed_"+numOfCycles+".png");
            clickedCycleButton.scale(400, 120);
          setImage(clickedCycleButton);
        } else {
            unclickedCycleButton = new GreenfootImage("Button/cycleButton_unpressed_"+numOfCycles+".png");
            unclickedCycleButton.scale(400, 120);
          setImage(unclickedCycleButton);
        }
    }
    public int getCycle(){
        return numOfCycles;
    }
}


