package game;

import display.Display;
import gfx.Assets;
import gfx.ImageLoader;
import gfx.SpriteSheet;

import java.awt.*;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

/**
 * Created by adrien on 03/05/16.
 * GameTuto project class
 */
public class Game implements Runnable{

    //variables
    private Display display;
    public int width, height;
    public String title;

    private boolean running = false;
    private Thread thread;

    private BufferStrategy bs;
    private Graphics g;

    //timer
    int x;


    //Constructor
    public Game(String title, int width, int height) {
        this.height = height;
        this.width = width;
        this.title = title;
    }

    private void init(){
        display = new Display(title, width, height);
        Assets.init();
    }

    //updates the screen
    //
    private void tick(){
        x+=1;

    }

    //displays the screen
    private void render(){
        bs = display.getCanvas().getBufferStrategy();
        if (bs == null){
            display.getCanvas().createBufferStrategy(3);
            return;
        }
        g = bs.getDrawGraphics();

        //clear screen
        g.clearRect(0,0,width,height);

        g.drawImage(Assets.door,x,20,null);
        //g.drawImage(Assets.genius,50,80,null);

        //we draw here
        //g.setColor(Color.green);
        //g.fillRect(0,0,width,height);
        //g.setColor(Color.blue);
        //g.fillRect(10,30,10,10);

        //draw image
        //g.drawImage(testImage, 20,20,null);

        //draw subImage

        //end of drawing
        bs.show();
        g.dispose();
    }

    public void run(){
        init();

        //Timer variables
        int fps = 60;
        double timePerTick = 1000000000/fps;
        double delta =0;
        long now;
        long lastTime = System.nanoTime();
        long timer =0;
        int ticks =0;

        while (running){
            now = System.nanoTime();
            //calculate how much time we have until we call tick again
            delta+=(now-lastTime)/timePerTick;
            timer+= now-lastTime;
            lastTime = now;

            //executes tick and render methods 60 times per second
            if (delta>=1) {
                tick();
                render();
                ticks++;
                delta--;
            }

            //displays frames per second
            if (timer>=1000000000){
                System.out.println("Ticks and frames "+ticks);
                ticks=0;
                timer=0;
            }
        }
        stop();

    }

    public synchronized void start(){
        if (running)return;
        running = true;
        thread = new Thread(this);
        thread.start();
    }

    public synchronized void stop(){
        if (!running)return;
        try {
            thread.join();
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
