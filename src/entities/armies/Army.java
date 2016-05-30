package entities.armies;

import entities.Entity;
import handler.Handler;

import tiles.Tile;
import worlds.WorldA;

/**
 * Created by adrien on 12/05/16.
 * EducationGame project class
 */
public abstract class Army extends Entity {

    //FINAL VARIABLES OF ARMIES
 
    public static final float DEFAULT_SPEED = 3.0f;
    public static final int DEFAULT_CREATURE_WIDTH = 64;
    public static final int DEFAULT_CREATURE_HEIGHT = 64;

    //armies variables

    protected float speed;
    protected float xMove;
    protected float yMove;

    //CONSTRUCTOR
    public Army(Handler handler, float x, float y, int width, int height) {
        super(handler,x, y,width,height);
       
        speed = DEFAULT_SPEED;
        xMove = 0;
        yMove = 0;
    }


    //HEALTH DISPLAYING


    //move method
    public void move(){
    	
    	
    	if(!this.checkEntityCollisions(xMove, 0f)){
    		moveX(); 
    	}
    	
    	if(!this.checkEntityCollisions(0f, yMove)){
    		moveY();
    	}
    }

    public void moveX(){

        if (xMove>0){//moving right

            //divide by TILEWIDTH or TILEHEIGHT to enter pixel positions
            int tx = (int)(x+xMove+bounds.x+bounds.width)/ Tile.TILEWIDTH;
            //avoiding collisions, if test false, we move
            if (!collisionWithTile(tx,(int)(y+bounds.y)/Tile.TILEHEIGHT)&&
                    !collisionWithTile(tx,(int)(y+bounds.y+bounds.height)/Tile.TILEHEIGHT)) {
                x+= xMove;
            }else {
                x= tx*Tile.TILEWIDTH - bounds.x-bounds.width -1;
            }
        }else if (xMove<0){//moving left
            int tx = (int)(x+xMove+bounds.x)/ Tile.TILEWIDTH;
            //avoiding collisions, if test false, we move
            if (!collisionWithTile(tx,(int)(y+bounds.y)/Tile.TILEHEIGHT)&&
                    !collisionWithTile(tx,(int)(y+bounds.y+bounds.height)/Tile.TILEHEIGHT)) {
                x+= xMove;
            }else {
                x= tx*Tile.TILEWIDTH - bounds.x+Tile.TILEWIDTH +1;
            }
        }

    }

    public void moveY(){
        if (yMove<0){//moving up
            int ty = (int)(y+yMove+bounds.y)/Tile.TILEHEIGHT;
            //avoiding collisions, if test false, we move
            if (!collisionWithTile((int)((x+bounds.x)/Tile.TILEWIDTH),ty) &&
                    !collisionWithTile((int)(x+bounds.x+bounds.width)/Tile.TILEWIDTH,ty)){
                y+=yMove;
            }else {
                y = ty*Tile.TILEHEIGHT + Tile.TILEHEIGHT-bounds.y;
            }

        }else if (yMove>0) {//moving down
            int ty = (int) (y + yMove + bounds.y+bounds.height) / Tile.TILEHEIGHT;
            //avoiding collisions, if test false, we move
            if (!collisionWithTile((int) ((x + bounds.x) / Tile.TILEWIDTH), ty) &&
                    !collisionWithTile((int) (x + bounds.x + bounds.width)/Tile.TILEWIDTH, ty)) {
                y += yMove;
            }
            else {
                y = ty*Tile.TILEHEIGHT - bounds.y - bounds.height-1;
            }
        }

    }

    protected boolean collisionWithTile(int x, int y){
        //returns true if target tile is solid
        return (handler.getWorld()).getTile(x,y).isSolid();
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





}
