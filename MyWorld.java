import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{
    public int score = 0;
    public Label scoreLabel;
    int level = 1;
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1000, 400, 1, false); 
        Elephant elephant = new Elephant();
        addObject(elephant, 200, 200);
        
        scoreLabel = new Label(score, 80);
        addObject(scoreLabel, 50, 50);
        
        spawnApple();
    }
    
    public void gameOver(){
        Label gameOverLabel = new Label("Game Over", 100);
        addObject(gameOverLabel, getWidth()/2, getHeight()/2);
    }
    public void increaseScore(){
        score++;
        scoreLabel.setValue(score);
        
        if(score % 5 == 0)
        {
            level +=1;
        }
    }
    
    public void spawnApple(){
        Apple apple = new Apple();
        apple.setSpeed(level);
        int x = Greenfoot.getRandomNumber(getWidth());
        int y = 10;
        addObject(apple, x , y);
    }
}
