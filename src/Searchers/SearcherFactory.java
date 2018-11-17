package Searchers;

import GameRules.Rules;
import HeurisiticFunctions.HeuristicFunction;
import Utils.State;

public class SearcherFactory {

    public static Searcher getSearcher(int num, State state, Rules rules, HeuristicFunction heuristicFunction){
        Searcher searcher=null;
        switch (num){
            case(1):
                searcher= new IDA(state,rules);
                break;
            case (2):
                searcher = new BFS(state,rules);
                break;
            case (3):
                searcher=new AStar(rules,state,heuristicFunction);
                break;
        }
        return searcher;
    }
}
