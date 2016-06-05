package worlds;

import java.awt.Graphics;

import entities.statics.Shapes;
import game.GameCThread;

public class WorldC extends World {
	//Instance variables
	//Constructor
	public WorldC(handler.Handler handler){
        this.handler = handler;
	}
	
	//Detect when we click on the rectangle (have to do it for every shapes)
	@Override
    public void tick() {
		if(handler.getMouseManager().isLeftPressed() && (380 < handler.getMouseManager().getMouseX() && handler.getMouseManager().getMouseX() < 530) && (100 < handler.getMouseManager().getMouseY() && handler.getMouseManager().getMouseY() < 180)){
    		System.out.println("You did it !!");
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

		
	}

	
	
}
