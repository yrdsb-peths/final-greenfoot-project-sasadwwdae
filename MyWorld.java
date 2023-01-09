import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{

    int numPlayer;
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MyWorld(){
        this(1);
    }
    
    public MyWorld(int numPlayers)
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1, false); 
        getBackground().scale(600,500);


        if(numPlayers == 1)
        {
            Player player = new Player();
            addObject(player,400,300);
        }
        else if(numPlayers == 2)
        {
            Player player = new Player();
            addObject(player,400,300);
            
            PlayerTwo playerTwo = new PlayerTwo();
            addObject(playerTwo,100,300);
        }
    }
}
