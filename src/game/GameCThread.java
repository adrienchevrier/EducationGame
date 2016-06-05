package game;

import java.awt.Graphics;

import entities.statics.Shapes;
import handler.Handler;
import states.State;

public class GameCThread implements Runnable {
	//Instance variables
	private Shapes s = new Shapes();
	private boolean running = false;
	private Thread ShapeThread;

	//CONSTRUCTOR
	public GameCThread() {
	}

	@Override
	public void run() {
		while(running){
			render();
		}
		stop();
	}


	public void tick() {
		
	}


	public void render() {
		s.draw();
	}
	
	//Method
	public synchronized void start(){
		if(running) return;
		running = true;
		ShapeThread = new Thread(this);
		ShapeThread.start();
	}
	
	public synchronized void stop(){
		if(running) return;
		try{
			ShapeThread.join();
		}catch(InterruptedException e){
			e.printStackTrace();
		}
	}
	

}
