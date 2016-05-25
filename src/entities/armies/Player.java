package entities.armies;

import gfx.Assets;
import handler.Handler;

import java.awt.*;

import entities.Entity;

/**
 * Created by adrien on 12/05/16.
 * EducationGame project class
 */
public class Player extends Army {


    //CONSTRUCTOR
    public Player(Handler handler, float x, float y) {
        super(handler,x, y, Army.DEFAULT_CREATURE_WIDTH,Army.DEFAULT_CREATURE_HEIGHT);
        bounds.x = width/4;
        bounds.y = height/2;
        bounds.width = width/2;
        bounds.height = height/2;
        this.health=100;
    }


    //each tick takes input and moves
    @Override
    public void tick() {

        getInput();
        move();
        //Attack
        checkAttack();
    }
    
    private void checkAttack(){
    	Rectangle cb= this.getCollisionBounds(0,0);
    	Rectangle ar= new Rectangle();
    	int arSize=20;
    	ar.width=arSize;
    	ar.height=arSize;
    	
    	if(handler.getKeymanager().up){
    		ar.x=cb.x+cb.width/2-arSize/2;
    		ar.y=cb.y-arSize;
    	}else if(handler.getKeymanager().down){
    		ar.x=cb.x+cb.width/2-arSize/2;
    		ar.y=cb.y+cb.height;
    	}else if(handler.getKeymanager().right){
    		ar.x=cb.x-arSize;
    		ar.y=cb.y+cb.height/2-arSize/2;
    	}else if(handler.getKeymanager().left){
    		ar.x=cb.x+cb.width;
    		ar.y=cb.y+cb.height/2-arSize/2;
    	}else{
    		return;
    	}
    	
    	for(Entity e: handler.getWorld().getEntityManager().getEntities()){
    		if(e.equals(this)){
    			continue; //if this entity is Player, then continue
    		}
    		if(this.getCollisionBounds(0,0).intersects(ar)){
    			e.hurt(1);
    			return;
    		}
    		
    	}
    	
    	
    	
    	
    }

    //method sets shifting of player according to input
    private void getInput(){
        xMove = 0;
        yMove = 0;

        if(handler.getKeymanager().up)yMove = -speed;
        if(handler.getKeymanager().down)yMove = speed;
        if(handler.getKeymanager().left)xMove = -speed;
        if(handler.getKeymanager().right)xMove = speed;
    }

    //displays the player
    @Override
    public void render(Graphics g) {
        g.drawImage(Assets.soldier,(int)x,(int)y,width,height, null);

        g.setColor(Color.red);
        g.fillRect((int)(x+bounds.x),(int)y+bounds.y,bounds.width,bounds.height);
    }


	@Override
	public void die() {
		System.out.println("GAME OVER YOU DIED!");
		
	}
}
