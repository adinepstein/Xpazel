package Searchers;

import GameRules.Rules;
import HeurisiticFunctions.HeuristicFunction;
import HeurisiticFunctions.StateComperatorEmptyCellEuclid;
import Utils.Direction;
import Utils.State;
import Utils.Utils;

import java.util.PriorityQueue;
import java.util.Queue;
// A star algorithm implementation
public class AStar implements Searcher {

    private Rules rules;
    private State initState;
    private HeuristicFunction heuristicFunction;
    private Queue<State> queue;

    public AStar(Rules rules, State initState, HeuristicFunction heuristicFunction) {
        this.rules = rules;
        this.initState = initState;
        this.heuristicFunction = heuristicFunction;
        queue= new PriorityQueue<State>(5000000, new StateComperatorEmptyCellEuclid(heuristicFunction));
        queue.add(initState);

    }

    @Override
    public State findSolution() {
        int opened=0;
        while (!queue.isEmpty()){
            State state=queue.poll();
            opened++;
            // g(x) + h(x)
            state.setPrintedResult(state.getPrintedResult()+ (int)heuristicFunction.calculate(state));
            state.setOpened(opened);
            //Utils.printMatrix(state.getMatrix());
            if(rules.checkIfGoal(state))
                return state;
            else{
                for(Direction direction:Direction.values()){
                    if(rules.checkSon(state,direction)){
                        State s=Utils.createSonState(state,direction);
                        //System.out.println("" + direction + " " + heuristicFunction.calculate(s));
                        queue.add(s);
                    }
                }
            }
        }
        return null;
    }
}
