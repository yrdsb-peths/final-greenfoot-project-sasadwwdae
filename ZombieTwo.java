import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class ZombieTwo here.
 * 
 * @author (Zhu) 
 * @version (2023 Jan 19)
 */
public class ZombieTwo extends Actor
{
    /**
     * Act - do whatever the ZombieTwo wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    //set the arrays of zombie 
    GreenfootImage[] idleRight = new GreenfootImage[9];
    //set the timer
    SimpleTimer animationTimer = new SimpleTimer();
    //set series of the variable 
    int speed = 1;
    int life = 5;
    int hurt = 1;
    //play the animation 
    public ZombieTwo()
    {
        // Add your action code here.
        for(int i=0; i < idleRight.length; i++)
        {
            idleRight[i] = new GreenfootImage ("images/ZombieRun/tile00" + i+ ".png");
            idleRight[i].scale(50,50);
        }
        
        animationTimer.mark();

        setImage(idleRight[0]);
    }
    int imageIndex = 0;
    //set the zombie image
    public void animateZombie()
    {
        if(animationTimer.millisElapsed() < 100)
        {
            return;
        }
        animationTimer.mark();

        setImage(idleRight[imageIndex]);
        imageIndex = (imageIndex + 1) % idleRight.length;

    }
    //move towards the player
    public void act()
    {
        MyWorld world = (MyWorld) getWorld();
        PlayerTwo player2 = world.player2;
        if(player2 != null){
            int x = world.player2.getX();
            int y = world.player2.getY();
            turnTowards(x, y);
        }
        move(1);
        
        animateZombie();
    }
    //set the speed
    public void setSpeed(int spd)
    {
        speed = spd;
    }
}
