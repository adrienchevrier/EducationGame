package states;

import gfx.Maze;
import handler.Handler;

import java.awt.*;

/**
 * Created by adrien on 10/05/16.
 * EducationGame project class
 */
public class A1State extends GameState{


    public A1State(Handler handler) {
        super(handler);
    }

    @Override
    public void tick() {

    }


    //we just display a maze
    @Override
    public void render(Graphics g) {
        g.drawImage(Maze.maze,0,0,null);


    }
}
