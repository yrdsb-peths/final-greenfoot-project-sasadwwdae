import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class GameOver here.
 * 
 * @author (Zhu) 
 * @version (2023 Jan 19)
 */
public class GameOver extends World
{
    // reference a new player
    Player player1;
    /**
     * Constructor for objects of class GameOver.
     * 
     */
    public GameOver()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1,true); 
        getBackground().scale(600,500);
        //add a new player in to the world
        player1 = new Player();
        addObject(player1,400,300);
        //add some infor
        Label label = new Label("Game Over", 80);
        addObject(label,282,190);
        label.setLocation(300,200);
        Label labelTwo = new Label("press 1 or 2 to restart", 60);
        addObject(labelTwo,300,100);
        label.setLocation(300,200);
    }

    //create the number of player depend on the buttom you press
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
    //add the ax when press the buttom 
    public void createAx()
    {
        Ax ax = new Ax();
        int x = player1.getX();
        int y = player1.getY();
        addObject(ax,x,y);
    }
}
