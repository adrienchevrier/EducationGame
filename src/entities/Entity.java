package entities;

import handler.Handler;

import java.awt.*;

import entities.armies.Player;

/**
 * Created by adrien on 12/05/16.
 * EducationGame project class
 * Every object in the handler will be an entity
 */
public abstract class Entity {

    //VARIABLES
	protected int health;
    protected Handler handler;
    protected float x,y;
    protected int width, height;
    protected boolean active=true; //if this is false, entity manager removes entity from arraylist
    protected Rectangle bounds;
    
    //ABSTRACT METHODS
    public abstract void tick();
    public abstract void render(Graphics g);
    
    public abstract void die();
    
    public void hurt(int amt){
    	health-=amt;
    	if(health<=0){
    		active=false;
    		die();
    	}
    }


	//CONSTRUCTOR
    public Entity(Handler handler, float x, float y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.handler = handler;
        bounds = new Rectangle(0,0,width,height);
    }
    
	public boolean checkEntityCollisions(float xOffset, float yOffset){
		for(Entity e : handler.getWorld().getEntityManager().getEntities()){
			if(e instanceof Player)
				continue;
			if(e.getCollisionBounds(0f, 0f).intersects(getCollisionBounds(xOffset, yOffset)))
				return true;
		}
		return false;
	}
	
	public Rectangle getCollisionBounds(float xOffset, float yOffset){
		return new Rectangle((int) (x + bounds.x + xOffset), (int) (y + bounds.y + yOffset), bounds.width, bounds.height);
	}

    //GETTERS AND SETTERS
    
	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}
	
    public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}
    
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
}




