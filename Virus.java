import greenfoot.*; // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Virus here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Virus extends Event {
  
  private MainWorld mw;
    
  private GreenfootImage virus;
  
  private int actsLeft;
  
  Label virusText = new Label("",45);
  
  /**
   * Act - do whatever the Virus wants to do. This method is called whenever the 'Act' or 'Run'
   * button gets pressed in the environment.
   */
  public Virus() {
    changeIndex(0, -2, -3);
    virus = new GreenfootImage(1280,720);
    virus.setColor(Color.GREEN);
    virus.fillRect(0,0,1280,720);
    virus.setTransparency(100);
    setImage(virus);
    
    actsLeft = 300;
    
    
  }

  public void act() {
    // Add your action code here.
    actsLeft--;
    
    if (actsLeft == 0){
        getWorld().removeObject(this.virusText);
        getWorld().removeObject(this);
    }
  }
  
  public void addedToWorld(World MainWorld){
    virusText.setValue("A Virus approaches..."  + "\nEPR -2" + "\nCWI -3");
    MainWorld.addObject(virusText, 260, 360);
  }
}
