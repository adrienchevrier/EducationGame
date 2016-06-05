package tiles;

import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Created by adrien on 12/05/16.
 * EducationGame project class
 */
public abstract class Tile {

    //STATIC TOOLS
    public static Tile[] tiles = new Tile[256];
    public static Tile grassTile = new GrassTile(0);
    public static Tile dirtTile = new DirtTile(1);
    public static Tile RockTile = new RockTile(2);
    public static Tile DoorTile = new DoorTile(3);
    
    public static Tile characterTile = new Character(4);
    public static Tile goalTile = new Goal(5);
    public static Tile rightTile = new RightTile(6);
    public static Tile leftTile = new LeftTile(7);
    public static Tile downTile = new DownTile(8);
    public static Tile upTile = new UpTile(9);
    public static Tile warpTile = new Warp(10);

    //CLASS

    public static final int TILEWIDTH = 64, TILEHEIGHT = 64;

    protected BufferedImage texture;
    protected final int id;

    public Tile(BufferedImage texture,int id) {
        this.id = id;
        this.texture = texture;

        tiles[id] = this;
    }

    public void tick(){

    }

    public void render(Graphics g,int x, int y){
        g.drawImage(texture,x,y,TILEWIDTH, TILEWIDTH, null);
    }

    public boolean isSolid(){
        return false;
    }

    public int getId() {
        return id;
    }
}
