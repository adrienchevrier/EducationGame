package worlds;

import tiles.Tile;

import java.awt.*;

/**
 * Created by adrien on 12/05/16.
 * EducationGame project class
 */
public class World {

    private int width, height;
    private int[][] tiles;

    public World(String path){
        loadWorld(path);

    }

    public void tick(){

    }

    public void render(Graphics g){
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                    getTile(x,y).render(g,x+Tile.TIEHEIGHT,y*Tile.TIEHEIGHT);
            }
        }

    }


    public Tile getTile(int x, int y){
        Tile t = Tile.tiles[tiles[x][y]];
        if (t == null)
            return Tile.dirtTile;
        return t;
    }

    private void loadWorld(String path){
        width = 5;
        height = 5;
        tiles = new int[width][height];

        for (int x = 0;x<width; x++){
            for (int y = 0; y < height; y++) {
                tiles[x][y]=2;
            }
        }
    }
}
