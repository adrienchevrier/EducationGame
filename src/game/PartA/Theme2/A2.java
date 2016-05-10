package game.PartA.Theme2;

import display.Display;
import game.Game;
import gfx.Assets;
import states.CurrentState;
import states.GameState;

/**
 * Created by adrien on 10/05/16.
 * EducationGame project class
 */
public class A2 extends Game {
    public A2(String title, int width, int height) {
        super(title, width, height);
    }


    private void init(){
        display = new Display(title, width, height);

        //TO BE CHANGED
        Assets.init();

        gameState = new GameState();
        CurrentState.setState(gameState);
    }
}
