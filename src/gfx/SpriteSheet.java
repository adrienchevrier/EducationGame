package gfx;

import java.awt.image.BufferedImage;

/**
 * Created by adrien on 04/05/16.
 * 2Dgame project class
 *
 * Class to draw a part of a bigger image
 */
public class SpriteSheet {
    private BufferedImage sheet;

    //Constructor
    public SpriteSheet(BufferedImage sheet) {
        this.sheet = sheet;
    }

    //returns the image found with input informations
    public BufferedImage crop(int x, int y, int width, int height ){
        return sheet.getSubimage(x,y,width,height);
    }
}
