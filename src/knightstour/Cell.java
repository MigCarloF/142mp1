package knightstour;

import java.util.ArrayList;

public class Cell {
    private int x;
    private int y;
    Boolean traversed;
    static Cell[][] board;

    ArrayList<Cell> possibleMoves;
    boolean validated = false;

    Cell(int y, int x){
        traversed = false;
        possibleMoves = new ArrayList<>();
        validated = false;
        this.x = x;
        this.y = y;
    }

    static void setBoard(Cell[][] board2){
        board = board2;
    }

    public void displayPossibleMoves(){
        System.out.println("Cell[" + y + "][" + x + "]'s possible moves are:" );
        for(Cell cell : possibleMoves){
            System.out.println("Cell[" + cell.getY() + "][" + cell.getX() + "]" );
        }
    }

    public void removePossibleMove(Cell cell) {
        possibleMoves.remove(cell);
    }

    int getX(){
        return x;
    }


    int getY(){
        return y;
    }

    public boolean getTraversed(){
        return traversed;
    }

    void setTraversed(boolean newTrav){
        traversed = newTrav;
    }
}
