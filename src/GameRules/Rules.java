package GameRules;

import Utils.Direction;
import Utils.State;

public interface Rules {
    //checks if it's possible to move in the selected direction
    public boolean checkSon(State currentState, Direction direction);
    // checks if state is the goal state
    public boolean checkIfGoal(State state);
}
