package Searchers;

import GameRules.Rules;
import HeurisiticFunctions.HeuristicFunction;
import HeurisiticFunctions.StateComperatorEmptyCellEuclid;
import Utils.Direction;
import Utils.State;
import Utils.Utils;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class AStar implements Searcher {

    private Rules rules;
    private State initState;
    private HeuristicFunction heuristicFunction;
    private Queue<State> queue;

    public AStar(Rules rules, State initState, HeuristicFunction heuristicFunction) {
        this.rules = rules;
        this.initState = initState;
        this.heuristicFunction = heuristicFunction;
        queue= new PriorityQueue<State>(50000, new StateComperatorEmptyCellEuclid(heuristicFunction));
        queue.add(initState);

    }

    @Override
    public State findSolution() {
        int opened=0;
        while (!queue.isEmpty()){
            State state=queue.poll();
            opened++;
            state.setOpenedState(opened);
            Utils.printMatrix(state.getMatrix());
            if(rules.checkIfGoal(state))
                return state;
            else{
                for(Direction direction:Direction.values()){
                    if(rules.checkSon(state,direction)){
                        State s=Utils.createSonState(state,direction);
                        queue.add(s);
                    }
                }
            }
        }
        return null;
    }
}
