package map;

import gfx.*;

import java.awt.image.BufferedImage;

/**
 * Created by adrien on 10/05/16.
 * EducationGame project class
 */
public class Map {


    public static void init() {
        SpriteSheet map;
        map = new SpriteSheet(ImageLoader.loadImage("/textures/maze.jpg"));
    }

    public void print(){

    }
}
