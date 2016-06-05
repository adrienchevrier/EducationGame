package tiles;

import java.awt.image.BufferedImage;

import gfx.Assets;

public class Goal extends Tile implements Swapable {
    public Goal(int id) {
        super(Assets.goal, id);
    }

	@Override
	public void swap(Tile src, int direction) {
		// TODO Auto-generated method stub
		
	}
}
