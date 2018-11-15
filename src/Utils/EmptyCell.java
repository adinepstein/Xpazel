package Utils;

public class EmptyCell {

    private Position position;
    private Boolean [] neighbors;
    private int metrixSize;

    public EmptyCell(Position position, int metrixSize) {
        this.position = position;
        this.neighbors= new Boolean[4];
        this.metrixSize= metrixSize;
        setNeighborsForLegalMovement();
    }

    private void setNeighborsForLegalMovement(){
        for (int i=0;i<3;i++)
            neighbors[i]=true;
        if (position.x==0)
            neighbors[1] = false;
        if (position.x==metrixSize-1)
            neighbors[0] = false;
        if (position.y==0)
            neighbors[3] = false;
        if (position.y==metrixSize-1)
            neighbors[2] = false;

    }

    public Position getPosition() {
        return position;
    }

    public Boolean[] getNeighbors() {
        return neighbors;
    }

    public int getMetrixSize() {
        return metrixSize;
    }
}
