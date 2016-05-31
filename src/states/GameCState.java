package states;

import worlds.WorldC;

import java.awt.*;

import handler.Handler;

public class GameCState extends State{
	//Instance variables
	private WorldC worldC;
	//Constructor
	public GameCState(Handler handler) {
		super(handler);
		worldC = new WorldC(handler);
	}
	//Override methods
	@Override
	public void tick() {
		worldC.tick();
	}

	@Override
	public void render(Graphics g) {
		worldC.render(g);
	}

}
