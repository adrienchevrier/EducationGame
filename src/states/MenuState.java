package states;


import handler.Handler;

import java.awt.*;

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
    	System.out.println(handler.getMouseManager().getMouseX()+" "+handler.getMouseManager().getMouseY());
    	if(handler.getMouseManager().isLeftPressed()&&handler.getMouseManager().isRightPressed()){
    		CurrentState.setState(handler.getGame().gameBState);	
    	}

    }

    @Override
    public void render(Graphics g) {
    	
    }
}
