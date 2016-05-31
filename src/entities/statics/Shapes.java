package entities.statics;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.geom.Arc2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.awt.geom.RoundRectangle2D;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.JPanel;


public class Shapes extends JPanel {
	//Instance variables
	private static final long serialVersionUID = 1L;
    private Color color;
    private Shape type;
    //All shape used
    private Shape s1 = new Ellipse2D.Double(680, 100, 150, 80);
	private Shape s2 = new Rectangle2D.Double(380, 100, 150, 80);
	private Shape s3 = new Ellipse2D.Double(80, 100, 150, 80);
	private Shape s4 = new RoundRectangle2D.Float(80, 250, 150, 80,20,20);
	private Shape s5 = new Arc2D.Double(380, 185, 300, 150, 180, 90, Arc2D.PIE);
	private Shape s6 = new RoundRectangle2D.Float(680, 250, 150, 80,20,20);
    
    //Getters and Setters
    public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public Shape getType() {
		return type;
	}

	public void setType(Shape type) {
		this.type = type;
	}
	
	//Methods
	//Method that will return a random color to the shape
	public Color randomColor(){
		//Local variable
		ArrayList<Color> allColor = new ArrayList<Color>();
		Random rand = new Random();
		//Range of colors (10 possible colors)
		allColor.add(Color.BLACK);
		allColor.add(Color.BLUE.darker());
		allColor.add(Color.CYAN.darker());
		allColor.add(Color.GREEN);
		allColor.add(Color.MAGENTA.darker());
		allColor.add(Color.ORANGE);
		allColor.add(Color.PINK);
		allColor.add(Color.RED);
		allColor.add(Color.YELLOW.darker());
		allColor.add(Color.WHITE);
		//return a random color
		return allColor.get(rand.nextInt(10));
		}
	
	//Random shape applicable only for the "gun" (we'll set the same shape for the shapes to compare)
	public Shape randomShape(){
		//Local variable
		ArrayList<Shape> allShape = new ArrayList<Shape>();
		Random rand = new Random();
		//Range of shapes possible (4 shapes possible)
		allShape.add(new Rectangle2D.Double(380, 480, 150, 80));
		allShape.add(new RoundRectangle2D.Float(380, 500, 150, 80,20,20));
		allShape.add(new Ellipse2D.Double(380, 480, 150, 80));
		allShape.add(new Arc2D.Double(380, 420, 300, 150, 180, 90, Arc2D.PIE));
		//return a random shape (that we'll fill later)
		return allShape.get(rand.nextInt(4));
	}
	
	//Override methods
		@Override
	public void paintComponent(Graphics g){	
		//Super
		super.paintComponent(g);
		//Local variables
		Graphics2D g2d = (Graphics2D) g;
		
		//Our component
		Color gunColor = this.randomColor();
		g2d.setColor(gunColor);
		Shape gunShape = this.randomShape();
		g2d.fill(gunShape);
		//Others static components (won't move)
		//1st shape
		g2d.setColor(this.randomColor());
		g2d.fill(s1);
		//2nd shape
		g2d.setColor(gunColor);
		g2d.fill(s2);
		//3rd shape
		g2d.setColor(this.randomColor());
		g2d.fill(s3);
		//4rd shape
		g2d.setColor(this.randomColor());
		g2d.fill(s4);
		//5th shape
		g2d.setColor(this.randomColor());
	    g2d.fill(s5);
	    //5th shape
	  	g2d.setColor(this.randomColor());
	  	g2d.fill(s6);
				
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
