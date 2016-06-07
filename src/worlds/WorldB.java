package worlds;

import tiles.*;
import tiles.Character;
import utils.Utils;

import java.awt.*;

import entities.gameB.CommandStack;
import gfx.Assets;
import states.*;

/**
 * Created by adrien on 12/05/16.
 * EducationGame project class
 */
public class WorldB extends World {

    protected Tile[][] tiles = new Tile[width][height];

    private CommandStack commandStack;
	public static int locationX;
	public static int locationY;
	public static int direction = 0;
	private int level;


    //CONSTRUCTOR
    public WorldB(handler.Handler handler, int level){
    	this.level = level;
    	commandStack = new CommandStack(level);
    	direction = 0;
        this.handler = handler;
        if(this.level == 1) {
            loadWorld("res/myWorlds/worldB1.txt");
        } else if(this.level == 2) {
            loadWorld("res/myWorlds/worldB2.txt");
        } else if(this.level == 3) {
            loadWorld("res/myWorlds/worldB3.txt");
        } else {
            loadWorld("res/myWorlds/worldB1.txt");
        }
    }

	@Override
    public void tick(){
		if(level == 4) CurrentState.setState(handler.getGame().gameState = new GameCState(handler));
    	if(commandStack.getCommandStack().isEmpty()) {
    		try {
    			switch(Character.swap(tiles, handler)) {
    			case -1: CurrentState.setState(handler.getGame().gameState = new GameOver(handler, new GameBState(handler, 1))); break;
    			case 1: CurrentState.setState(handler.getGame().gameState = new GameBState(handler, ++level)); break;
    			}
    		} catch(ClassCastException e) {
    			System.out.println("Not character");
    		}
    	} else {
    		if(handler.getMouseManager().isLeftPressed() && (handler.getMouseManager().getMouseX() < width*64) && (handler.getMouseManager().getMouseX() < height*64)) {
    			commandStack.allocateCommand(handler.getMouseManager().getMouseX(), handler.getMouseManager().getMouseY(), tiles);
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

    //displays each tile of the array
	@Override
    public void render(Graphics g){
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
            	tiles[x][y].render(g,x*Tile.TILEWIDTH,y*Tile.TILEHEIGHT);
            }
        }
    	commandStack.render(g);
    }
    
    @Override
    //method puts values into tiles array
    protected void loadWorld(String path){
        String file = Utils.loadFileAsString(path);
        String[]tokens = file.split("\\s+");

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                tiles[x][y] = Tile.tiles[Utils.parseInt(tokens[(x+y*width)])];
                if(tiles[x][y].getClass() == Character.class) {
                	locationX = Integer.valueOf(x);
                	locationY = Integer.valueOf(y);
                }
            }
        }
    }


}