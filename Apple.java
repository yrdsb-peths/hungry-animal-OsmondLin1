import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)


public class Apple extends Actor
{
    /**
     * Act - do whatever the Apple wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    int speed = 1;
    
    public void act()
    {
        int x = getX();
        int y = getY() + speed;
        setLocation(x, y);
        MyWorld world = (MyWorld) getWorld();
        int bottomY = getWorld().getHeight();
        if(getY() > bottomY) {
            if(world.lives > 0)
            {
                world.removeObject(this);
                world.decreaseLives();
                world.spawnApple();
            }
            else
            {
                world.removeObject(this);
                world.gameOver();
            }
                
            
            
            
        }// Add your action code here.
    }
    
    public void setSpeed(int spd){
        speed = spd;
    }
}

