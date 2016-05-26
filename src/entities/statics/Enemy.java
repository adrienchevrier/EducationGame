package entities.statics;

import java.awt.Color;
import java.awt.Graphics;

import gfx.Assets;
import handler.Handler;
import tiles.Tile;

public class Enemy extends StaticEntity{

	

	public Enemy(Handler handler, float x, float y, int health) {
		super(handler, x, y, Tile.TILEWIDTH, Tile.TILEHEIGHT);
        bounds.x = width/4;
        bounds.y = height/2;
        bounds.width = width/2;
        bounds.height = height/2;
        this.health=health;
        
		
	}

	@Override
	public void tick() {
		
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(Assets.soldier, (int) x, (int) y, width, height, null);
		g.setColor(Color.blue);
        
        g.fillRect((int)(x+bounds.x),(int)y+bounds.y,bounds.width,bounds.height);
		
	}
	
	@Override
	public void die() {
		System.out.println(alive);
		//can spawn items player can collect
	}
	

}
