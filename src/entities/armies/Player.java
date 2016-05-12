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
        super(x, y, Army.DEFAULT_CREATURE_WIDTH,Army.DEFAULT_CREATURE_HEIGHT);
        this.game = game;
    }

    @Override
    public void tick() {

        getInput();
        move();



    }

    private void getInput(){
        xMove = 0;
        yMove = 0;

        if(game.getKeyManager().up)yMove = -speed;
        if(game.getKeyManager().down)yMove = speed;
        if(game.getKeyManager().left)xMove = -speed;
        if(game.getKeyManager().right)xMove = speed;
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(Assets.soldier,(int)x,(int)y,width,height, null);
    }
}
