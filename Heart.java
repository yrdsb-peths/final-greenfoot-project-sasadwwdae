import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Heart here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Heart extends Actor
{
    //refer the heart image
    GreenfootImage heart = new GreenfootImage("Images/heart.png");
    /**
     * Act - do whatever the Heart wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        // Add your action code here.
        // add the heart class
        PlayerHeat();
    }
    
    public void PlayerHeat()
    {
        //set the charactor image
        heart.scale(60,50);
        setImage(heart);
    }
}
