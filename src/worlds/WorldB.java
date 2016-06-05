package worlds;

import tiles.*;
import utils.Utils;

import java.awt.*;

import entities.gameB.CommandStack;
import gfx.Assets;

/**
 * Created by adrien on 12/05/16.
 * EducationGame project class
 */
public class WorldB extends World {

    protected Tile[][] tiles2 = new Tile[width][height];

    private CommandStack commandStack = new CommandStack();


    //CONSTRUCTOR
    public WorldB(handler.Handler handler, String path){

        this.handler = handler;
        loadWorld(path);
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
	    	}

	    	try {
				Thread.sleep(300);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
    	} else {
    		if(handler.getMouseManager().isLeftPressed() && (handler.getMouseManager().getMouseX() < width*64) && (handler.getMouseManager().getMouseX() < height*64)) {
    			commandStack.allocateCommand(handler.getMouseManager().getMouseX(), handler.getMouseManager().getMouseY(), tiles2);
    		}
    		else if(handler.getMouseManager().isLeftPressed() && (704 < handler.getMouseManager().getMouseX() && handler.getMouseManager().getMouseX() < 768) && (576 < handler.getMouseManager().getMouseY() && handler.getMouseManager().getMouseY() < 650))
    			commandStack.addStart();
    		else if(handler.getMouseManager().isLeftPressed() && (704 < handler.getMouseManager().getMouseX() && handler.getMouseManager().getMouseX() < 768) && (0 < handler.getMouseManager().getMouseY() && handler.getMouseManager().getMouseY() < 64))
    			commandStack.subStart();
    	}
    	try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

    }
    
    private void action(int x1, int y1, int x2, int y2) {
    	Tile tmp;
    	if(tiles2[x2][y2].getClass() == GrassTile.class) {
    		tmp = tiles2[x1][y1];
    		tiles2[x1][y1] = tiles2[x2][y2];
    		tiles2[x2][y2] = tmp;
    	} else if(tiles2[x2][y2].getClass() == RightTile.class) {
    		tmp = tiles2[x1][y1];
    		tiles2[x1][y1] = Tile.tiles[0];
    		tiles2[x2][y2] = tmp;
    		direction = 0;
    	} else if(tiles2[x2][y2].getClass() == LeftTile.class) {
    		tmp = tiles2[x1][y1];
    		tiles2[x1][y1] = Tile.tiles[0];
    		tiles2[x2][y2] = tmp;
    		direction = 1;
    	} else if(tiles2[x2][y2].getClass() == DownTile.class) {
    		tmp = tiles2[x1][y1];
    		tiles2[x1][y1] = Tile.tiles[0];
    		tiles2[x2][y2] = tmp;
    		direction = 2;
    	} else if(tiles2[x2][y2].getClass() == UpTile.class) {
    		tmp = tiles2[x1][y1];
    		tiles2[x1][y1] = Tile.tiles[0];
    		tiles2[x2][y2] = tmp;
    		direction = 3;
    	} else if(tiles2[x2][y2].getClass() == RockTile.class) {
    		direction = -1;
    	} else if(tiles2[x2][y2].getClass() == Goal.class) {
    		tiles2[x1][y1] = GrassTile.dirtTile;
    		direction = 4;
    	}
    }

    //displays each tile of the array
	@Override
    public void render(Graphics g){
    	if(direction == -1) {
    		g.drawImage(Assets.gameOverBackground, 0, 0, null);
    	} else {
	        for (int y = 0; y < height; y++) {
	            for (int x = 0; x < width; x++) {
	            	tiles2[x][y].render(g,x*Tile.TILEWIDTH,y*Tile.TILEHEIGHT);
	            }
	        }
	    	commandStack.render(g);
    	}
    }
    
    @Override
    //method puts values into tiles array
    protected void loadWorld(String path){
        String file = Utils.loadFileAsString(path);
        String[]tokens = file.split("\\s+");

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                tiles2[x][y] = Tile.tiles[Utils.parseInt(tokens[(x+y*width)])];
            }
        }
    }


}