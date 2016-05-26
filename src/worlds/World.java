package worlds;

import game.Game;
import tiles.Tile;
import utils.Utils;

import java.awt.*;
import java.util.logging.Handler;

import entities.EntityManager;
import entities.armies.Player;
import entities.statics.Enemy;

/**
 * Created by adrien on 12/05/16.
 * EducationGame project class
 */
public class World {

    //VARIABLES
    private handler.Handler handler;
    private int width=11 , height=10;
    private int spawnX=60 , spawnY=60;
    
    private EntityManager entityManager;

    //array of tiles
    private int[][] tiles = new int[width][height];

    //CONSTRUCTOR
    public World(handler.Handler handler, String path){
        this.handler = handler;
        entityManager=new EntityManager(handler, new Player(handler, 0, 0));
        //create enemy here
        entityManager.addEntity(new Enemy(handler, 200, 400, 10));
        entityManager.addEntity(new Enemy(handler, 70, 400, 5));
        entityManager.addEntity(new Enemy(handler, 500, 400, 8));
        entityManager.addEntity(new Enemy(handler, 500, 500, 3));
        entityManager.addEntity(new Enemy(handler, 500, 300, 9));
        
        
        
        
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


    //return type of chosen tile
    public Tile getTile(int x, int y){
        if (x<0 || y<0 || x>= width || y>= height)
            return Tile.grassTile;

        Tile t = Tile.tiles[tiles[x][y]];
        //if no tile, returns dirt tile
        if (t == null)
            return Tile.dirtTile;
        return t;
    }
    
    public EntityManager getEntityManager() {
		return entityManager;
	}

    //method puts values into tiles array
    private void loadWorld(String path){
        String file = Utils.loadFileAsString(path);
        String[]tokens = file.split("\\s+");
//        width = Utils.parseInt(tokens[0]);
//        height = Utils.parseInt(tokens[1]);
//        spawnX = Utils.parseInt(tokens[2]);
//        spawnY = Utils.parseInt(tokens[3]);

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                tiles[x][y] = Utils.parseInt(tokens[(x+y*width)]);
                //tiles[x][y] = 0;
            }
        }
        /*
        for (int i = 0; i < height; i++) {
            tiles [4][4] = 2;
        }
        tiles[3][4] = 3;
        tiles[1][4] = 1;
        tiles[2][2] = 2;*/
        }
    }