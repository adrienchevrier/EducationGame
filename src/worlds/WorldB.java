package worlds;

import tiles.Tile;
import utils.Utils;

import java.awt.*;

import entities.gameB.CommandStack;

/**
 * Created by adrien on 12/05/16.
 * EducationGame project class
 */
public class WorldB extends World {


    private CommandStack commandStack = new CommandStack();


    //CONSTRUCTOR
    public WorldB(handler.Handler handler, String path){

        this.handler = handler;
        super.loadWorld(path);
    }

	private int locationX = 1;
	private int locationY = 1;
	private int direction = 0;

	@Override
    public void tick(){
    	if(commandStack.getCommandStack().isEmpty()) {
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

	    	try {
				Thread.sleep(300);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
    	} else {
    		if(handler.getMouseManager().isLeftPressed() && (handler.getMouseManager().getMouseX() < width*64) && (handler.getMouseManager().getMouseX() < height*64)) {
    			commandStack.allocateCommand(handler.getMouseManager().getMouseX(), handler.getMouseManager().getMouseY(), tiles);
    		}
    		if(handler.getMouseManager().isLeftPressed() && (704 < handler.getMouseManager().getMouseX() && handler.getMouseManager().getMouseX() < 768) && (576 < handler.getMouseManager().getMouseY() && handler.getMouseManager().getMouseY() < 650))
    			commandStack.addStart();
    		if(handler.getMouseManager().isLeftPressed() && (704 < handler.getMouseManager().getMouseX() && handler.getMouseManager().getMouseX() < 768) && (0 < handler.getMouseManager().getMouseY() && handler.getMouseManager().getMouseY() < 64))
    			commandStack.subStart();
    	}
    	try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
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
	@Override
    public void render(Graphics g){
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                getTile(x,y).render(g,x*Tile.TILEWIDTH,y*Tile.TILEHEIGHT);
            }
        }
    	commandStack.render(g);
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


}