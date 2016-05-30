package states;



import tiles.Tile;
import worlds.World;

import java.awt.*;

/**
 * Created by adrien on 10/05/16.
 * EducationGame project class
 */
public abstract class GameState extends State {

    
    private World world;
 

    //CONSTRUCTOR
    public GameState(handler.Handler handler){
        super(handler);
        
        //path to world information
        world = new World(handler,"res/myWorlds/world1.txt");
        handler.setWorld(world);
       
        
    }


    //calls required ticks
    @Override
    public void tick() {
        world.tick();       
    }

    //displays handler to the screen
    @Override
    public void render(Graphics g) {
        world.render(g);
        
        
        Tile.tiles[3].render(g,0,0);
    }

}
