package tiles;

import java.awt.image.BufferedImage;

import gfx.Assets;

public class Character extends Tile implements Swapable {
    public Character(int id) {
        super(Assets.character, id);
    }

	@Override
	public void swap(int x, int y, Tile src, int direction) {
		// TODO Auto-generated method stub
		
	}
}
