import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Player here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Player extends Actor
{
    private String curWorld;
    public static int[] spawn = {200, 528}; // Default is for tutorial
    // Note: First life listed here is third life slot
    public static Lives[] lives = {new Lives(true), new Lives(true), new Lives(true)};
    public static int score = 0;
    
    // Movement variables
    private double GRAVITY = 0.1; // gravity speed
    private int MAX_VERT_VELOCITY = 20;
    private double jumpSpeed = 8.0; // jump speed
    private double tempJumpSpeed = 8.0; // jump speed - decel
    private double jumpDecel = 0.75;
    private double jumpDecelTimer = 0;
    private int JUMP_HEIGHT = 100;
    private double amountJumped;
    private double amountFallen = 0;
    private int maxHoriVelocity = 2;
    private int horiSpeed = 1; //possible to change to make player move faster, possible powerup
    private double tempHoriSpeed;
    private int x;
    private int y;
    private boolean wPressed;
    private boolean aPressed;
    private boolean dPressed;
    private boolean isFalling = false;
    private boolean isJumping = false;
    private char lastMoveState;
    
    /**
     * Act - do whatever the Player wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private void movementCollision()
    {
        //resets x,y changes 
        x= 0;
        y= 0;
        
        //detects which keys are pressed
        if(Greenfoot.isKeyDown("w") && !isFalling){
            wPressed = true;
        }
        if(Greenfoot.isKeyDown("a")){
            aPressed = true;
            changeFrameDir(1); // now facing left
        } else {
            aPressed = false;
        }
        if(Greenfoot.isKeyDown("d")){
            dPressed = true;
            changeFrameDir(0); // now facing right
        } else {
            dPressed = false;
        }
        if(wPressed){
            jump();
        }
        
        //calls leftRight method to move player left or right 
        if(aPressed == true || dPressed == true){
            leftRight(aPressed, dPressed);
        }else{
            //resets the velocity if neither 'A' or 'D' is pressed
            tempHoriSpeed = horiSpeed;
        }
        
        //pushes player out of ground incase they clip into the floor
        if (isTouching(ImpassableBoxFloor.class) && (isTouching(ImpassableBoxLeftSide.class) || isTouching(ImpassableBoxRightSide.class))){
            y-= 1;
        }
        
        //will make you fall if you are in the air and not jumping
        if (!(isTouching(ImpassableBoxFloor.class)) && isJumping == false && !(isTouching(ImpassableBoxLeftSide.class) || isTouching(ImpassableBoxRightSide.class)) && isFalling == false){
            amountFallen = 0;
            isFalling = true;
        }
        
        if (isFalling == true){
            fall();
        }
               
        move(x,y);
        
        //resets jump if touching the floor
        if (!isTouching(ImpassableBoxCeiling.class)){
            if (isTouching(ImpassableBoxFloor.class) && isFalling == true){
                isJumping = false;
                isFalling = false;
            }
        }
        
        //incase player is stuck inbetween a ceiling and floor, it will 
        //push the player out
        if (isTouching(ImpassableBoxCeiling.class) && isTouching(ImpassableBoxFloor.class)){
            y += 1;
        }
        
        //resets position of player and takes one life from the player
        if(isTouching(EmptyVoid.class)){
            y = 0; // Reset velocities
            x = 0;
            Sounds.playSound("Void.mp3");
            updateHP(false);
            setLocation(spawn[0], spawn[1] - 24); // Reset to spawn; -24 offset on y to prevent clipping
        }
        
        //makes you lose if you run out of lives
        if(!lives[lives.length-1].getFilled())
        {
            Lose gameWorld = new Lose();
            Greenfoot.setWorld(gameWorld);
        }
        
        //sends you to next world
        if(isTouching(NextLevel.class)){
            nextWorld(curWorld);
        }
    }
    
    private void leftRight(boolean aPressed, boolean dPressed){
        //slowly increases speed as you hold 'A' or 'D'
        if (tempHoriSpeed <= maxHoriVelocity){
            tempHoriSpeed += 0.1;
        }
        //if 'A' and 'D' are pressed at the same time, reset speed
        if (aPressed && dPressed){
            tempHoriSpeed = horiSpeed;
        } else {
            //if 'A' pressed, subtract from x value
            if(aPressed){
                if(isTouching(ImpassableBoxRightSide.class)){
                    
                } else {
                    x -= tempHoriSpeed;
                }
            }
            //if 'D' pressed, add to x value
            if(dPressed){
                if(isTouching(ImpassableBoxLeftSide.class)){
                    
                } else {
                    x += tempHoriSpeed;
                }
            }
        }
    }
}
