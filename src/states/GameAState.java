package states;



import tiles.Tile;
import worlds.WorldA;

import java.awt.*;

/**
 * Created by adrien on 10/05/16.
 * EducationGame project class
 */
public class GameAState extends State {

    
    private WorldA worldA;
 

    //CONSTRUCTOR
    public GameAState(handler.Handler handler){
        super(handler);
        
        //path to worldA information
        worldA = new WorldA(handler,"res/myWorlds/world1.txt");
        handler.setWorld(worldA);
       
        
    }


    //calls required ticks
    @Override
    public void tick() {
        worldA.tick();
    }

    //displays handler to the screen
    @Override
    public void render(Graphics g) {
        worldA.render(g);
        
        
        Tile.tiles[3].render(g,0,0);
    }

}
