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

    public static BufferedImage door, entrance, grass, dirt,soldier, wall,genius;

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



        genius = sheet.crop(width*2,0,width,height);


    }
}
