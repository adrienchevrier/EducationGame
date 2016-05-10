package game.PartA.Theme1;

import display.Display;
import game.Game;
import map.Map;
import states.CurrentState;
import states.GameState;

/**
 * Created by adrien on 10/05/16.
 * EducationGame project class
 */
public class A1 extends Game {

    public A1(String title, int width, int height) {
        super(title, width, height);
    }

    private void init(){
        display = new Display(title, width, height);
        Map.init();

        gameState = new GameState();
        CurrentState.setState(gameState);
    }
}
