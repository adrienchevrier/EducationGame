package gfx;

import java.awt.image.BufferedImage;

/**
 * Created by adrien on 04/05/16.
 * 2Dgame project class
 *
 * Class contains and extracts all images from an array
 */
public class Assets {
    private static final int width = 64,height = 64;

    public static BufferedImage door, entrance, grass, dirt,soldier, wall, genius;
    public static BufferedImage goal, character, right, left, down, up;

    //init images to be displayed
    public static void init(){
        SpriteSheet sheet;
        sheet = new SpriteSheet(ImageLoader.loadImage("/textures/table.png"));

        grass = sheet.crop(0,0,width,height);
        dirt = sheet.crop(width,0,width,height);
        wall = sheet.crop(2*width,0,width,height);
        door = sheet.crop(3*width,0,width,height);
        soldier = sheet.crop(0,height,width,height);
        entrance = sheet.crop(width,0,width,height);

        //Part B
        character = sheet.crop(width*4,height*4,width,height);
        goal = sheet.crop(width*3,height*4,width,height);
        right = sheet.crop(width*2,height*4,width,height);
        left = sheet.crop(0,height*3,width,height);
        down = sheet.crop(width*1,height*4,width,height);
        up = sheet.crop(0,height*4,width,height);


        genius = sheet.crop(width*2,0,width,height);


    }
}
