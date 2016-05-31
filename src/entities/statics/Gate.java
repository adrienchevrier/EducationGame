package entities.statics;

import java.awt.Graphics;

import gfx.Assets;
import handler.Handler;
import states.CurrentState;
import states.GameAState;
import tiles.Tile;

public class Gate extends StaticEntity{

	public final boolean WIN = true;
	public final boolean LOOSE = false;

	private int min;
	private int max;

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
	
	public boolean checkCondition(int health){
		if (health<=this.max && health>=this.min){
			System.out.println("You Won!");
			return WIN;
			//CurrentState.setState(handler.getGame().gameState = new GameAState(handler));
		}else{
			System.out.println("You Lost~");
			return LOOSE;
		}
	}
	
	@Override
	public void tick() {
		
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(Assets.door, (int) x, (int) y, width, height, null);
		
		
	}
	
	@Override
	public void die() {
		System.out.println(alive);
		//can spawn items player can collect
	}
	

}
