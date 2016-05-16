package worlds;

import tiles.Tile;
import utils.Utils;

import java.awt.*;

/**
 * Created by adrien on 12/05/16.
 * EducationGame project class
 */
public class World {

    //VARIABLES
    private int width = 5, height = 5;
    private int spawnX = 0, spawnY = 0;

    //array of tiles
    private int[][] tiles = new int[width][height];

    //CONSTRUCTOR
    public World(String path){
        loadWorld(path);

    }

    public void tick(){

    }

    //displays each tile of the array
    public void render(Graphics g){
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                    getTile(x,y).render(g,x+Tile.TIEHEIGHT,y*Tile.TIEHEIGHT);
            }
        }

    }


    //return type of choosen tile
    public Tile getTile(int x, int y){
        Tile t = Tile.tiles[tiles[x][y]];
        //if no tile, returns dirt tile
        if (t == null)
            return Tile.dirtTile;
        return t;
    }

    //method puts values into tiles array
    private void loadWorld(String path){
        //String file = Utils.loadFileAsString(path);
        //String[]tokens = file.split("\\s+");
        //width = Utils.parseInt(tokens[0]);
        //height = Utils.parseInt(tokens[1]);
        //spawnX = Utils.parseInt(tokens[2]);
        //spawnY = Utils.parseInt(tokens[3]);

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                //tiles[x][y] = Utils.parseInt(tokens[(x+y*width)+4]);
                tiles[x][y] = 0;
            }
        }
        for (int i = 0; i < height; i++) {
            tiles [4][4] = 2;
        }
        tiles[3][4] = 3;
        tiles[1][4] = 1;
        tiles[2][2] = 2;
        }
    }
