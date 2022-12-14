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
    public int lives = 5;
    public Label scoreLabel;
    public Label cupPong;
    int level = 1;
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(700, 400, 1, false); 
        Elephant elephant = new Elephant();
        addObject(elephant, 200, 200);
        
        
        //Create score label to display the score
        scoreLabel = new Label("Score:" + score, 65);
        addObject(scoreLabel, 130, 50);
        
        cupPong = new Label("Lives:" + lives, 50);
        addObject(cupPong, 570, 50);
        spawnApple();
    }
    
    public void gameOver(){
        Label gameOverLabel = new Label("Game Over", 100);
        addObject(gameOverLabel, getWidth()/2, getHeight()/2);
    }
    public void increaseScore(){
        score++;
        scoreLabel.setValue("Score:" + score);
        
        if(score % 5 == 0)
        {
            level +=1;
        }
    }
    
    public void decreaseLives(){
        lives--;
        cupPong.setValue("Lives:" + lives);
    }
    
    public void spawnApple(){
        Apple apple = new Apple();
        apple.setSpeed(level);
        int x = Greenfoot.getRandomNumber(getWidth());
        int y = 10;
        addObject(apple, x , y);
    }
}
