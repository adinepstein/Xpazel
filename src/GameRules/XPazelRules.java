package GameRules;

import Utils.Direction;
import Utils.State;

public class XPazelRules implements Rules {
    @Override
    public boolean checkSon(State currentState, Direction direction) {
        switch(direction){
            case up:
                return currentState.getEmptyCell().getNeighbors()[0];
            case down:
                return currentState.getEmptyCell().getNeighbors()[1];
            case left:
                return currentState.getEmptyCell().getNeighbors()[2];
            case right:
                return currentState.getEmptyCell().getNeighbors()[3];
        }
       return false;
    }

    @Override
    public boolean checkIfGoal(State state) {
        int i =1;
        int size=state.getMatrix().length;
        for (int r =0;r<size;r++)
            for (int c=0; c<size;c++){
                if((r+1)*(c+1)==size*size)
                    return true;
                if(state.getMatrix()[r][c]!=i)
                    return false;
                i++;
            }


        return false;
    }
}
