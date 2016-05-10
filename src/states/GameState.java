package states;


import gfx.Assets;

import java.awt.*;

/**
 * Created by adrien on 10/05/16.
 * EducationGame project class
 */
public class GameState extends State {

    public GameState(){

    }


    @Override
    public void tick() {

    }

    @Override
    public void render(Graphics g) {
        g.drawImage(Assets.genius,0,0,null);
    }
}
