package HeurisiticFunctions;

import Utils.State;

public interface HeuristicFunction {
    //calculating the heuristic function- must implement
    public double calculate(State curState);
}
