import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Zombie here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Zombie extends Actor
{
    /**
     * Act - do whatever the Zombie wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    GreenfootImage[] idleRight = new GreenfootImage[9];

    SimpleTimer animationTimer = new SimpleTimer();

    int speed = 1;
    int life = 5;
    int hurt = 1;

    public Zombie()
    {
        // Add your action code here.
        for(int i=0; i < idleRight.length; i++)
        {
            idleRight[i] = new GreenfootImage ("images/ZombieRun/tile00" + i+ ".png");
            idleRight[i].scale(100,100);
        }

        animationTimer.mark();

        setImage(idleRight[0]);
    }
    int imageIndex = 0;

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

    public void setSpeed(int spd)
    {
        speed = spd;
    }

    private int getLife()
    {
        return life;
    }
}
