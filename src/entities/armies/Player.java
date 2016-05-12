package entities.armies;

import game.Game;
import gfx.Assets;

import java.awt.*;

/**
 * Created by adrien on 12/05/16.
 * EducationGame project class
 */
public class Player extends Army {
    private Game game;

    public Player(Game game, float x, float y) {
        super(x, y);
        this.game = game;
    }

    @Override
    public void tick() {

            //if(game.getKeyManager().up !=null)
        if (game.getKeyManager().up) y -= 3;
        if (game.getKeyManager().down) y += 3;
        if (game.getKeyManager().left) x -= 3;
        if (game.getKeyManager().right) x += 3;



    }

    @Override
    public void render(Graphics g) {
        g.drawImage(Assets.soldier,(int)x,(int)y,null);
    }
}
