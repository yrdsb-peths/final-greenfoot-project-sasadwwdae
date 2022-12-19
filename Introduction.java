import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Introduction here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Introduction extends World
{

    /**
     * Constructor for objects of class Introduction.
     * 
     */
    public Introduction()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        prepare();
        getBackground().scale(600,500);
    }
    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        Label label = new Label("in this game you need to kill zombies", 40);
        addObject(label,270,84);
        label.setLocation(289,82);
        Label label2 = new Label("Try to get high score if you can", 40);
        addObject(label2,272,174);
        label2.setLocation(323,155);
        Label label3 = new Label("try your best do not killed by zimbies", 40);
        addObject(label3,267,233);
        label3.setLocation(285,224);
        Label label4 = new Label("use wasd and arrows to move", 40);
        addObject(label4,284,278);
        label4.setLocation(321,279);
        Label label5 = new Label("q and / to attack", 40);
        addObject(label5,288,313);
        label5.setLocation(310,323);
        label.setLocation(322,49);
        label2.setLocation(299,101);
        label3.setLocation(302,158);
        label4.setLocation(286,232);
        label5.setLocation(306,268);
        label4.setLocation(320,215);
        label5.setLocation(319,255);
        Label label6 = new Label("press 1 or 2 start the game", 40);
        addObject(label6,287,310);
        label6.setLocation(308,309);
    }
}
