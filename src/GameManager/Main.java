package GameManager;

import GameRules.XPazelRules;
import HeurisiticFunctions.EmptyCellEuclidDistance;
import HeurisiticFunctions.HeuristicFunction;
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
        int algo= Integer.parseInt(st);
        //pazel size
        st=bf.readLine();
        int matrixSize=Integer.parseInt(st);
        //order of numbers on board
        st=bf.readLine();
        int [][] matrix= Utils.createInitialMatrix(st,matrixSize);
        bf.close();
        // create searcher
        EmptyCell emptyCell= Utils.getEmptyCell(matrix,matrixSize);
        State state= new State(matrix,emptyCell,null,null,0);
        HeuristicFunction heuristicFunction= new EmptyCellEuclidDistance();
        Searcher searcher= SearcherFactory.getSearcher(algo,state,new XPazelRules(),heuristicFunction);
        //find goal state and solution direcions
        State goalState = searcher.findSolution();
        String directionsToGoal=Utils.getDirectionsToSolution(goalState);
        //write solution to file
        BufferedWriter writer = new BufferedWriter(new FileWriter("output.txt"));
        writer.write(directionsToGoal + " " + goalState.getOpened() + " "+ goalState.getPrintedResult() +"\n");
        writer.close();

    }


}
