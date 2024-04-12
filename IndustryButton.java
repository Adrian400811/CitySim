import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class IndustryButton here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class IndustryButton extends Button
{
    private GreenfootImage image;
    private int type;
    private String[] icons = {"Manufacturing","Agriculture","Education","Energy","Forestry",
                              "Material","Technology", "Recreation", "UrbanDev"};
    
    public IndustryButton(int type){
        this.type = type;
        image = new GreenfootImage("images/industry/"+icons[type]+"1.png");
        image.scale(128, 128);
        setImage(image);
    }
    /**
     * Act - do whatever the IndustryButton wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        // Add your action code here.
        if (Greenfoot.mouseClicked(this)) {
          System.out.println("clicked"+type);
        }
    }
}
