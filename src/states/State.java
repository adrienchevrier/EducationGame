package states;

import java.awt.*;

/**
 * Created by adrien on 10/05/16.
 * EducationGame project class
 */
public abstract class State {


    public abstract void tick();
    public abstract void render(Graphics g);
}
