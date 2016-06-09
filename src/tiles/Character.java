package tiles;

import java.awt.image.BufferedImage;

import gfx.Assets;
import handler.Handler;
import states.CurrentState;
import states.GameBState;
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
		} else if(src[WorldB.locationX][WorldB.locationY].getClass() == Warp.class) {
			int i, j = 0;
			src[WorldB.locationX][WorldB.locationY] = Tile.tiles[0];
			for(i=0;i<src.length;i++) {
				for(j=0;j<src[i].length;j++) {
					if(src[j][i].getClass() == Warp.class) break;
				}
				if(src[j][i].getClass() == Warp.class) break;
			}
			WorldB.locationX = j;
			WorldB.locationY = i;
			WorldB.direction = 0;
		}
		
		tmp = src[WorldB.locationX][WorldB.locationY];
		src[WorldB.locationX][WorldB.locationY] = src[x2][y2];
		src[x2][y2] = Tile.tiles[0];
		
		return 0;
	}
}
