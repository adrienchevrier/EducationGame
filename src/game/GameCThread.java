package game;

import java.awt.Graphics;

import entities.statics.Shapes;
import handler.Handler;
import states.State;

public class GameCThread extends State implements Runnable {
	//Instance variables
	private Shapes s = new Shapes();
	private boolean running = false;
	private Thread ShapeThread;
	private Graphics g;

	public GameCThread(Handler handler, Graphics g) {
		super(handler);
		this.g = g;
		// TODO Auto-generated constructor stub
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(running){
			this.render(g);
		}
		stop();
	}

	@Override
	public void tick() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void render(Graphics g) {
		// TODO Auto-generated method stub
		//s.paintComponent(g);
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
