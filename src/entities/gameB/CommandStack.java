package entities.gameB;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import gfx.Assets;
import gfx.ImageLoader;
import gfx.SpriteSheet;
import tiles.GrassTile;
import tiles.Tile;
import utils.Utils;


public class CommandStack {
	private static final int STACKCNT = 5;
	private ArrayList<Integer> stack = new ArrayList<Integer>();
	private BufferedImage stackImg = new SpriteSheet(ImageLoader.loadImage("/textures/container.png")).crop(0,0,100,640);
	private int start = 0;
	
	public CommandStack(int level) {
		loadCommand(level);
	}
    
    public void loadCommand(int level){
    	String path = "";
    	if(level == 1) {
    		path = "res/myWorlds/command1";
    	} else if(level == 2) {
    		path = "res/myWorlds/command2";
    	} else if(level == 3) {
    		path = "res/myWorlds/command3";
    	} else {
    		path = "res/myWorlds/command4";
    	}
        String file = Utils.loadFileAsString(path);
        String[]tokens = file.split("\\s+");

        for (int i = 0; i < tokens.length; i++) {
        	stack.add(Utils.parseInt(tokens[i]));
        }
    }
    
    public void allocateCommand(int x, int y, Tile[][] tiles){
    	if(tiles[x/64][y/64].getClass() == GrassTile.class) {
    		subStart();
    		tiles[x/64][y/64] = Tile.tiles[stack.remove(0)];
    	}
    }
    
    public ArrayList<Integer> getCommandStack() {
    	return stack;
    }
    
    public int getStart() {
    	return start;
    }

    public void addStart() {
    	if(stack.size()-start > STACKCNT) {
    		start++;
    	}
    }
    public void subStart() {
		if(start > 0) {
			start--;
		}
    }
    
    public void render(Graphics g){
    	BufferedImage img;
		g.drawImage(stackImg, 704, 0, 100, 640, null);
		if(start > 0) {
			g.drawImage(Assets.upp, 721, 0, null);
		}
		for(int i=start;i<start+STACKCNT;i++) {
			if(i < stack.size()) {
				if(stack.get(i) == 6) {
					img = Assets.right;
				} else if(stack.get(i) == 7) {
					img = Assets.left;
				} else if(stack.get(i) == 8) {
					img = Assets.down;
				} else if(stack.get(i) == 9) {
					img = Assets.up;
				} else if(stack.get(i) == 10) {
					img = Assets.warp;
				} else {
					img = Assets.grass;
				}
				g.drawImage(img, 721, 100+(i-start)*100, null);
			} else {
				break;
			}
		}
		if(stack.size()-start > STACKCNT) {
			g.drawImage(Assets.downn, 721, 576, null);
		}
    }
}
