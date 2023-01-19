import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Ax here.
 * 
 * @author (Zhu) 
 * @version (2023 Jan 19)
 */
public class Ax extends Actor
{
    //add the information 
    GreenfootImage ax = new GreenfootImage("Images/Ax.png");
    int speed = 2;
    /**
     * Act - do whatever the Ax wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */

    public void act()
    {
        //make sure the ax can move
        move(speed);
        //set the ax size
        Axplay();
        //make sure the ax remove the zombie class and the score increase
        hit();
    }
    //set the image size
    public void Axplay()
    {
        ax.scale(60,50);
        setImage(ax);
    }
    //remove zombie and increase the score
    public void hit()
    {
        if( isTouching(Zombie.class))
        {
            removeTouching(Zombie.class);
            MyWorld world = (MyWorld) getWorld();
            world.createZombie();
            world.increaseScore();
        }
        if( isTouching(ZombieTwo.class))
        {
            removeTouching(ZombieTwo.class);
            MyWorld world = (MyWorld) getWorld();
            world.createZombieTwo();
            world.increaseScore();
        }
    }
}
