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
    GreenfootImage[] idleKill = new GreenfootImage[5];
    GreenfootImage[] idleStand = new GreenfootImage[5];

    String facing = "right";
    SimpleTimer animationTimer = new SimpleTimer();

    int zombieLife = 5;
    int hurt = 1;
    int heroLife = 3;

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

        for(int i=0; i < idleKill.length; i++)
        {
            idleKill[i] = new GreenfootImage ("images/Swing/tile00"+i+".png");
            idleKill[i].scale(80,80);
        }

        for(int i=0; i < idleStand.length; i++)
        {
            idleStand[i] = new GreenfootImage ("images/HeroStand/tile"+i+".png");
            idleStand[i].scale(80,80);
        }

        animationTimer.mark();

        setImage(idleRight[0]);
    }

    int imageIndex = 0;
    public void animateHeroRun()
    {
        if(animationTimer.millisElapsed() < 200)
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
            setImage(idleKill[imageIndex]);
            imageIndex = (imageIndex + 1) % idleKill.length;
        }
        else if(facing.equals("Down"))
        {
            setImage(idleStand[imageIndex]);
            imageIndex = (imageIndex + 1) % idleStand.length;
        }
    }

    public void act()
    {
        // Add your action code here.
        if(Greenfoot.isKeyDown("w"))
        {
            setLocation(getX(),getY()-3);
        }
        else if(Greenfoot.isKeyDown("s"))
        {
            setLocation(getX(),getY()+3);
        }
        else if(Greenfoot.isKeyDown("d"))
        {
            setLocation(getX()+3,getY());
            facing = "right";
        }
        else if(Greenfoot.isKeyDown("a"))
        {
            setLocation(getX()-3,getY());
            facing = "left";
        }
        else if(Greenfoot.isKeyDown("q"))
        {
            facing = "up";
        }
        else
        {
            facing = "down";
        }

        animateHeroRun();

    } 

    private int getZombieLife()
    {
        return zombieLife;
    }

    private int getHeroLife()
    {
        return heroLife;
    }
}

