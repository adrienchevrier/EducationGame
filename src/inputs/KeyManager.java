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
    public boolean aUp,aDown,aLeft,aRight;

    //CONSTRUCTOR
    public KeyManager() {
        keys = new boolean[256];
    }

    //tick method reads inputs when called
    public void tick(){
        up = keys[KeyEvent.VK_W];
        down = keys[KeyEvent.VK_S];
        left = keys[KeyEvent.VK_A];
        right = keys[KeyEvent.VK_D];
        
        aUp = keys[KeyEvent.VK_UP];
        aDown = keys[KeyEvent.VK_DOWN];
        aLeft = keys[KeyEvent.VK_LEFT];
        aRight = keys[KeyEvent.VK_RIGHT];
    }

    @Override
    public void keyTyped(KeyEvent e) {

        for (boolean key : keys)key = false;

    }

    @Override
    public void keyPressed(KeyEvent e) {
        keys[e.getKeyCode()] = true;
    }

    @Override
    public void keyReleased(KeyEvent e) {
        keys[e.getKeyCode()] = false;
    }
}
