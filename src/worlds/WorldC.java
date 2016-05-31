package worlds;

import java.awt.Graphics;

import entities.statics.Shapes;

public class WorldC extends World {
	//Instance variables
	private Shapes s = new Shapes();
	//Constructor
	public WorldC(handler.Handler handler){
        this.handler = handler;
	}
	
	@Override
    public void tick() {
		if(handler.getMouseManager().isLeftPressed() && (380 < handler.getMouseManager().getMouseX() && handler.getMouseManager().getMouseX() < 530) && (100 < handler.getMouseManager().getMouseY() && handler.getMouseManager().getMouseY() < 180)){
    		System.out.println("You did it !!");;
    		try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    	}
    }


	@Override
	public void render(Graphics g) {
		s.paintComponent(g);

	}
}
