import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{
    public int score;
    Label scoreLabel;
    int level = 1;
    int numPlayer;
    int speed = 1;

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
        
        scoreLabel = new Label(0, 80);
        addObject(scoreLabel,50,50);


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
    
    public void increaseScore()
    {
        score++;
        scoreLabel.setValue(score);
        int i = score / 50;
        if(i >= 1)
        {
            level = i + 1;
        }
        else
        {
            level = 1;
        }
    }
}
