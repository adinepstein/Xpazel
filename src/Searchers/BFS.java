package Searchers;

import GameRules.Rules;
import Utils.Direction;
import Utils.State;
import Utils.Utils;

import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
//PFS algorithm implementation
public class BFS implements Searcher {

    private State initState;
    private Queue<State> queue;
    private Rules rules;
    private int opened=0;

    public BFS(State initState, Rules rules) {
        this.initState = initState;
        this.rules = rules;
        this.queue = new ArrayBlockingQueue<State>(5000000);
        queue.add(this.initState);
    }


    @Override
    public State findSolution() {
        while(queue.peek()!=null){
            State next= queue.poll();
            opened++;
           // System.out.println(next.getDirectionToState());
            next.setOpened(opened);
            if (rules.checkIfGoal(next))
                return next;
            for(Direction direction: Direction.values()){
                if(rules.checkSon(next,direction)) {
                    State sonState=Utils.createSonState(next, direction);
                    sonState.setPrintedResult(0);
                    sonState.setOpened(opened);
                    //Utils.printMatrix(sonState.getMatrix());

                    queue.add(sonState);

                        }


            }
        }
        return null;
    }
}
