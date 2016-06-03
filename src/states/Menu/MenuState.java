package states.Menu;
import handler.Handler;
import states.State;

import javax.swing.*;
import java.awt.*;

/**
 * Created by adrien on 12/05/16.
 * EducationGame project class
 */
public class MenuState extends State {


    private JPanel panelA = new JPanel();

    JButton button = new JButton("Test");

    public MenuState(Handler handler) {
        super(handler);
        //button.setHorizontalAlignment(SwingConstants.WEST);
        //button.setVerticalAlignment(SwingConstants.BOTTOM);
        panelA.add(button);
    }

    @Override
    public void tick() {



    }

    @Override
    public void render(Graphics g) {

        //display.getFrame().add(button);




    }
}
