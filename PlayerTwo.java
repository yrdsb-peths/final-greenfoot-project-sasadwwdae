import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)


/**
 * Write a description of class Player here.
 * 
 * @author (Zhu) 
 * @version (2023 Jan 19)
 */
public class PlayerTwo extends Actor
{
    /**
     * Act - do whatever the Elephant wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    //set the attack sound
    GreenfootSound swingSound = new GreenfootSound("swing.mp3");
    
    //set the different idle
    GreenfootImage[] idleRight = new GreenfootImage[5];
    GreenfootImage[] idleLeft = new GreenfootImage[5];
    GreenfootImage[] idleKill = new GreenfootImage[5];
    GreenfootImage[] idleKillLeft = new GreenfootImage[5];
    GreenfootImage[] idleStand = new GreenfootImage[5];
    GreenfootImage[] idleStandLeft = new GreenfootImage[5];
    
    String facing = "right";//facing direction
    String action = "standing";//set the action attack,stand,run
    SimpleTimer animationTimer = new SimpleTimer();//animation timer

    int hurt = 1;//the hert number
    int heroLife = 3;//the hero life

    public PlayerTwo()
    {
        //right run
        for(int i=0; i < idleRight.length; i++)
        {
            idleRight[i] = new GreenfootImage ("images/HeroRun/tile00"+i+".png");
            idleRight[i].scale(80,80);
        }
        //left run
        for(int i=0; i < idleLeft.length; i++)
        {
            idleLeft[i] = new GreenfootImage ("images/HeroRun/tile00"+i+".png");
            idleLeft[i].mirrorHorizontally();
            idleLeft[i].scale(80,80);
        }
        //attack right
        for(int i=0; i < idleKill.length; i++)
        {
            idleKill[i] = new GreenfootImage ("images/Swing/tile00"+i+".png");
            idleKill[i].scale(80,80);
        }
        //attack left
        for(int i=0; i < idleKill.length; i++)
        {
            idleKillLeft[i] = new GreenfootImage ("images/Swing/tile00"+i+".png");
            idleKillLeft[i].mirrorHorizontally();
            idleKillLeft[i].scale(80,80);
        }
        //stand right
        for(int i=0; i < idleStand.length; i++)
        {
            idleStand[i] = new GreenfootImage ("images/HeroStand/tile"+i+".png");
            idleStand[i].scale(80,80);
        }
        //stand left
        for(int i=0; i < idleStandLeft.length; i++)
        {
            idleStandLeft[i] = new GreenfootImage ("images/HeroStand/tile"+i+".png");
            idleStandLeft[i].mirrorHorizontally();
            idleStandLeft[i].scale(80,80);
        }
        //animation timer
        animationTimer.mark();
        //set the image
        setImage(idleRight[0]);
    }

    int imageIndex = 0;
    public void animateHero()
    {
        //return the animation timer
        if(animationTimer.millisElapsed() < 200)
        {
            return;
        }
        animationTimer.mark();
        //set the image
        if(facing.equals("right") && action.equals("run"))//right run
        {
            setImage(idleRight[imageIndex]);
            imageIndex = (imageIndex + 1) % idleRight.length;
        }
        else if(facing.equals("right")&&action.equals("attack"))//right attack 
        {
            setImage(idleKill[imageIndex]);
            imageIndex = (imageIndex + 1) % idleKill.length;
        }
        else if(facing.equals("right")&&action.equals("stand"))//right stand
        {
            setImage(idleStand[imageIndex]);
            imageIndex = (imageIndex + 1) % idleStand.length;
        }
        
        else if(facing.equals("left")&&action.equals("run"))//left run
        {
            setImage(idleLeft[imageIndex]);
            imageIndex = (imageIndex + 1) % idleLeft.length;
        }
        else if(facing.equals("left")&&action.equals("attack"))//left attack
        {
            setImage(idleKillLeft[imageIndex]);
            imageIndex = (imageIndex + 1) % idleKillLeft.length;
        }
        else if(facing.equals("left")&&action.equals("stand"))//left stand
        {
            setImage(idleStandLeft[imageIndex]);
            imageIndex = (imageIndex + 1) % idleStandLeft.length;
        }
    }

    public void act()
    {
        // Add your action code here.
        if(Greenfoot.isKeyDown("up"))//move up
        {
            setLocation(getX(),getY()-3);
        }
        else if(Greenfoot.isKeyDown("down"))//move down
        {
            setLocation(getX(),getY()+3);
        }

        else if(Greenfoot.isKeyDown("right"))//move right, set the facing and action
        {
            setLocation(getX()+3,getY());
            facing = "right";
            action = "run";
        }

        else if(Greenfoot.isKeyDown("left"))//move left, set the facing and action
        {
            setLocation(getX()-3,getY());
            facing = "left";
            action = "run";
        }

        else if(Greenfoot.isKeyDown("/"))
        {
            action = "attack";
            Ax ax = new Ax();
            //depend facing derection than depend on the ax attack direction
            if(facing == "right") 
            {
                ax.speed = 2;
            } 
            else if(facing == "left")
            {
                ax.speed = -2;
            }
            //add the ax class
            getWorld().addObject(ax, getX(), getY());
            //play the attack sound
            swingSound.play();
        }
        else//set stand idle
        {
            action = "stand";
        }
        // the animation of the player run
        animateHero();
        //hit by zombie and lose life 
        hit();
    }
    //if touching the zombie then the player will get heart
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
}

