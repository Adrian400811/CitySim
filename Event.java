import greenfoot.*; // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Event Superclass
 *
 * @author Jimmy, Adrian, Daniel
 * @version April 24, 2024
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

  /**
   * Changes the index of the MainWorld based off of the parameter values
   *
   * @param SI The value of SI to be changed
   * @param EPR The value of EPR to be changed
   * @param CWI The value of CWI to be changed
   */
  public void changeIndex(int SI, int EPR, int CWI) {
    mw.changeSI(SI);
    mw.changeEPR(EPR);
    mw.changeCWI(CWI);
  }
}
