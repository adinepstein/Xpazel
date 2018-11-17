package Utils;

public class State {

    private int [][] matrix;
    private EmptyCell emptyCell;
    private Direction directionToState;
    private State father;
    //IDA-depth, A*-cost, BFS- 0
    private int printedResult;
    private  int opened;

    public State(int[][] matrix, EmptyCell emptyCell, Direction directionToState, State father,int printedResult) {
        this.matrix = matrix;
        this.emptyCell = emptyCell;
        this.directionToState = directionToState;
        this.father = father;
        this.printedResult = printedResult;

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

    public int getPrintedResult() {
        return printedResult;
    }

    public void setPrintedResult(int printedResult) {
        this.printedResult = printedResult;
    }

    public int getOpened() {
        return opened;
    }

    public void setOpened(int opened) {
        this.opened = opened;
    }
}
