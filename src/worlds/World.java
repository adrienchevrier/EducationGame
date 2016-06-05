package worlds;

import tiles.Tile;
import utils.Utils;
import java.awt.*;

/**
 * Created by adrien on 30/05/16.
 * EducationGame project class
 */
public abstract class World {


    //VARIABLES
    protected handler.Handler handler;
    protected int width=11 , height=10;
    protected int spawnX=60 , spawnY=60;

    //array of tiles
    protected int[][] tiles = new int[width][height];

    public abstract void tick();
    public abstract void render(Graphics g);

    public Tile getTile(int x, int y){
        if (x<0 || y<0 || x>= width || y>= height)
            return Tile.grassTile;

        Tile t = Tile.tiles[tiles[x][y]];
        //if no tile, returns dirt tile
        if (t == null)
            return Tile.dirtTile;
        return t;
    }

    //method puts values into tiles array
    protected void loadWorld(String path){
        String file = Utils.loadFileAsString(path);
        String[]tokens = file.split("\\s+");

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                tiles[x][y] = Utils.parseInt(tokens[(x+y*width)]);
            }
        }
    }
}
