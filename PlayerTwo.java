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
    GreenfootImage[] idleKill = new GreenfootImage[5];
    GreenfootImage[] idleStand = new GreenfootImage[5];

    String facing = "right";
    SimpleTimer animationTimer = new SimpleTimer();

    int hurt = 1;
    int heroLife = 3;

    public PlayerTwo()
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
            setImage(idleKill[imageIndex]);
            imageIndex = (imageIndex + 1) % idleKill.length;
        }
        else if(facing.equals("down"))
        {
            setImage(idleStand[imageIndex]);
            imageIndex = (imageIndex + 1) % idleStand.length;
        }
    }

    public void act()
    {
        // Add your action code here.
        if(Greenfoot.isKeyDown("up"))
        {
            setLocation(getX(),getY()-3);
        }
        else if(Greenfoot.isKeyDown("down"))
        {
            setLocation(getX(),getY()+3);
        }

        else if(Greenfoot.isKeyDown("right"))
        {
            setLocation(getX()+3,getY());
            facing = "right";
        }

        else if(Greenfoot.isKeyDown("left"))
        {
            setLocation(getX()-3,getY());
            facing = "left";
        }

        else if(Greenfoot.isKeyDown("/"))
        {
            facing = "up";
        }
        else
        {
            facing = "down";
        }

        animateHeroRun();
        
        hit();

    }
    
    public int hit()
    {
        if( isTouching(Zombie.class))
        {
            heroLife --;
            removeTouching(Zombie.class);
            MyWorld world = (MyWorld) getWorld();
            world.createZombie();
        }
        if( isTouching(ZombieTwo.class))
        {
            heroLife --;
            removeTouching(ZombieTwo.class);
            MyWorld world = (MyWorld) getWorld();
            world.createZombieTwo();
        }
        return heroLife;
    }

    private int getHeroLife()
    {
        return heroLife;
    }
}
