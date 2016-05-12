package states;

import gfx.Maze;

import java.awt.*;

/**
 * Created by adrien on 10/05/16.
 * EducationGame project class
 */
public class A1State extends GameState{


    public A1State() {
    }

    @Override
    public void tick() {

    }

    @Override
    public void render(Graphics g) {
        g.drawImage(Maze.maze,50,50,null);


    }
}
