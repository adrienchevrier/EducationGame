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
		if(handler.getMouseManager().isLeftPressed() && (40 < handler.getMouseManager().getMouseX() && handler.getMouseManager().getMouseX() < 440) && (400 < handler.getMouseManager().getMouseY() && handler.getMouseManager().getMouseY() < 600)){
    		CurrentState.setState(handler.getGame().gameState = new GameAState(handler,1));
    		try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    	}
		if(handler.getMouseManager().isLeftPressed() && (480 < handler.getMouseManager().getMouseX() && handler.getMouseManager().getMouseX() < 880) && (400 < handler.getMouseManager().getMouseY() && handler.getMouseManager().getMouseY() < 600)){
    		CurrentState.setState(handler.getGame().gameState = new GameBState(handler));
    		try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    	}
		if(handler.getMouseManager().isLeftPressed() && (920 < handler.getMouseManager().getMouseX() && handler.getMouseManager().getMouseX() < 1320) && (400 < handler.getMouseManager().getMouseY() && handler.getMouseManager().getMouseY() < 600)){
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
    	g.drawImage(Assets.menuBackground, 0, 0, null);
    	if ((40 < handler.getMouseManager().getMouseX() && handler.getMouseManager().getMouseX() < 440) && (400 < handler.getMouseManager().getMouseY() && handler.getMouseManager().getMouseY() < 600)){
    		g.drawImage(Assets.gameA1, 40, 400, null);
    	}
    	else{
    		g.drawImage(Assets.gameA2, 40, 400, null);
    	}
		
		//2nd game
    	if((480 < handler.getMouseManager().getMouseX() && handler.getMouseManager().getMouseX() < 880) && (400 < handler.getMouseManager().getMouseY() && handler.getMouseManager().getMouseY() < 600)){
    		g.drawImage(Assets.gameB1, 480, 400, null);
    	}
    	else{
    		g.drawImage(Assets.gameB2, 480, 400, null);
    	}
		
		//3rd game
    	if((920 < handler.getMouseManager().getMouseX() && handler.getMouseManager().getMouseX() < 1320) && (400 < handler.getMouseManager().getMouseY() && handler.getMouseManager().getMouseY() < 600)){
    		g.drawImage(Assets.gameC1, 920, 400, null);
    	}
    	else{
    		g.drawImage(Assets.gameC2, 920, 400, null);
    	}
		

    }
}
