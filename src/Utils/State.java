package Utils;

public class State {

    private int [][] matrix;
    private EmptyCell emptyCell;
    private Direction directionToState;
    private State father;

    public State(int[][] matrix, EmptyCell emptyCell, Direction directionToState, State father) {
        this.matrix = matrix;
        this.emptyCell = emptyCell;
        this.directionToState = directionToState;
        this.father = father;
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
}
