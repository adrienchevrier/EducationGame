package states;


import entities.armies.Player;
import tiles.Tile;
import worlds.World;

import java.awt.*;

/**
 * Created by adrien on 10/05/16.
 * EducationGame project class
 */
public class GameState extends State {

    private Player player;
    private World world;

    //CONSTRUCTOR
    public GameState(handler.Handler handler){
        super(handler);
        player = new Player(handler, 100,100);
        //path to world information
        world = new World(handler,"res/myWorlds/world1.txt");
        handler.setWorld(world);
    }


    //calls required ticks
    @Override
    public void tick() {
        world.tick();
        player.tick();

    }

    //displays handler to the screen
    @Override
    public void render(Graphics g) {
        world.render(g);
        player.render(g);
        Tile.tiles[3].render(g,0,0);
    }

}
