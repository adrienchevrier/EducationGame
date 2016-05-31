package entities.armies;

import gfx.Assets;
import handler.Handler;
import states.CurrentState;
import states.MenuState;

import java.awt.*;

import entities.Entity;
import entities.statics.Ally;
import entities.statics.Enemy;
import entities.statics.Gate;
import utils.intefaces.healthDisplaying;
import worlds.WorldA;

/**
 * Created by adrien on 12/05/16.
 * EducationGame project class
 */
public class Player extends Army implements healthDisplaying {
	private long lastAttackTimer, attackCooldown=100, attackTimer=attackCooldown;

    //CONSTRUCTOR
    public Player(Handler handler, float x, float y) {
        super(handler,x, y, Army.DEFAULT_CREATURE_WIDTH,Army.DEFAULT_CREATURE_HEIGHT);
        bounds.x = width/4;
        bounds.y = height/2;
        bounds.width = width/2;
        bounds.height = height/2;
        this.health=MAX_HEALTH;
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
    	attackTimer+=System.currentTimeMillis()-lastAttackTimer;
    	lastAttackTimer=System.currentTimeMillis();
    	if(attackTimer<attackCooldown){
    		return;
    	}
    	
    	
    	Rectangle cb= this.getCollisionBounds(0,0);
    	Rectangle ar= new Rectangle();
    	int arSize=50;
    	ar.width=arSize;
    	ar.height=arSize;
    	
    	if(handler.getKeymanager().aUp){
    		ar.x=cb.x+cb.width/2-arSize/2;
    		ar.y=cb.y-arSize;
    		
    	}else if(handler.getKeymanager().aDown){
    		ar.x=cb.x+cb.width/2-arSize/2;
    		ar.y=cb.y+cb.height;
    		
    	}else if(handler.getKeymanager().aLeft){
    		ar.x=cb.x-arSize;
    		ar.y=cb.y+cb.height/2-arSize/2;
    		
    	}else if(handler.getKeymanager().aRight){
    		ar.x=cb.x+cb.width;
    		ar.y=cb.y+cb.height/2-arSize/2;
    		
    	}else{
    		return;
    	}
    	attackTimer=0;
    	
    	for(Entity e: ((WorldA)handler.getWorld()).getEntityManager().getEntities()){
    		if(e instanceof Player){
    			
    			if (((Player) e).health<=0){
    				System.out.println("Game Over!");
    				//go to game over mode
    				CurrentState.setState(handler.getGame().menuState= new MenuState(handler));
    			}
    			continue; //if this entity is Player, then continue
    		}
    		
    		if(e.getCollisionBounds(0,0).intersects(ar)){
    			if (e instanceof Enemy){
    				e.hurt(1);
    				this.health-=1;
    				System.out.println("Player's health "+this.health);
    			}
    			else if(e instanceof Ally){
    				e.hurt(1);
    				this.health+=1;
    				System.out.println("Player's health "+this.health);
    			}else if(e instanceof Gate){
    				((Gate) e).checkCondition(this.health);
    			}
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

        g.setColor(Color.blue);
        g.fillRect((int)(x+bounds.x),(int)y+bounds.y,bounds.width,bounds.height);
		displayHealth(g);
    }


	@Override
	public void die() {
		System.out.println("GAME OVER YOU DIED!");
		
	}

	@Override
	public void displayHealth(Graphics g) {
        String str = Integer.toString(health);
        g.drawString(str,750,45);
		g.setColor(Color.blue);
		g.fillRect(750,50,150*health/MAX_HEALTH,50);
        g.setColor(Color.black);
        g.drawRect(750,50,150,50);
	}
}
