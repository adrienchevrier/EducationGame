package states;


import handler.Handler;

import java.awt.*;

import gfx.Assets;

/**
 * Created by adrien on 12/05/16.
 * EducationGame project class
 */
public class MenuState extends State{

    public MenuState(Handler handler) {
        super(handler);
    }

    @Override
    public void tick() {
		if(handler.getMouseManager().isLeftPressed() && (500 < handler.getMouseManager().getMouseX() && handler.getMouseManager().getMouseX() < 564) && (500 < handler.getMouseManager().getMouseY() && handler.getMouseManager().getMouseY() < 564)){
    		CurrentState.setState(handler.getGame().gameState = new GameBState(handler));
    		try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    	}
		if(handler.getMouseManager().isLeftPressed() && (700 < handler.getMouseManager().getMouseX() && handler.getMouseManager().getMouseX() < 764) && (500 < handler.getMouseManager().getMouseY() && handler.getMouseManager().getMouseY() < 564)){
    		CurrentState.setState(handler.getGame().gameState = new GameState(handler, 1));
    		try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    	}
		
		if(handler.getMouseManager().isLeftPressed() && (900 < handler.getMouseManager().getMouseX() && handler.getMouseManager().getMouseX() < 964) && (500 < handler.getMouseManager().getMouseY() && handler.getMouseManager().getMouseY() < 564)){
    		CurrentState.setState(handler.getGame().gameState = new GameCState(handler));
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
    	//First game
		g.drawImage(Assets.dirt, 500, 500, null);
		//2nd game
		g.drawImage(Assets.dirt, 700, 500, null);
		//3rd game
		g.drawImage(Assets.dirt, 900, 500, null);

    }
}
