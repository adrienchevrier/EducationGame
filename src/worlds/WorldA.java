package worlds;

import game.Game;
import tiles.Tile;
import utils.Utils;

import java.awt.*;
import java.util.logging.Handler;

import entities.EntityManager;
import entities.armies.Player;
import entities.statics.Ally;
import entities.statics.Enemy;
import entities.statics.Gate;

/**
 * Created by adrien on 12/05/16.
 * EducationGame project class
 */
public class WorldA extends World {


    
    private EntityManager entityManager;



    //CONSTRUCTOR
    public WorldA(handler.Handler handler, String path){
        this.handler = handler;
        entityManager=new EntityManager(handler, new Player(handler, 0, 0));
        //create enemy here
        entityManager.addEntity(new Enemy(handler, 200, 400, 10));
        entityManager.addEntity(new Enemy(handler, 70, 400, 5));
        entityManager.addEntity(new Enemy(handler, 500, 400, 8));
        entityManager.addEntity(new Enemy(handler, 500, 500, 3));
        entityManager.addEntity(new Enemy(handler, 500, 300, 9));
        
        entityManager.addEntity(new Ally(handler, 300, 400, 8));
        entityManager.addEntity(new Ally(handler, 600, 500, 3));
        entityManager.addEntity(new Ally(handler, 100, 300, 9));
        
        entityManager.addEntity(new Gate(handler, 500, 100, 1, 9));
        
        
        
        
        loadWorld(path);
        entityManager.getPlayer().setX(spawnX);
        entityManager.getPlayer().setY(spawnY);

    }




	public void tick(){
    	entityManager.tick();
    }

    //displays each tile of the array
    public void render(Graphics g){
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                    getTile(x,y).render(g,x*Tile.TILEWIDTH,y*Tile.TILEHEIGHT);
            }
        }
        
        //Entities
        entityManager.render(g);

    }
    
    public EntityManager getEntityManager() {
		return entityManager;
	}


    }