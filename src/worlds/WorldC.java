package worlds;

import java.awt.Graphics;

import entities.statics.Shapes;

public class WorldC extends World {
	//Instance variables
	private Shapes s = new Shapes();
	//Constructor
	public WorldC(){
	}
	
	@Override
    public void tick() {
              
    }

	@Override
	public void render(Graphics g) {
		s.paintComponent(g);

	}
}
