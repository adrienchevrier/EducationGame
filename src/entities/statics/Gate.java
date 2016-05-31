package entities.statics;

import java.awt.Color;
import java.awt.Graphics;

import gfx.Assets;
import handler.Handler;
import states.CurrentState;
import states.GameState;
import states.MenuState;
import tiles.Tile;

public class Gate extends StaticEntity{

	private int min;
	private int max;
	public static int currentLevel=1;
	public static final int maxLevel=2;

	public Gate(Handler handler, float x, float y, int min, int max) {
		super(handler, x, y, Tile.TILEWIDTH, Tile.TILEHEIGHT);
        bounds.x = 0;
        bounds.y = 0;
        bounds.width = width;
        bounds.height = height;
        this.min=min;
        this.max=max;
        this.health=100;
        
		
	}
	
	public void checkCondition(int health){
		if (health<=this.max && health>=this.min){
			System.out.println("You Won!");
			
			currentLevel+=1;
			if(currentLevel>maxLevel){
				System.out.println("Game completed! Good Job");
				CurrentState.setState(handler.getGame().menuState = new MenuState(handler));
			}
			
			CurrentState.setState(handler.getGame().gameState = new GameState(handler, currentLevel));
		}else{
			System.out.println("You Lost~");
			currentLevel=0;
			CurrentState.setState(handler.getGame().menuState = new MenuState(handler));
			
		}
	}
	
	@Override
	public void tick() {
		
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(Assets.door, (int) x, (int) y, width, height, null);
        String str = Integer.toString(min);
        g.drawString(str,(int)x,(int)y-(int)(width/1.5));
        
        str = Integer.toString(max);
        g.drawString(str,(int)x+Tile.TILEWIDTH,(int)y-(int)(width/1.5));
        
		
		g.setColor(Color.black);
		g.drawRect((int)x,(int)y-(int)(width/2.5),10*max,height/4);
		g.setColor(Color.green);
		g.fillRect((int)x,(int)y-(int)(width/2.5),10*max,height/4);
		g.setColor(Color.RED);
		g.fillRect((int)x,(int)y-(int)(width/2.5),10*min,height/4);
		
		
	}
	
	@Override
	public void die() {
		System.out.println(alive);
		//can spawn items player can collect
	}
	

}
