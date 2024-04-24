import greenfoot.*; // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Button here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public abstract class Button extends Actor {
    private boolean ifDiscbetion=false;
    private String discbetion;
    
    private MouseInfo m = Greenfoot.getMouseInfo();
    public Button(boolean Discbetion){
        this.ifDiscbetion=Discbetion;
    }
    
  /**
   * Act - do whatever the Button wants to do. This method is called whenever the 'Act' or 'Run'
   * button gets pressed in the environment.
   */
  public void act() {}
    public boolean cheakDis(){
        return ifDiscbetion;
    }
  public boolean checkClicked() {
      if (Greenfoot.mouseClicked(this)) {
      return true;
    }
    return false;

  }
  public boolean openDis(boolean ifDiscbetion){
      if(ifDiscbetion && Greenfoot.mouseClicked(this) && m.getButton()==3){
        return true;
        }
        return false;
  }
  public String getDis(){
      return discbetion;
  }
}
