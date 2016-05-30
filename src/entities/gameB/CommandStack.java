package entities.gameB;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import gfx.Assets;
import gfx.ImageLoader;
import gfx.SpriteSheet;
import utils.Utils;

public class CommandStack {
	private ArrayList<Integer> stack = new ArrayList<Integer>();
	private BufferedImage stackImg = new SpriteSheet(ImageLoader.loadImage("/textures/table.png")).crop(64,192,64,64);
	private int start = 0;
	
	public CommandStack() {
		loadCommand("res/myWorlds/command1");
	}
    
    public void loadCommand(String path){
        String file = Utils.loadFileAsString(path);
        String[]tokens = file.split("\\s+");

        for (int i = 0; i < tokens.length; i++) {
        	stack.add(Utils.parseInt(tokens[i]));
        }
    }
    
    public void allocateCommand(int x, int y, int[][] tiles){
    	System.out.println(x/64+" "+y/64+" "+tiles[x/64][y/64]);
    	if(tiles[x/64][y/64] == 0) {
    		tiles[x/64][y/64] = stack.remove(0);
    	}
    }
    
    public ArrayList<Integer> getCommandStack() {
    	return stack;
    }
    
    public int getStart() {
    	return start;
    }

    public void addStart() {
    	start++;
    }
    public void subStart() {
    	start--;
    }
    
    public void render(Graphics g){
    	BufferedImage img;
		g.drawImage(stackImg, 704, 0, 100, 640, null);
		if(start > 0) {
			g.drawImage(Assets.dirt, 704, 576, null);
		}
		for(int i=start;i<start+4;i++) {
			if(i < stack.size()) {
				if(stack.get(i) == 6) {
					img = Assets.right;
				} else if(stack.get(i) == 7) {
					img = Assets.left;
				} else if(stack.get(i) == 8) {
					img = Assets.down;
				} else if(stack.get(i) == 9) {
					img = Assets.up;
				} else {
					img = Assets.grass;
				}
				g.drawImage(img, 704, 100+i*100, null);
			} else {
				break;
			}
		}
		if(stack.size() > 4) {
			g.drawImage(Assets.dirt, 704, 576, null);
		}
    }
}
