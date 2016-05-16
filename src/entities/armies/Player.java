package entities.armies;

import game.Game;
import gfx.Assets;

import java.awt.*;

/**
 * Created by adrien on 12/05/16.
 * EducationGame project class
 */
public class Player extends Army {


    //CONSTRUCTOR
    public Player(Game game, float x, float y) {
        super(game,x, y, Army.DEFAULT_CREATURE_WIDTH,Army.DEFAULT_CREATURE_HEIGHT);
    }


    //each tick takes input and moves
    @Override
    public void tick() {

        getInput();
        move();



    }

    //method sets shifting of player according to input
    private void getInput(){
        xMove = 0;
        yMove = 0;

        if(game.getKeyManager().up)yMove = -speed;
        if(game.getKeyManager().down)yMove = speed;
        if(game.getKeyManager().left)xMove = -speed;
        if(game.getKeyManager().right)xMove = speed;
    }

    //displays the player
    @Override
    public void render(Graphics g) {
        g.drawImage(Assets.soldier,(int)x,(int)y,width,height, null);
    }
}
