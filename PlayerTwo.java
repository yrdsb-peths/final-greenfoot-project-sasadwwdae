import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class PlayerTwo here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PlayerTwo extends Actor
{
    /**
     * Act - do whatever the Elephant wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    GreenfootImage[] idleRight = new GreenfootImage[5];
    GreenfootImage[] idleLeft = new GreenfootImage[5];

    String facing = "right";
    SimpleTimer animationTimer = new SimpleTimer();
    
    boolean eatApple = false;

    public PlayerTwo()
    {
        for(int i=0; i < idleRight.length; i++)
        {
            idleRight[i] = new GreenfootImage ("images/HeroRun/tile"+i+".png");
            idleRight[i].scale(80,80);
        }

        for(int i=0; i < idleRight.length; i++)
        {
            idleLeft[i] = new GreenfootImage ("images/HeroRun/tile"+i+".png");
            idleLeft[i].mirrorHorizontally();
            idleLeft[i].scale(80,80);
        }

        animationTimer.mark();

        setImage(idleRight[0]);
    }

    int imageIndex = 0;
    public void animateHeroRun()
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
        // Add your action code here.
        if(Greenfoot.isKeyDown("down"))
        {
            setLocation(getX(),getY()-3);
        }

        if(Greenfoot.isKeyDown("up"))
        {
            setLocation(getX(),getY()+3);
        }

        if(Greenfoot.isKeyDown("right"))
        {
            setLocation(getX()+3,getY());
            facing = "right";
        }

        if(Greenfoot.isKeyDown("left"))
        {
            setLocation(getX()-3,getY());
            facing = "left";
        }
        hit();

        animateHeroRun();

    }

    public void hit()
    {
        if(isTouching(Zombie.class))
        {
            removeTouching(Zombie.class);
            MyWorld world = (MyWorld) getWorld();

        }
    }  

    int size = 80;
    public void setSize(int sz)
    {
        size = size + sz;
    }

    public boolean getEatApple()
    {
        return eatApple;
    }
}
