package GameRules;

import Utils.Direction;
import Utils.State;

public interface Rules {

    public boolean checkSon(State currentState, Direction direction);
    public boolean checkIfGoal(State state);
}
