package tiles;

import java.awt.image.BufferedImage;

import gfx.Assets;
import handler.Handler;
import states.CurrentState;
import states.GameCState;
import worlds.WorldB;

public class Character extends Tile {
    public Character(int id) {
        super(Assets.character, id);
    }

	public static int swap(Tile[][] src, Handler handler) {
		Tile tmp;
		int x2 = WorldB.locationX, y2 = WorldB.locationY;
		
		switch(WorldB.direction) {
		case 0: ++WorldB.locationX; break;
		case 1: --WorldB.locationX; break;
		case 2: ++WorldB.locationY; break;
		case 3: --WorldB.locationY; break;
		}
		
		if(src[WorldB.locationX][WorldB.locationY].getClass() == RockTile.class) {
			WorldB.locationX = x2;
			WorldB.locationY = y2;
			WorldB.direction = -1;
			return -1;
		} else if(src[WorldB.locationX][WorldB.locationY].getClass() == Goal.class) {
			src[WorldB.locationX][WorldB.locationY] = Tile.tiles[0];
			WorldB.locationX = x2;
			WorldB.locationY = y2;
			WorldB.direction = 4;
    		CurrentState.setState(handler.getGame().gameState = new GameCState(handler));
			return 1;
		} else if(src[WorldB.locationX][WorldB.locationY].getClass() == RightTile.class) {
			src[WorldB.locationX][WorldB.locationY] = Tile.tiles[0];
			WorldB.direction = 0;
		} else if(src[WorldB.locationX][WorldB.locationY].getClass() == LeftTile.class) {
			src[WorldB.locationX][WorldB.locationY] = Tile.tiles[0];
			WorldB.direction = 1;
		} else if(src[WorldB.locationX][WorldB.locationY].getClass() == DownTile.class) {
			src[WorldB.locationX][WorldB.locationY] = Tile.tiles[0];
			WorldB.direction = 2;
		} else if(src[WorldB.locationX][WorldB.locationY].getClass() == UpTile.class) {
			src[WorldB.locationX][WorldB.locationY] = Tile.tiles[0];
			WorldB.direction = 3;
		}
		
		tmp = src[WorldB.locationX][WorldB.locationY];
		src[WorldB.locationX][WorldB.locationY] = src[x2][y2];
		src[x2][y2] = tmp;
		
		return 0;
	}
}
