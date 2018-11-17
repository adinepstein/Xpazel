package Searchers;

import GameRules.Rules;
import Utils.State;

import java.util.List;

public class IDA implements Searcher {

    private State initState;
    private Rules rules;

    public IDA(State initState, Rules rules) {
        this.initState = initState;
        this.rules = rules;
    }

    @Override
    public State findSolution() {
        int limit=0;
        while(true){
            DFS_L dfsl=new DFS_L(rules,initState,limit);
            State goal= dfsl.findSolution();
            if(goal!=null)
                return goal;
            else
                limit++;

        }
    }
}
