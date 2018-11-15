package Searchers;

public class SearcherFactory {

    public Searcher getSearcher(int num){
        Searcher searcher=null;
        switch (num){
            case(1):
                searcher= new IDA();
                break;
            case (2):
                searcher = new BFS();
                break;
            case (3):
                searcher=new AStar();
                break;
        }
        return searcher;
    }
}
