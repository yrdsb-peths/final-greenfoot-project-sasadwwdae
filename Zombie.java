import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Zombie here.
 * 
 * @author (Zhu) 
 * @version (2023 Jan 19)
 */
public class Zombie extends Actor
{
    /**
     * Act - do whatever the Zombie wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    //set the zombie move animation 
    GreenfootImage[] idleRight = new GreenfootImage[9];
    //the animation timer 
    SimpleTimer animationTimer = new SimpleTimer();
    //set the series of variable
    int speed = 1;
    int life = 5;
    int hurt = 1;

    //paly the animation 
    public Zombie()
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
    //set the animation 
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
    //towards the player1
    public void act()
    {
        MyWorld world = (MyWorld) getWorld();
        Player player1 = world.player1;
        if(player1 != null){
            int x = world.player1.getX();
            int y = world.player1.getY();
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
