package states;


import java.awt.*;

/**
 * Created by adrien on 10/05/16.
 * EducationGame project class
 */
public abstract class State {

    protected handler.Handler handler;

    public State(handler.Handler handler) {
        this.handler = handler;
    }

    public abstract void tick();
    public abstract void render(Graphics g);
}
