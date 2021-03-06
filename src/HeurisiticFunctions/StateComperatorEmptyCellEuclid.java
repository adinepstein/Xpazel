package HeurisiticFunctions;

import Utils.State;

import java.util.Comparator;
//comperator for priority queue for the heuristic implementation of the empty cell distance to goal location
public class StateComperatorEmptyCellEuclid implements Comparator<State> {

    private HeuristicFunction heuristicFunction;

    public StateComperatorEmptyCellEuclid(HeuristicFunction heuristicFunction) {
        this.heuristicFunction = heuristicFunction;
    }

    @Override
    public int compare(State s1, State s2) {
        double Fs1= s1.getPrintedResult() + heuristicFunction.calculate(s1);
        double Fs2 = s2.getPrintedResult() + heuristicFunction.calculate(s2);
        if(Fs1>Fs2)
            return 1;
        else if(Fs1<Fs2)
            return -1;
        else
            return 0;
    }
}
