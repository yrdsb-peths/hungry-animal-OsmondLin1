import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class TitleScreen here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TitleScreen extends World
{

    /**
     * Constructor for objects of class TitleScreen.
     * 
     */
    public TitleScreen()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1);
        Label titleLabel = new Label("Hungry Elephant", 80);

        addObject(titleLabel, getWidth()/2, getHeight()/2);
        Label spaceLabel = new Label("Press SPACE to Start", 30);

        addObject(spaceLabel, getWidth()/2, 350);

        prepare();
    }

    public void act(){
        if(Greenfoot.isKeyDown("space")){
            MyWorld world = new MyWorld();
            Greenfoot.setWorld(world);
        }
    }
    
    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        Elephant elephant = new Elephant();
        addObject(elephant,520,77);
        Label label = new Label("Use 'd' to move right and 'a' for left", 50);
        addObject(label,436,312);
        label.setLocation(281,295);
        removeObject(label);
        Label labela = new Label("Press d for right and a for left", 30);
        addObject(labela,300,288);
        
    }
}
