package entities.armies;

import entities.Entity;

/**
 * Created by adrien on 12/05/16.
 * EducationGame project class
 */
public abstract class Army extends Entity {

    protected int health;

    public Army(float x, float y) {
        super(x, y);
        health = 10;
    }
}
