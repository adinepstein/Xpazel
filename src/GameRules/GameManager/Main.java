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
        Searcher searcher= SearcherFactory.getSearcher(algo,state,new XPazelRules());

        State goalState = searcher.findSolution();
        String directionsToGoal=Utils.getDirectionsToSolution(goalState);

        BufferedWriter writer = new BufferedWriter(new FileWriter("output.txt"));
        writer.write(directionsToGoal + " " + goalState.getOpenedState() + " "+ goalState.getLevel() +"\n");
        writer.close();

    }


}
