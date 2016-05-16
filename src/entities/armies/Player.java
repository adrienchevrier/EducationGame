package entities.armies;

import game.Game;
import gfx.Assets;
import handler.Handler;

import java.awt.*;

/**
 * Created by adrien on 12/05/16.
 * EducationGame project class
 */
public class Player extends Army {


    //CONSTRUCTOR
    public Player(Handler handler, float x, float y) {
        super(handler,x, y, Army.DEFAULT_CREATURE_WIDTH,Army.DEFAULT_CREATURE_HEIGHT);
        bounds.x = width/4;
        bounds.y = height/2;
        bounds.width = width/2;
        bounds.height = height/2;
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

        if(handler.getKeymanager().up)yMove = -speed;
        if(handler.getKeymanager().down)yMove = speed;
        if(handler.getKeymanager().left)xMove = -speed;
        if(handler.getKeymanager().right)xMove = speed;
    }

    //displays the player
    @Override
    public void render(Graphics g) {
        g.drawImage(Assets.soldier,(int)x,(int)y,width,height, null);

        g.setColor(Color.red);
        g.fillRect((int)(x+bounds.x),(int)y+bounds.y,bounds.width,bounds.height);
    }
}
