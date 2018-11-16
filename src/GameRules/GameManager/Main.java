package GameRules.GameManager;

import GameRules.XPazelRules;
import Searchers.Searcher;
import Searchers.SearcherFactory;
import Utils.EmptyCell;
import Utils.*;

import java.io.*;

public class Main {

    public static void main (String [] args) throws IOException {
        //open input file
        File file = new File("input.txt");
        BufferedReader bf= new BufferedReader(new FileReader(file));
        //algo number
        String st;
        st=bf.readLine();
        int algo= Integer.getInteger(st);
        //pazel size
        st=bf.readLine();
        int matrixSize=Integer.getInteger(st);
        //order of numbers on board
        st=bf.readLine();
        int [][] matrix= Utils.createInitialMatrix(st,matrixSize);
        // create searcher
        EmptyCell emptyCell= Utils.getEmptyCell(matrix,matrixSize);
        State state= new State(matrix,emptyCell,null,null,0,1);
        Searcher searcher= SearcherFactory.getSearcher(algo,state,new XPazelRules());

        State goalState = searcher.findSolution();
        String DirectionsToGoal=Utils.getDirectionsToSolution(goalState);


    }


}
