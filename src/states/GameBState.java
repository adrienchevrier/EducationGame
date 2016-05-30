package states;



import tiles.Tile;
import worlds.World;
import worlds.WorldB;

import java.awt.*;

public class GameBState extends State {

    
    private WorldB worldB;
 

    //CONSTRUCTOR
    public GameBState(handler.Handler handler){
        super(handler);
        
        //path to world information
        worldB = new WorldB(handler,"res/myWorlds/worldB.txt");
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