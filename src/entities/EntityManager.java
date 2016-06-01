package entities;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Comparator;

import entities.dynamics.Player;
import handler.Handler;

public class EntityManager {
	
	private Handler handler;
	private Player player;
	private ArrayList<Entity> entities = new ArrayList<Entity>();
	private Entity e;
	private Comparator<Entity> renderSorter = new Comparator<Entity>(){
		@Override
		public int compare(Entity a, Entity b) {
			if(a.getY() + a.getHeight() < b.getY() + b.getHeight())
				return -1;
			return 1;
		}
	};
	
	
	public EntityManager(Handler handler, Player player){
		this.handler=handler;
		this.player=player;
		this.addEntity(player);
	}
	
	public void tick(){
		for(int i = 0;i < entities.size();i++){
			e = entities.get(i);
			e.tick();
			
			if(!e.isAlive())
				entities.remove(e);
			
		}
		entities.sort(renderSorter);
	}
	
	public void render(Graphics g){
		for(Entity e:entities){
			e.render(g);
		}
		
	}
	
	public void addEntity(Entity e){
		entities.add(e);
	}
	
	
	//GETTERS and SETTERS
	
	public Handler getHandler() {
		return handler;
	}

	public void setHandler(Handler handler) {
		this.handler = handler;
	}
	
	
	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	public ArrayList<Entity> getEntities() {
		return entities;
	}

	public void setEntities(ArrayList<Entity> entities) {
		this.entities = entities;
	}


	
	
}
