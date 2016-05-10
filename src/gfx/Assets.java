package gfx;

import java.awt.image.BufferedImage;

/**
 * Created by adrien on 04/05/16.
 * 2Dgame project class
 * Class contains and extracts all images from an array
 */
public class Assets {
    private static final int width = 100,height = 80;

    public static BufferedImage door, entrance, grass, grey,soldier,way,genius;
    public static void init(){
        SpriteSheet sheet;
        sheet = new SpriteSheet(ImageLoader.loadImage("/textures/table.png"));

        door = sheet.crop(0,0,width,height);
        entrance = sheet.crop(width,0,width,height);
        grass = sheet.crop(2*width,0,width,height);
        soldier = sheet.crop(0,height,width,height);
        way = sheet.crop(width,height,width,height);
        genius = sheet.crop(width*2,height,width,height);

    }
}
