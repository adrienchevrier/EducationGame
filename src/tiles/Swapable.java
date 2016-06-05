package tiles;

// Tiles can swap by implementing this
public interface Swapable {
	public void swap(Tile src, int direction);
}