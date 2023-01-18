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
    Player player1;
    PlayerTwo player2;
    Heart heart = new Heart();
    Heart heart2 = new Heart();
    Heart heart3 = new Heart();

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
        super(600, 400, 1, true); 
        getBackground().scale(600,500);

        scoreLabel = new Label(0, 80);
        addObject(scoreLabel,50,50);

        player1 = new Player();
        addObject(player1,400,300);
        
        addObject(heart,575,25);
        heart.setLocation(575,25);
        addObject(heart2,550,25);
        addObject(heart3,525,25);
        heart3.setLocation(525,25);

        if(numPlayers == 2)
        {
            player2 = new PlayerTwo();
            addObject(player2,100,300);
            
            createZombieTwo();
        }
        
        createZombie();

    }
    
    public void createZombie()
    {
        Zombie zombie = new Zombie();
        int x = Greenfoot.getRandomNumber(600);
        int y = Greenfoot.getRandomNumber(400);
        addObject(zombie,x,y);
    }
    
    public void createZombieTwo()
    {
        ZombieTwo zombie = new ZombieTwo();
        int x = Greenfoot.getRandomNumber(600);
        int y = Greenfoot.getRandomNumber(400);
        addObject(zombie,x,y);
    }
    
    public void createAx(int angle)
    {
        Ax ax = new Ax();
        int x = player1.getX();
        int y = player1.getY();
        ax.setRotation(angle);
        addObject(ax,x,y);
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
    
    public void act()
    {
        if(player1.heroLife==2)
        {
            removeObject(heart3);
        }
        if(player1.heroLife==1)
        {
            removeObject(heart3);
            removeObject(heart2);
        }
        if(player1.heroLife==0)
        {
            GameOver gameWorld = new GameOver();
            Greenfoot.setWorld(gameWorld);
        }
    }
}
