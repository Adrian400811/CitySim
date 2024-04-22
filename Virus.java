import greenfoot.*; // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Virus here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Virus extends Event {
  
  private GreenfootImage virus;
  
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
  }

  public void act() {
    // Add your action code here.
  }
}
