import greenfoot.*; // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Event here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public abstract class Event extends SuperSmoothMover {
  private MainWorld mw;

  /**
   * Act - do whatever the Event wants to do. This method is called whenever the 'Act' or 'Run'
   * button gets pressed in the environment.
   */
  public void act() {
    // Add your action code here.
  }

  public void addedToWorld(World w) {
    mw = (MainWorld) w;
  }

  public void changeIndex(int SI, int EPR, int CWI) {
    mw.changeSI(SI);
    mw.changeEPR(EPR);
    mw.changeCWI(CWI);
  }
}
