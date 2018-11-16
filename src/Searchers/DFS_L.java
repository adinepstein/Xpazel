package Searchers;

import GameRules.Rules;
import Utils.*;

import java.util.List;
import java.util.Stack;

public class DFS_L implements Searcher {

    private Rules rules;
    private Stack<State> openList;
    private State initState;
    private int limit;


    public DFS_L(Rules rules, State initState, int limit) {
        this.rules = rules;
        this.initState = initState;
        this.limit=limit;
        openList= new Stack<State>();
        openList.add(initState);

    }

    @Override
    public State findSolution() {
        int depth=0;
        while(!openList.isEmpty()){
            if(depth<=limit){
                State state=openList.pop();
                if(rules.checkIfGoal(state))
                    return state;
                else {
                    Direction [] direcions= Direction.values();
                    for (int i=direcions.length-1; i>=0; i--){
                        if(rules.checkSon(state,direcions[i])){
                            State s = Utils.createSonState(state,direcions[i]);
                            openList.add(s);
                        }

                    }
                    depth++;
                }
            }
            else{
                return null;
            }
        }
        return null;
    }


}
