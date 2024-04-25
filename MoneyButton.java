import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MoneyButton here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MoneyButton extends Button
{
    boolean ifDiscbetion=true;
    int initialMoney=0; //0~5000 +-1000
    private GreenfootImage unclickedMoneyButton = new GreenfootImage("Button/ImoneyButton_unpressed_0.png");
    private GreenfootImage clickedMoneyButton = new GreenfootImage("Button/ImoneyButton_pressed_0.png");
    /**
     * Act - do whatever the MoneyButton wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public MoneyButton(){
        super(true);
    }
    public int getInitialMoney(){
        return initialMoney;
    }
    public void act()
    {
        if (Greenfoot.mouseClicked(this)) {
            if(initialMoney<5000){
                initialMoney+=1000;
            }
            else{
                initialMoney=0;
            }
            clickedMoneyButton = new GreenfootImage("Button/ImoneyButton_pressed_"+initialMoney+".png");
            
            clickedMoneyButton.scale(400, 120);
          setImage(clickedMoneyButton);
        } else {
            unclickedMoneyButton = new GreenfootImage("Button/ImoneyButton_unpressed_"+initialMoney+".png");
            unclickedMoneyButton.scale(400, 120);
          setImage(unclickedMoneyButton);
        }
    }
}
