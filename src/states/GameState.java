package states;


import entities.armies.Player;
import game.Game;
import gfx.Assets;
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

    public GameState(Game game){
        super(game);
        player = new Player(game, 100,100);
        world = new World("res/worlds/world1.txt");
    }


    @Override
    public void tick() {
        world.tick();
        player.tick();

    }

    @Override
    public void render(Graphics g) {
        world.render(g);
        player.render(g);
        Tile.tiles[3].render(g,0,0);
    }

}
