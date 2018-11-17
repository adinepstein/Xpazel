package HeurisiticFunctions;

import Utils.Position;
import Utils.State;
public class EmptyCellEuclidDistance implements HeuristicFunction {
    @Override
    public double calculate(State curState) {
        Position p1=curState.getEmptyCell().getPosition();
        int size= curState.getMatrix().length;
        Position p2 = new Position(size-1,size-1);

        double distance= ((p1.x-p2.x)*(p1.x-p2.x)) + ((p1.y-p2.y)*(p1.y-p2.y));
        distance= Math.sqrt(distance);

        return distance;
    }
}
