package Searchers;

import GameRules.Rules;
import Utils.State;

public class SearcherFactory {

    public static Searcher getSearcher(int num, State state, Rules rules){
        Searcher searcher=null;
        switch (num){
            case(1):
                searcher= new IDA();
                break;
            case (2):
                searcher = new BFS(state,rules);
                break;
            case (3):
                searcher=new AStar();
                break;
        }
        return searcher;
    }
}
