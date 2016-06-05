package states;



import worlds.WorldB;

import java.awt.*;

public class GameBState extends State {

    
    private WorldB worldB;
 

    //CONSTRUCTOR
    public GameBState(handler.Handler handler, int level){
        super(handler);
        
        //path to world information
        worldB = new WorldB(handler,level);
        handler.setWorld(worldB);
       
        
    }


    //calls required ticks
    @Override
    public void tick() {
        worldB.tick();       
    }

    //displays handler to the screen
    @Override
    public void render(Graphics g) {
        worldB.render(g);
    }

}