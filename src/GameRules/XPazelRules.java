package GameRules;

import Utils.Direction;
import Utils.State;

public class XPazelRules implements Rules {
    @Override
    public boolean checkSon(State currentState, Direction direction) {
        return false;
    }

    @Override
    public boolean checkIfGoal(State state) {
        return false;
    }
}
