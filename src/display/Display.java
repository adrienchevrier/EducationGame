package display;

import javax.swing.*;
import java.awt.*;

/**
 * Created by adrien on 03/05/16.
 * GameTuto project class
 */
public class Display {
    //frame is displayed on the screen
    private JFrame frame;
    //canvas corresponds to next image to be displayed
    private Canvas canvas;

    private String title;
    private int width, height;

    //CONSTRUCTOR
    public Display( String title, int width, int height) {
        this.title = title;
        this.width = width;
        this.height = height;

        createDisplay();
    }

    //generates the screen to be displayed
    private void createDisplay(){
        frame = new JFrame(title);
        frame.setSize(width,height);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        canvas = new Canvas();
        canvas.setPreferredSize(new Dimension(width,height));
        canvas.setMaximumSize(new Dimension(width,height));
        canvas.setMinimumSize(new Dimension(width,height));
        canvas.setFocusable(false);

        frame.add(canvas);
        frame.pack();
    }

    //GETTERS AND SETTERS
    public JFrame getFrame() {
        return frame;
    }

    public Canvas getCanvas() {
        return canvas;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
}
