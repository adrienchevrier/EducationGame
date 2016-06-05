package tiles;

// Tiles can swap by implementing this
public interface Swapable {
	public void swap(int x, int y, Tile src, int direction);
}