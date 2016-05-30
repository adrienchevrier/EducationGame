package worlds;

import game.Game;
import tiles.Tile;
import utils.Utils;

import java.awt.*;
import java.util.ArrayList;
import java.util.logging.Handler;

/**
 * Created by adrien on 12/05/16.
 * EducationGame project class
 */
public class WorldB extends World{

    //VARIABLES
    private handler.Handler handler;
    private int width=11 , height=10;
    private int spawnX=0 , spawnY=0;

    //array of tiles
    private int[][] tiles = new int[width][height];

    //CONSTRUCTOR
    public WorldB(handler.Handler handler, String path){
    	super(handler, path);
        this.handler = handler;
        loadWorld(path);
        loadCommand("res/myWorlds/command1");
    }

	private int locationX = 1;
	private int locationY = 1;
	private int direction = 0;
	private ArrayList<Integer> commandStack = new ArrayList<Integer>();

    public void tick(){
    	if(commandStack.isEmpty()) {
	    	if(direction == 0) {
	    		action(locationX, locationY, ++locationX, locationY);
	    	} else if(direction == 1) {
	    		action(locationX, locationY, --locationX, locationY);
	    	} else if(direction == 2) {
	    		action(locationX, locationY, locationX, ++locationY);
	    	} else if(direction == 3) {
	    		action(locationX, locationY, locationX, --locationY);
	    	} else if(direction == -1) {
	    		System.out.println("Game Over!");
	    	} else if(direction == 4) {
	    		System.out.println("Win");
	    	}
    	} else {
    		if(handler.getMouseManager().isLeftPressed() && (handler.getMouseManager().getMouseX() < width*64) && (handler.getMouseManager().getMouseX() < height*64))
    			allocateCommand(handler.getMouseManager().getMouseX(), handler.getMouseManager().getMouseY());
    	}
    	try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

    }
    
    private void loadCommand(String path){
        String file = Utils.loadFileAsString(path);
        String[]tokens = file.split("\\s+");

        for (int i = 0; i < tokens.length; i++) {
        	commandStack.add(Utils.parseInt(tokens[i]));
        }
    }
    
    private void allocateCommand(int x, int y){
    	System.out.println(x/64+" "+y/64+" "+tiles[x/64][y/64]);
    	if(tiles[x/64][y/64] == 0) {
    		tiles[x/64][y/64] = commandStack.remove(0);
    	}
    }
    
    private void action(int x1, int y1, int x2, int y2) {
    	int tmp;
    	if(tiles[x2][y2] == 0) {
    		tmp = tiles[x1][y1];
    		tiles[x1][y1] = tiles[x2][y2];
    		tiles[x2][y2] = tmp;
    	} else if(tiles[x2][y2] == 6) {
    		tmp = tiles[x1][y1];
    		tiles[x1][y1] = 0;
    		tiles[x2][y2] = tmp;
    		direction = 0;
    	} else if(tiles[x2][y2] == 7) {
    		tmp = tiles[x1][y1];
    		tiles[x1][y1] = 0;
    		tiles[x2][y2] = tmp;
    		direction = 1;
    	} else if(tiles[x2][y2] == 8) {
    		tmp = tiles[x1][y1];
    		tiles[x1][y1] = 0;
    		tiles[x2][y2] = tmp;
    		direction = 2;
    	} else if(tiles[x2][y2] == 9) {
    		tmp = tiles[x1][y1];
    		tiles[x1][y1] = 0;
    		tiles[x2][y2] = tmp;
    		direction = 3;
    	} else if(tiles[x2][y2] == 2) {
    		direction = -1;
    	} else if(tiles[x2][y2] == 5) {
    		tiles[x1][y1] = 0;
    		direction = 4;
    	}
    }

    //displays each tile of the array
    public void render(Graphics g){
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                getTile(x,y).render(g,x*Tile.TILEWIDTH,y*Tile.TILEHEIGHT);
            }
        }
    }


    //return type of choose tile
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
    private void loadWorld(String path){
        String file = Utils.loadFileAsString(path);
        String[]tokens = file.split("\\s+");

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                tiles[x][y] = Utils.parseInt(tokens[(x+y*width)]);
            }
        }
    }
}