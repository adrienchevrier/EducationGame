package states;

/**
 * Created by adrien on 10/05/16.
 * EducationGame project class
 */
public class CurrentState {

    private static State currentState = null;

    public static void setState(State state){
        currentState = state;
    }

    public static State getState(){
        return currentState;
    }
}
