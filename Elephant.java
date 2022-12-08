import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Elephant here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Elephant extends Actor
{
    /**
     * Act - do whatever the Elephant wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    GreenfootSound sound;
    SimpleTimer animTimer = new SimpleTimer();
    GreenfootImage [] images = new GreenfootImage[8];
    GreenfootImage [] imagesleft = new GreenfootImage[8];
    
    String facing = "right";
    
    public Elephant(){
        sound = new GreenfootSound("sounds/elephantcub.mp3");
        
        for(int i = 0; i < images.length; i++){
            images[i] = new GreenfootImage("images/elephant_idle/idle" + i + ".png");
            images[i].scale(100, 100);
        } 
        
        for(int i = 0; i < imagesleft.length; i++){
            imagesleft[i] = new GreenfootImage("images/elephant_idle/idle" + i + ".png");
            imagesleft[i].mirrorHorizontally();
            imagesleft[i].scale(100, 100);
        }
        
        
        setImage(images[0]);
        animTimer.mark();
        
        
    }
    public void act()
    {
        if(Greenfoot.isKeyDown("d")){
            move(10);
            facing = "right";
        }
        if(Greenfoot.isKeyDown("a")){
            move(-10);
            facing = "left";
        }
        if(Greenfoot.isKeyDown("w")){
            setLocation(getX(), getY() - 10);
        }
        if(Greenfoot.isKeyDown("s")){
            setLocation(getX(), getY() + 10);
        }
        if(isTouching(Apple.class))
        {
            eat();
        }
        animate();
        
    }
    
    int i = 0;
    public void animate(){
        
        if(animTimer.millisElapsed() > 100){
            if(facing.equals("right")){
                setImage(images[i]);
                i = (i + 1) % images.length;
            }
            else
            {
                setImage(imagesleft[i]);
                i = (i + 1) % imagesleft.length;
            }
            animTimer.mark();
        }
        
        
    }
            
    public void eat(){
        removeTouching(Apple.class);
        MyWorld world = (MyWorld) getWorld();
        world.increaseScore();
        world.spawnApple();
        sound.play();
    }// Add your action code here.
    
}
