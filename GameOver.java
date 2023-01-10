import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class GameOver here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GameOver extends World
{

    /**
     * Constructor for objects of class GameOver.
     * 
     */
    public GameOver()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        getBackground().scale(600,500);
        
        Player player = new Player();
        addObject(player,400,300);
        
        
    }
    
    private void prepare()
    {
        Label label = new Label("Game Over", 80);
        addObject(label,282,190);
        label.setLocation(300,200);
        
        Label labelTwo = new Label("press 1 or 2 to restart", 80);
        addObject(labelTwo,300,100);
        label.setLocation(300,200);
    }
    
    public void act()
    {
        if(Greenfoot.isKeyDown("1"))
        {
            MyWorld gameWorld = new MyWorld(1);
            Greenfoot.setWorld(gameWorld);
        }else if(Greenfoot.isKeyDown("2"))
        {
            MyWorld gameWorld = new MyWorld(2);
            Greenfoot.setWorld(gameWorld);
        }
    }
}
