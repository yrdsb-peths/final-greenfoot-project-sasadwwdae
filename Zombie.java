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
    GreenfootImage[] idleLeft = new GreenfootImage[5];
    
    String facing = "right";
    SimpleTimer animationTimer = new SimpleTimer();
    
    int speed = 1;
    int life = 5;
    int hurt = 1;
    public void act()
    {
        // Add your action code here.
        for(int i=0; i < idleRight.length; i++)
        {
            idleRight[i] = new GreenfootImage ("images/ZombieStand" + i+ ".png");
            idleRight[i].scale(40,40);
        }

        for(int i=0; i < idleRight.length; i++)
        {
            idleLeft[i] = new GreenfootImage ("images/ZombieStand" + i+ ".png");
            idleLeft[i].mirrorHorizontally();
            idleLeft[i].scale(40,40);
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
        if(facing.equals("right"))
        {
            setImage(idleRight[imageIndex]);
            imageIndex = (imageIndex + 1) % idleRight.length;
        }
        else
        {
            setImage(idleLeft[imageIndex]);
            imageIndex = (imageIndex + 1) % idleLeft.length;
        }
    }
    
    public void act()
    {
        if(Zombie.getX() != Player.getX())
        {
            setLocation(getX()+2,getY()&&setLocation(getX()-2,getY());
        }
        
        if(Zombie.getY() != Player.getY())
        {
            setLocation(getX(),getY()+2)&&setLocation(getX(),getY()-2);
        }
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
