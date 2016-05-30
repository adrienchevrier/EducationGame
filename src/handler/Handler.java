package handler;

import game.Game;
import inputs.KeyManager;
import inputs.MouseManager;
import worlds.World;
import worlds.WorldA;

/**
 * Created by adrien on 16/05/16.
 * EducationGame project class
 */
public class Handler {
    private Game game;
    private World world;

    //CONSTRUCTOR
    public Handler(Game game) {
        this.game = game;
    }

    public KeyManager getKeymanager(){
        return game.getKeyManager();
    }
    
    public MouseManager getMouseManager(){
    	return game.getMouseManager();
    }

    public int getWidth(){
        return game.getWidth();
    }

    public int getHeight(){
        return game.getHeight();
    }

    //GETTERS AND SETTERS


    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public World getWorld() {
        return world;
    }

    public void setWorld(World world) {
        this.world = world;
    }
}
