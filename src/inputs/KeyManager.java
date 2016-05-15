package inputs;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Created by adrien on 12/05/16.
 * EducationGame project class
 *
 * key manager corresponds to key inputs from player
 */
public class KeyManager implements KeyListener{

    //VARIABLES
    private boolean[] keys;
    public boolean up,down,left,right;

    //CONSTRUCTOR
    public KeyManager() {
        keys = new boolean[256];
    }

    //tick method reads inputs when called
    public void tick(){
        up = keys[KeyEvent.VK_Z];
        down = keys[KeyEvent.VK_S];
        left = keys[KeyEvent.VK_Q];
        right = keys[KeyEvent.VK_D];
    }

    @Override
    public void keyTyped(KeyEvent e) {

        for (boolean key : keys)key = false;

    }

    @Override
    public void keyPressed(KeyEvent e) {
        keys[e.getKeyCode()] = true;
        System.out.println("pressed!!");
    }

    @Override
    public void keyReleased(KeyEvent e) {
        keys[e.getKeyCode()] = false;
    }
}
