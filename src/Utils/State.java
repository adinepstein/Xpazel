package Utils;

public class State {

    private int [][] matrix;
    private EmptyCell emptyCell;
    private Direction directionToState;
    private State father;
    private int level;
    private  int openedState;

    public State(int[][] matrix, EmptyCell emptyCell, Direction directionToState, State father,int level) {
        this.matrix = matrix;
        this.emptyCell = emptyCell;
        this.directionToState = directionToState;
        this.father = father;
        this.level=level;

    }

    public int[][] getMatrix() {
        return matrix;
    }

    public void setMatrix(int[][] matrix) {
        this.matrix = matrix;
    }

    public EmptyCell getEmptyCell() {
        return emptyCell;
    }

    public void setEmptyCell(EmptyCell emptyCell) {
        this.emptyCell = emptyCell;
    }

    public Direction getDirectionToState() {
        return directionToState;
    }

    public void setDirectionToState(Direction directionToState) {
        this.directionToState = directionToState;
    }

    public State getFather() {
        return father;
    }

    public void setFather(State father) {
        this.father = father;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getOpenedState() {
        return openedState;
    }

    public void setOpenedState(int openedState) {
        this.openedState = openedState;
    }
}
