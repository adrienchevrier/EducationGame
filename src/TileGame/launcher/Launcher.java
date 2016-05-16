package TileGame.launcher;

import game.Game;

/**
 * Created by adrien on 03/05/16.
 * GameTuto project class
 */
public class Launcher {

    public static void main(String[] args) {

        Game game = new Game("Game",1000,1000);
        game.start();
    }
}
