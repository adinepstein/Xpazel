package Utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.*;
import java.io.*;
import java.util.*;

public class Utils {

     public static State createSonState(State state, Direction direction){
        int[][] m = copyMatrix(state.getMatrix());
        EmptyCell emptyCell=null;
        Position pos= state.getEmptyCell().getPosition();
        int matrixSize= state.getEmptyCell().getMetrixSize();
        Direction directionToState=null;
        if(direction==Direction.up){
            m[pos.x][pos.y]=m[pos.x+1][pos.y];
            m[pos.x+1][pos.y]=0;
            emptyCell=new EmptyCell(new Position(pos.x+1,pos.y),matrixSize);
            directionToState=Direction.up;
        }
        else if(direction==Direction.down){
            m[pos.x][pos.y]=m[pos.x-1][pos.y];
            m[pos.x-1][pos.y]=0;
            emptyCell=new EmptyCell(new Position(pos.x-1,pos.y),matrixSize);
            directionToState=Direction.down;
        }
        else if(direction==Direction.left){
            m[pos.x][pos.y]=m[pos.x][pos.y+1];
            m[pos.x][pos.y+1]=0;
            emptyCell=new EmptyCell(new Position(pos.x,pos.y+1),matrixSize);
            directionToState=Direction.left;
        }
        else if(direction==Direction.right){
            m[pos.x][pos.y]=m[pos.x][pos.y-1];
            m[pos.x][pos.y-1]=0;
            emptyCell=new EmptyCell(new Position(pos.x,pos.y-1),matrixSize);
            directionToState=Direction.right;
        }
        State sonState=new State(m,emptyCell,directionToState,state,state.getLevel()+1);
        return sonState;
    }

    public static   int [][] createInitialMatrix(String st,int size){
        String [] numbers=st.split("-");
        int [][] matrix= new int [size][size];

        int num=0;
        for (int r=0;r<size;r++)
            for(int c=0; c<size; c++){
                matrix[r][c]=Integer.parseInt(numbers[num]);
                num++;
            }
        return matrix;
    }

    public static EmptyCell getEmptyCell(int[][] matrix, int size){
        EmptyCell emptyCell=null;
        for (int r=0;r<size;r++)
            for(int c=0; c<size; c++)
                if(matrix[r][c]==0) {
                    Position pos = new Position(r, c);
                    emptyCell = new EmptyCell(pos, size);
                }
        return emptyCell;

    }

    public static String getDirectionsToSolution(State state){
        String path ="";
        while(state!=null && state.getDirectionToState()!=null){
            path+= getFirstLeter(state.getDirectionToState());
            state=state.getFather();
        }
        return reverseString(path);
    }

    public static void printMatrix(int [][] matrix){
        String m="";
        for(int r=0;r<matrix.length;r++){
            for(int c=0;c<matrix.length;c++)
                m+=matrix[r][c] + " ";
            m+="\n";
        }
        System.out.println(m);

    }

    private static String getFirstLeter(Direction direction){
        switch (direction){
            case up:
                return "U";
            case down:
                return "D";
            case left:
                return "L";
            case right:
                return "R";
        }
        return null;
    }

    private static String reverseString(String string){
        byte [] stringRevered=new byte[string.length()];
        byte [] stringArray= string.getBytes();
        for (int i=0; i<string.length();i++)
            stringRevered[i]=stringArray[string.length()-i-1];

        return new String(stringRevered);
    }

    private static int [][] copyMatrix(int[][] matrix){
        int [][] newMatrix= new int [matrix.length][matrix.length];
        for(int r=0; r<matrix.length; r++)
            for (int c=0; c<matrix.length;c++)
                newMatrix[r][c]=matrix[r][c];

        return newMatrix;
    }


}
