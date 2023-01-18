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
    GreenfootSound swingSound = new GreenfootSound("swing.mp3");
    GreenfootImage[] idleRight = new GreenfootImage[5];
    GreenfootImage[] idleLeft = new GreenfootImage[5];
    GreenfootImage[] idleKill = new GreenfootImage[5];
    GreenfootImage[] idleKillLeft = new GreenfootImage[5];
    GreenfootImage[] idleStand = new GreenfootImage[5];
    GreenfootImage[] idleStandLeft = new GreenfootImage[5];

    String facing = "right";
    String action = "standing";
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

        for(int i=0; i < idleKill.length; i++)
        {
            idleKillLeft[i] = new GreenfootImage ("images/Swing/tile00"+i+".png");
            idleKillLeft[i].mirrorHorizontally();
            idleKillLeft[i].scale(80,80);
        }

        for(int i=0; i < idleStand.length; i++)
        {
            idleStand[i] = new GreenfootImage ("images/HeroStand/tile"+i+".png");
            idleStand[i].scale(80,80);
        }

        for(int i=0; i < idleStandLeft.length; i++)
        {
            idleStandLeft[i] = new GreenfootImage ("images/HeroStand/tile"+i+".png");
            idleStandLeft[i].mirrorHorizontally();
            idleStandLeft[i].scale(80,80);
        }

        animationTimer.mark();

        setImage(idleRight[0]);
    }

    int imageIndex = 0;
    public void animateHero()
    {
        if(animationTimer.millisElapsed() < 200)
        {
            return;
        }
        animationTimer.mark();

        if(facing.equals("right") && action.equals("run"))
        {
            setImage(idleRight[imageIndex]);
            imageIndex = (imageIndex + 1) % idleRight.length;
        }
        else if(facing.equals("right")&&action.equals("attack"))
        {
            setImage(idleKill[imageIndex]);
            imageIndex = (imageIndex + 1) % idleKill.length;
        }
        else if(facing.equals("right")&&action.equals("stand"))
        {
            setImage(idleStand[imageIndex]);
            imageIndex = (imageIndex + 1) % idleStand.length;
        }

        else if(facing.equals("left")&&action.equals("run"))
        {
            setImage(idleLeft[imageIndex]);
            imageIndex = (imageIndex + 1) % idleLeft.length;
        }
        else if(facing.equals("left")&&action.equals("attack"))
        {
            setImage(idleKillLeft[imageIndex]);
            imageIndex = (imageIndex + 1) % idleKillLeft.length;
        }
        else if(facing.equals("left")&&action.equals("stand"))
        {
            setImage(idleStandLeft[imageIndex]);
            imageIndex = (imageIndex + 1) % idleStandLeft.length;
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
            action = "run";
        }

        else if(Greenfoot.isKeyDown("left"))
        {
            setLocation(getX()-3,getY());
            facing = "left";
            action = "run";
        }

        else if(Greenfoot.isKeyDown("."))
        {
            action = "attack";
            Ax ax = new Ax();
            if(facing == "right")
            {
                ax.speed = 2;
            } 
            else if(facing == "left")
            {
                ax.speed = -2;
            }
            getWorld().addObject(ax, getX(), getY());
            swingSound.play();
        }
        else
        {
            action = "stand";
        }

        animateHero();

        hit();

    }

    public int hit()
    {
        if(isTouching(Zombie.class))
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
