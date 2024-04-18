import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Image here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Image extends Actor
{
    private GreenfootImage image;
    public Image(String path){
        image = new GreenfootImage(path);
        setImage(image);
    }
    public Image(String path, int scaleX, int scaleY){
        image = new GreenfootImage(path);
        image.scale(scaleX, scaleY);
        setImage(image);
    }
    public Image(String path, int scalePercent){
        image = new GreenfootImage(path);
        double width = image.getWidth()*scalePercent/100;
        double height = image.getHeight()*scalePercent/100;
        image.scale((int)width, (int)height);
        setImage(image);
    }
    /**
     * Act - do whatever the Image wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        // Add your action code here.
    }
}
