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
    GreenfootImage[] idleUp = new GreenfootImage[5];
    GreenfootImage[] idleDown = new GreenfootImage[5];

    String facing = "right";
<<<<<<< Updated upstream
=======
    String action = "stand";
>>>>>>> Stashed changes
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
<<<<<<< Updated upstream
        /*
        for(int i=0; i < idleup.length; i++)
=======

        for(int i=0; i < idleKill.length; i++)
        {
            idleKill[i] = new GreenfootImage ("images/Swing/tile00"+i+".png");
            idleKill[i].scale(80,80);
        }

        for(int i=0; i < idleKillLeft.length; i++)
        {
            idleKill[i] = new GreenfootImage ("images/Swing/tile00"+i+".png");
            idleKill[i].mirrorHorizontally();
            idleKill[i].scale(80,80);
        }

        for(int i=0; i < idleStand.length; i++)
>>>>>>> Stashed changes
        {
        idleRight[i] = new GreenfootImage ("images/Swing/tile00"+i+".png");
        idleRight[i].scale(80,80);
        }
         */
        for(int i=0; i < idleDown.length; i++)
        {
<<<<<<< Updated upstream
            idleDown[i] = new GreenfootImage ("images/HeroStand/tile"+i+".png");
            idleDown[i].scale(80,80);
=======
            idleStand[i] = new GreenfootImage ("images/HeroStand/tile"+i+".png");
            idleStand[i].mirrorHorizontally();
            idleStand[i].scale(80,80);
>>>>>>> Stashed changes
        }

        animationTimer.mark();

        setImage(idleDown[0]);
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
<<<<<<< Updated upstream
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
            setImage(idleUp[imageIndex]);
            imageIndex = (imageIndex + 1) % idleUp.length;
        }
        else if(facing.equals("down"))
        {
            setImage(idleDown[imageIndex]);
            imageIndex = (imageIndex + 1) % idleDown.length;
=======
            if(action.equals("run"))
            {
                setImage(idleRight[imageIndex]);
                imageIndex = (imageIndex + 1) % idleRight.length;
            }
            else if(action.equals("attack"))
            {
                setImage(idleKill[imageIndex]);
                imageIndex = (imageIndex + 1) % idleKill.length;
            }
            else if(action.equals("stand"))
            {
                setImage(idleStand[imageIndex]);
                imageIndex = (imageIndex + 1) % idleStand.length;
            }
        }
        else if(facing.equals("left"))
        {
            if(action.equals("run"))
            {
                setImage(idleLeft[imageIndex]);
                imageIndex = (imageIndex + 1) % idleLeft.length;
            }
            else if(action.equals("attack"))
            {
                setImage(idleKillLeft[imageIndex]);
                imageIndex = (imageIndex + 1) % idleKillLeft.length;
            }
            else if(action.equals("stand"))
            {
                setImage(idleStandLeft[imageIndex]);
                imageIndex = (imageIndex + 1) % idleStandLeft.length;
            }
>>>>>>> Stashed changes
        }
    }

    public void act()
    {
        // Add your action code here.
        MyWorld world = (MyWorld) getWorld();

        if(Greenfoot.isKeyDown("w"))
        {
            setLocation(getX(),getY()-3);
        }
        else if(Greenfoot.isKeyDown("s"))
        {
            setLocation(getX(),getY()+3);
        }
        else if(Greenfoot.isKeyDown("w"))
        {
            setLocation(getX(),getY()+3);
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
<<<<<<< Updated upstream
            facing = "up";
=======
            action = "attack";
            MyWorld mainWorld = (MyWorld) getWorld();
            mainWorld.createAx();
>>>>>>> Stashed changes
        }
        else
        {
            facing = "down";
        }
        hit();

        animateHeroRun();

    }
<<<<<<< Updated upstream

    public void hit()
=======
    public int hit()
>>>>>>> Stashed changes
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

