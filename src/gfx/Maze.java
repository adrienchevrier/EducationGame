package gfx;

import java.awt.image.BufferedImage;

/**
 * Created by adrien on 12/05/16.
 * EducationGame project class
 */
public class Maze {

    public static BufferedImage maze;

    public static void init() {
        maze = ImageLoader.loadImage("/textures/maze.jpg");

    }
}
