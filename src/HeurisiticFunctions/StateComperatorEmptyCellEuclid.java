package HeurisiticFunctions;

import Utils.State;

import java.util.Comparator;

public class StateComperatorEmptyCellEuclid implements Comparator<State> {

    private HeuristicFunction heuristicFunction;

    public StateComperatorEmptyCellEuclid(HeuristicFunction heuristicFunction) {
        this.heuristicFunction = heuristicFunction;
    }

    @Override
    public int compare(State s1, State s2) {
        double Fs1= s1.getLevel() + heuristicFunction.calculate(s1);
        double Fs2 = s2.getLevel() + heuristicFunction.calculate(s2);
        if(Fs1>Fs2)
            return -1;
        else
            return 1;
    }
}
