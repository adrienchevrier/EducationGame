package entities;

import handler.Handler;

import java.awt.*;

/**
 * Created by adrien on 12/05/16.
 * EducationGame project class
 * Every object in the handler will be an entity
 */
public abstract class Entity {

    //VARIABLES
    protected Handler handler;
    protected float x,y;
    protected int width, height;
    protected Rectangle bounds;

    //CONSTRUCTOR
    public Entity(Handler handler, float x, float y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.handler = handler;
        bounds = new Rectangle(0,0,width,height);
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

