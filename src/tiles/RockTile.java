package tiles;

import gfx.Assets;

import java.awt.image.BufferedImage;

/**
 * Created by adrien on 12/05/16.
 * EducationGame project class
 */
public class RockTile extends Tile {
    public RockTile(int id) {
        super(Assets.wall, id);
    }

    @Override
    public boolean isSolid(){
        return true;
    }
}
