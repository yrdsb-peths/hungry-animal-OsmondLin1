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
        
        int bottomY = getWorld().getHeight();
        if(getY() > bottomY) {
            MyWorld world = (MyWorld) getWorld();
            world.gameOver();
            world.removeObject(this);
        }// Add your action code here.
    }
    
    public void setSpeed(int spd){
        speed = spd;
    }
}

