package entities.armies;

import entities.dynamics.Army;
import gfx.Assets;
import handler.Handler;

import java.awt.*;

/**
 * Created by adrien on 18/05/16.
 * EducationGame project class
 */
public class Enemy extends Army {
    public Enemy(Handler handler, float x, float y) {
        super(handler, x, y, Army.DEFAULT_CREATURE_WIDTH,Army.DEFAULT_CREATURE_HEIGHT);
        bounds.x = width/4;
        bounds.y = height/2;
        bounds.width = width/2;
        bounds.height = height/2;
    }

    @Override
    public void tick() {

    }

    @Override
    public void render(Graphics g) {
        g.drawImage(Assets.character,(int)x,(int)y,width,height, null);
    }

    @Override
    public void die() {

    }
}
