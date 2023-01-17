import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Ax here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Ax extends Actor
{
    GreenfootImage ax = new GreenfootImage("Images/Ax.png");
    /**
     * Act - do whatever the Ax wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
   
        public void act()
    {
        // Add your action code here.
        Axplay();
        hit();


        MyWorld world = (MyWorld) getWorld();
        Player player1 = world.player1;
        if(player1.facing.equals("right"))
        {
            setLocation(getX()+1,getY());
        }
        if(player1.facing.equals("left"))
        {
            setLocation(getX()-1,getY());
        }
        
        setLocation(getX(),getY()-3);
    }
    
    public void Axplay()
    {
        ax.scale(60,50);
        setImage(ax);
    }
    
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
