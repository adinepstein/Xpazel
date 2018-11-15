package Searchers;

import GameRules.Rules;
import Utils.Direction;
import Utils.State;
import Utils.Utils;

import java.util.List;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

public class BFS implements Searcher {

    private State initState;
    private Queue<State> queue;
    private Rules rules;

    public BFS(State initState, Rules rules) {
        this.initState = initState;
        this.rules = rules;
        this.queue = new ArrayBlockingQueue<State>(Integer.MAX_VALUE);
        queue.add(this.initState);
    }


    @Override
    public State findSolution() {
        while(queue.peek()!=null){
            State next= queue.poll();
            if (rules.checkIfGoal(next))
                return next;
            else{
                    for(Direction direction: Direction.values()){
                        if(rules.checkSon(next,direction))
                            queue.add(Utils.createSonState(next,direction));
                }
            }
        }
        return null;
    }
}
