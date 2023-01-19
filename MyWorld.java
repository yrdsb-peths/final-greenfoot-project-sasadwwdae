import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (Zhu) 
 * @version (2023 Jan 19)
 */
public class MyWorld extends World
{
    public int score;
    Label scoreLabel;
    int level = 1;
    //the player number
    int numPlayer;
    //set the ax speed
    int speed = 1;
    //create player
    Player player1;
    PlayerTwo player2;
    //create heart
    Heart heart = new Heart();
    Heart heart2 = new Heart();
    Heart heart3 = new Heart();
    //this code used for ditermine the number of player
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MyWorld(){
        this(1);
    }
    //this code used for ditermine the number of player
    public MyWorld(int numPlayers)
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1, true); 
        getBackground().scale(600,500);

        //recose the score
        scoreLabel = new Label(0, 80);
        addObject(scoreLabel,50,50);
        //create player1
        player1 = new Player();
        addObject(player1,400,300);
        //add heart into the world
        addObject(heart,575,25);
        heart.setLocation(575,25);
        addObject(heart2,550,25);
        addObject(heart3,525,25);
        heart3.setLocation(525,25);

        //this code will create a new player
        if(numPlayers == 2)
        {
            player2 = new PlayerTwo();
            addObject(player2,100,300);
            
            createZombieTwo();
        }
        //create a zombie
        createZombie();

    }
    //when do not have zombie,creat a zombie
    public void createZombie()
    {
        Zombie zombie = new Zombie();
        int x = Greenfoot.getRandomNumber(600);
        int y = Greenfoot.getRandomNumber(400);
        addObject(zombie,x,y);
    }
    //when do not have zombie,creat a zombie
    public void createZombieTwo()
    {
        ZombieTwo zombie = new ZombieTwo();
        int x = Greenfoot.getRandomNumber(600);
        int y = Greenfoot.getRandomNumber(400);
        addObject(zombie,x,y);
    }
    //create the ax method make sure it can move in the player's diretion 
    public void createAx(int angle)
    {
        Ax ax = new Ax();
        int x = player1.getX();
        int y = player1.getY();
        ax.setRotation(angle);
        addObject(ax,x,y);
    }
    //when kill a zombie can increase the score
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
    //when player get hurt the heart can disappear in the main world
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
