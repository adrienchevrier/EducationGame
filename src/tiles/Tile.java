package tiles;

import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Created by adrien on 12/05/16.
 * EducationGame project class
 */
public class Tile {

    //STATIC TOOLS
    public static Tile[] tiles = new Tile[256];
    public static Tile grassTile = new GrassTile(0);
    public static Tile dirtTile = new DirtTile(1);
    public static Tile RockTile = new RockTile(2);
    public static Tile DoorTile = new DoorTile(3);

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
