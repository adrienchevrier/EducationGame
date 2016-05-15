package entities.armies;

import entities.Entity;

/**
 * Created by adrien on 12/05/16.
 * EducationGame project class
 */
public abstract class Army extends Entity {

    //FINAL VARIABLES OF ARMIES
    public static final int DEFAULT_HEALTH = 10;
    public static final float DEFAULT_SPEED = 3.0f;
    public static final int DEFAULT_CREATURE_WIDTH = 64;
    public static final int DEFAULT_CREATURE_HEIGHT = 64;

    //armies variables
    protected int health;
    protected float speed;
    protected float xMove;
    protected float yMove;

    //CONSTRUCTOR
    public Army(float x, float y, int width, int height) {
        super(x, y,width,height);
        health = DEFAULT_HEALTH;
        speed = DEFAULT_SPEED;
        xMove = 0;
        yMove = 0;
    }

    //move method
    public void move(){
        x+= xMove;
        y+=yMove;
    }

    //GETTERS &SETTERS
    public float getxMove() {
        return xMove;
    }

    public void setxMove(float xMove) {
        this.xMove = xMove;
    }

    public float getyMove() {
        return yMove;
    }

    public void setyMove(float yMove) {
        this.yMove = yMove;
    }

    public float getSpeed() {
        return speed;
    }

    public void setSpeed(float speed) {
        this.speed = speed;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }





}
