package states;



import tiles.Tile;
import worlds.WorldA;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Created by adrien on 10/05/16.
 * EducationGame project class
 */
public class GameAState extends State {

    
    private WorldA worldA;
 

    //CONSTRUCTOR
    public GameAState(handler.Handler handler, int level){
        super(handler);
        
        //path to worldA information
        if (level==1){
        	worldA = new WorldA(handler,"res/myWorlds/world1.txt", level);
        }else if(level==2){
        	worldA = new WorldA(handler,"res/myWorlds/world2.txt", level);
        }else if(level==3){
        	worldA = new WorldA(handler,"res/myWorlds/world3.txt", level);
        }


        handler.setWorld(worldA);
       
        
    }


    //calls required ticks
    @Override
    public void tick() {
        worldA.tick();
    }

    //displays handler to the screen
    @Override
    public void render(Graphics g) {
        worldA.render(g);

        
        
        Tile.tiles[3].render(g,0,0);
    }

}
