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
                    image = ImageIO.read(new File("res/gameEnds/EndOfGameA.png"));
                }
                if (previousState instanceof GameBState) {
                    image = ImageIO.read(new File("res/gameEnds/EndOfGameB.png"));
                }
                if (previousState instanceof GameBState) {
                    image = ImageIO.read(new File("res/gameEnds/EndOfGameB.png"));
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    @Override
    public void tick() {
        if(handler.getMouseManager().isLeftPressed() && (400 < handler.getMouseManager().getMouseX() && handler.getMouseManager().getMouseX() < 464) && (500 < handler.getMouseManager().getMouseY() && handler.getMouseManager().getMouseY() < 564)){
            next();
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        if(handler.getMouseManager().isLeftPressed() && (600 < handler.getMouseManager().getMouseX() && handler.getMouseManager().getMouseX() < 664) && (500 < handler.getMouseManager().getMouseY() && handler.getMouseManager().getMouseY() < 564)){
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

        g.drawImage(image,150,150,null);
        //g.drawString("Continue?",500,200);
        //First game
        g.drawImage(Assets.next, 400, 500, null);
        //2nd game
        g.drawImage(Assets.menu, 600, 500, null);
    }

    public void next(){
        //Select next state depending on level finished
        if (previousState instanceof GameAState){
            CurrentState.setState(handler.getGame().gameState = new GameBState(handler));
        }
        else if (previousState instanceof GameBState){
            CurrentState.setState(handler.getGame().gameState = new GameCState(handler));
        }
        else if (previousState instanceof GameCState){

            CurrentState.setState(handler.getGame().gameState = new MenuState(handler));
        }
    }
}
