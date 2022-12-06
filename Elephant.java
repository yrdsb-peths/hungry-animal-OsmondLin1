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
    
    public Elephant(){
        sound = new GreenfootSound("sounds/elephantcub.mp3");
    }
    public void act()
    {
        if(Greenfoot.isKeyDown("d")){
            move(10);
        }
        if(Greenfoot.isKeyDown("a")){
            move(-10);
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
        
    }
            
    public void eat(){
        removeTouching(Apple.class);
        MyWorld world = (MyWorld) getWorld();
        world.increaseScore();
        world.spawnApple();
        sound.play();
    }// Add your action code here.
    
}
