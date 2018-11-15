package Utils;

public class Utils {

    static public State createSonState(State state, Direction direction){
        int[][] m =state.getMatrix();
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
        else if(direction==Direction.down){
            m[pos.x][pos.y]=m[pos.x][pos.y-1];
            m[pos.x][pos.y-1]=0;
            emptyCell=new EmptyCell(new Position(pos.x,pos.y-1),matrixSize);
            directionToState=Direction.right;
        }
        State sonState=new State(m,emptyCell,directionToState,state);
        return sonState;
    }
}
