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
public class EndState extends State {
    private State previousState;
    private BufferedImage image=null;


    public EndState(Handler handler,State previousState) {
        super(handler);
        this.previousState = previousState;

            try {
                if (previousState instanceof GameAState) {
                    image = ImageIO.read(new File("res/textures/WIN.png"));
                }
                if (previousState instanceof GameBState) {
                    image = ImageIO.read(new File("res/textures/WIN.png"));
                }
                if (previousState instanceof GameBState) {
                    image = ImageIO.read(new File("res/textures/WIN.png"));
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    @Override
    public void tick() {
        if(handler.getMouseManager().isLeftPressed() && (186 < handler.getMouseManager().getMouseX() && handler.getMouseManager().getMouseX() < 586) && (400 < handler.getMouseManager().getMouseY() && handler.getMouseManager().getMouseY() < 600)){
            next();
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
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

        g.drawImage(image,0,0,null);
        //g.drawString("Continue?",500,200);
        //First game
        g.drawImage(Assets.next1, 186, 400, null);
        if((186 < handler.getMouseManager().getMouseX() && handler.getMouseManager().getMouseX() < 586) && (400 < handler.getMouseManager().getMouseY() && handler.getMouseManager().getMouseY() < 600)){
        	g.drawImage(Assets.next2, 186,400, null);
        }
        else{
        	g.drawImage(Assets.next1, 186, 400, null);
        }

        //2nd game
        g.drawImage(Assets.menu1, 772, 400, null);
        if((772 < handler.getMouseManager().getMouseX() && handler.getMouseManager().getMouseX() < 1172) && (400 < handler.getMouseManager().getMouseY() && handler.getMouseManager().getMouseY() < 600)){
        	g.drawImage(Assets.menu2, 772, 400, null);
        }
        else{
        	g.drawImage(Assets.menu1, 772, 400, null);
        }
    }

    public void next(){
        //Select next state depending on level finished
        if (previousState instanceof GameAState){
            CurrentState.setState(handler.getGame().gameState = new GameBState(handler,1));
        }
        else if (previousState instanceof GameBState){
            CurrentState.setState(handler.getGame().gameState = new GameCState(handler));
        }
        else if (previousState instanceof GameCState){

            CurrentState.setState(handler.getGame().gameState = new MenuState(handler));
        }
    }
}
