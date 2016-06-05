package states;

import gfx.Assets;
import handler.Handler;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Created by adrien on 31/05/16.
 * EducationGame project class
 */
public class GameOver extends State {

    private State previousState;
    private BufferedImage img = null;

//CONSTRUCTOR
    public GameOver(Handler handler,State previousState) {
        super(handler);
        this.previousState = previousState;
//Open gameOver image
        try {
            img = ImageIO.read(new File("res/textures/gameOver.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void tick() {
        //game is reset if the reset button is clicked
        if(handler.getMouseManager().isLeftPressed() && (186 < handler.getMouseManager().getMouseX() && handler.getMouseManager().getMouseX() < 586) && (400 < handler.getMouseManager().getMouseY() && handler.getMouseManager().getMouseY() < 600)){
            reset();
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        //go to menu is menu button is clicked
        if(handler.getMouseManager().isLeftPressed() && (772 < handler.getMouseManager().getMouseX() && handler.getMouseManager().getMouseX() < 1172) && (400 < handler.getMouseManager().getMouseY() && handler.getMouseManager().getMouseY() < 600)){
            CurrentState.setState(handler.getGame().gameState = new MenuState(handler));
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    @Override
    public void render(Graphics g) {

        g.drawImage(Assets.gameOverBackground,0, 0, null);
        //First game
        if((186 < handler.getMouseManager().getMouseX() && handler.getMouseManager().getMouseX() < 586) && (400 < handler.getMouseManager().getMouseY() && handler.getMouseManager().getMouseY() < 600)){
        	g.drawImage(Assets.retry2, 186,400, null);
        }
        else{
        	g.drawImage(Assets.retry1, 186, 400, null);
        }
        
        //2nd game
        if((772 < handler.getMouseManager().getMouseX() && handler.getMouseManager().getMouseX() < 1172) && (400 < handler.getMouseManager().getMouseY() && handler.getMouseManager().getMouseY() < 600)){
        	g.drawImage(Assets.menu2, 772, 400, null);
        }
        else{
        	g.drawImage(Assets.menu1, 772, 400, null);
        }
        
    }

    public void reset(){
        //Reset according to previous game played
        if (previousState instanceof GameAState){
            CurrentState.setState(handler.getGame().gameState = new GameAState(handler, 1));
        }
        else if (previousState instanceof GameBState){
            CurrentState.setState(handler.getGame().gameState = new GameBState(handler));
        }
        else if (previousState instanceof GameCState){
            CurrentState.setState(handler.getGame().gameState = new GameCState(handler));
        }
    }
}
