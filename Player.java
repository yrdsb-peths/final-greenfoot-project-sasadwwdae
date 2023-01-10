import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Player here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
    public class Player extends Actor
{
    /**
     * Act - do whatever the Elephant wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    GreenfootImage[] idleRight = new GreenfootImage[5];
    GreenfootImage[] idleLeft = new GreenfootImage[5];
    GreenfootImage[] idleup = new GreenfootImage[5];
    GreenfootImage[] idleDown = new GreenfootImage[5];

    String facing = "right";
    SimpleTimer animationTimer = new SimpleTimer();
    
    boolean eatApple = false;

    public Player()
    {
        for(int i=0; i < idleRight.length; i++)
        {
            idleRight[i] = new GreenfootImage ("images/HeroRun/tile00"+i+".png");
            idleRight[i].scale(80,80);
        }

        for(int i=0; i < idleLeft.length; i++)
        {
            idleLeft[i] = new GreenfootImage ("images/HeroRun/tile00"+i+".png");
            idleLeft[i].mirrorHorizontally();
            idleLeft[i].scale(80,80);
        }
        /*
        for(int i=0; i < idleup.length; i++)
        {
            idleRight[i] = new GreenfootImage ("images/Swing/tile00"+i+".png");
            idleRight[i].scale(80,80);
        }
        */
        for(int i=0; i < idleDown.length; i++)
        {
            idleRight[i] = new GreenfootImage ("images/HeroStand/tile00"+i+".png");
            idleRight[i].scale(80,80);
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
        else if(facing.equals("left"))
        {
            setImage(idleLeft[imageIndex]);
            imageIndex = (imageIndex + 1) % idleLeft.length;
        }
        else if(facing.equals("up"))
        {
            setImage(idleup[imageIndex]);
            imageIndex = (imageIndex + 1) % idleup.length;
        }
        else if(facing.equals("Down"))
        {
            setImage(idleDown[imageIndex]);
            imageIndex = (imageIndex + 1) % idleDown.length;
        }
    }

    public void act()
    {
        // Add your action code here.
        if(Greenfoot.isKeyDown("w"))
        {
            setLocation(getX(),getY()-3);
        }

        if(Greenfoot.isKeyDown("s"))
        {
            setLocation(getX(),getY()+3);
        }

        if(Greenfoot.isKeyDown("d"))
        {
            setLocation(getX()+3,getY());
            facing = "right";
        }

        if(Greenfoot.isKeyDown("a"))
        {
            setLocation(getX()-3,getY());
            facing = "left";
        }
        
        if(Greenfoot.isKeyDown("q"))
        {
            facing = "up";
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

