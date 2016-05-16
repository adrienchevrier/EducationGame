package entities;

import game.Game;

import java.awt.*;

/**
 * Created by adrien on 12/05/16.
 * EducationGame project class
 * Every object in the game will be an entity
 */
public abstract class Entity {

    //VARIABLES
    protected Game game;
    protected float x,y;
    protected int width, height;

    //CONSTRUCTOR
    public Entity(Game game, float x, float y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.game = game;
    }

    //GETTERS AND SETTERS
    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }


    //ABSTRACT METHODS
    public abstract void tick();
    public abstract void render(Graphics g);
    }

