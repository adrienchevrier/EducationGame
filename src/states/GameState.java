package states;


import entities.armies.Player;
import game.Game;
import gfx.Assets;

import java.awt.*;

/**
 * Created by adrien on 10/05/16.
 * EducationGame project class
 */
public class GameState extends State {

    private Player player;

    public GameState(Game game){
        super(game);
        player = new Player(game, 100,100);

    }


    @Override
    public void tick() {
        player.tick();

    }

    @Override
    public void render(Graphics g) {
        player.render(g);
    }

}
