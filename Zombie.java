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
    GreenfootImage[] idleRight = new GreenfootImage[5];

    SimpleTimer animationTimer = new SimpleTimer();

    int speed = 1;
    int life = 5;
    int hurt = 1;
    Player player;
    public Zombie(Player player)
    {
        // Add your action code here.
        for(int i=0; i < idleRight.length; i++)
        {
            idleRight[i] = new GreenfootImage ("images/ZombieStand/" + i+ ".png");
            idleRight[i].scale(40,40);
        }

        animationTimer.mark();

        setImage(idleRight[0]);
    }
    int imageIndex = 0;
    public void animateZombie()
    {
        if(animationTimer.millisElapsed() < 230)
        {
            return;
        }
        animationTimer.mark();

        setImage(idleRight[imageIndex]);
        imageIndex = (imageIndex + 1) % idleRight.length;

    }

    public void act()
    {
        turnTowards(player.getX(),player.getY());
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
